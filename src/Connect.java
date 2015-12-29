import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	
	public GestionBDDClient gestionClient;
	public GestionBDDVille gestionVille;
	public GestionBDDHotel gestionHotel;
	public GestionBDDCategorie gestionCategorie;
	public GestionBDDChambre gestionChambre;
	public GestionBDDLigne gestionLigne;
	public GestionBDDTrajet gestionTrajet;
	public GestionBDDDate gestionDate;
	public GestionBDDReservation gestionReservation;
	public GestionStat gestionStat;
	
  public Connect() {      

    try {

      Class.forName("org.postgresql.Driver");

      System.out.println("Driver O.K.");


      String url = "jdbc:postgresql://localhost:5432/ProjetCOO";

      String user = "postgres";

      String passwd = "azerty";


      Connection conn = DriverManager.getConnection(url, user, passwd);

      System.out.println("Connexion effective !");         
      
      gestionClient = new GestionBDDClient(conn);
      gestionVille = new GestionBDDVille(conn);
      gestionHotel = new GestionBDDHotel(conn);
      gestionCategorie = new GestionBDDCategorie(conn);
      gestionChambre = new GestionBDDChambre(conn);
      gestionLigne = new GestionBDDLigne(conn);
      gestionTrajet = new GestionBDDTrajet(conn);
      gestionDate = new GestionBDDDate(conn);
      gestionReservation = new GestionBDDReservation(conn);
      gestionStat = new GestionStat(conn);

    } catch (Exception e) {

      e.printStackTrace();

    }      
    
    

  }

}