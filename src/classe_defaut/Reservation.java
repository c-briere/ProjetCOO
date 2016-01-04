package classe_defaut;

/**
 * Le client passe des réservations. Il réserve son transport et son séjour
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
	 * date du départ du voyage
	 */
	public String dateAller;
	/**
	 * Départ du voyage
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
	 * Hôtel réservé
	 */
	public Hotel hotel;
	/**
	 * catégorie de la chambre réservée
	 */
	public Categorie categorie;
	/**
	 * chambre réservée
	 */
	public Chambre chambre;
	/**
	 * Nombre de nuitées
	 */
	public int nbDeNuit;
	/**
	 * Prix de la catégorie de la chambre (par extension prix de l'hôtel)
	 */
	public double prixHotel;
	/**
	 * Prix du transport + prix de l'hôtel
	 */
	public double prixTotal;
	/**
	 * Nom du client
	 */
	public String nom;
	/**
	 * Heure de départ
	 */
	public String heureAller;
	/**
	 * Heure de départ pour le retour
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
	 *            départ du voyage
	 * @param dateRetour
	 *            date de la fin du voyage
	 * @param prixTransport
	 *            prix du transport
	 * @param nbPersonne
	 *            nombre de personnes participantes au voyage
	 * @param hotel
	 *            hôtel réservé pour le voyage
	 * @param categorie
	 *            catégorie de la chambre
	 * @param chambre
	 *            chambre réservée
	 * @param nbDeNuit
	 *            nombre de nuitées
	 * @param prixHotel
	 *            prix de l'hôtel
	 * @param prixTotal
	 *            prix de l'hôtel + prix du transport
	 * @param nom
	 *            nom du client
	 * @param heureAller
	 *            horaire de départ du voyage
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
