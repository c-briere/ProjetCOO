package traitement.client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import BDD.Connect;
import vue.client.FenetreAjouterClient;
import vue.client.FenetreGestionClient;


public class TraitementAjoutClient implements ActionListener {

	public FenetreAjouterClient fenetreAjouterCLient; 
	public Connect connect;

	public TraitementAjoutClient(FenetreAjouterClient fenetreAjouterClient, Connect connect) {
		this.fenetreAjouterCLient=fenetreAjouterClient;
		this.connect=connect;
	}


	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();

		if(source== this.fenetreAjouterCLient.getBouttonValider()){
			String s = this.fenetreAjouterCLient.getDate().getText();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date d = null;
			try {
				d = sdf.parse(s);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if(!this.fenetreAjouterCLient.getNom().getText().equals("") && !this.fenetreAjouterCLient.getPrenom().getText().equals("") && !d.equals("") && !this.fenetreAjouterCLient.getVille().getText().equals("")){
				if(connect.gestionClient.addClient(this.fenetreAjouterCLient.getNom().getText(), this.fenetreAjouterCLient.getPrenom().getText(), d, this.fenetreAjouterCLient.getVille().getText())){
					JOptionPane.showMessageDialog(null,"Insertion r�ussi");
					fenetreAjouterCLient.dispose();
					FenetreGestionClient c = new FenetreGestionClient(this.connect);
				}
			}
		}
		if(source == this.fenetreAjouterCLient.getBouttonAnnuler()){
			this.fenetreAjouterCLient.dispose();
			FenetreGestionClient c = new FenetreGestionClient(this.connect);
		}
	}

}
