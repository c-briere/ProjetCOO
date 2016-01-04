package BDD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import classe_defaut.Chambre;

/**
 * Gestion des requêtes sur la chambre
 * 
 * @author BRIERE / CARDON
 *
 */
public class GestionBDDChambre {

	Connection conn;

	/**
	 * Constructeur de la class
	 * 
	 * @param conn
	 *            connexion à la BDD (préalablement créée par la class Connect)
	 */
	public GestionBDDChambre(Connection conn) {
		this.conn = conn;
	}

	/**
	 * Requête SQL qui insert une chambre dans la BDD
	 * 
	 * @param cleCategorie
	 *            ID de la catégorie
	 * @param nom
	 *            nom de la chambre
	 * @return
	 */
	public boolean addChambre(int cleCategorie, String nom) {
		String requete = "insert into chambre (nom, idcategorie) values ('" + nom + "'," + cleCategorie + ")";
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
	 * Suppression d'une chambre
	 * 
	 * @param chambre
	 * @param cleCategorie
	 * @return
	 */
	public boolean suppChambre(String chambre, int cleCategorie) {
		String requete = "delete from chambre where lower(nom) ='" + chambre + "' and idcategorie =" + cleCategorie;
		String requete2 = "select * from chambre  where lower(nom) ='" + chambre + "' and idhotel =" + cleCategorie;
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
	 * Selectionne toutes les chambres d'une catégorie
	 * 
	 * @param cleCategorie
	 *            ID catégorie
	 * @return
	 */
	public ArrayList<Chambre> voirChambre(int cleCategorie) {
		ArrayList<Chambre> chambre = new ArrayList<Chambre>();
		String requete = "select nom from chambre  where idcategorie =" + cleCategorie + " order by lower(nom)";
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while (result.next()) {
				String nom = result.getString(1);
				Chambre c = new Chambre(nom);
				chambre.add(c);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chambre;
	}

	/**
	 * Création d'une liste de chambres
	 * 
	 * @param idCategorie
	 *            ID catégorie
	 * @param liste
	 * @return
	 */
	public ArrayList<Chambre> listChambre(int idCategorie, ArrayList<Integer> liste) {
		ArrayList<Chambre> chambre = new ArrayList<Chambre>();
		String s = "";
		if (liste != null) {
			for (int i = 0; i < liste.size(); i++) {
				s = s + Integer.toString(liste.get(i));
			}

		}

		String requete;
		System.out.println(idCategorie);
		if (!s.equals("")) {
			requete = "select chambre.nom from chambre  where chambre.idcategorie =" + idCategorie
					+ " and chambre.id_chambre not in (select id_chambre from chambre where id_chambre=" + s + ")";
		} else {
			requete = "select chambre.nom from chambre where chambre.idcategorie =" + idCategorie;

		}

		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while (result.next()) {
				String nom = result.getString(1);
				chambre.add(new Chambre(nom));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chambre;
	}

	/**
	 * Cherche l'id d'une chambre en fonction de son nom et de sa catégorie
	 * 
	 * @param denomination
	 *            nom de la chambre
	 * @param idCategorie
	 *            ID catégorie
	 * @return
	 */
	public int cleChambre(String denomination, int idCategorie) {
		int cle2 = 0;
		String requete = "select id_chambre from chambre  where idcategorie =" + idCategorie + " and nom ='"
				+ denomination + "'";
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while (result.next()) {
				cle2 = result.getInt(1);
			}

			return cle2;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cle2;

	}
}
