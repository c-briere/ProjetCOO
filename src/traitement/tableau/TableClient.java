package traitement.tableau;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import classe_defaut.Client;

 public class TableClient extends AbstractTableModel {
          private String[] columnNames = { "Nom", "Prenom", "Date de Naissance",
                    "Ville" };
          ArrayList<Client> list = null;

         public TableClient(ArrayList<Client> list) {
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

          public Class getColumnClass(int c) {
               return getValueAt(0, c).getClass();
          }
     }