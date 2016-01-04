package traitement.tableau;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import classe_defaut.Hotel;

/**
 * tableau pour les hôtels
 * 
 * @author BRIERE / CARDON
 *
 */
public class TableHotel extends AbstractTableModel {
	/**
	 * HEADER du tableau
	 */
	private String[] columnNames = { "Nom" };
	/**
	 * liste des hôtels
	 */
	ArrayList<Hotel> list = null;

	/**
	 * constructeur de la class
	 * 
	 * @param list
	 *            liste des hôtels
	 */
	public TableHotel(ArrayList<Hotel> list) {
		this.list = list;
	}

	/**
	 * retourne le nmobre de colonnes
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

		Hotel hotel = list.get(row);

		switch (col) {
		case 0:
			return hotel.getNom();

		default:
			return "unknown";
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}