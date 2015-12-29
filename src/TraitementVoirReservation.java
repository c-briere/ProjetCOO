import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;


public class TraitementVoirReservation implements ActionListener {
	
	FenetreGestionVoirReservation fenetreGestionVoirReservation;
	Connect connect;

	public TraitementVoirReservation(
			FenetreGestionVoirReservation fenetreGestionVoirReservation,
			Connect connect) {
		this.connect=connect;
		this.fenetreGestionVoirReservation=fenetreGestionVoirReservation;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source=arg0.getSource();
		if(source==this.fenetreGestionVoirReservation.bouttonAnnuler){
			this.fenetreGestionVoirReservation.dispose();
			FenetreAccueil a = new FenetreAccueil(connect);
		}
		if(source==this.fenetreGestionVoirReservation.bouttonVoir){
			int cle=0;
			String nom = this.fenetreGestionVoirReservation.nom.getText();
			String prenom=this.fenetreGestionVoirReservation.prenom.getText();
			String s = this.fenetreGestionVoirReservation.date.getText();
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
				ArrayList<Reservation> reservation; 
				reservation=this.connect.gestionReservation.voirResa(cle);
				this.fenetreGestionVoirReservation.dispose();
				FenetreVoirResa r= new FenetreVoirResa(connect,reservation);
			}
			else{
				JOptionPane.showMessageDialog(null,"Client Introuvable");

			}
		}

	}

}
