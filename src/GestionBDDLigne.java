import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class GestionBDDLigne {

	Connection conn;

	public GestionBDDLigne(Connection conn) {
		this.conn=conn;
	}

	public boolean addLigne(String villeAller, String villeRetour,
			int cleVilleAller, int cleVilleRetour) {

		String requete = "insert into ligne (idvillealler,nomvilledepart,idvilleretour,nomvillearrive) values ("+cleVilleAller+",'"+villeAller+"',"+cleVilleRetour+",'"+villeRetour+"')";
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

	public boolean supLigne(int cleVilleAller, int cleVilleRetour) {
		String requete = "delete from ligne where idvillealler ="+cleVilleAller+" and idvilleretour="+cleVilleRetour;
		String requete2 = "select * from ligne where idvillealler ="+cleVilleAller+" and idvilleretour ="+cleVilleRetour;
		System.out.println(requete);
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

	public ArrayList<Ligne> allLigne() {
		ArrayList<Ligne> ligne = new ArrayList<Ligne>();
		String requete = "select nomvilledepart , nomvillearrive from ligne";
		try{
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while(result.next()){
				String nom = result.getString("nomvilledepart");
				String nom2 = result.getString("nomvillearrive");
				Ville depart = new Ville(nom);
				Ville arrive = new Ville(nom2);
				Ligne l = new Ligne(depart,arrive);
 				ligne.add(l);
			}

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return ligne;
		
	}

	public int cleLigne(String villeD, String villeA) {
		int cle =0;
		String requete = "select idligne from ligne  where nomvilledepart ='"+villeD+"' and nomvillearrive ='"+villeA+"'";
		try{
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while(result.next()){
				cle = result.getInt("idligne");
			}
			
			return cle;

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return cle;
	}

	public ArrayList<Ligne> voirLigneResaArrive(int cleVilleDepart) {
		ArrayList<Ligne> ligne = new ArrayList<Ligne>();
		String requete = "select nomvilledepart , nomvillearrive from ligne where idvillealler ="+cleVilleDepart;
		try{
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while(result.next()){
				String nom = result.getString("nomvilledepart");
				String nom2 = result.getString("nomvillearrive");
				Ville depart = new Ville(nom);
				Ville arrive = new Ville(nom2);
				Ligne l = new Ligne(depart,arrive);
 				ligne.add(l);
			}

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return ligne;
		
	}

}
