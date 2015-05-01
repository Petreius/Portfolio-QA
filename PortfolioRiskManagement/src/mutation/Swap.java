package mutation;

import java.util.Collections;

import modele.Etat;
import modele.Probleme;
import modele.Routage;

public class Swap implements IMutation {


	public void faire(Routage r) {
		// TODO Auto-generated method stub

	}


	public double calculer(Routage r) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Seule m�thode utilis�e dans la classe Swap. 
	 * Swap d�signe une mutation TSP qui consiste � �changer deux noeuds de la route.
	 * Cette m�thode effectue cette mutation sur un Routage
	 * @param r
	 * Routage sur lequel on mute
	 * @param i
	 * Indice du premier noeud �chang�
	 * @param j
	 * Indice du second noeud �chang�
	 */
	public static void faire(Routage r , int i,int j){

		Collections.swap(r.getRoute(),i,j);
	}

	@Override
	public void faire(Probleme p) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public double calculer(Probleme p) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public double calculer(Probleme p, Etat e) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void faire(Probleme p, Etat e) {
		// TODO Auto-generated method stub
	}


	@Override
	public void maj() {
		// TODO Auto-generated method stub
		
	}




}
