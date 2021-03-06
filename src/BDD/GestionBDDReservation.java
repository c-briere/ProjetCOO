package BDD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import classe_defaut.Categorie;
import classe_defaut.Chambre;
import classe_defaut.Hotel;
import classe_defaut.Reservation;
import classe_defaut.Ville;

/**
 * Gestion des requêtes sur les réservations
 * 
 * @author BRIERE / CARDON
 *
 */
public class GestionBDDReservation {

	public Connection conn;

	/**
	 * Constructeur de la class
	 * 
	 * @param conn
	 *            connexion à la BDD (préalablement créée par la class Connect)
	 */
	public GestionBDDReservation(Connection conn) {
		this.conn = conn;
	}

	/**
	 * Création d'une réservation
	 * 
	 * @param heureAller
	 * @param heureRetour
	 * @param villeAller
	 * @param dateAller
	 * @param villeRetour
	 * @param dateRetour
	 * @param prixAller
	 * @param prixRetour
	 * @param nbPersonneVoyage
	 * @param idHotel
	 * @param idCategorie
	 * @param cleClient
	 * @param idChambre
	 * @param nbJour
	 * @return
	 */
	public Reservation createReservation(String heureAller, String heureRetour, String villeAller, String dateAller,
			String villeRetour, String dateRetour, Double prixAller, Double prixRetour, int nbPersonneVoyage,
			int idHotel, int idCategorie, int cleClient, int idChambre, int nbJour) {
		Reservation reservation = null;

		String requete = "select hotel.nom,categorie.nom,chambre.nom, categorie.prix from hotel join categorie on hotel.idhotel=categorie.idhotel join chambre on categorie.idcategorie=chambre.idcategorie"
				+ " where hotel.idhotel=" + idHotel + " and categorie.idcategorie=" + idCategorie
				+ " and chambre.id_chambre=" + idChambre;
		String requete2 = "select nom from client where idclient=" + cleClient;
		try {
			Statement stmt = conn.createStatement();
			Statement stmt2 = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			ResultSet result2 = stmt2.executeQuery(requete2);
			while (result.next()) {
				String nomHotel = result.getString(1);
				String nomCategorie = result.getString(2);
				String nomChambre = result.getString(3);
				double prix = result.getDouble(4);
				while (result2.next()) {
					String nom = result2.getString(1);
					reservation = new Reservation(new Ville(villeAller), dateAller, new Ville(villeRetour), dateRetour,
							prixAller + prixRetour, nbPersonneVoyage, new Hotel(nomHotel),
							new Categorie(nomCategorie, nbPersonneVoyage, prix), new Chambre(nomChambre), nbJour, prix,
							(prix * nbJour) + prixAller + prixRetour, nom, heureAller, heureRetour);

				}
			}
			stmt.close();
			stmt2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reservation;
	}

	/**
	 * Ajout de la réservation
	 * 
	 * @param cleClient
	 * @param cleVilleDepart
	 * @param cleVilleArrive
	 * @param cleLigneAller
	 * @param cleLigneRetour
	 * @param classeAller
	 * @param classeRetour
	 * @param idHotel
	 * @param idCategorie
	 * @param cleChambre
	 * @param dateAller
	 * @param dateRetour
	 * @param prixTotal
	 * @param nbPersonne
	 * @return
	 */
	public boolean ajoutResa(int cleClient, int cleVilleDepart, int cleVilleArrive, int cleLigneAller,
			int cleLigneRetour, String classeAller, String classeRetour, int idHotel, int idCategorie, int cleChambre,
			String dateAller, String dateRetour, double prixTotal, int nbPersonne) {
		String requete = "insert into reservation (cleclient,idvilledepart,idvillearrive,clelignealler,cleligneretour,classealler,classeretour,idhotel,idcategorie,idchambre,datearrive,dateretour,prixtotal,nbpersonne) values ("
				+ cleClient + "," + cleVilleDepart + "," + cleVilleArrive + "," + cleLigneAller + "," + cleLigneRetour
				+ ",'" + classeAller + "','" + classeRetour + "'," + idHotel + "," + idCategorie + "," + cleChambre
				+ ",'" + dateAller + "','" + dateRetour + "'," + prixTotal + "," + nbPersonne + ")";
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(requete);
			stmt.close();
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;

		}

	}

	/**
	 * Détermine l'ID d'une réservation
	 * 
	 * @return
	 */
	public int cleResa() {
		String requete = "SELECT idreservation FROM reservation ORDER BY idreservation DESC LIMIT 1 ";
		int cle = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while (result.next()) {
				cle = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cle;
	}

	/**
	 * Vérification pour savoir si on peut annuler une réservation Passée une
	 * certaine période on ne peut annuler une réservation
	 * 
	 * @param nom
	 *            nom du client
	 * @param id
	 *            ID de la réservation
	 * @return
	 */
	public boolean verifSuppResa(String nom, String id) {
		int i = 0;
		String requete = "select (reservation.datearrive-annulable)::date- current_date::date from reservation join trajet on reservation.clelignealler=trajet.idligne join client on reservation.cleclient=client.idclient where idreservation="
				+ id + " and client.nom='" + nom + "'";
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while (result.next()) {
				i = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i > 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Suppression d'une réservation
	 * 
	 * @param text
	 *            ID réservation
	 * @return
	 */
	public boolean suppResa(String text) {
		String requete = "delete from reservation where idreservation =" + text;
		String requete2 = "select * from reservation  where idreservation =" + text;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(requete2);
			if (rs.next()) {
				stmt.executeUpdate(requete);
				stmt.close();
			} else {
				stmt.close();
				return false;
			}
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;

		}
	}

	/**
	 * Sélectionne les réservations d'un client
	 * 
	 * @param cle
	 *            ID client
	 * @return
	 */
	public ArrayList<Reservation> voirResa(int cle) {
		ArrayList<Reservation> reservation = new ArrayList<Reservation>();
		String requeteAller = "select reservation.idreservation, ville.nom, reservation.datearrive,reservation.prixtotal, reservation.nbpersonne, hotel.nom,categorie.nom,chambre.nom, client.nom, trajet.heuredepart from reservation join client on reservation.cleclient=client.idclient join hotel on reservation.idhotel=hotel.idhotel join categorie on reservation.idcategorie=categorie.idcategorie join chambre on reservation.idchambre=chambre.id_chambre join ville on reservation.idvilledepart = ville.idville join trajet on reservation.clelignealler=trajet.idligne where idclient ="
				+ cle;
		System.out.println(requeteAller);
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requeteAller);
			while (result.next()) {
				int cleResa = result.getInt(1);
				String villeAller = result.getString(2);
				String dateAller = result.getString(3);
				double prix = result.getDouble(4);
				int nbPersonne = result.getInt(5);
				String nomHotel = result.getString(6);
				String nomCategorie = result.getString(7);
				String nomChambre = result.getString(8);
				String nomClient = result.getString(9);
				String heureArrive = result.getString(10);
				String requeteRetour = "select ville.nom,reservation.dateretour,trajet.heuredepart from reservation join trajet on reservation.cleligneretour=trajet.idligne join ville on reservation.idvillearrive=ville.idville where idreservation="
						+ cleResa;
				try {
					Statement stmt2 = conn.createStatement();
					ResultSet result2 = stmt2.executeQuery(requeteRetour);
					while (result2.next()) {
						String villeRetour = result2.getString(1);
						String dateRetour = result2.getString(2);
						String heureRetour = result2.getString(3);
						Reservation r = new Reservation(new Ville(villeAller), dateAller, new Ville(villeRetour),
								dateRetour, 0, nbPersonne, new Hotel(nomHotel),
								new Categorie(nomCategorie, nbPersonne, 0), new Chambre(nomChambre), 0, 0, prix,
								nomClient, heureArrive, heureRetour);
						reservation.add(r);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservation;
	}

}
