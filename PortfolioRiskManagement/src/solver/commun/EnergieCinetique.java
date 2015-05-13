package solver.commun;

/**
 * 
 * Classe abstraite qui sert de template pour les �nergies cin�tiques du recuit quantique.
 * Concr�tement, cette classe correspond � une m�thode de calcul de l'�nergie cin�tique sp�cifique � un probl�me.
 * <p>
 * Il est n�cessaire d'impl�menter une sous-classe fille, et d'y impl�menter calculer() et calculerDeltaE().
 * Il faut aussi impl�menter calculerDeltaEUB() pour pouvoir utiliser le Recuit Quantique Acc�l�r�.
 */
public abstract class EnergieCinetique{
	
	/**
	 * 
	 * @param probleme
	 * 	Le probl�me dont on calcule l'�nergie cin�tique.
	 * @return Un double correspondant � l'�nergie cin�tique totale de la particule.
	 */
	abstract public double calculer(Probleme probleme);
	
	/**
	 * 
	 * @param etat
	 * 	L'�tat que l'on modifie.
	 * @param prev
	 * 	L'�tat situ� avant l'�tat modifi�.
	 * @param next
	 * 	L'�tat situ� apr�s l'�tat modifi�.
	 * @param mutation
	 * 	La mutation que subit l'�tat centre et dont l'on veut calculer le changement d'�nergie cin�tique provoqu�.
	 * @return Le changement d'�nergie cin�tique provoqu� par la mutation sur l'�tat centre.
	 * 		
	 */
	abstract public double calculerDeltaE(Etat etat, Etat prev, Etat next, MutationElementaire mutation);
	
	/**
	 * 
	 * @param etat
	 * 	L'�tat que l'on modifie.
	 * @param prev
	 * 	L'�tat situ� avant l'�tat modifi�.
	 * @param next
	 * 	L'�tat situ� apr�s l'�tat modifi�.
	 * @param mutation
	 * 	La mutation que subit l'�tat centre et dont l'on veut calculer la borne sup�rieure du changement d'�nergie cin�tique provoqu�.
	 * @return La borne sup�rieure du changement d'�nergie cin�tique provoqu� par la mutation sur l'�tat centre.
	 * 		
	 */
	abstract public double calculerDeltaEUB(Etat etat, Etat prev, Etat next, MutationElementaire mutation);
}
