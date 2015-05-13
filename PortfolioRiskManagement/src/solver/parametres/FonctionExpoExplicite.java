package solver.parametres;

/**
 * {@inheritDoc}
 * <p>
 * Calcul explicite de la temp�rature avec une exponentielle.
 * Le coefficient normalis�(variable) permet de choisir la pente ind�pendamment de 
 * la temp�rature de d�but, de celle de fin et du nombre d'it�rations.
 * <p>
 * En effet, T(0) = Td�but <br>
 * Et T(nbIter) = Tfinal+(Td�but-Tfinal)*exp(coefPente*nbIter) 
 *				= Tfinal+(Td�but-Tfinal)*exp(-coef*nbIter/nbIter) 
 *              = Tfinal+(Td�but-Tfinal)*exp(-coef)  <br>
 * Or exp(-coef) est proche de zero. <br>
 *    T(nbIter) ~= Tfinal
 *<p>
 * Le coefficient est � prendre plutot entre 4 et 6, puisque exp(-4) = 0.02 et exp(-6) = 0.0025.
 * Ainsi, on a une bonne exponentielle, qui ne reste pas trop lontemps vers Tfin mais quand m�me un peu.
 * @see FonctionExpoRecursive
 */
public class FonctionExpoExplicite extends Fonction {

	/**
	 * Coefficient de la pente exponentiel normalis�e. Il permet de choisir la pente ind�pendamment de 
	 * la temp�rature de d�but, de celle de fin et du nombre d'it�rations.
	 */
	double coefPente; 
	/**
	 * Nombre d'it�rations effectu�es.
	 */
	int k;
	
	public void init(){
		super.init();
		this.k=0;
	}
	
	/**
	 * Cr�ation d'une variable coefPente(normalis�e) et de k.
	 */
	public FonctionExpoExplicite(double tdebut, double tfinal, int nbIteration, double coef ) {
		super(tdebut,tfinal,nbIteration);
		this.k=0;
		this.coefPente = -coef/this.nbIteration ;
	}
	
	/**
	 * {@inheritDoc}
	 * <p>
	 * Ici, diminue la distance de la temp�rature actuelle � la temp�rature finale du facteur(en variable).
	 * Le calcul est un peu lourd, mais pr�cis.
	 */
	public boolean modifierT() {
		if (this.t < this.Tfinal) return false;
		else 
		{ 
			this.k++;
			this.t=Tfinal+(Tdebut-Tfinal)*Math.exp(coefPente*this.k);
			return true;		  
		}
	}
}