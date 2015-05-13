package solver.parametres;

/**
 * {@inheritDoc}
 * <p>
 * La temp�rature ne descend qu'apr�s un certain nombre d'appels de modification de temp�rature, d�pendant du palier.
 * La descente est constante(lin�aire).
 * Le nombre r�el d'it�rations est une approximation puisque le pas lin�aire est un double � pr�cision limit�e.
 */
public class FonctionLineairePalier extends Fonction {
	
	/**
	 * Valeur approxim�e du pas(en n�gatif) pour descendre de la 
	 * temp�rature de d�but � celle de fin en le nombre d'it�rations voulu.
	 */
	double pasLineaire;
	
	/**
	 * Nombre d'it�rations que l'on va faire avant de descendre de temp�rature.
	 */
	int palier;
	/**
	 * Nombre d'it�rations faites sur le palier courant
	 */
	int compteurPalier;
	
	public void init(){
		super.init();
		this.compteurPalier=1;
	}
	
	/**
	 * Cr�ation des variables pasLineaire et compteurPalier.
	 */
	public FonctionLineairePalier(double tdebut, double tfinal,int nbIteration, int palier) {
		super(tdebut, tfinal, nbIteration);
		this.pasLineaire = (this.Tfinal-this.Tdebut)/this.nbIteration ;
		this.palier = palier;
		this.compteurPalier = 1;
	}
	
	/**
	 * {@inheritDoc}
	 * <p>
	 * Ici, on v�rifie si on doit incr�menter le nombre d'it�rations faites sur le pr�sent palier ou aller au prochain palier de temp�rature.
	 * Dans le deuxi�me cas, on ajoute le pas � la temp�rature.
	 */
	public boolean modifierT() {
		if (this.t < this.Tfinal) {
			return false;
		} else if(this.compteurPalier == palier) {
			this.t += this.pasLineaire;
			this.compteurPalier = 1;
			return true;
		}else{
			this.compteurPalier++;
			return true;
		}
	}

	// a completer !
}
