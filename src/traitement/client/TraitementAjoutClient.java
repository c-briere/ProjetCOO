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

/**
 * Traitement pour pouvoir ajouter un client
 * 
 * @author BRIERE / CARDON
 *
 */
public class TraitementAjoutClient implements ActionListener {

	public FenetreAjouterClient fenetreAjouterCLient;
	/**
	 * connexion à la BDD
	 */
	public Connect connect;

	/**
	 * constructeur de la class
	 * 
	 * @param fenetreAjouterClient
	 * @param connect
	 *            connexion à la BDD
	 */
	public TraitementAjoutClient(FenetreAjouterClient fenetreAjouterClient, Connect connect) {
		this.fenetreAjouterCLient = fenetreAjouterClient;
		this.connect = connect;
	}

	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		/**
		 * bouton valider
		 */
		if (source == this.fenetreAjouterCLient.getBouttonValider()) {
			String s = this.fenetreAjouterCLient.getDate().getText();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date d = null;
			try {
				d = sdf.parse(s);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (!this.fenetreAjouterCLient.getNom().getText().equals("")
					&& !this.fenetreAjouterCLient.getPrenom().getText().equals("") && !d.equals("")
					&& !this.fenetreAjouterCLient.getVille().getText().equals("")) {
				if (connect.gestionClient.addClient(this.fenetreAjouterCLient.getNom().getText(),
						this.fenetreAjouterCLient.getPrenom().getText(), d,
						this.fenetreAjouterCLient.getVille().getText())) {
					JOptionPane.showMessageDialog(null, "Insertion réussi");
					fenetreAjouterCLient.dispose();
					new FenetreGestionClient(this.connect);
				}
			}
		}
		// bouton annuler
		if (source == this.fenetreAjouterCLient.getBouttonAnnuler()) {
			this.fenetreAjouterCLient.dispose();
			new FenetreGestionClient(this.connect);
		}
	}

}
