package traitement.chambre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BDD.Connect;
import vue.chambre.FenetreAjouterChambre;
import vue.ville.FenetreGestionVille;

/**
 * Traitement pour pouvoir ajouter une chambre
 * 
 * @author BRIERE / CARDON
 *
 */
public class TraitementAjoutChambre implements ActionListener {

	public FenetreAjouterChambre fenetreAjouterChambre;
	/**
	 * connexion pour la BDD
	 */
	public Connect connect;
	/**
	 * ID de la cat�gorie
	 */
	public int cleCategorie;

	/**
	 * constructeur de la class
	 * 
	 * @param fenetreAjouterChambre
	 * @param connect
	 *            conenxion � la BDD
	 * @param cleCategorie
	 *            Cat�gorie ID
	 */
	public TraitementAjoutChambre(FenetreAjouterChambre fenetreAjouterChambre, Connect connect, int cleCategorie) {
		this.fenetreAjouterChambre = fenetreAjouterChambre;
		this.connect = connect;
		this.cleCategorie = cleCategorie;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o = arg0.getSource();
		// test pour savoir si la formulaire est compl�t�
		if (o == this.fenetreAjouterChambre.getBouttonValider()) {
			if (!this.fenetreAjouterChambre.getNom().getText().equals("")) {
				String nom = this.fenetreAjouterChambre.getNom().getText();
				if (this.connect.gestionChambre.addChambre(cleCategorie, nom)) {
					JOptionPane.showMessageDialog(null, "insertion effectu�e");
					this.fenetreAjouterChambre.dispose();
					new FenetreGestionVille(this.connect);
				} else {
					JOptionPane.showMessageDialog(null, "Insertion �chou�e");
				}

			}
		}
		// bouton annuler
		if (o == this.fenetreAjouterChambre.getBouttonAnnuler()) {
			this.fenetreAjouterChambre.dispose();
			new FenetreGestionVille(this.connect);
		}

	}

}
