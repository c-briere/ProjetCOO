import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class GestionBDDTrajet {
	
	Connection conn;

	public GestionBDDTrajet(Connection conn) {
		this.conn=conn;
	}

	public boolean addTrajet(int cleLigne, String jour, String heure,
			int duree, int nbPassager1, double prixPassager1, int nbPassager2,
			double prixPassager2, int annulable) {
		String requete = "insert into trajet (idligne,jour,heuredepart,duree,nbpassagerpremiere,prixpremierclasse,nbpassagerdeuxieme,prixdeuxiemeclasse,annulable) "
				+ "values ("+cleLigne+",'"+jour+"','"+heure+"',"+duree+","+nbPassager1+","+prixPassager1+","+nbPassager2+","+prixPassager2+","+annulable+")";
		try{
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(requete);
			stmt.close();
			return  true;

		}
		catch (SQLException e) {

			e.printStackTrace();
			return false;

		}
	}

}
