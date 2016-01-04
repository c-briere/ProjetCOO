package traitement.tableau;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import classe_defaut.Reservation;

/**
 * tableau pour les réservations
 * 
 * @author BRIERE / CARDON
 *
 */
public class TableReservation extends AbstractTableModel {
	/**
	 * HEADER du tableau
	 */
	private String[] columnNames = { "Ville aller", "date depart", "Ville retour", "date retour", "nombre de personne",
			"hotel", "categorie", "chambre", "prix total", "nom clien", "heure depart", "heure retour" };
	/**
	 * liste des réservations
	 */
	ArrayList<Reservation> list = null;

	/**
	 * constructeur de la class
	 * 
	 * @param list
	 *            liste des réservations
	 */
	public TableReservation(ArrayList<Reservation> list) {
		this.list = list;
	}

	/**
	 * retourne le nombre de colonnes
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
	 * retourne le nom de la ligne
	 */
	public String getColumnName(int col) {
		return columnNames[col];
	}

	/**
	 * retourne la valeur du tableau
	 */
	public Object getValueAt(int row, int col) {

		Reservation reservation = list.get(row);

		switch (col) {
		case 0:
			return reservation.getVilleAller().getNom();
		case 1:
			return reservation.getDateAller();
		case 2:
			return reservation.getVilleRetour().getNom();
		case 3:
			return reservation.getDateRetour();
		case 4:
			return reservation.getNbPersonne();
		case 5:
			return reservation.getHotel().getNom();
		case 6:
			return reservation.getCategorie().getNom();
		case 7:
			return reservation.getChambre().getDenomination();
		case 8:
			return reservation.getPrixTotal();
		case 9:
			return reservation.getNom();
		case 10:
			return reservation.getHeureAller();
		case 11:
			return reservation.getHeureRetour();
		default:
			return "unknown";
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

}
