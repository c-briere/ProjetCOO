package traitement.tableau;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import classe_defaut.Trajet;

/**
 * tableau pour les réservations
 * 
 * @author BRIERE / CARDON
 *
 */
public class TableTrajetPrixTotal extends AbstractTableModel {
	/**
	 * HEADER du tableau
	 */
	private String[] columnNames = { "Jour", "Heure depart", "Duree", "Nombre passager 1ere", "Prix Premiere",
			"Nombre passager 2eme", "Prix Deuxieme", "Jour moins annulable", "Prix total 1ere classe",
			"Prix total 2eme classe" };
	/**
	 * liste des trajets
	 */
	ArrayList<Trajet> list = null;
	/**
	 * nombre de voyageurs
	 */
	public int nbPersonne;

	/**
	 * constructeur de la class
	 * 
	 * @param list
	 *            liste des trajets
	 * @param nbPersonne
	 *            nombre de voyageurs
	 */
	public TableTrajetPrixTotal(ArrayList<Trajet> list, int nbPersonne) {
		this.list = list;
		this.nbPersonne = nbPersonne;
	}

	/**
	 * retourne le nombre de colonnes
	 */
	public int getColumnCount() {
		return columnNames.length;
	}

	/**
	 * retourne le noombre de lignes
	 */
	public int getRowCount() {
		return list.size();
	}

	/**
	 * retourne le nom de la colonne
	 */
	public String getColumnName(int col) {
		return columnNames[col];
	}

	/**
	 * retourne la valeur du tableau
	 */
	public Object getValueAt(int row, int col) {

		Trajet trajet = list.get(row);
		switch (col) {
		case 0:
			return trajet.getJour();
		case 1:
			return trajet.getHeure();
		case 2:
			return trajet.getDuree();
		case 3:
			return trajet.getNbPassager1ere();
		case 4:
			return trajet.getPrixPassager1ere();
		case 5:
			return trajet.getNbPassager2eme();
		case 6:
			return trajet.getPrixPassager2eme();
		case 7:
			return trajet.getAnnulage();
		case 8:
			return trajet.getPrixPassager1ere() * nbPersonne;
		case 9:
			return trajet.getPrixPassager2eme() * nbPersonne;

		default:
			return "unknown";
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}