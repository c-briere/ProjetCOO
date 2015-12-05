import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

 class TableHotel extends AbstractTableModel {
          private String[] columnNames = { "Nom"};
          ArrayList<Hotel> list = null;

         TableHotel(ArrayList<Hotel> list) {
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