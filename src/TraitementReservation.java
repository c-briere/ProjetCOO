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
				this.fenetreGestionReservation.CleartSelectionClient();
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

	}

}
