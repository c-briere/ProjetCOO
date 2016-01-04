package classe_defaut;

import java.util.ArrayList;

/**
 * Le client au moment de r�server choisit sa destination et ensuite son h�tel
 * 
 * @author BRIERE / CARDON
 *
 */
public class Hotel {
	/**
	 * nom de l'h�tel
	 */
	private String nom;
	/**
	 * Liste de cat�gorie de chambres de l'h�tel
	 */
	private ArrayList<Categorie> categorieChambre;

	/**
	 * constructeur de la class
	 * 
	 * @param nom
	 *            nom de l'h�tel
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
	 * Ajout d'une cat�gorie de chambre � l'h�tel
	 * 
	 * @param c
	 */
	public void addCategorieChambre(Categorie c) {
		categorieChambre.add(c);
	}

	/**
	 * Supression d'une cat�gorie de chambre dans l'h�tel
	 * 
	 * @param c
	 */
	public void suppCategorieChambre(Categorie c) {
		categorieChambre.remove(c);
	}

}
