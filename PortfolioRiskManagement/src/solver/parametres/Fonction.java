package solver.parametres;

/**
 * Classe qui d�crit un comportement (par exemple lin�aire ou exponentiel), et qui est utilis� entre autre pour la temp�rature.
 * Cette classe permet de mod�liser le comportement des param�tres comme la temp�rature dans le recuit simul� ou le
 * param�tre Gamma dans le recuit quantique.
 *
 */
public abstract  class Fonction {       

	/**
	 * Temp�rature de d�part de la fonction
	 */
	double Tdebut;
	/**
	 * Temp�rature de fin de la fonction
	 */
	double Tfinal;
	/**
	 * Nombre d'it�rations th�oriques effectu�s(en vrai, peut �tre un peu diff�rent)
	 */
	public int nbIteration ; 
	
	/**
	 * Temp�rature actuelle de la fonction
	 */
	public double t;
	
	public double getTdebut() {
		return Tdebut;
	}

	public double getTfinal() {
		return Tfinal;
	}

	public double getT() {
		return t;
	}

	/**
	 * Fonction qui change la temperature et indique si on est � la temperature finale.
	 * @return True s'il faut continuer, false sinon.
	 */
	 public boolean  modifierT() {
		return false;
	} 
		
	/**
	 * Fonction d'initialisation(ou plus pr�cisemment r�initialisation) de l'instance. 
	 * La temp�rature gard�e dans l'instance est r�initialis�e � la temp�rature de d�but donn�e
	 * � l'instanciation de l'objet.
	 */
	public void init(){
		this.t = this.Tdebut;
	}
	 
	/**
	 * Constructeur.
	 * @param tdebut Temp�rature de d�but, gard�e em m�moire pour une r�initialisation possible.
	 * @param tfinal Temp�rature de fin, gard�e en m�moire.
	 * @param nbIteration Le nombre d'it�rations, gard� en m�moire.
	 */
	 public Fonction(double tdebut, double tfinal, int nbIteration) {
		this.Tdebut = tdebut;
		this.Tfinal = tfinal;
		this.nbIteration = nbIteration;
		this.t = tdebut;
	}
	
	
}
