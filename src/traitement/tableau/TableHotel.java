package traitement.tableau;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import classe_defaut.Hotel;

 public class TableHotel extends AbstractTableModel {
          private String[] columnNames = { "Nom"};
          ArrayList<Hotel> list = null;

         public TableHotel(ArrayList<Hotel> list) {
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

               Hotel hotel = list.get(row);

               switch (col) {
               case 0:
                    return hotel.getNom();
          
               default:
                    return "unknown";
               }
          }

          public Class getColumnClass(int c) {
               return getValueAt(0, c).getClass();
          }
     }