package traitement.tableau;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import classe_defaut.Categorie;

public class TableCategorie extends AbstractTableModel {
	
          private String[] columnNames = { "Nom", "Place", "Prix"};
          ArrayList<Categorie> list = null;

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

          public Class getColumnClass(int c) {
               return getValueAt(0, c).getClass();
          }
     }