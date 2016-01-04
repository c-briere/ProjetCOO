package classe_defaut;

import java.util.ArrayList;

/**
 * La ligne est une liaison entre deux villes La ligne ne se suffit pas �
 * elle-m�me pour faire voyager des clients. Il faudra y ajouter des trajets
 * 
 * @author BRIERE / CARDON
 *
 */
public class Ligne {
	/**
	 * destination de la ligne
	 */
	public Ville villeAller;
	/**
	 * d�part de la ligne
	 */
	public Ville villeRetour;
	/**
	 * liste des trajets ratach�s � la ligne
	 */
	public ArrayList<Trajet> trajet;

	/**
	 * Constructeur de la class
	 * 
	 * @param villeAller
	 *            destination de la ligne
	 * @param villeRetour
	 *            ville de d�part de la ligne
	 */
	public Ligne(Ville villeAller, Ville villeRetour) {
		this.villeAller = villeAller;
		this.villeRetour = villeRetour;
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

	/**
	 * ajout d'une trajet � la ligne
	 * 
	 * @param t
	 */
	public void addTrajet(Trajet t) {
		trajet.add(t);
	}

	/**
	 * supression d'un trajet � la ligne
	 * 
	 * @param t
	 */
	public void suppTrajet(Trajet t) {
		trajet.remove(t);
	}

}
