package traitement.ville;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BDD.Connect;
import vue.ville.FenetreGestionVille;
import vue.ville.FenetreSupprimerVille;

/**
 * Traitement pour pouvoir supprimer une ville
 * 
 * @author BRIERE / CARDON
 *
 */
public class TraitementSupprimerVille implements ActionListener {

	public FenetreSupprimerVille fenetreSupprimerVille;
	/**
	 * connexion à la BDD
	 */
	public Connect connect;

	/**
	 * constructeur de la class
	 * 
	 * @param fenetreSupprimerVille
	 * @param connect
	 *            connexion à la BDD
	 */
	public TraitementSupprimerVille(FenetreSupprimerVille fenetreSupprimerVille, Connect connect) {
		this.fenetreSupprimerVille = fenetreSupprimerVille;
		this.connect = connect;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object e = arg0.getSource();
		// bouton valider
		if (e == this.fenetreSupprimerVille.getBouttonValider()) {
			if (connect.gestionVille.supVille(this.fenetreSupprimerVille.getVille().getText())) {
				JOptionPane.showMessageDialog(null, "Suppression réussi");
				this.fenetreSupprimerVille.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Echec suppression ou la ville n'existe pas");

			}
		}
		// bouton annuler
		if (e == this.fenetreSupprimerVille.getBouttonAnnuler()) {
			this.fenetreSupprimerVille.dispose();
			new FenetreGestionVille(this.connect);
		}

	}

}
