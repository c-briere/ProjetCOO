package classe_defaut;

/**
 * Les clients réservent en plus du transport un chambre d'hôtel
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
