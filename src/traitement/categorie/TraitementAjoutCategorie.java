package traitement.categorie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BDD.Connect;
import vue.categorie.FenetreAjouterCategorie;
import vue.ville.FenetreGestionVille;

/**
 * Permet d'ajouter une catégorie
 * 
 * @author BRIERE / CARDON
 *
 */
public class TraitementAjoutCategorie implements ActionListener {

	public FenetreAjouterCategorie fenetreAjouterCategorie;
	/**
	 * connexion à la BDD
	 */
	public Connect connect;
	/**
	 * ID de l'hôtel
	 */
	public int cleHotel;

	/**
	 * Cosntructeur de la class
	 * 
	 * @param fenetreAjouterCategorie
	 * @param connect
	 *            connexion à la BDD
	 * @param cleHotel
	 *            ID de l'hôtel
	 */
	public TraitementAjoutCategorie(FenetreAjouterCategorie fenetreAjouterCategorie, Connect connect, int cleHotel) {
		this.fenetreAjouterCategorie = fenetreAjouterCategorie;
		this.connect = connect;
		this.cleHotel = cleHotel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) throws NumberFormatException {
		Object o = arg0.getSource();
		// bouton valider
		if (o == this.fenetreAjouterCategorie.getBouttonValider()) {
			// test pour savoir si le formulaire est bien complété
			if (!this.fenetreAjouterCategorie.getNom().getText().equals("")
					&& !this.fenetreAjouterCategorie.getPlace().getText().equals("")
					&& !this.fenetreAjouterCategorie.getPrix().getText().equals("")) {
				String nom = this.fenetreAjouterCategorie.getNom().getText();
				double prix = 0;
				int place = 0;
				try {
					prix = Double.parseDouble(this.fenetreAjouterCategorie.getPrix().getText().trim());
					place = Integer.parseInt(this.fenetreAjouterCategorie.getPlace().getText().trim());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "mettre le bon format pour le prix/le nombre de place");

				}
				if (prix != 0 && place != 0) {
					if (this.connect.gestionCategorie.addCategorie(cleHotel, nom, prix, place)) {
						JOptionPane.showMessageDialog(null, "insertion effectuée");
						this.fenetreAjouterCategorie.dispose();
						new FenetreGestionVille(this.connect);
					} else {
						JOptionPane.showMessageDialog(null, "Insertion échouée");
					}
				}
			}
		}
		// bouton annuler
		if (o == this.fenetreAjouterCategorie.getBouttonAnnuler()) {
			this.fenetreAjouterCategorie.dispose();
			new FenetreGestionVille(this.connect);
		}

	}

}
