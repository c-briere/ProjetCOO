package classe_defaut;
import java.util.ArrayList;


public class Ville {
	
	private String nom;
	private ArrayList<Hotel> listHotel;
	
	public Ville(String nom){
		this.nom=nom;
		this.listHotel= new ArrayList<Hotel>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void addHotel(Hotel hotel){
		this.listHotel.add(hotel);
	}
	
	public void suppHotel(Hotel hotel){
		this.listHotel.remove(hotel);
	}

	public ArrayList<Hotel> getListHotel() {
		return listHotel;
	}

	public void setListHotel(ArrayList<Hotel> listHotel) {
		this.listHotel = listHotel;
	}
	
	
	
}
