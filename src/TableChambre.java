import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

 class TableChambre extends AbstractTableModel {
          private String[] columnNames = { "Nom"};
          ArrayList<Chambre> list = null;

         TableChambre(ArrayList<Chambre> list) {
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

               Chambre chambre = list.get(row);

               switch (col) {
               case 0:
                    return chambre.getDenomination();
              
               
               default:
                    return "unknown";
               }
          }

          public Class getColumnClass(int c) {
               return getValueAt(0, c).getClass();
          }
     }