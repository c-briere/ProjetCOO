package classe_defaut;

/**
 * Le client passe des r�servations. Il r�serve son transport et son s�jour
 * 
 * @author BRIERE / CARDON
 *
 */
public class Reservation {
	/**
	 * Destination du voyage
	 */
	public Ville villeAller;
	/**
	 * date du d�part du voyage
	 */
	public String dateAller;
	/**
	 * D�part du voyage
	 */
	public Ville villeRetour;
	/**
	 * date de fin du voyage
	 */
	public String dateRetour;
	/**
	 * prix des transports (aller-retour)
	 */
	public double prixTransport;
	/**
	 * Nombre de personnes participent au voyage
	 */
	public int nbPersonne;
	/**
	 * H�tel r�serv�
	 */
	public Hotel hotel;
	/**
	 * cat�gorie de la chambre r�serv�e
	 */
	public Categorie categorie;
	/**
	 * chambre r�serv�e
	 */
	public Chambre chambre;
	/**
	 * Nombre de nuit�es
	 */
	public int nbDeNuit;
	/**
	 * Prix de la cat�gorie de la chambre (par extension prix de l'h�tel)
	 */
	public double prixHotel;
	/**
	 * Prix du transport + prix de l'h�tel
	 */
	public double prixTotal;
	/**
	 * Nom du client
	 */
	public String nom;
	/**
	 * Heure de d�part
	 */
	public String heureAller;
	/**
	 * Heure de d�part pour le retour
	 */
	public String heureRetour;

	/**
	 * Constructeur de la class
	 * 
	 * @param villeAller
	 *            destination du voyage
	 * @param dateAller
	 *            date du voyage
	 * @param villeRetour
	 *            d�part du voyage
	 * @param dateRetour
	 *            date de la fin du voyage
	 * @param prixTransport
	 *            prix du transport
	 * @param nbPersonne
	 *            nombre de personnes participantes au voyage
	 * @param hotel
	 *            h�tel r�serv� pour le voyage
	 * @param categorie
	 *            cat�gorie de la chambre
	 * @param chambre
	 *            chambre r�serv�e
	 * @param nbDeNuit
	 *            nombre de nuit�es
	 * @param prixHotel
	 *            prix de l'h�tel
	 * @param prixTotal
	 *            prix de l'h�tel + prix du transport
	 * @param nom
	 *            nom du client
	 * @param heureAller
	 *            horaire de d�part du voyage
	 * @param heureRetour
	 *            horaire de fin du voyage
	 */
	public Reservation(Ville villeAller, String dateAller, Ville villeRetour, String dateRetour, double prixTransport,
			int nbPersonne, Hotel hotel, Categorie categorie, Chambre chambre, int nbDeNuit, double prixHotel,
			double prixTotal, String nom, String heureAller, String heureRetour) {
		this.villeAller = villeAller;
		this.dateAller = dateAller;
		this.villeRetour = villeRetour;
		this.dateRetour = dateRetour;
		this.prixTransport = prixTransport;
		this.nbPersonne = nbPersonne;
		this.hotel = hotel;
		this.categorie = categorie;
		this.chambre = chambre;
		this.nbDeNuit = nbDeNuit;
		this.prixHotel = prixHotel;
		this.prixTotal = prixTotal;
		this.nom = nom;
		this.heureAller = heureAller;
		this.heureRetour = heureRetour;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getHeureAller() {
		return heureAller;
	}

	public void setHeureAller(String heureAller) {
		this.heureAller = heureAller;
	}

	public String getHeureRetour() {
		return heureRetour;
	}

	public void setHeureRetour(String heureRetour) {
		this.heureRetour = heureRetour;
	}

	public Ville getVilleAller() {
		return villeAller;
	}

	public void setVilleAller(Ville villeAller) {
		this.villeAller = villeAller;
	}

	public String getDateAller() {
		return dateAller;
	}

	public void setDateAller(String dateAller) {
		this.dateAller = dateAller;
	}

	public Ville getVilleRetour() {
		return villeRetour;
	}

	public void setVilleRetour(Ville villeRetour) {
		this.villeRetour = villeRetour;
	}

	public String getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(String dateRetour) {
		this.dateRetour = dateRetour;
	}

	public double getPrixTransport() {
		return prixTransport;
	}

	public void setPrixTransport(double prixTransport) {
		this.prixTransport = prixTransport;
	}

	public int getNbPersonne() {
		return nbPersonne;
	}

	public void setNbPersonne(int nbPersonne) {
		this.nbPersonne = nbPersonne;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public int getNbDeNuit() {
		return nbDeNuit;
	}

	public void setNbDeNuit(int nbDeNuit) {
		this.nbDeNuit = nbDeNuit;
	}

	public double getPrixHotel() {
		return prixHotel;
	}

	public void setPrixHotel(double prixHotel) {
		this.prixHotel = prixHotel;
	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}

}
