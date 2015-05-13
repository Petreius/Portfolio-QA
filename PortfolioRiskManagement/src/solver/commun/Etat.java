package solver.commun;

/**
 * Classe abstraite servant de template pour les �tats d'un probl�me. Un �tat repr�sente une configuration 
 * possible d'une particule. Un �tat dispose n�cessairement d'un lien vers une �nergie potentielle. 
 * <p>
 * Il est n�cessaire d'impl�menter une sous-classe fille, avec les informations du probl�me en particulier.
 * Il doit aussi y avoir moyen de l'initialiser, pour que ce soit utiliser par la fonction initialiser() du probl�me.
 * Il y a aussi moyen de d�composer les fonctionnalit�s de faire() de l'impl�mentation de IMutation pour qu'elle appelle
 * une fonction dans Etat qui effectue la mutation sur les variables internes.
 * @see EnergiePotentielle
 * @see Particule
 *
 */
public abstract class Etat {
	
	public EnergiePotentielle Ep;
	
}
