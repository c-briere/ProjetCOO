package traitement.ligne;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BDD.Connect;
import vue.ligne.FenetreGestionLigne;
import vue.ligne.FenetreSupprimerLigne;

/**
 * Traitement pour pouvoir supprimer une ligne (liaison)
 * 
 * @author BRIERE / CARDON
 *
 */
public class TraitementSupprimerLigne implements ActionListener {

	public FenetreSupprimerLigne fenetreSupprimerLigne;
	/**
	 * connexion à la BDD
	 */
	public Connect connect;

	/**
	 * constructeur de la class
	 * 
	 * @param fenetreSupprimerLigne
	 * @param connect
	 *            connexion à la BDD
	 */
	public TraitementSupprimerLigne(FenetreSupprimerLigne fenetreSupprimerLigne, Connect connect) {
		this.fenetreSupprimerLigne = fenetreSupprimerLigne;
		this.connect = connect;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		// bouton valider
		if (o == fenetreSupprimerLigne.getBouttonValider()) {
			int cleVilleAller;
			int cleVilleRetour;
			String VilleAller = fenetreSupprimerLigne.getChoixVilleAller().getSelectedItem().toString();
			String VilleRetour = fenetreSupprimerLigne.getChoixVilleRetour().getSelectedItem().toString();
			if (!VilleAller.equals(VilleRetour) && !VilleAller.equals("") && !VilleRetour.equals("")) {
				VilleAller = fenetreSupprimerLigne.getChoixVilleAller().getSelectedItem().toString();
				VilleRetour = fenetreSupprimerLigne.getChoixVilleRetour().getSelectedItem().toString();
				cleVilleAller = this.connect.gestionVille.cleVille(VilleAller);
				cleVilleRetour = this.connect.gestionVille.cleVille(VilleRetour);
				if (this.connect.gestionLigne.supLigne(cleVilleAller, cleVilleRetour)) {
					JOptionPane.showMessageDialog(null, "Suppression réussi");
					this.fenetreSupprimerLigne.dispose();
					new FenetreGestionLigne(this.connect);

				} else {
					JOptionPane.showMessageDialog(null, "Suppression impossible ou ligne inexistante");

				}
			}
		}
		// bouton annuler
		if (o == this.fenetreSupprimerLigne.getBouttonAnnuler()) {
			this.fenetreSupprimerLigne.dispose();
			new FenetreGestionLigne(this.connect);
		}

	}

}
