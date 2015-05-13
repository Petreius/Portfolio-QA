package solver.commun;

/**
 * Classe abstraite qui sert de template pour les �nergies potentielles des recuits.
 * Concr�tement, cette classe correspond � une m�thode de calcul de l'�nergie potentielle sp�cifique � un probl�me.
 * <p>
 * Il est n�cessaire de coder une sous-classe fille pour chaque projet, et d'y impl�menter calculer() et et calculerDeltaE().
 */
public abstract class EnergiePotentielle{
	
	/**
	 * 
	 * @param etat
	 * Etat modifi� par la mutation.
	 * @return L'�nergie potentielle de l'�tat modifi�.
	 */
	abstract public double calculer(Etat etat);
	
	/**
	 * 
	 * @param etat
	 * Etat modifi� par la mutation.
	 * @param mutation
	 * Mutation affectant l'�tat en question.
	 * @return La diff�rence d'�nergie potentielle sur l'�tat modifi� par la mutation donn�e.
	 */
	abstract public double calculerDeltaE(Etat etat, MutationElementaire mutation);
	
}
