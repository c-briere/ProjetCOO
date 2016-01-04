package classe_defaut;

public class HotelRestant {
	
	String nom;
	int nbPlaceRestante;
	
	public HotelRestant(String nom,int nbPlaceRestante){
		this.nom=nom;
		this.nbPlaceRestante=nbPlaceRestante;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbPlaceRestante() {
		return nbPlaceRestante;
	}

	public void setNbPlaceRestante(int nbPlaceRestante) {
		this.nbPlaceRestante = nbPlaceRestante;
	}
	
}
