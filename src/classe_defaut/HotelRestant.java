package classe_defaut;

/**
 * Les hôtels restants sont les hôtels qui ne sont pas complets
 * 
 * @author BRIERE / CARDON
 *
 */
public class HotelRestant {
	/**
	 * nom de l'hôtel
	 */
	private String nom;
	/**
	 * nombre de places restantes
	 */
	private int nbPlaceRestante;

	/**
	 * Constructeur de la class
	 * 
	 * @param nom
	 *            nom de l'hôtel
	 * @param nbPlaceRestante
	 *            nombre de places restantes dans l'hôtel
	 */
	public HotelRestant(String nom, int nbPlaceRestante) {
		this.nom = nom;
		this.nbPlaceRestante = nbPlaceRestante;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbPlaceRestante() {
		return nbPlaceRestante;
	}

	public void setNbPlaceRestante(int nbPlaceRestante) {
		this.nbPlaceRestante = nbPlaceRestante;
	}

}
