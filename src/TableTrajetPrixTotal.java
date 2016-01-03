import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

 class TableTrajetPrixTotal extends AbstractTableModel {
          private String[] columnNames = { "Jour", "Heure depart", "Duree",
                    "Nombre passager 1ere", "Prix Premiere", "Nombre passager 2eme", "Prix Deuxieme", "Jour moins annulable","Prix total 1ere classe"
                    ,"Prix total 2eme classe"};
          ArrayList<Trajet> list = null;
          int nbPersonne;

         TableTrajetPrixTotal(ArrayList<Trajet> list, int nbPersonne) {
               this.list = list;
               this.nbPersonne=nbPersonne;
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

               Trajet trajet = list.get(row);
               switch (col) {
               case 0:
                    return trajet.getJour();
               case 1:
                    return trajet.getHeure();
               case 2:
                    return trajet.getDuree();
               case 3:
                    return trajet.getNbPassager1ere();
               case 4:
            	   return trajet.getPrixPassager1ere();
               case 5:
            	   return trajet.getNbPassager2eme();
               case 6:
            	   return trajet.getPrixPassager2eme();
               case 7:
            	   return trajet.getAnnulage();
               case 8:
            	   return trajet.getPrixPassager1ere()*nbPersonne;
               case 9:
            	   return trajet.getPrixPassager2eme()*nbPersonne;
               
               default:
                    return "unknown";
               }
          }

          public Class getColumnClass(int c) {
               return getValueAt(0, c).getClass();
          }
     }