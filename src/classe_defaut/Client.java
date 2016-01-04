package classe_defaut;
import java.util.Date;


public class Client {

	public String nom;
	public String prenom;
	public Date dateNaissance;
	public String ville;
	
	public Client(String nom, String prenom, Date dateNaissance, String ville){
		this.nom=nom;
		this.prenom=prenom;
		this.dateNaissance=dateNaissance;
		this.ville=ville;
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
