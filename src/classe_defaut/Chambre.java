package classe_defaut;

/**
 * Les clients r�servent en plus du transport un chambre d'h�tel
 * 
 * @author BRIERE / CARDON
 *
 */
public class Chambre {
	/**
	 * nom de la chambre
	 */
	public String denomination;

	/**
	 * Constructeur de la class
	 * @param denomination
	 */
	public Chambre(String denomination) {
		this.denomination = denomination;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

}
