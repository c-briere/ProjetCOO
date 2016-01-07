package traitement.categorie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BDD.Connect;
import vue.categorie.FenetreSupprimerCategorie;
import vue.ville.FenetreGestionVille;

/**
 * Traitement opur pouvoir supprimer une catégorie
 * 
 * @author BRIERE / CARDON
 *
 */
public class TraitementSuppressionCategorie implements ActionListener {

	public FenetreSupprimerCategorie fenetreSupprimerCategorie;
	/**
	 * connexion pour la BDD
	 */
	public Connect connect;
	/**
	 * ID de l'hôtel
	 */
	public int cleHotel;

	/**
	 * Constructeur de la class
	 * 
	 * @param fenetreSupprimerCategorie
	 * @param connect
	 *            connexion à la BDD
	 * @param cleHotel
	 *            ID de l'hôtel
	 */
	public TraitementSuppressionCategorie(FenetreSupprimerCategorie fenetreSupprimerCategorie, Connect connect,
			int cleHotel) {
		this.fenetreSupprimerCategorie = fenetreSupprimerCategorie;
		this.connect = connect;
		this.cleHotel = cleHotel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o = arg0.getSource();
		// bouton valider
		if (o == this.fenetreSupprimerCategorie.getBouttonValider()) {
			if (!this.fenetreSupprimerCategorie.getCategorie().getText().equals("")) {
				if (this.connect.gestionCategorie.suppCategorie(this.fenetreSupprimerCategorie.getCategorie().getText(),
						this.cleHotel)) {
					JOptionPane.showMessageDialog(null, "Suppression réussi");
					this.fenetreSupprimerCategorie.dispose();
					new FenetreGestionVille(this.connect);
				} else {
					JOptionPane.showMessageDialog(null, "Suppression échouée ou catégorie introuvable");

				}
			}
		}
		// bouton annuler
		if (o == this.fenetreSupprimerCategorie.getBouttonAnnuler()) {
			this.fenetreSupprimerCategorie.dispose();
			new FenetreGestionVille(this.connect);
		}

	}

}
