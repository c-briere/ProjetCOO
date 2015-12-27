import java.util.ArrayList;


public class Categorie {
	String nom;
	int place;
	double prix;
	ArrayList<Chambre> listChambre;

	Categorie(String nom, int place, double prix){
		this.nom=nom;
		this.place=place;
		this.prix=prix;
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
	public void addChambre(Chambre c){
		listChambre.add(c);
	}

	public void removeChambre(Chambre c){
		listChambre.remove(c);
	}
}
