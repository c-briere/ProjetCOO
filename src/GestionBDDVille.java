import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class GestionBDDVille {

	public Connection conn;

	public GestionBDDVille(Connection conn) {
		this.conn=conn;
	}

	public boolean addVille(String nom) {
		String requete = "insert into ville (nom) values ('"+nom+"')";
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

	public boolean supVille(String ville) {
		String requete = "delete from ville where lower(nom) ='"+ville+"'";
		String requete2 = "select * from ville  where lower(nom) ='"+ville+"'";
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

	public ArrayList<Ville> voirListeVille() {
		ArrayList<Ville> ville = new ArrayList<Ville>();
		String requete = "select nom from ville order by lower(nom)";
		try{
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while(result.next()){
				String nom = result.getString(1);
				Ville c = new Ville(nom);
				ville.add(c);

			}

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return ville;

	}

	public int cleVille(String ville) {
		int cle =0;
		String requete = "select idville from ville  where nom ='"+ville+"'";
		try{
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while(result.next()){
				cle = result.getInt("idville");
			}

			return cle;

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return cle;
	}

	public int cleVilleResaDepart(int cle) {
		int cleVille=0;
	
		String requete = "select idville from ville join client on lower(ville.nom) = lower(client.ville) where idclient ="+cle;
		try{
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while(result.next()){
				cleVille = result.getInt("idville");
				
			}
			return cleVille;

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return cleVille;
	}

	public Ville getVille(int cleVille) {
		Ville ville=null;
		String requete = "select * from ville  where idville ="+cleVille;
		try{
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while(result.next()){
				String nom = result.getString("nom");

				ville = new Ville(nom);
			}
			return ville;

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return ville;
	}

}
