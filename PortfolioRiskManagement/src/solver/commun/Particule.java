package solver.commun;

/**
 * Classe abstraite servant de template pour les particules d'un probléme. 
 * <p>
 * Une particule dispose de plusieurs états, qui sont des possibilités pour la particule. 
 * Elle dispose d'un lien vers une énergie cinétique et vers une mutation(template).
 * @see EnergieCinetique
 * @see IMutation
 * @see Etat
 */
public abstract class Particule {
	
	public EnergieCinetique Ec;
	public IMutation mutation;
	public Etat[] etats;

}
