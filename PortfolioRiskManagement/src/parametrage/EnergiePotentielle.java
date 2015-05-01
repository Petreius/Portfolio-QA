package parametrage;
import modele.Etat;


/**
 * 
 * @author Pierre
 *
 */
public  class EnergiePotentielle {


	/**
	 * N'est pas utilis� en tant que tel. 
	 * On calcule toujours une sous-�nergie potentielle qui correspond � un certain probl�me.
	 * L'utilisateur devra impl�menter cette m�thode dans la classe fille adapt�e.
	 * Ex : EnergiePotentielleTSP pour TSP
	 * @param etat
	 * l'etat sur lequel on calcule l'�nergie potentielle
	 * @return 0
	 */
	public static double calculer(Etat etat){
		return 0;
	}

}
