package traitement.hotel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BDD.Connect;
import vue.hotel.FenetreAjouterHotel;
import vue.ville.FenetreGestionVille;

/**
 * traitement pour l'ajout d'un h�tel
 * 
 * @author BRIERE / CARDON
 *
 */
public class TraitementAjoutHotel implements ActionListener {

	public FenetreAjouterHotel fenetreAjouterHotel;
	/**
	 * connexion � la BDD
	 */
	public Connect connect;
	/**
	 * ID de l'h�tel
	 */
	public int cle;

	/**
	 * Constructeur de la class
	 * 
	 * @param fenetreAjouterHotel
	 * @param connect
	 *            connexion � la BDD
	 * @param cle
	 *            ID de l'h�tel
	 */
	public TraitementAjoutHotel(FenetreAjouterHotel fenetreAjouterHotel, Connect connect, int cle) {
		this.fenetreAjouterHotel = fenetreAjouterHotel;
		this.connect = connect;
		this.cle = cle;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		// bouton annuler
		if (o == this.fenetreAjouterHotel.getBouttonAnnuler()) {
			this.fenetreAjouterHotel.dispose();
			new FenetreGestionVille(connect);
		}
		// bouton valider
		if (o == this.fenetreAjouterHotel.getBouttonValider()) {
			if (!this.fenetreAjouterHotel.getHotel().getText().equals("")) {
				if (this.connect.gestionHotel.addHotel(cle, this.fenetreAjouterHotel.getHotel().getText())) {
					JOptionPane.showMessageDialog(null, "Insertion r�ussi");
					this.fenetreAjouterHotel.dispose();
					new FenetreGestionVille(this.connect);

				}
			}
		}

	}

}
