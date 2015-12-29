import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class GestionBDDDate {
	Connection conn;

	public GestionBDDDate(Connection conn) {
		this.conn=conn;
	}


	public String dateEnjours(String date){
		String requete = "SELECT date_part('dow',date ('"+date+"'))";
		String nom = null;
		try{
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while(result.next()){
				nom = result.getString(1);
			}
		}

		catch(SQLException e){
			e.printStackTrace();
		}
		switch(nom){
		case "0":
			return "Dimanche";
		case "1":
			return "Lundi";
		case "2":
			return "Mardi";
		case "3":
			return "Mercredi";
		case "4":
			return "Jeudi";
		case "5":
			return "Vendredi";
		case "6":
			return "Samedi";
			
		}
		return nom;

	}


	public int nbDeJour(String dateAller, String dateRetour) {
		int a = 0;
		String requete = "select '"+dateRetour+"'::date - '"+dateAller+"'::date-1";
		try{
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while(result.next()){
				a = result.getInt(1);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		
		return a;
	}

}
