package classe_defaut;

import java.util.ArrayList;

/**
 * Il existe deux types villes. La ville de départ du client et la ville où le
 * client veut aller.
 * 
 * @author BRIERE / CARDON
 *
 */
public class Ville {
	/**
	 * nom de la ville
	 */
	private String nom;
	/**
	 * Liste des hôtels de la ville
	 */
	private ArrayList<Hotel> listHotel;

	/**
	 * Constructeur de la class
	 * 
	 * @param nom
	 *            nom de la ville
	 */
	public Ville(String nom) {
		this.nom = nom;
		this.listHotel = new ArrayList<Hotel>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Ajout d'une hôtel dans la ville
	 * 
	 * @param hotel
	 */
	public void addHotel(Hotel hotel) {
		this.listHotel.add(hotel);
	}

	/**
	 * Suppression d'un hôtel dans la ville
	 * 
	 * @param hotel
	 */
	public void suppHotel(Hotel hotel) {
		this.listHotel.remove(hotel);
	}

	public ArrayList<Hotel> getListHotel() {
		return listHotel;
	}

	public void setListHotel(ArrayList<Hotel> listHotel) {
		this.listHotel = listHotel;
	}

}
