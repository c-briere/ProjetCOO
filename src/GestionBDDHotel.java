import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;


public class GestionBDDHotel {
	
	Connection conn;

	public GestionBDDHotel(Connection conn) {
		this.conn=conn;
	}
	
	
	public boolean addHotel(int cle,String nom){
		String requete = "insert into hotel (idville, nom) values ("+cle+",'"+nom+"')";
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


	public boolean deleteHotel(int cle, String hotel) {
		String requete = "delete from hotel where lower(nom) ='"+hotel+"' and idville ="+cle;
		String requete2 = "select * from hotel  where lower(nom) ='"+hotel+"' and idville ="+cle ;
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(requete2);
			if(rs.next()){
				stmt.executeUpdate(requete);
				stmt.close();
			}
			else{
				stmt.close();
				return false;
			}
			return  true;

		}
		catch (SQLException e) {

			e.printStackTrace();
			return false;

		}
		
	}


	public ArrayList<Hotel> voirHotel(int cle) {
		ArrayList<Hotel> hotel = new ArrayList<Hotel>();
		String requete = "select nom from hotel  where idville ="+cle+" order by lower(nom)";
		try{
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while(result.next()){
				String nom = result.getString(1);
				Hotel c = new Hotel(nom);
				hotel.add(c);

			}

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return hotel;
		
	}


	public int cleHotel(String hotel, int cleVille) {
		int cle =0;
		String requete = "select idhotel from hotel  where idville ="+cleVille+" and nom ='"+hotel+"'";
		try{
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while(result.next()){
				cle = result.getInt("idhotel");
			}
			
			return cle;

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return cle;
	}


}
