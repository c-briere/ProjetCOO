package BDD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.Date;

import classe_defaut.Hotel;
import classe_defaut.HotelRestant;

/**
 * Gestion des requêtes sur l'hôtel
 * 
 * @author BRIERE / CARDON
 *
 */
public class GestionBDDHotel {

	Connection conn;

	/**
	 * Constructeur de la class
	 * 
	 * @param conn
	 *            connexion à la BDD (préalablement créée par la class Connect
	 */
	public GestionBDDHotel(Connection conn) {
		this.conn = conn;
	}

	/**
	 * Ajout d'un hôtel
	 * 
	 * @param cle
	 *            ID hôtel
	 * @param nom
	 *            nom de l'hôtel
	 * @return
	 */
	public boolean addHotel(int cle, String nom) {
		String requete = "insert into hotel (idville, nom) values (" + cle + ",'" + nom + "')";
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
	 * Suppression d'un hôtel
	 * 
	 * @param cle
	 *            ID hôtel
	 * @param hotel
	 *            nom de l'hôtel
	 * @return
	 */
	public boolean deleteHotel(int cle, String hotel) {
		String requete = "delete from hotel where lower(nom) ='" + hotel + "' and idville =" + cle;
		String requete2 = "select * from hotel  where lower(nom) ='" + hotel + "' and idville =" + cle;
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
	 * Selectionne les hôtels d'une ville
	 * 
	 * @param cle
	 *            ID hôtel
	 * @return
	 */
	public ArrayList<Hotel> voirHotel(int cle) {
		ArrayList<Hotel> hotel = new ArrayList<Hotel>();
		String requete = "select nom from hotel  where idville =" + cle + " order by lower(nom)";
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while (result.next()) {
				String nom = result.getString(1);
				Hotel c = new Hotel(nom);
				hotel.add(c);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hotel;

	}

	/**
	 * Détermine l'ID d'un hôtel
	 * 
	 * @param hotel
	 *            nom de l'hôtel
	 * @param cleVille
	 *            ID de la ville
	 * @return
	 */
	public int cleHotel(String hotel, int cleVille) {
		int cle = 0;
		String requete = "select idhotel from hotel  where idville =" + cleVille + " and nom ='" + hotel + "'";
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while (result.next()) {
				cle = result.getInt("idhotel");
			}

			return cle;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cle;
	}

	/**
	 * Liste des disponibilités
	 * 
	 * @param cleVilleArrive
	 *            ID ville d'arrivée
	 * @param nbPersonneVoyage
	 * @param arrive
	 *            date d'arrivée
	 * @param depart
	 *            date de départ
	 * @param liste
	 * @return
	 */
	public ArrayList<HotelRestant> listHotel(int cleVilleArrive, int nbPersonneVoyage, Date arrive, Date depart,
			ArrayList<Integer> liste) {
		String s = "";
		if (liste != null) {
			for (int i = 0; i < liste.size(); i++) {
				s = s + Integer.toString(liste.get(i));
			}

		}
		ArrayList<HotelRestant> hotel = new ArrayList<HotelRestant>();
		String requete;
		if (!s.equals("")) {
			requete = "select hotel.nom,count(hotel.nom) as nombreRestant from hotel join categorie on hotel.idhotel = categorie.idhotel join chambre on categorie.idcategorie=chambre.idcategorie where hotel.idville ="
					+ cleVilleArrive
					+ " and chambre.id_chambre not in (select id_chambre from chambre where id_chambre=" + s
					+ ") and categorie.place >= " + nbPersonneVoyage + " group by hotel.nom";
		} else {
			requete = "select hotel.nom,count(hotel.nom) as nombreRestant from hotel join categorie on hotel.idhotel = categorie.idhotel join chambre on categorie.idcategorie = chambre.idcategorie where hotel.idville ="
					+ cleVilleArrive + "  and categorie.place >= " + nbPersonneVoyage + " group by hotel.nom";

		}
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while (result.next()) {
				String nom = result.getString("nom");
				int nb = result.getInt("nombreRestant");
				hotel.add(new HotelRestant(nom, nb));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hotel;
	}

	/**
	 * Sélectionne toutes les chambres réservées
	 * 
	 * @param cleVilleArrive
	 *            ID ville d'arrivée
	 * @param arrive
	 *            date d'arrivée
	 * @param depart
	 *            date du départ
	 * @return
	 */
	public ArrayList<Integer> listChambreNonDipos(int cleVilleArrive, Date arrive, Date depart) {
		ArrayList<Integer> liste = null;
		String requete = "select distinct idchambre from reservation natural join categorie where reservation.idvillearrive ="
				+ cleVilleArrive + " and reservation.datearrive between '" + arrive + "' and '" + depart
				+ "' or reservation.dateretour between '" + arrive + "' and '" + depart
				+ "' or reservation.datearrive = '" + arrive + "'or reservation.datearrive = '" + depart
				+ "' or reservation.dateretour = '" + arrive + "' or reservation.dateretour = '" + depart + "'";
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			liste = new ArrayList<Integer>();
			while (result.next()) {
				int a = result.getInt("idchambre");
				liste.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}

}
