package traitement.tableau;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import classe_defaut.Categorie;

/**
 * Création du tableau pour les catégories
 * 
 * @author BRIERE / CARDON
 *
 */
public class TableCategorie extends AbstractTableModel {

	/*
	 * HEADER pour le tableau
	 */
	private String[] columnNames = { "Nom", "Place", "Prix" };
	/**
	 * liste de catégorie
	 */
	ArrayList<Categorie> list = null;

	/**
	 * constructeur de la class
	 * 
	 * @param list
	 */
	public TableCategorie(ArrayList<Categorie> list) {
		this.list = list;
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return list.size();
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	/**
	 * Insertion d'une valeur dans le tableau
	 */
	public Object getValueAt(int row, int col) {

		Categorie categorie = list.get(row);

		switch (col) {
		case 0:
			return categorie.getNom();
		case 1:
			return categorie.getPlace();
		case 2:
			return categorie.getPrix();

		default:
			return "unknown";
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}