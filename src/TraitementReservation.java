import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;


public class TraitementReservation implements ActionListener {

	FenetreGestionReservation fenetreGestionReservation;
	Connect connect;

	public TraitementReservation(
			FenetreGestionReservation fenetreGestionReservation, Connect connect) {
		this.fenetreGestionReservation=fenetreGestionReservation;
		this.connect=connect;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o = arg0.getSource();
		if(o==this.fenetreGestionReservation.bouttonNextClient){
			int cle=0;
			String nom = this.fenetreGestionReservation.nom.getText();
			String prenom=this.fenetreGestionReservation.prenom.getText();
			String s = this.fenetreGestionReservation.date.getText();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date d = null;
			try {
				d = sdf.parse(s);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			try {
				cle = this.connect.gestionClient.verifClientResa(nom, prenom, d);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
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
				String dateArrive=this.fenetreGestionReservation.dateDepart.getText();
				int cleLigneAller = this.connect.gestionLigne.cleLigne(this.fenetreGestionReservation.VilleDepart.getNom(), this.fenetreGestionReservation.choixVille.getSelectedItem().toString());
				int cleLigneRetour =this.connect.gestionLigne.cleLigne(this.fenetreGestionReservation.choixVille.getSelectedItem().toString(),this.fenetreGestionReservation.VilleDepart.getNom() );
				ArrayList<Trajet> ligne=this.connect.gestionTrajet.allTrajetResa(jourDepart,cleLigneAller);
				ArrayList<Trajet> ligneRetour=this.connect.gestionTrajet.allTrajetResa(jourArrivee,cleLigneRetour);
				String villeRetour = this.fenetreGestionReservation.choixVille.getSelectedItem().toString();
				if(ligne.size()!=0 && ligneRetour.size()!=0){
					this.fenetreGestionReservation.clearChoixDate();
					int nbPersonne=Integer.parseInt(this.fenetreGestionReservation.nbPersonne.getText());
					this.fenetreGestionReservation.choixAller(dateDepart,dateArrive,cleLigneAller,cleLigneRetour,ligne,ligneRetour,jourDepart,jourArrivee,nbPersonne,villeRetour);
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
			
			this.fenetreGestionReservation.clearChoixRetour();
			this.fenetreGestionReservation.recapitulatif(heureRetour,classeRetour,prixRetour);

		}
	}
}
