package BDD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import classe_defaut.Trajet;
import classe_defaut.Ville;


public class GestionStat {

	Connection conn;

	public GestionStat(Connection conn) {
		this.conn=conn;
	}

	public ArrayList<Ville> villeLesPlusDemandes(String date1, String date2) {
		ArrayList<Ville> ville = new ArrayList<Ville>();
		String requete = "select count(ville.nom) as total,ville.nom from reservation join ville on reservation.idvillearrive=ville.idville where reservation.datearrive between '"+date1+"' and '"+date2+"' or reservation.dateretour between '"+date1+"' and '"+date2+"' or reservation.datearrive = '"+date1+"' or reservation.datearrive = '"+date2+"' or reservation.dateretour = '"+date1+"' or reservation.dateretour = '"+date2+"' group by ville.nom order by total desc";
		try{
			System.out.println(">>> STATS REQUETE VILLE : OK");
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while(result.next()){
				String nom = result.getString(2);
				ville.add(new Ville(nom));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		return ville;
	}

	public int nbDeVoyageur(String date1, String date2) {
		int nb=0;
		String requete ="select sum(reservation.nbpersonne) from reservation where reservation.datearrive between '"+date1+"' and '"+date2+"' or reservation.dateretour between '"+date1+"' and '"+date2+"' or reservation.datearrive = '"+date1+"' or reservation.datearrive = '"+date2+"' or reservation.dateretour = '"+date1+"' or reservation.dateretour = '"+date2+"'";
		try{
			System.out.println(">>> STATS REQUETE NB VOYAGEURS : OK");
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while(result.next()){
				nb = result.getInt(1);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		return nb;
	}

	public ArrayList<Trajet> ligneNonUtilise(String date1,String date2){
		ArrayList<Integer> liste =ligneUtilise(date1,date2);
		String s = "";
		if(liste!=null ){
			for(int i=0;i<liste.size();i++){
				s=s+Integer.toString(liste.get(i));
			}
		}

		ArrayList<Trajet> trajet = new ArrayList<Trajet>();
		String requete; 
		if(!s.equals("")){
			requete = "select * from trajet where idligne not in (select idligne from trajet where idligne="+s+")";
		}
		else{
			requete = "select * from trajet";
		}
		try{
			System.out.println(">>> STATS REQUETE TRAJET : OK");
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while(result.next()){
				String jour = result.getString("jour");
				String heuredepart = result.getString("heuredepart");
				int duree = result.getInt("duree");
				int nbPassager1 = result.getInt("nbpassagerpremiere");
				double prix1 = result.getDouble("prixpremierclasse");
				int nbPassager2 = result.getInt("nbpassagerdeuxieme");
				double prix2 = result.getDouble("prixdeuxiemeclasse");
				int annulable = result.getInt("annulable");
				Trajet l = new Trajet(jour,heuredepart,duree,nbPassager1,prix1,nbPassager2,prix2,annulable);
				trajet.add(l);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return trajet;



	}

	public ArrayList<Integer> ligneUtilise(String date1, String date2){
		ArrayList<Integer> liste = null;
		String requete= "select distinct reservation.clelignealler, reservation.cleligneretour from reservation  where reservation.datearrive between '"+date1+"' and '"+date2+"' or reservation.dateretour between '"+date1+"' and '"+date2+"' or reservation.datearrive = '"+date1+"'or reservation.datearrive = '"+date2+"' or reservation.dateretour = '"+date1+"' or reservation.dateretour = '"+date2+"'";
		try{
			System.out.println(">>> STATS REQUETE LIGNE : OK");
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			liste = new ArrayList<Integer>();
			while(result.next()){
				int a = result.getInt(1);
				liste.add(a);
				a =result.getInt(2);
				liste.add(a);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return liste;

	}
}
