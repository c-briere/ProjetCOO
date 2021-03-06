package BDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import classe_defaut.Client;

/**
 * Gestion des requêtes sur le client
 * 
 * @author BRIERE / CARDON
 *
 */
public class GestionBDDClient {

	public Connection conn;

	/**
	 * Constructeur de la class
	 * 
	 * @param conn
	 *            connexion à la BDD (préalablement créée par la class Connect
	 */
	public GestionBDDClient(Connection conn) {
		this.conn = conn;
	}

	/**
	 * Ajout d'un nouveau client
	 * 
	 * @param nom
	 *            nom du client
	 * @param prenom
	 *            prénom du client
	 * @param date
	 *            date de naissance du client
	 * @param ville
	 *            ville du client
	 * @return
	 */
	public boolean addClient(String nom, String prenom, Date date, String ville) {
		String requete = "insert into client (nom,prenom,datenaissance,ville) values ('" + nom + "','" + prenom + "','"
				+ date + "','" + ville + "')";
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
	 * Selectionne les clients
	 * 
	 * @return
	 * @throws ParseException
	 */
	public ArrayList<Client> voirListeClient() throws ParseException {
		ArrayList<Client> client = new ArrayList<Client>();
		String requete = "select nom,prenom,to_char(\"datenaissance\", 'DD/MM/YYYY'),ville from client order by lower(nom),lower(prenom)";
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while (result.next()) {
				String nom = result.getString(1);
				String prenom = result.getString(2);
				String date = result.getString(3);
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date d = sdf.parse(date);
				String ville = result.getString(4);
				Client c = new Client(nom, prenom, d, ville);
				client.add(c);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;

	}

	/**
	 * Suppression d'un client
	 * 
	 * @param nom
	 *            nom du client
	 * @param prenom
	 *            prénom du client
	 * @param d
	 *            date de naissance
	 * @return
	 */
	public boolean supClient(String nom, String prenom, Date d) {
		String requete = "delete from client where lower(nom) ='" + nom + "' and lower(prenom) ='" + prenom
				+ "' and datenaissance ='" + d + "'";
		String requete2 = "select * from client  where lower(nom) ='" + nom + "' and lower(prenom) ='" + prenom
				+ "' and datenaissance ='" + d + "'";
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
	 * cherche l'Id d'une client
	 * 
	 * @param nom
	 *            nom du client
	 * @param prenom
	 *            prénom du client
	 * @param date
	 *            date de naissance
	 * @param ville
	 *            ville du client
	 * @return
	 * @throws ParseException
	 */
	public int verifClient(String nom, String prenom, String date, String ville) throws ParseException {
		int cle = 0;
		String requete2 = "select idclient from client  where nom ='" + nom + "' and prenom ='" + prenom
				+ "' and datenaissance =TO_DATE('" + date + "','dd/mm/yyyy') and ville ='" + ville + "'";
		try {
			System.out.println(requete2);
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete2);
			while (result.next()) {
				cle = result.getInt("idclient");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cle;
	}

	/**
	 * Update sur un client
	 * 
	 * @param cle
	 *            ID client
	 * @param nom
	 *            nom du client
	 * @param prenom
	 *            prénom du client
	 * @param d
	 *            date de naissance
	 * @param ville
	 *            ville du client
	 * @return
	 */
	public boolean ModifClient(int cle, String nom, String prenom, String d, String ville) {

		try {
			PreparedStatement stmt = conn.prepareStatement(
					"update client set nom='" + nom + "', prenom='" + prenom + "',datenaissance=TO_DATE('" + d
							+ "','dd/mm/yyyy'), ville='" + ville + "' where idclient =" + cle);

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
	 * Recherche de l'ID d'un client
	 * 
	 * @param nom
	 *            nom du client
	 * @param prenom
	 *            prénom du client
	 * @param s
	 *            date de naissance (en string)
	 * @return
	 * @throws ParseException
	 */
	public int verifClientResa(String nom, String prenom, String s) throws ParseException {
		int cle = 0;
		String requete2 = "select idclient from client  where nom='" + nom + "' and prenom='" + prenom
				+ "' and datenaissance =TO_DATE('" + s + "','dd/MM/yyyy')";
		System.out.println(requete2);
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete2);
			while (result.next()) {
				cle = result.getInt("idclient");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cle;
	}

}
