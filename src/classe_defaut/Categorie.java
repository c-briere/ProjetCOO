package classe_defaut;

import java.util.ArrayList;

/**
 * Chaque chambre appartient à une catégorie La catégorie est représentée par un
 * nom, un prix et un nombre de places
 * 
 * @author BRIERE / CARDON
 *
 */
public class Categorie {
	/**
	 * nom de la catégorie
	 */
	private String nom;
	/**
	 * Nombre de place maximum pour la catégorie
	 */
	private int place;
	/**
	 * prix à payer pour cette catégorie
	 */
	private double prix;
	/**
	 * Chaque chambre appartient é une catégorie
	 */
	private ArrayList<Chambre> listChambre;

	/**
	 * Constructeur de la class
	 * 
	 * @param nom
	 *            nom de la catégorie
	 * @param place
	 *            nombre de place disponible dans la catégorie
	 * @param prix
	 *            prix à payer pour la catégorie
	 */
	public Categorie(String nom, int place, double prix) {
		this.nom = nom;
		this.place = place;
		this.prix = prix;
		listChambre = new ArrayList<Chambre>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * Ajout d'une chambre dans la catégorie
	 * 
	 * @param c
	 */
	public void addChambre(Chambre c) {
		listChambre.add(c);
	}

	/**
	 * Enlever une chambre de la catégorie
	 * 
	 * @param c
	 */
	public void removeChambre(Chambre c) {
		listChambre.remove(c);
	}
}
