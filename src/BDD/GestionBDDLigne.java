package BDD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import classe_defaut.Ligne;
import classe_defaut.Ville;

/**
 * Gestion des requêtes sur les lignes
 * 
 * @author BRIERE / CARDON
 *
 */
public class GestionBDDLigne {

	Connection conn;

	/**
	 * Constructeur de la class
	 * 
	 * @param conn
	 *            connexion à la BDD (préalablement créée par la class Connect
	 */
	public GestionBDDLigne(Connection conn) {
		this.conn = conn;
	}

	/**
	 * Ajoute une ligne
	 * 
	 * @param villeAller
	 *            nom de la ville
	 * @param villeRetour
	 *            nom de la ville
	 * @param cleVilleAller
	 *            ID ville
	 * @param cleVilleRetour
	 *            ID ville
	 * @return
	 */
	public boolean addLigne(String villeAller, String villeRetour, int cleVilleAller, int cleVilleRetour) {

		String requete = "insert into ligne (idvillealler,nomvilledepart,idvilleretour,nomvillearrive) values ("
				+ cleVilleAller + ",'" + villeAller + "'," + cleVilleRetour + ",'" + villeRetour + "')";
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
	 * Supprission d'une ligne
	 * 
	 * @param cleVilleAller
	 *            ID ville
	 * @param cleVilleRetour
	 *            ID ville
	 * @return
	 */
	public boolean supLigne(int cleVilleAller, int cleVilleRetour) {
		String requete = "delete from ligne where idvillealler =" + cleVilleAller + " and idvilleretour="
				+ cleVilleRetour;
		String requete2 = "select * from ligne where idvillealler =" + cleVilleAller + " and idvilleretour ="
				+ cleVilleRetour;
		System.out.println(requete);
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
	 * Selectionne les lignes
	 * 
	 * @return
	 */
	public ArrayList<Ligne> allLigne() {
		ArrayList<Ligne> ligne = new ArrayList<Ligne>();
		String requete = "select nomvilledepart , nomvillearrive from ligne";
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while (result.next()) {
				String nom = result.getString("nomvilledepart");
				String nom2 = result.getString("nomvillearrive");
				Ville depart = new Ville(nom);
				Ville arrive = new Ville(nom2);
				Ligne l = new Ligne(depart, arrive);
				ligne.add(l);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ligne;

	}

	/**
	 * Détermine l'id d'une ligne
	 * 
	 * @param villeD
	 *            nom de la ville de départ
	 * @param villeA
	 *            nom de la ville d'arrivéee
	 * @return
	 */
	public int cleLigne(String villeD, String villeA) {
		int cle = 0;
		String requete = "select idligne from ligne  where nomvilledepart ='" + villeD + "' and nomvillearrive ='"
				+ villeA + "'";
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while (result.next()) {
				cle = result.getInt("idligne");
			}

			return cle;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cle;
	}

	/**
	 * Voir les lignes disponibles au départ d'une ville
	 * 
	 * @param cleVilleDepart
	 *            ID de la ville de départ
	 * @return
	 */
	public ArrayList<Ligne> voirLigneResaArrive(int cleVilleDepart) {
		ArrayList<Ligne> ligne = new ArrayList<Ligne>();
		String requete = "select nomvilledepart , nomvillearrive from ligne where idvillealler =" + cleVilleDepart;
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while (result.next()) {
				String nom = result.getString("nomvilledepart");
				String nom2 = result.getString("nomvillearrive");
				Ville depart = new Ville(nom);
				Ville arrive = new Ville(nom2);
				Ligne l = new Ligne(depart, arrive);
				ligne.add(l);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ligne;

	}

}
