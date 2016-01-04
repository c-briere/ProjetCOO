package traitement.tableau;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import classe_defaut.Ville;

/**
 * tableau pour les villes
 * 
 * @author BRIERE / CARDON
 *
 */
public class TableVille extends AbstractTableModel {
	/**
	 * HEADER du tableau
	 */
	private String[] columnNames = { "Ville" };
	/**
	 * liste de villes
	 */
	ArrayList<Ville> list = null;

	/**
	 * constructeur de la class
	 * 
	 * @param list
	 *            liste de ville
	 */
	public TableVille(ArrayList<Ville> list) {
		this.list = list;
	}

	/**
	 * retourne le nombre de colonne
	 */
	public int getColumnCount() {
		return columnNames.length;
	}

	/**
	 * retourne le nombre de ligne
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

		Ville ville = list.get(row);

		switch (col) {
		case 0:
			return ville.getNom();

		default:
			return "unknown";
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}