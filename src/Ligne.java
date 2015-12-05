
public class Ligne {

	public Ville villeAller;
	public Ville villeRetour;
	
	public Ligne(Ville villeAller, Ville villeRetour){
		this.villeAller=villeAller;
		this.villeRetour=villeRetour;
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
	
}
