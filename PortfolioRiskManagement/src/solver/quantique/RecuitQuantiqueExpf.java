
	package solver.quantique;



	import java.util.ArrayList;
import java.util.Collections;

	import solver.commun.Etat;
import solver.commun.IRecuit;
import solver.commun.MutationElementaire;
import solver.commun.Probleme;
import solver.parametres.ConstanteK;
import solver.parametres.Fonction;

	/**
	 * D�riv� du recuitQuantique utilisant expf au lieu de Mathexp pour acc�l�rer
	 * 
	 * @see RecuitSimule, Particule, Etat
	 */
	public class RecuitQuantiqueExpf implements IRecuit { 				

		/**
		 * Fonction Gamma modulable. Repr�sente l'effet tunnel.
		 * @see Fonction
		 */
		public Fonction Gamma;
		/**
		 * Constante k modulable.
		 * @see Constante
		 */
		public ConstanteK K;
		/**
		 * Meilleure �nergie(potentielle + cin�tique) atteinte par le recuit simul�.
		 */
		public double meilleureEnergie = Double.MAX_VALUE;
		/**
		 * Temp�rature du recuit intervenant dans les calculs de probabilit�, constante dans le recuit quantique.
		 */
		public double temperature;
		
		/**
		 * Nombre maximal d'it�rations si la solution n'est pas trouv�e, en redondance avec T.nbIteration
		 */
		public int nbMaxIteration;
		/**
		 * Nombre d'it�rations cons�cutives sur un seul �tat.
		 */
		public int palier;


		/**
		 * R�initialise Gamma et K au d�but de lancer().
		 */
		protected void init(){
			this.Gamma.init();
			this.K.init();
			meilleureEnergie = Double.MAX_VALUE;
		}

		/**
		 * On envoie les param�tres modulables.
		 * @param Gamma
		 * Fonction Gamma effet tunnel cr��e au pr�alable.
		 * @param K
		 * Constante k cr��e au pr�alable.
		 * @param palier
		 * Nombre d'it�rations cons�cutives sur un seul �tat.
		 * @param temperature
		 * Temp�rature constante du recuit quantique.
		 */
		public RecuitQuantiqueExpf(Fonction Gamma, ConstanteK K, int palier, double temperature) {
			this.Gamma=Gamma;
			this.K=K;
			this.nbMaxIteration=this.Gamma.nbIteration;
			this.palier = palier;		
			this.temperature = temperature;
		}


		/**
		 * Effectue le recuit quantique sur le probl�me.
		 * Le recuit quantique va pr�parer les variables, puis circuler al�atoirement sur une cha�ne li�e invariante connectant les 
		 * divers �tats du probl�mes.
		 * Ensuite il va penser � une mutations possible � l'�tat. Si elle est positive(diminue l'�nergie potentielle) 
		 * alors on va l'effectuer, sinon on va l'effectuer avec une probabilit� d�pendante de la temp�rature, de la
		 * diff�rence d'�nergie potentielle de la mutation et de k.
		 * On r�it�re le processus un certain nombre de fois puis on change d'�tat.
		 * On r�it�re le tout jusqu'� avoir trouv� une r�ponse voulue ou un nombre d'it�ration maximale.
		 * <p>
		 * Pour ce qui est de l'utilisation de ce recuit, il faut cr�er une Fonction Gamma, une Constante k et un Probl�me 
		 * au pr�alable. On initialise le recuit avec les deux premiers ainsi qu'une temp�rature et un palier constant,
		 * et on lance ensuite le recuit en lui envoyant le probl�me.
		 * A la fin de lancer, on peut obtenir les r�sultats sur la variable probl�me modifi�e.
		 * @param problem
		 * Le probl�me sur lequel on veut effectuer le recuit quantique.
		 */
		public void lancer(Probleme probleme) {

			this.init();
			
			int mutationsTentees = 0;
			int mutationsAcceptees = 0;
			
			int nombreRepliques = probleme.etats.length;
			
			Etat etat = probleme.etats[0];
			Etat previous = probleme.etats[nombreRepliques-1];
			Etat next = probleme.etats[1];
			for (int i = 0; i < nombreRepliques; i++){	// initialisation de meilleureEnergie
				double energie = probleme.etats[i].Ep.calculer(probleme.etats[i]) ;
				if (energie < this.meilleureEnergie){
					this.meilleureEnergie = energie ;
				}

			}

			double proba = 1;
			double EpActuelle = 0;

			// tableau des indices des etats a parcourir dans un certain ordre
			ArrayList<Integer> indiceEtats = new ArrayList<Integer>(); 
			for( int i = 0; i < nombreRepliques ; i++){
				indiceEtats.add(i);
			}
			
			while(Gamma.modifierT() && this.meilleureEnergie!=0){

				Collections.shuffle(indiceEtats, probleme.gen);	// melanger l'ordre de parcours des indices
				double Jr = -this.temperature/2*Math.log(Math.tanh(this.Gamma.t/nombreRepliques/this.temperature));	// calcul de Jr pour ce palier
				
				for (Integer p : indiceEtats){	
					
					etat = probleme.etats[p];	
					
					if(p == 0){
						previous = probleme.etats[nombreRepliques-1];
					}
					else{
						previous = probleme.etats[p-1];
					}
					
					if (p == nombreRepliques - 1){
						next = probleme.etats[0];
					}
					else{
						next = probleme.etats[p+1];
					}
					
					for (int j = 0; j < this.palier; j++){
						
						MutationElementaire mutation = probleme.getMutationElementaire(etat);	// trouver une mutation possible
						mutationsTentees++; //permet d'avoir une r�f�rence ind�pendante pour les am�liorations de l'algorithme, mais aussi sur son temps
						
						double deltaEp = probleme.calculerDeltaEp(etat, mutation);	// calculer deltaEp si la mutation etait acceptee
						double deltaEc = probleme.calculerDeltaEc(etat, previous, next, mutation);  // calculer deltaIEc si la mutation etait acceptee
							
						//diff�rences du hamiltonien total
						//multiplier deltaIEc par JGamma
						double deltaE = deltaEp/nombreRepliques - deltaEc*Jr;
						
						//K.calculerK(deltaE);
									
						if( deltaE <= 0 || deltaEp < 0) proba = 1;
						else	proba = expf(-deltaE / (this.K.k * this.temperature));
						
						if (proba == 1 || proba >= probleme.gen.nextDouble()) {
							mutationsAcceptees++;
							probleme.modifElem(etat, mutation);				// faire la mutation
							if (deltaEp < 0){
								EpActuelle = etat.Ep.calculer(etat);		// energie potentielle temporelle
								if( EpActuelle < this.meilleureEnergie ){		// mettre a jour la meilleur energie
									this.meilleureEnergie = EpActuelle;
									System.out.println("meilleureEnergie = "+ this.meilleureEnergie);
									System.out.println("mutationsTentees = "+ mutationsTentees);
									if (this.meilleureEnergie == 0){	// fin du programme
										System.out.println("Mutations tent�es : " + mutationsTentees);
										System.out.println("Mutations accept�es : " + mutationsAcceptees);
										return;
									}
								}
							}
						}
					}
					

				}
			}
			
			
			System.out.println("Mutations tent�es : " + mutationsTentees);
			System.out.println("Mutations accept�es : " + mutationsAcceptees);
			return;
		}
	

	
	
	public static double exp1(double x) {
		x = 1.0 + x / 256.0;
		x *= x;
		x *= x;
		x *= x;
		x *= x;
		x *= x;
		x *= x;
		x *= x;
		x *= x;
		return x;
	}

	public static double exp2(double val) {
		final long tmp = (long) (1512775 * val + 1072632447);
		return Double.longBitsToDouble(tmp << 32);
	}
	
	public static double expf(double val) {
		if (val >= 0)
			return 1;
		if (val > -2.5)
			return exp1(val);
		if (val > -700)
			return exp2(val);
		else
			return 0;
	}
}
