import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class GestionBDDChambre {
	
	Connection conn;

	public GestionBDDChambre(Connection conn) {
		this.conn=conn;
	}

	public boolean addChambre(int cleCategorie, String nom) {
		String requete = "insert into chambre (nom, idcategorie) values ('"+nom+"',"+cleCategorie+")";
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

	public boolean suppChambre(String chambre, int cleCategorie) {
		String requete = "delete from chambre where lower(nom) ='"+chambre+"' and idcategorie ="+cleCategorie;
		String requete2 = "select * from chambre  where lower(nom) ='"+chambre+"' and idhotel ="+cleCategorie ;
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

	public ArrayList<Chambre> voirChambre(int cleCategorie) {
		ArrayList<Chambre> chambre = new ArrayList<Chambre>();
		String requete = "select nom from chambre  where idcategorie ="+cleCategorie+" order by lower(nom)";
		try{
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while(result.next()){
				String nom = result.getString(1);
				Chambre c = new Chambre(nom);
				chambre.add(c);

			}

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return chambre;
	}

}
