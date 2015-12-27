import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class GestionBDDClient {

	public Connection conn;

	public GestionBDDClient(Connection conn) {
		this.conn = conn;
	}


	public boolean addClient(String nom,String prenom,Date date,String ville){
		String requete = "insert into client (nom,prenom,datenaissance,ville) values ('"+nom+"','"+prenom+"','"+date+"','"+ville+"')";
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

	public ArrayList<Client> voirListeClient() throws ParseException{
		ArrayList<Client> client = new ArrayList<Client>();
		String requete = "select nom,prenom,to_char(\"datenaissance\", 'DD/MM/YYYY'),ville from client order by lower(nom),lower(prenom)";
		try{
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while(result.next()){
				String nom = result.getString(1);
				String prenom = result.getString(2);
				String date = result.getString(3);
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date d = sdf.parse(date);
				String ville = result.getString(4);
				Client c = new Client(nom,prenom,d,ville);
				client.add(c);

			}

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return client;

	}


	public boolean supClient(String nom, String prenom, Date d) {
		String requete = "delete from client where lower(nom) ='"+nom+"' and lower(prenom) ='"+prenom+"' and datenaissance ='"+d+"'";
		String requete2 = "select * from client  where lower(nom) ='"+nom+"' and lower(prenom) ='"+prenom+"' and datenaissance ='"+d+"'";
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


	public int verifClient(String nom, String prenom, Date date, String ville) throws ParseException {
		int cle = 0;
		String requete2 = "select idclient from client  where lower(nom) ='"+nom+"' and lower(prenom) ='"+prenom+"' and datenaissance ='"+date+"' and lower(ville) ='"+ville+"'";
		try{
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete2);
			while(result.next()){
				cle=result.getInt("idclient");


			}

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return cle;
	}


	public boolean ModifClient(int cle,String nom, String prenom, Date d, String ville) {
		
		try{
			PreparedStatement stmt = conn.prepareStatement("update client set nom='"+nom+"', prenom='"+prenom+"',datenaissance='"+d+"', ville='"+ville+"' where idclient ="+cle);
			

			stmt.executeUpdate();
			stmt.close();
			return true;

		}



		catch (SQLException e) {

			e.printStackTrace();
			return false;

		}
	}
	
	public int verifClientResa(String nom, String prenom, Date date) throws ParseException {
		int cle = 0;
		String requete2 = "select idclient from client  where lower(nom) ='"+nom+"' and lower(prenom) ='"+prenom+"' and datenaissance ='"+date+"'";
		try{
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete2);
			while(result.next()){
				cle=result.getInt("idclient");


			}

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return cle;
	}


}


