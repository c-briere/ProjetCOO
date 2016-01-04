package classe_defaut;

public class Reservation {

	public Ville villeAller;
	public String dateAller;
	public Ville villeRetour;
	public String dateRetour;
	public double prixTransport;
	public int nbPersonne;
	public Hotel hotel;
	public Categorie categorie;
	public Chambre chambre;
	public int nbDeNuit;
	public double prixHotel;
	public double prixTotal;
	public String nom;
	public String heureAller;
	public String heureRetour;
	
	public Reservation(Ville villeAller, String dateAller, Ville villeRetour,String dateRetour,double prixTransport,
			int nbPersonne, Hotel hotel, Categorie categorie, Chambre chambre, int nbDeNuit, double prixHotel, double prixTotal, String nom, String heureAller, String heureRetour){
		this.villeAller=villeAller;
		this.dateAller=dateAller;
		this.villeRetour=villeRetour;
		this.dateRetour=dateRetour;
		this.prixTransport=prixTransport;
		this.nbPersonne=nbPersonne;
		this.hotel=hotel;
		this.categorie=categorie;
		this.chambre=chambre;
		this.nbDeNuit=nbDeNuit;
		this.prixHotel=prixHotel;
		this.prixTotal=prixTotal;
		this.nom=nom;
		this.heureAller=heureAller;
		this.heureRetour=heureRetour;
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
