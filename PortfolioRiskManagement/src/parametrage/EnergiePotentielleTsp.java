package parametrage;

import modele.Routage;

public class EnergiePotentielleTsp extends EnergiePotentielle {
	
	/**
	 * Calcule l'�nergie potentielle de l'�tat Routage pour TSP. C'est la distance totale du Routage
	 * @param r
	 * Route sur laquelle on calcule Epot
	 * @return
	 * Energie potentielle (distance) du Routage TSP
	 */
	public static double calculer(Routage r) {
		
		return r.getEnergie();
	}

}
