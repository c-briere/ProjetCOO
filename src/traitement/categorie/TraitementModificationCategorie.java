package traitement.categorie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BDD.Connect;
import vue.categorie.FenetreModifCategorie;
import vue.ville.FenetreGestionVille;

/**
 * Traitement pour pouvoir modifier une catégorie
 * 
 * @author BRIERE / CARDON
 *
 */
public class TraitementModificationCategorie implements ActionListener {

	public FenetreModifCategorie fenetreModifCategorie;
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
	 * @param fenetreModifCategorie
	 * @param connect
	 *            connexion à la BDD
	 * @param cleHotel
	 *            ID de l'hôtel
	 */
	public TraitementModificationCategorie(FenetreModifCategorie fenetreModifCategorie, Connect connect, int cleHotel) {
		this.fenetreModifCategorie = fenetreModifCategorie;
		this.connect = connect;
		this.cleHotel = cleHotel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object e = arg0.getSource();
		int cle = 0;
		if (e == this.fenetreModifCategorie.getBouttonValider()) {
			String s = this.fenetreModifCategorie.getBouttonValider().getText();
			String nom = this.fenetreModifCategorie.getNom().getText();
			if (s.equals("Rechercher")) {

				if (!nom.equals("")) {
					cle = connect.gestionCategorie.verifCategorie(cleHotel, nom);

					if (cle != 0) {
						this.fenetreModifCategorie.getBouttonValider().setText("Modifier");
						this.fenetreModifCategorie.getPlace().setVisible(true);
						this.fenetreModifCategorie.getPrix().setVisible(true);
						this.fenetreModifCategorie.setCleCategorie(cle);
					}
				}
			}
			if (s.equals("Modifier")) {
				boolean modif;
				if (!this.fenetreModifCategorie.getNom().equals("") && !this.fenetreModifCategorie.getPlace().equals("")
						&& !this.fenetreModifCategorie.getPrix().equals("")) {
					Double place = Double.parseDouble(this.fenetreModifCategorie.getPlace().getText());
					int prix = Integer.parseInt(this.fenetreModifCategorie.getPrix().getText());
					modif = connect.gestionCategorie.ModifClient(this.fenetreModifCategorie.getCleCategorie(), nom,
							place, prix);
					if (modif) {
						this.fenetreModifCategorie.dispose();
						JOptionPane.showMessageDialog(null, "Modification réussi");

						new FenetreGestionVille(connect);
					} else {
						JOptionPane.showMessageDialog(null, "Echec modification");

					}
				}
			}
		}
		// bouton annuler
		if (e == this.fenetreModifCategorie.getBouttonAnnuler()) {
			this.fenetreModifCategorie.dispose();
			new FenetreGestionVille(connect);

		}

	}
}
