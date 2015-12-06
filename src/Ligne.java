import java.util.ArrayList;


public class Ligne {

	public Ville villeAller;
	public Ville villeRetour;
	public ArrayList<Trajet> trajet;
	
	public Ligne(Ville villeAller, Ville villeRetour){
		this.villeAller=villeAller;
		this.villeRetour=villeRetour;
		trajet = new ArrayList<Trajet>();
	}

	public Ville getVilleAller() {
		return villeAller;
	}

	public void setVilleAller(Ville villeAller) {
		this.villeAller = villeAller;
	}

	public Ville getVilleRetour() {
		return villeRetour;
	}

	public void setVilleRetour(Ville villeRetour) {
		this.villeRetour = villeRetour;
	}

	public ArrayList<Trajet> getTrajet() {
		return trajet;
	}

	public void setTrajet(ArrayList<Trajet> trajet) {
		this.trajet = trajet;
	}
	
	public void addTrajet(Trajet t){
		trajet.add(t);
	}
	
	public void suppTrajet(Trajet t){
		trajet.remove(t);
	}
	
}
