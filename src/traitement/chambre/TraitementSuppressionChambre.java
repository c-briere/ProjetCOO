package traitement.chambre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BDD.Connect;
import vue.chambre.FenetreSupprimerChambre;
import vue.ville.FenetreGestionVille;

/**
 * Traitement pour pouvoir supprimer une chambre
 * 
 * @author BRIERE / CARDON
 *
 */
public class TraitementSuppressionChambre implements ActionListener {

	public FenetreSupprimerChambre fenetreSupprimerChambre;
	/**
	 * Connexion pour la BDD
	 */
	public Connect connect;
	/**
	 * Catégorie ID
	 */
	public int cleCategorie;

	/**
	 * Constructeur de la class
	 * 
	 * @param fenetreSupprimerChambre
	 * @param connect
	 *            connexion à la BDD
	 * @param cleCategorie
	 *            catégorie ID
	 */
	public TraitementSuppressionChambre(FenetreSupprimerChambre fenetreSupprimerChambre, Connect connect,
			int cleCategorie) {
		this.fenetreSupprimerChambre = fenetreSupprimerChambre;
		this.connect = connect;
		this.cleCategorie = cleCategorie;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o = arg0.getSource();
		// bouton valider
		if (o == this.fenetreSupprimerChambre.getBouttonValider()) {
			// vérification du formulaire
			if (!this.fenetreSupprimerChambre.getNom().getText().equals("")) {
				if (this.connect.gestionChambre.suppChambre(this.fenetreSupprimerChambre.getNom().getText(),
						this.cleCategorie)) {
					JOptionPane.showMessageDialog(null, "Suppression réussi");
					this.fenetreSupprimerChambre.dispose();
					new FenetreGestionVille(this.connect);
				} else {
					JOptionPane.showMessageDialog(null, "Suppression échouée ou catégorie introuvable");

				}
			}
		}

		// bouton annuler
		if (o == this.fenetreSupprimerChambre.getBouttonAnnuler()) {
			this.fenetreSupprimerChambre.dispose();
			new FenetreGestionVille(this.connect);
		}

	}

}
