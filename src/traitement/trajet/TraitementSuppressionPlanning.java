package traitement.trajet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BDD.Connect;
import vue.ligne.FenetreGestionLigne;
import vue.trajet.FenetreSupprimerPlanning;

/**
 * Traitement pour pouvoir supprimer un trajet
 * 
 * @author BRIERE / CARDON
 *
 */
public class TraitementSuppressionPlanning implements ActionListener {
	public FenetreSupprimerPlanning fenetreSupprimerPlanning;
	/**
	 * connexion à la base
	 */
	public Connect connect;
	/**
	 * ID de la ligne
	 */
	public int cleLigne;

	/**
	 * constructeur de la class
	 * 
	 * @param fenetreSupprimerPlanning
	 * @param connect
	 *            connexion de la BDD
	 * @param cleLigne
	 *            Id de la ligne
	 */
	public TraitementSuppressionPlanning(FenetreSupprimerPlanning fenetreSupprimerPlanning, Connect connect,
			int cleLigne) {
		this.fenetreSupprimerPlanning = fenetreSupprimerPlanning;
		this.connect = connect;
		this.cleLigne = cleLigne;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o = arg0.getSource();
		// bouton annuler
		if (o == this.fenetreSupprimerPlanning.getBouttonAnnuler()) {
			this.fenetreSupprimerPlanning.dispose();
			new FenetreGestionLigne(connect);
		}
		// bouton valider
		if (o == this.fenetreSupprimerPlanning.getBouttonValider()) {
			if (this.connect.gestionTrajet.deleteTrajet(cleLigne,
					Integer.parseInt(this.fenetreSupprimerPlanning.getDuree().getText()),
					this.fenetreSupprimerPlanning.getHeure().getText(),
					this.fenetreSupprimerPlanning.getJour().getSelectedItem().toString())) {
				JOptionPane.showMessageDialog(null, "Suppression réussi");
				this.fenetreSupprimerPlanning.dispose();
				new FenetreGestionLigne(this.connect);
			} else {
				JOptionPane.showMessageDialog(null, "echec suppression ou le trajet n'existe pas");
			}
		}

	}

}
