package traitement.tableau;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import classe_defaut.Client;

/**
 * tableau pour les clients
 * 
 * @author BRIERE / CARDON
 *
 */
public class TableClient extends AbstractTableModel {
	/**
	 * HEADER du tableau
	 */
	private String[] columnNames = { "Nom", "Prenom", "Date de Naissance", "Ville" };
	/**
	 * liste des clients
	 */
	ArrayList<Client> list = null;

	/**
	 * constructeur de la class
	 * 
	 * @param list
	 *            liste des clients
	 */
	public TableClient(ArrayList<Client> list) {
		this.list = list;
	}

	/**
	 * nombre de colonnes
	 */
	public int getColumnCount() {
		return columnNames.length;
	}

	/**
	 * nombre de ligne
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

		Client client = list.get(row);

		switch (col) {
		case 0:
			return client.getNom();
		case 1:
			return client.getPrenom();
		case 2:
			return client.getDateNaissance();
		case 3:
			return client.getVille();

		default:
			return "unknown";
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}