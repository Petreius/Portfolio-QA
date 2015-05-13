package solver.parametres;

/**
 * {@inheritDoc}
 * <p>
 * A chaque appel de modification de la temp�rature, la temp�rature descend d'un pas exponentiellement d�croissant.
 * Le nombre r�el d'it�rations est une approximation puisque le pas exponentiel est un double � pr�cision limit�e.
 * Le coefficient normalis�(variable) permet de choisir la pente ind�pendamment de 
 * la temp�rature de d�but, de celle de fin et du nombre d'it�rations.
 * @see FonctionExpoExplicite
 */
public class FonctionExpoRecursive extends Fonction {

	/**
	 * Facteur normalis�.Il permet de choisir la pente ind�pendamment de 
	 * la temp�rature de d�but, de celle de fin et du nombre d'it�rations.
	 */
	double facteur; 
	                                            
	/**
	 * Cr�ation d'une variable facteur(normalis�).
	 */
	public FonctionExpoRecursive(double tdebut, double tfinal, int nbIteration, double coef ) {
		super(tdebut,tfinal,nbIteration);
		this.facteur = Math.exp(-coef/this.nbIteration) ; 
		System.out.println(this.facteur);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Ici, diminue la distance de la temp�rature actuelle � la temp�rature finale d'un certain facteur.
	 * Le calcul est moins lourd que pour FonctionExpoExplicite mais aussi moins pr�cis(assez pr�cis pour nos besoins par contre)
	 */
	public boolean modifierT() {
		if (this.t < this.Tfinal) return false;
		else { 
			this.t=(this.t-this.Tfinal)*this.facteur+this.Tfinal;
			//System.out.println("valeur de G "+this.t);
			return true;		  
		}
	}
}