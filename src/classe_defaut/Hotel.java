package classe_defaut;

import java.util.ArrayList;

/**
 * Le client au moment de réserver choisit sa destination et ensuite son hôtel
 * 
 * @author BRIERE / CARDON
 *
 */
public class Hotel {
	/**
	 * nom de l'hôtel
	 */
	private String nom;
	/**
	 * Liste de catégorie de chambres de l'hôtel
	 */
	private ArrayList<Categorie> categorieChambre;

	/**
	 * constructeur de la class
	 * 
	 * @param nom
	 *            nom de l'hôtel
	 */
	public Hotel(String nom) {
		this.nom = nom;
		categorieChambre = new ArrayList<Categorie>();

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArrayList<Categorie> getCategorieChambre() {
		return categorieChambre;
	}

	public void setCategorieChambre(ArrayList<Categorie> categorieChambre) {
		this.categorieChambre = categorieChambre;
	}

	/**
	 * Ajout d'une catégorie de chambre à l'hôtel
	 * 
	 * @param c
	 */
	public void addCategorieChambre(Categorie c) {
		categorieChambre.add(c);
	}

	/**
	 * Supression d'une catégorie de chambre dans l'hôtel
	 * 
	 * @param c
	 */
	public void suppCategorieChambre(Categorie c) {
		categorieChambre.remove(c);
	}

}
