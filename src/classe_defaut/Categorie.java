package classe_defaut;

import java.util.ArrayList;

/**
 * Chaque chambre appartient � une cat�gorie La cat�gorie est repr�sent�e par un
 * nom, un prix et un nombre de places
 * 
 * @author BRIERE / CARDON
 *
 */
public class Categorie {
	/**
	 * nom de la cat�gorie
	 */
	private String nom;
	/**
	 * Nombre de place maximum pour la cat�gorie
	 */
	private int place;
	/**
	 * prix � payer pour cette cat�gorie
	 */
	private double prix;
	/**
	 * Chaque chambre appartient � une cat�gorie
	 */
	private ArrayList<Chambre> listChambre;

	/**
	 * Constructeur de la class
	 * 
	 * @param nom
	 *            nom de la cat�gorie
	 * @param place
	 *            nombre de place disponible dans la cat�gorie
	 * @param prix
	 *            prix � payer pour la cat�gorie
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
	 * Ajout d'une chambre dans la cat�gorie
	 * 
	 * @param c
	 */
	public void addChambre(Chambre c) {
		listChambre.add(c);
	}

	/**
	 * Enlever une chambre de la cat�gorie
	 * 
	 * @param c
	 */
	public void removeChambre(Chambre c) {
		listChambre.remove(c);
	}
}
