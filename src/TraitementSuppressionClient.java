import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;


public class TraitementSuppressionClient implements ActionListener {
	
	public Connect connect;
	public FenetreSupprimerClient fenetreSupprimerClient;

	public TraitementSuppressionClient(
			FenetreSupprimerClient fenetreSupprimerClient, Connect connect) {
		this.connect= connect;
		this.fenetreSupprimerClient=fenetreSupprimerClient;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object e = arg0.getSource();
		
		if(e==fenetreSupprimerClient.bouttonValider){
			String nom = this.fenetreSupprimerClient.nom.getText();
			String prenom = this.fenetreSupprimerClient.prenom.getText();
			String date = this.fenetreSupprimerClient.date.getText();
			Date d = null;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			try {
				d = sdf.parse(date);
			}catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			if(connect.gestionClient.supClient(nom,prenom, d)){
				JOptionPane.showMessageDialog(null,"Suppression réussi");
				this.fenetreSupprimerClient.dispose();
				FenetreGestionClient c = new FenetreGestionClient(this.connect);
			}
			else{
				JOptionPane.showMessageDialog(null,"Echec suppression ou le client n'existe pas");

			}

			
		}
		
		if(e==fenetreSupprimerClient.bouttonAnnuler){
			fenetreSupprimerClient.dispose();
			new FenetreGestionClient(connect);
		}

	}

}
