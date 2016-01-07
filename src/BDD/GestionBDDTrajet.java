package BDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import classe_defaut.Trajet;

/**
 * Gestion des requêtes sur les trajets
 * 
 * @author BRIERE / CARDON
 *
 */
public class GestionBDDTrajet {

	Connection conn;

	/**
	 * Constructeur de la class
	 * 
	 * @param conn
	 *            connexion à la BDD (préalablement créée par la class Connect)
	 */
	public GestionBDDTrajet(Connection conn) {
		this.conn = conn;
	}

	/**
	 * Ajout d'un trajet
	 * 
	 * @param cleLigne
	 *            ID de la ligne
	 * @param jour
	 * @param heure
	 *            heure du départ
	 * @param duree
	 *            durée du trajet
	 * @param nbPassager1
	 * @param prixPassager1
	 * @param nbPassager2
	 * @param prixPassager2
	 * @param annulable
	 *            nombre de jours nécessaire pour pouvoir annuler
	 * @return
	 */
	public boolean addTrajet(int cleLigne, String jour, String heure, int duree, int nbPassager1, double prixPassager1,
			int nbPassager2, double prixPassager2, int annulable) {
		String requete = "insert into trajet (idligne,jour,heuredepart,duree,nbpassagerpremiere,prixpremierclasse,nbpassagerdeuxieme,prixdeuxiemeclasse,annulable) "
				+ "values (" + cleLigne + ",'" + jour + "','" + heure + "'," + duree + "," + nbPassager1 + ","
				+ prixPassager1 + "," + nbPassager2 + "," + prixPassager2 + "," + annulable + ")";
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
	 * Suppression d'un trajet
	 * 
	 * @param cleLigne
	 *            ID de la ligne
	 * @param duree
	 * @param heure
	 *            heure de départ
	 * @param jour
	 * @return
	 */
	public boolean deleteTrajet(int cleLigne, int duree, String heure, String jour) {
		String requete = "delete from trajet where idligne =" + cleLigne + " and jour ='" + jour + "' and duree = "
				+ duree + " and heuredepart = '" + heure + "'";
		String requete2 = "select * from trajet where idligne =" + cleLigne + " and jour ='" + jour + "' and duree = "
				+ duree + " and heuredepart = '" + heure + "'";
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
	 * Sélectionne les informations d'une ligne
	 * 
	 * @param cleLigne
	 *            ID ligne
	 * @return
	 */
	public ArrayList<Trajet> voirListeVille(int cleLigne) {
		ArrayList<Trajet> trajet = new ArrayList<Trajet>();
		String requete = "select * from trajet where idligne =" + cleLigne;
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while (result.next()) {
				String jour = result.getString("jour");
				String heuredepart = result.getString("heuredepart");
				int duree = result.getInt("duree");
				int nbPassager1 = result.getInt("nbpassagerpremiere");
				double prix1 = result.getDouble("prixpremierclasse");
				int nbPassager2 = result.getInt("nbpassagerdeuxieme");
				double prix2 = result.getDouble("prixdeuxiemeclasse");
				int annulable = result.getInt("annulable");
				Trajet l = new Trajet(jour, heuredepart, duree, nbPassager1, prix1, nbPassager2, prix2, annulable);
				trajet.add(l);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trajet;

	}

	/**
	 * Sélectionne les informations d'une ligne
	 * 
	 * @param cleLigne
	 *            ID ligne
	 * @param jour
	 * @param duree
	 * @param heure
	 *            heure de départ
	 * @return
	 */
	public Trajet searchTrajet(int cleLigne, String jour, int duree, String heure) {
		Trajet trajet = null;
		String requete = "select * from trajet where idligne =" + cleLigne + " and jour ='" + jour
				+ "' and heuredepart ='" + heure + "' and duree =" + duree;
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while (result.next()) {
				String jour2 = result.getString("jour");
				String heuredepart = result.getString("heuredepart");
				int duree2 = result.getInt("duree");
				int nbPassager1 = result.getInt("nbpassagerpremiere");
				double prix1 = result.getDouble("prixpremierclasse");
				int nbPassager2 = result.getInt("nbpassagerdeuxieme");
				double prix2 = result.getDouble("prixdeuxiemeclasse");
				int annulable = result.getInt("annulable");
				trajet = new Trajet(jour2, heuredepart, duree2, nbPassager1, prix1, nbPassager2, prix2, annulable);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trajet;
	}

	/**
	 * Modification d'un trajet
	 * 
	 * @param trajet
	 * @param cleLigne
	 *            ID ligne
	 * @param jour
	 * @param heure
	 *            heure de départ
	 * @param duree
	 * @param nbPassager1
	 * @param prixPassager1
	 * @param nbPassager2
	 * @param prixPassager2
	 * @param annulable
	 *            nombre de jour nécessaire pour annuler
	 * @return
	 */
	public boolean modifTrajet(Trajet trajet, int cleLigne, String jour, String heure, int duree, int nbPassager1,
			double prixPassager1, int nbPassager2, double prixPassager2, int annulable) {

		try {
			PreparedStatement stmt = conn.prepareStatement("update trajet set jour='" + jour + "', heuredepart='"
					+ heure + "', duree=" + duree + ", nbpassagerpremiere=" + nbPassager1 + ", prixpremierclasse="
					+ prixPassager1 + ", nbpassagerdeuxieme=" + nbPassager2 + ", prixdeuxiemeclasse=" + prixPassager2
					+ ", annulable=" + annulable + " where idligne =" + cleLigne + " and jour='" + trajet.getJour()
					+ "' and heuredepart='" + trajet.getHeure() + "' and duree=" + trajet.getDuree());

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
	 * 
	 * @param jourResa
	 * @param cleLigne
	 * @return
	 */
	public ArrayList<Trajet> allTrajetResa(String jourResa, int cleLigne) {
		ArrayList<Trajet> trajet = new ArrayList<Trajet>();
		String requete = "select * from trajet where idligne =" + cleLigne + " and jour ='" + jourResa + "'";
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while (result.next()) {
				String jour = result.getString("jour");
				String heuredepart = result.getString("heuredepart");
				int duree = result.getInt("duree");
				int nbPassager1 = result.getInt("nbpassagerpremiere");
				double prix1 = result.getDouble("prixpremierclasse");
				int nbPassager2 = result.getInt("nbpassagerdeuxieme");
				double prix2 = result.getDouble("prixdeuxiemeclasse");
				int annulable = result.getInt("annulable");
				Trajet l = new Trajet(jour, heuredepart, duree, nbPassager1, prix1, nbPassager2, prix2, annulable);
				trajet.add(l);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trajet;

	}
}
