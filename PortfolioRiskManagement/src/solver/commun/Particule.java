package solver.commun;

/**
 * Classe abstraite servant de template pour les particules d'un probl�me. 
 * <p>
 * Une particule dispose de plusieurs �tats, qui sont des possibilit�s pour la particule. 
 * Elle dispose d'un lien vers une �nergie cin�tique et vers une mutation(template).
 * @see EnergieCinetique
 * @see IMutation
 * @see Etat
 */
public abstract class Particule {
	
	public EnergieCinetique Ec;
	public IMutation mutation;
	public Etat[] etats;

}
