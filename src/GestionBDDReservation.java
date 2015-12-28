import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class GestionBDDReservation {

	public Connection conn;


	public GestionBDDReservation(Connection conn) {
		this.conn=conn;
	}


	public Reservation createReservation(String heureAller,String heureRetour,String villeAller, String dateAller,
			String villeRetour, String dateRetour,  Double prixAller,
			Double prixRetour, int nbPersonneVoyage, int idHotel,
			int idCategorie, int cleClient, int idChambre, int nbJour) {
		Reservation reservation = null;

		String requete = "select hotel.nom,categorie.nom,chambre.nom, categorie.prix from hotel join categorie on hotel.idhotel=categorie.idhotel join chambre on categorie.idcategorie=chambre.idcategorie"
				+ " where hotel.idhotel="+idHotel+" and categorie.idcategorie="+idCategorie+" and chambre.id_chambre="+idChambre ;
		String requete2 ="select nom from client where idclient="+cleClient;
		try{
			Statement stmt = conn.createStatement();
			Statement stmt2 = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			ResultSet result2=stmt2.executeQuery(requete2);
			while(result.next()){
				String nomHotel=result.getString(1);
				String nomCategorie=result.getString(2);
				String nomChambre=result.getString(3);
				double prix=result.getDouble(4);
				while(result2.next()){
					String nom=result2.getString(1);
					reservation= new Reservation(new Ville(villeAller),dateAller,new Ville(villeRetour),dateRetour,prixAller+prixRetour,nbPersonneVoyage,new Hotel(nomHotel),new Categorie(nomCategorie,nbPersonneVoyage,prix),new Chambre(nomChambre),nbJour,prix,(prix*nbJour)+prixAller+prixRetour,nom,heureAller,heureRetour);

				}
			}
			stmt.close();
			stmt2.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		return reservation;
	}


	public boolean ajoutResa(int cleClient, int cleVilleDepart,
			int cleVilleArrive, int cleLigneAller, int cleLigneRetour,
			String classeAller, String classeRetour, int idHotel,
			int idCategorie, int cleChambre, String dateAller,
			String dateRetour, double prixTotal) {
		String requete = "insert into reservation (cleclient,idvilledepart,idvillearrive,clelignealler,cleligneretour,classealler,classeretour,idhotel,idcategorie,idchambre,datearrive,dateretour,prixtotal) values ("+cleClient+","+cleVilleDepart+","+cleVilleArrive+","+cleLigneAller+","+cleLigneRetour+",'"+classeAller+"','"+classeRetour+"',"+idHotel+","+idCategorie+","+cleChambre+",'"+dateAller+"','"+dateRetour+"',"+prixTotal+")";
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


	public int cleResa() {
		String requete= "select * from reservation where idreservation=max(idreservation)";
		int cle=0;
		try{
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requete);
			while(result.next()){
				cle=result.getInt(1);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return cle;
	}

}
