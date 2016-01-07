package traitement.hotel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BDD.Connect;
import vue.hotel.FenetreSupprimerHotel;
import vue.ville.FenetreGestionVille;

/**
 * traitement pour la supression d'un hôtel
 * 
 * @author BRIERE / CARDON
 *
 */
public class TraitementSuppressionHotel implements ActionListener {

	public FenetreSupprimerHotel fenetreSupprimerHotel;
	/**
	 * connexion à la BDD
	 */
	public Connect connect;
	/**
	 * ID de l'hôtel
	 */
	public int cle;

	/**
	 * Constructeur de la class
	 * 
	 * @param fenetreSupprimerHotel
	 * @param connect
	 *            connexion à la BDD
	 * @param cle
	 *            ID de l'hôtel
	 */
	public TraitementSuppressionHotel(FenetreSupprimerHotel fenetreSupprimerHotel, Connect connect, int cle) {
		this.fenetreSupprimerHotel = fenetreSupprimerHotel;
		this.connect = connect;
		this.cle = cle;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object e = arg0.getSource();
		// bouton valider
		if (e == this.fenetreSupprimerHotel.getBouttonValider()) {
			if (this.connect.gestionHotel.deleteHotel(cle, this.fenetreSupprimerHotel.getHotel().getText())) {
				JOptionPane.showMessageDialog(null, "Suppression réussi");
				this.fenetreSupprimerHotel.dispose();
				new FenetreGestionVille(this.connect);
			} else {
				JOptionPane.showMessageDialog(null, "echec suppression ou l'hotel n'existe pas");
			}
		}
		// bouton annuler
		if (e == this.fenetreSupprimerHotel.getBouttonAnnuler()) {
			this.fenetreSupprimerHotel.dispose();
			new FenetreGestionVille(this.connect);
		}

	}

}
