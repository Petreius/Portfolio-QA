package parametrage;

public class Ponderation {
	ParametreGamma gamma;
	/**
	 * Construit un J(Gamma)
	 * @param gamma
	 * Paramétre Gamma correspondant
	 */
	public Ponderation(ParametreGamma gamma){
		this.gamma=gamma;
	}

	/**
	 * Permet d'établir un nouveau Gamma pour ce J
	 * @param gamma
	 * Nouveau paramétre Gamma
	 */
	public void setGamma(ParametreGamma gamma){
		this.gamma = gamma;
	}
	
	/**
	 * Calcule la valeur numérique de J (loi en ln tanh)
	 * @param temperature
	 * Température du recuit
	 * @param p
	 * Coefficient Entier (fixé é la taille du probléme dans le recuit)
	 * @return
	 * Valeur numérique de J
	 */
	public double calcul(Temperature temperature, int p) {
		double t = temperature.getValue();
		return - t/2*Math.log(Math.tanh(this.gamma.getGamma()/(p*t))) ;
	}

}
