package traitement.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import BDD.Connect;
import vue.client.FenetreGestionClient;
import vue.client.FenetreSupprimerClient;

/**
 * Traitement pour pouvoir supprimer un client
 * 
 * @author BRIERE / CARDON
 *
 */
public class TraitementSuppressionClient implements ActionListener {
	/**
	 * connexion à la BDD
	 */
	public Connect connect;
	public FenetreSupprimerClient fenetreSupprimerClient;

	/**
	 * constructeur de la class
	 * 
	 * @param fenetreSupprimerClient
	 * @param connect
	 *            connexion à la base
	 */
	public TraitementSuppressionClient(FenetreSupprimerClient fenetreSupprimerClient, Connect connect) {
		this.connect = connect;
		this.fenetreSupprimerClient = fenetreSupprimerClient;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object e = arg0.getSource();
		// bouton valider
		if (e == fenetreSupprimerClient.getBouttonValider()) {
			String nom = this.fenetreSupprimerClient.getNom().getText();
			String prenom = this.fenetreSupprimerClient.getPrenom().getText();
			String date = this.fenetreSupprimerClient.getDate().getText();
			Date d = null;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			try {
				d = sdf.parse(date);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}

			if (connect.gestionClient.supClient(nom, prenom, d)) {
				JOptionPane.showMessageDialog(null, "Suppression réussi");
				this.fenetreSupprimerClient.dispose();
				new FenetreGestionClient(this.connect);
			} else {
				JOptionPane.showMessageDialog(null, "Echec suppression ou le client n'existe pas");

			}

		}
		// bouton annuler
		if (e == fenetreSupprimerClient.getBouttonAnnuler()) {
			fenetreSupprimerClient.dispose();
			new FenetreGestionClient(connect);
		}

	}

}
