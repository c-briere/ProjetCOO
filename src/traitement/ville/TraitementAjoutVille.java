package traitement.ville;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BDD.Connect;
import vue.ville.FenetreAjouterVille;
import vue.ville.FenetreGestionVille;

/**
 * Traitement pour pouvoir ajouter une ville
 * 
 * @author BRIERE / CARDON
 *
 */
public class TraitementAjoutVille implements ActionListener {

	public FenetreAjouterVille fenetreAjouterVille;
	/**
	 * connexion à la BDD
	 */
	public Connect connect;

	/**
	 * Constructeur de la class
	 * 
	 * @param fenetreAjouterVille
	 * @param connect
	 *            connexion à la BDD
	 */
	public TraitementAjoutVille(FenetreAjouterVille fenetreAjouterVille, Connect connect) {
		this.fenetreAjouterVille = fenetreAjouterVille;
		this.connect = connect;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		// bouton valider
		if (o == this.fenetreAjouterVille.getBouttonValider()) {
			if (!this.fenetreAjouterVille.getVille().getText().equals("")) {
				if (this.connect.gestionVille.addVille(this.fenetreAjouterVille.getVille().getText())) {
					JOptionPane.showMessageDialog(null, "Insertion réussi");
					this.fenetreAjouterVille.dispose();
					new FenetreGestionVille(this.connect);

				}
			}
		}
		// bouton annuler
		if (o == this.fenetreAjouterVille.getBouttonAnnuler()) {
			this.fenetreAjouterVille.dispose();
			new FenetreGestionVille(this.connect);
		}

	}

}
