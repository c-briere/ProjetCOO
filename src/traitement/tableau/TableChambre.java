package traitement.tableau;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import classe_defaut.Chambre;

/**
 * Tableau pour les chambres
 * 
 * @author BRIERE / CARDON
 *
 */
public class TableChambre extends AbstractTableModel {
	/**
	 * HEADER du tableau
	 */
	private String[] columnNames = { "Nom" };
	/**
	 * liste des chambres
	 */
	ArrayList<Chambre> list = null;

	/**
	 * constructeur de la class
	 * 
	 * @param list
	 */
	public TableChambre(ArrayList<Chambre> list) {
		this.list = list;
	}

	/**
	 * retourne le nombre de colonnes
	 */
	public int getColumnCount() {
		return columnNames.length;
	}

	/**
	 * retourne le nmobre de lignes
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
	 * retourne le valeur du tableau
	 */
	public Object getValueAt(int row, int col) {

		Chambre chambre = list.get(row);

		switch (col) {
		case 0:
			return chambre.getDenomination();

		default:
			return "unknown";
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}