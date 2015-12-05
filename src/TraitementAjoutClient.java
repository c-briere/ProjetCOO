import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;


public class TraitementAjoutClient implements ActionListener {

	public FenetreAjouterClient fenetreAjouterCLient; 
	public Connect connect;

	public TraitementAjoutClient(FenetreAjouterClient fenetreAjouterClient, Connect connect) {
		this.fenetreAjouterCLient=fenetreAjouterClient;
		this.connect=connect;
	}


	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();

		if(source== this.fenetreAjouterCLient.bouttonValider){
			String s = this.fenetreAjouterCLient.date.getText();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date d = null;
			try {
				d = sdf.parse(s);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if(!this.fenetreAjouterCLient.nom.getText().equals("") && !this.fenetreAjouterCLient.prenom.getText().equals("") && !d.equals("") && !this.fenetreAjouterCLient.ville.getText().equals("")){
				if(connect.gestionClient.addClient(this.fenetreAjouterCLient.nom.getText(), this.fenetreAjouterCLient.prenom.getText(), d, this.fenetreAjouterCLient.ville.getText())){
					JOptionPane.showMessageDialog(null,"Insertion réussi");
					fenetreAjouterCLient.dispose();
					FenetreGestionClient c = new FenetreGestionClient(this.connect);
				}
			}
		}
		if(source == this.fenetreAjouterCLient.bouttonAnnuler){
			this.fenetreAjouterCLient.dispose();
			FenetreGestionClient c = new FenetreGestionClient(this.connect);
		}
	}

}
