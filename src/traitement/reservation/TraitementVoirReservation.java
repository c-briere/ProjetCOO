package traitement.reservation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BDD.Connect;
import classe_defaut.Reservation;
import vue.FenetreAccueil;
import vue.reservation.FenetreGestionVoirReservation;
import vue.reservation.FenetreVoirResa;

/**
 * Traitement pour sélectionner une réservation
 * 
 * @author BRIERE / CARDON
 *
 */
public class TraitementVoirReservation implements ActionListener {

	FenetreGestionVoirReservation fenetreGestionVoirReservation;
	/**
	 * connexion pour la BDD
	 */
	Connect connect;

	/**
	 * constructeur de la class
	 * 
	 * @param fenetreGestionVoirReservation
	 * @param connect
	 *            connexion pour la BDD
	 */
	public TraitementVoirReservation(FenetreGestionVoirReservation fenetreGestionVoirReservation, Connect connect) {
		this.connect = connect;
		this.fenetreGestionVoirReservation = fenetreGestionVoirReservation;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		// bouton annuler
		if (source == this.fenetreGestionVoirReservation.bouttonAnnuler) {
			this.fenetreGestionVoirReservation.dispose();
			new FenetreAccueil(connect);
		}
		// bouton valider/voir
		if (source == this.fenetreGestionVoirReservation.bouttonVoir) {
			int cle = 0;
			String nom = this.fenetreGestionVoirReservation.nom.getText();
			String prenom = this.fenetreGestionVoirReservation.prenom.getText();
			String s = this.fenetreGestionVoirReservation.date.getText();
			try {
				cle = this.connect.gestionClient.verifClientResa(nom, prenom, s);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (cle != 0) {
				ArrayList<Reservation> reservation;
				reservation = this.connect.gestionReservation.voirResa(cle);
				this.fenetreGestionVoirReservation.dispose();
				new FenetreVoirResa(connect, reservation);
			} else {
				JOptionPane.showMessageDialog(null, "Client Introuvable");

			}
		}

	}

}
