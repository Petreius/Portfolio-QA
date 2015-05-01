package mutation;
import modele.Etat;
import modele.Probleme;

/**
 * 
 * @author Pierre
 *
 */
public interface IMutation {
	/**
	 * Faire la mutation. Modifie la particule.
	 * Dans le cas o� la mutation porte sur une r�plique � la fois, impl�menter seulement faire(Probleme p, Etat e) 
	 * L'utilisateur devra impl�menter cette m�thode dans la classe fille adapt�e.
	 * @param p
	 * Probleme sur lequel on mute (exemple : ParticuleTSP)
	 */
public void faire(Probleme p);
	/**
	 * Calcule la diff�rence d'�nergie apparue lors de la mutation.
	 * Dans le cas o� la mutation porte sur une r�plique � la fois, retourner 0 et impl�menter faire(Probleme p, Etat e) 
	 * L'utilisateur devra impl�menter cette m�thode dans la classe fille adapt�e.
	 * @param p
	 * Probleme sur lequel on mute
	 * @return
	 * Valeur num�rique de la diff�rence d'�nergie apr�s mutation (sans pour autant muter !)
	 */
public double calculer(Probleme p);
/**
 * Faire la mutation sur l'�tat e de la particule. Ex : faire(p,p.getEtat.get(0))
 * L'utilisateur devra impl�menter cette m�thode dans la classe fille adapt�e
 * @param p
 * Probl�me sur lequel on mute.
 * @param e
 * Etat de la particule sur lequel la mutation a lieu
 * @return
 * Etat mut�
 */
public void faire(Probleme p, Etat e);
/**
 * Calcule la diff�rence d'energie suite � la mutation sur l'�tat e
 * L'utilisateur devra impl�menter cette m�thode dans la classe fille adapt�e
 * @param p
 * Probl�me sur lequel on mute
 * @param e
 * Etat de la particule sur lequel la mutation a lieu.
 * @return
 * Diff�rence d'�nergie apr�s mutation
 */
public double calculer(Probleme p, Etat e);
/**
 * Transforme la mutation courante en une autre mutation, de m�me type(m�me type d'objet) mais diff�rente(arguments diff�rents)
 * C'est en fait un g�n�rateur de mutation al�atoire,cr�ant une mutation ind�pendante de la mutation trait�e mais de m�me type : c'est un constructeur en fait
 * L'utilisateur devra impl�menter cette m�thode dans la classe fille adapt�e
 */
public void maj();
}
