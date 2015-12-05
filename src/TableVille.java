import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

 class TableVille extends AbstractTableModel {
          private String[] columnNames = { "Ville"};
          ArrayList<Ville> list = null;

         TableVille(ArrayList<Ville> list) {
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

              Ville ville = list.get(row);

               switch (col) {
               case 0:
                    return ville.getNom();
             
               
               default:
                    return "unknown";
               }
          }

          public Class getColumnClass(int c) {
               return getValueAt(0, c).getClass();
          }
     }