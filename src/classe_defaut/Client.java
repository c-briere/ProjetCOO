package classe_defaut;

import java.util.Date;

/**
 * Le client représente la personne qui va réserver le transport et la chambre
 * d'hôtel
 * 
 * @author BRIERE / CARDON
 *
 */
public class Client {
	/**
	 * nom du client
	 */
	public String nom;
	/**
	 * Prénom du client
	 */
	public String prenom;
	/**
	 * date de naissance du client
	 */
	public Date dateNaissance;
	/**
	 * Ville du client
	 */
	public String ville;

	/**
	 * Constructeur de la classe
	 * 
	 * @param nom
	 *            nom du client
	 * @param prenom
	 *            prénom du client
	 * @param dateNaissance
	 *            date de naissance
	 * @param ville
	 *            ville du client
	 */
	public Client(String nom, String prenom, Date dateNaissance, String ville) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.ville = ville;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
