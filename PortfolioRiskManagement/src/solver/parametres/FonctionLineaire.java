package solver.parametres;

/**
 * {@inheritDoc}
 * <p>
 * A chaque appel de modification de la temp�rature, la temp�rature descend d'un pas constant.
 * Le nombre r�el d'it�rations est une approximation puisque le pas lin�aire est un double � pr�cision limit�e.
 */
public class FonctionLineaire extends Fonction {

	/**
	 * Valeur approxim�e du pas(en n�gatif) pour descendre de la 
	 * temp�rature de d�but � celle de fin en le nombre d'it�rations voulu.
	 */
	double pasLineaire;
	
	/**
	 * Cr�ation d'une variable pasLineaire.
	 */
	public FonctionLineaire(double tdebut, double tfinal, int nbIteration) {
		super(tdebut,tfinal,nbIteration); 
		this.pasLineaire = (this.Tfinal-this.Tdebut)/this.nbIteration ; 
}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Ici, on ajoute le pas � la temp�rature et on v�rifie si la temp�rature r�sultante est inf�rieure � la temp�rature de fin.
	 */
	public boolean modifierT() {
		if (this.t+this.pasLineaire < this.Tfinal) {
			return false;
		} else {
			this.t += this.pasLineaire; //pas lineaire negatif
			return true;
		}
	}
}