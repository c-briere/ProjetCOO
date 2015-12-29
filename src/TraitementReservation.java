import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 * 
 * @author BRIERE / CARDON
 *
 */
public class TraitementReservation implements ActionListener {

	FenetreGestionReservation fenetreGestionReservation;
	Connect connect;
	Date aller;
	Date retour;

	public TraitementReservation(
			FenetreGestionReservation fenetreGestionReservation, Connect connect) {
		this.fenetreGestionReservation=fenetreGestionReservation;
		this.connect=connect;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o = arg0.getSource();
		ArrayList<Integer> chambreNonDispo;
		if(o==this.fenetreGestionReservation.bouttonNextClient){
			int cle=0;
			String nom = this.fenetreGestionReservation.nom.getText();
			String prenom=this.fenetreGestionReservation.prenom.getText();
			String s = this.fenetreGestionReservation.date.getText();

			try {
				cle = this.connect.gestionClient.verifClientResa(nom, prenom, s);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if(cle!=0){
				this.fenetreGestionReservation.cleartSelectionClient();
				int cleVille= this.connect.gestionVille.cleVilleResaDepart(cle);
				Ville villeDepart=this.connect.gestionVille.getVille(cleVille);
				ArrayList<Ligne> ligne = this.connect.gestionLigne.voirLigneResaArrive(cleVille);
				this.fenetreGestionReservation.choixVilleDate(cle,cleVille,villeDepart,ligne);
			}
			else{
				JOptionPane.showMessageDialog(null,"Client Introuvable");

			}
		}
		if(o==this.fenetreGestionReservation.bouttonAnnuler){
			this.fenetreGestionReservation.dispose();
			new FenetreAccueil(this.connect);
		}

		if(o==this.fenetreGestionReservation.bouttonNextChoixDate){
			if(!this.fenetreGestionReservation.dateArrive.getText().equals("") && !this.fenetreGestionReservation.dateDepart.getText().equals("") && !this.fenetreGestionReservation.nbPersonne.getText().equals("")){
				String jourDepart = this.connect.gestionDate.dateEnjours(this.fenetreGestionReservation.dateDepart.getText());
				String jourArrivee=this.connect.gestionDate.dateEnjours(this.fenetreGestionReservation.dateArrive.getText());
				String dateDepart=this.fenetreGestionReservation.dateDepart.getText();
				String dateArrive=this.fenetreGestionReservation.dateArrive.getText();
				int cleLigneAller = this.connect.gestionLigne.cleLigne(this.fenetreGestionReservation.VilleDepart.getNom(), this.fenetreGestionReservation.choixVille.getSelectedItem().toString());
				int cleLigneRetour =this.connect.gestionLigne.cleLigne(this.fenetreGestionReservation.choixVille.getSelectedItem().toString(),this.fenetreGestionReservation.VilleDepart.getNom() );
				ArrayList<Trajet> ligne=this.connect.gestionTrajet.allTrajetResa(jourDepart,cleLigneAller);
				ArrayList<Trajet> ligneRetour=this.connect.gestionTrajet.allTrajetResa(jourArrivee,cleLigneRetour);
				String villeRetour = this.fenetreGestionReservation.choixVille.getSelectedItem().toString();
				int cleVilleArrive = this.connect.gestionVille.cleVille(this.fenetreGestionReservation.choixVille.getSelectedItem().toString());
				if(ligne.size()!=0 && ligneRetour.size()!=0){
					this.fenetreGestionReservation.clearChoixDate();
					int nbPersonne=Integer.parseInt(this.fenetreGestionReservation.nbPersonne.getText());
					this.fenetreGestionReservation.choixAller(cleVilleArrive,dateDepart,dateArrive,cleLigneAller,cleLigneRetour,ligne,ligneRetour,jourDepart,jourArrivee,nbPersonne,villeRetour);
				}
				else{
					JOptionPane.showMessageDialog(null,"Aucun aller et/ou retour disponible à ses dates");
				}
			}



		}
		if(o==this.fenetreGestionReservation.bouttonNextChoixAller){
			String heureAller = (String)this.fenetreGestionReservation.tableau.getModel().getValueAt(this.fenetreGestionReservation.tableau.getSelectedRow(),1);
			String classeAller;
			double prixAller;
			if(this.fenetreGestionReservation.choixClasse.getSelectedItem().toString().equals("1ere classe")){
				classeAller="1 ere classe";
				prixAller= (Double)this.fenetreGestionReservation.tableau.getModel().getValueAt(this.fenetreGestionReservation.tableau.getSelectedRow(),8);
			}
			else{
				classeAller="2 eme classe";
				prixAller= (Double)this.fenetreGestionReservation.tableau.getModel().getValueAt(this.fenetreGestionReservation.tableau.getSelectedRow(),9);

			}

			this.fenetreGestionReservation.clearChoixAller();
			this.fenetreGestionReservation.choixRetour(heureAller,classeAller,prixAller);
		}
		if(o==this.fenetreGestionReservation.bouttonNextChoixRetour){
			String heureRetour = (String)this.fenetreGestionReservation.tableau.getModel().getValueAt(this.fenetreGestionReservation.tableau.getSelectedRow(),1);
			String classeRetour;
			double prixRetour;
			if(this.fenetreGestionReservation.choixClasse.getSelectedItem().toString().equals("1ere classe")){
				classeRetour="1 ere classe";
				prixRetour= (Double)this.fenetreGestionReservation.tableau.getModel().getValueAt(this.fenetreGestionReservation.tableau.getSelectedRow(),8);
			}
			else{
				classeRetour="2 eme classe";
				prixRetour= (Double)this.fenetreGestionReservation.tableau.getModel().getValueAt(this.fenetreGestionReservation.tableau.getSelectedRow(),9);

			}
			conversationDate();
			chambreNonDispo=this.connect.gestionHotel.listChambreNonDipos(this.fenetreGestionReservation.cleVilleArrive, aller,retour);
			
			ArrayList<HotelRestant> hotel = this.connect.gestionHotel.listHotel(this.fenetreGestionReservation.cleVilleArrive, this.fenetreGestionReservation.nbPersonneVoyage, aller,retour,chambreNonDispo);
			this.fenetreGestionReservation.clearChoixRetour();
			this.fenetreGestionReservation.choixHotel(heureRetour,classeRetour,prixRetour, hotel);

		}
		
		if(o==this.fenetreGestionReservation.bouttonNextChoixHotel){
			int idHotel;
			idHotel=this.connect.gestionHotel.cleHotel(this.fenetreGestionReservation.hotel.get(this.fenetreGestionReservation.choixHotel.getSelectedIndex()).getNom(), this.fenetreGestionReservation.cleVilleArrive);
			ArrayList<Categorie> categorie= new ArrayList<Categorie>();
			conversationDate();
			chambreNonDispo=this.connect.gestionHotel.listChambreNonDipos(this.fenetreGestionReservation.cleVilleArrive,aller,retour);

			categorie= this.connect.gestionCategorie.listCategorie(idHotel,chambreNonDispo,this.fenetreGestionReservation.nbPersonneVoyage);
			this.fenetreGestionReservation.clearChoixHotel();
			this.fenetreGestionReservation.choixCategorie(idHotel, categorie);
		}
		
		if(o==this.fenetreGestionReservation.bouttonNextChoixCategorie){
			int idCategorie;
			idCategorie=this.connect.gestionCategorie.cleCategorie(this.fenetreGestionReservation.categorie.get(this.fenetreGestionReservation.choixCategorie.getSelectedIndex()).getNom(), this.fenetreGestionReservation.idHotel);
			conversationDate();
			ArrayList<Chambre> chambre =new ArrayList<Chambre>();
			chambreNonDispo=this.connect.gestionHotel.listChambreNonDipos(this.fenetreGestionReservation.cleVilleArrive,aller,retour);
			chambre=this.connect.gestionChambre.listChambre(idCategorie,chambreNonDispo);
			this.fenetreGestionReservation.clearChoixCategorie();
			this.fenetreGestionReservation.choixChambre(idCategorie, chambre);
		}
		
		if(o==this.fenetreGestionReservation.bouttonNextChoixChambre){
			int idChambre,nbJour;
			idChambre=this.connect.gestionChambre.cleChambre(this.fenetreGestionReservation.chambre.get(this.fenetreGestionReservation.choixChambre.getSelectedIndex()).getDenomination(),this.fenetreGestionReservation.idCategorie);
			nbJour=this.connect.gestionDate.nbDeJour(this.fenetreGestionReservation.dateAller,this.fenetreGestionReservation.dateRetour);
			Reservation reservation= this.connect.gestionReservation.createReservation(this.fenetreGestionReservation.heureAller,this.fenetreGestionReservation.heureRetour,this.fenetreGestionReservation.VilleDepart.getNom(),this.fenetreGestionReservation.dateAller,this.fenetreGestionReservation.villeRetour,this.fenetreGestionReservation.dateRetour,this.fenetreGestionReservation.prixAller,this.fenetreGestionReservation.prixRetour,this.fenetreGestionReservation.nbPersonneVoyage,this.fenetreGestionReservation.idHotel,this.fenetreGestionReservation.idCategorie,this.fenetreGestionReservation.cleClient,idChambre,nbJour);
			this.fenetreGestionReservation.clearChoixChambre();
			this.fenetreGestionReservation.recapilutatif(idChambre,reservation);
			
		}
		if(o==this.fenetreGestionReservation.bouttonValider){
			boolean verif =this.connect.gestionReservation.ajoutResa(this.fenetreGestionReservation.cleClient,this.fenetreGestionReservation.cleVilleDepart,this.fenetreGestionReservation.cleVilleArrive,this.fenetreGestionReservation.cleLigneAller,this.fenetreGestionReservation.cleLigneRetour,this.fenetreGestionReservation.classeAller,this.fenetreGestionReservation.classeRetour,this.fenetreGestionReservation.idHotel,this.fenetreGestionReservation.idCategorie,this.fenetreGestionReservation.cleChambre,this.fenetreGestionReservation.dateAller,this.fenetreGestionReservation.dateRetour,this.fenetreGestionReservation.reservation.getPrixTotal(),this.fenetreGestionReservation.reservation.getNbPersonne());
			if(verif){
				int cleResa=this.connect.gestionReservation.cleResa();
				JOptionPane.showMessageDialog(null,"Insertion réussi : numero de resarvation : "+cleResa);
				this.fenetreGestionReservation.clearRecapitulatif();
				this.fenetreGestionReservation.dispose();
				FenetreAccueil fenetreAccueil=new FenetreAccueil(connect);
			}
			else{
				JOptionPane.showMessageDialog(null,"Echec de l ajout");

			}
		}
	}
	
	public void conversationDate(){
		aller = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			aller = sdf.parse(this.fenetreGestionReservation.dateAller);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		retour = null;
		try {
			retour = sdf2.parse(this.fenetreGestionReservation.dateRetour);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
