package BDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import classe_defaut.Categorie;

/**
 * Gestion des requêtes sur la catégorie
 * 
 * @author BRIERE / CARDON
 *
 */
public class GestionBDDCategorie {
	Connection conn;

	/**
	 * Constructeur de la class
	 * 
	 * @param conn
	 *            connexion à la BDD (préalablement créée par la class Connect
	 */
	public GestionBDDCategorie(Connection conn) {
		this.conn = conn;
	}

	/**
	 * Requête SQL qui ajoute une catégorie dans la BDD
	 * 
	 * @param cleHotel
	 *            ID de l'hotel
	 * @param nom
	 *            nom de la catégorie
	 * @param prix
	 *            prix de la catégorie
	 * @param place
	 *            nombre de place
	 * @return
	 */
	public boolean addCategorie(int cleHotel, String nom, double prix, int place) {
		String requete = "insert into categorie (idhotel, nom, place, prix) values (" + cleHotel + ",'" + nom + "',"
				+ place + "," + prix + ")";
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
	 * Requête qui supprime une catégorie
	 * 
	 * @param categorie
	 *            nom de la catégorie
	 * @param cleHotel
	 *            ID de l'hôtel
	 * @return
	 */
	public boolean suppCategorie(String categorie, int cleHotel) {
		String requete = "delete from categorie where lower(nom) ='" + categorie + "' and idhotel =" + cleHotel;
		String requete2 = "select * from categorie  where lower(nom) ='" + categorie + "' and idhotel =" + cleHotel;
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
	 * Requête SQL qui affiche toutes les catégories d'un hôtel
	 * 
	 * @param cleHotel
	 *            ID de l'hôtel
	 * @return
	 */
	public ArrayList<Categorie> voirCategorie(int cleHotel) {
		ArrayList<Categorie> categorie = new ArrayList<Categorie>();
		String requete = "select nom, place,prix from categorie  where idhotel =" + cleHotel + " order by lower(nom)";
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while (result.next()) {
				String nom = result.getString(1);
				int place = result.getInt(2);
				double prix = result.getDouble(3);
				Categorie c = new Categorie(nom, place, prix);
				categorie.add(c);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorie;
	}

	/**
	 * Requête SQL qui cherche l'ID d'une catégorie en donnant son nom et son
	 * hôtel
	 * 
	 * @param cleHotel
	 *            ID de l'hôtel
	 * @param nom
	 *            nom de la catégorie
	 * @return
	 */
	public int verifCategorie(int cleHotel, String nom) {
		int cle = 0;
		System.out.println(cleHotel);
		String requete2 = "select idcategorie from categorie where lower(nom) ='" + nom + "' and idhotel =" + cleHotel;
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete2);
			while (result.next()) {
				cle = result.getInt("idcategorie");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cle;
	}

	/**
	 * Modification de la table catégorie
	 * 
	 * @param cleCategorie
	 *            ID de la catégorie
	 * @param nom
	 *            nom de la catégorie
	 * @param place
	 *            nombre de place
	 * @param prix
	 *            prix de la catégorie
	 * @return
	 */
	public boolean ModifClient(int cleCategorie, String nom, Double place, int prix) {
		try {
			PreparedStatement stmt = conn.prepareStatement("update categorie set nom='" + nom + "', place=" + place
					+ ",prix=" + prix + " where idcategorie =" + cleCategorie);

			stmt.executeUpdate();
			stmt.close();
			return true;

		}

		catch (SQLException e) {

			e.printStackTrace();
			return false;

		}
	}

	/**
	 * Recherche de l'id d'une catégorie en fonction de l'hôtel et du nom de la
	 * catégorie
	 * 
	 * @param categorie
	 *            nom de la catégorie
	 * @param cle
	 *            ID de l'hôtel
	 * @return
	 */
	public int cleCategorie(String categorie, int cle) {
		int cle2 = 0;
		String requete = "select idcategorie from categorie  where idhotel =" + cle + " and nom ='" + categorie + "'";
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while (result.next()) {
				cle2 = result.getInt("idcategorie");
			}

			return cle2;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cle2;

	}

	/**
	 * Création d'une liste de catégories
	 * 
	 * @param idHotel
	 * @param liste
	 * @param nbPersonneVoyage
	 * @return
	 */
	public ArrayList<Categorie> listCategorie(int idHotel, ArrayList<Integer> liste, int nbPersonneVoyage) {
		ArrayList<Categorie> categorie = new ArrayList<Categorie>();
		String s = "";
		if (liste != null) {
			for (int i = 0; i < liste.size(); i++) {
				s = s + Integer.toString(liste.get(i));
			}

		}

		String requete;
		if (!s.equals("")) {
			requete = "select categorie.nom,categorie.place, categorie.prix from categorie join chambre on categorie.idcategorie=chambre.idcategorie where categorie.idhotel ="
					+ idHotel + " and chambre.id_chambre not in (select id_chambre from chambre where id_chambre=" + s
					+ ") and categorie.place >= " + nbPersonneVoyage;
		} else {
			requete = "select categorie.nom,categorie.place, categorie.prix from categorie where categorie.idhotel ="
					+ idHotel + "  and categorie.place >= " + nbPersonneVoyage;

		}

		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while (result.next()) {
				String nom = result.getString(1);
				int nb = result.getInt(2);
				double prix = result.getDouble(3);
				categorie.add(new Categorie(nom, nb, prix));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorie;
	}
}
