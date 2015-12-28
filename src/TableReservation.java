import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;


public class TableReservation  extends AbstractTableModel {
	 private String[] columnNames = { "Ville aller", "date depart", "Ville retour",
             "date retour", "nombre de personne", "hotel", "categorie", "chambre","prix total","nom clien","heure depart", "heure retour" };
   ArrayList<Reservation> list = null;

  TableReservation(ArrayList<Reservation> list) {
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

   public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
   }

}
