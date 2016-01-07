package traitement.reservation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BDD.Connect;
import vue.reservation.FenetreChoixGestionReservation;
import vue.reservation.FenetreGestionSuppressionReservation;

/**
 * traitement pour supprimer une réservation
 * 
 * @author BRIERE / CARDON
 *
 */
public class TraitementSuppressionReservation implements ActionListener {

	public FenetreGestionSuppressionReservation fenetreGestionSuppressionReservation;
	/**
	 * connexion pour la BDD
	 */
	public Connect connect;

	/**
	 * constructeur de la class
	 * 
	 * @param fenetreGestionSuppressionReservation
	 * @param connect
	 *            connexion pour la BDD
	 */
	public TraitementSuppressionReservation(FenetreGestionSuppressionReservation fenetreGestionSuppressionReservation,
			Connect connect) {
		this.fenetreGestionSuppressionReservation = fenetreGestionSuppressionReservation;
		this.connect = connect;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		// bouton annuler
		if (source == this.fenetreGestionSuppressionReservation.getAnnuler()) {
			this.fenetreGestionSuppressionReservation.dispose();
			new FenetreChoixGestionReservation(connect);
		}
		// bouton valider
		if (source == this.fenetreGestionSuppressionReservation.getValider()) {
			if (!this.fenetreGestionSuppressionReservation.getNom().getText().equals("")
					&& !this.fenetreGestionSuppressionReservation.getNumeroResa().getText().equals("")) {
				boolean supp;
				supp = this.connect.gestionReservation.verifSuppResa(
						this.fenetreGestionSuppressionReservation.getNom().getText(),
						this.fenetreGestionSuppressionReservation.getNumeroResa().getText());
				if (supp) {
					supp = this.connect.gestionReservation
							.suppResa(this.fenetreGestionSuppressionReservation.getNumeroResa().getText());
					if (supp) {
						this.fenetreGestionSuppressionReservation.dispose();
						JOptionPane.showMessageDialog(null, "Suppression réussi");
					} else {
						JOptionPane.showMessageDialog(null, "Echec suppression");

					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Impossible de supprimer cette reservation/aucune reservation à ce nom ou  numéro");

				}
			}
		}
	}

}
