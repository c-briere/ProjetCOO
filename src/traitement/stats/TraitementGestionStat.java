package traitement.stats;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import BDD.Connect;
import classe_defaut.Trajet;
import classe_defaut.Ville;
import vue.FenetreAccueil;
import vue.stats.FenetreChoixDateStat;
import vue.stats.FenetreVoirStat;

/**
 * Traitement pour les statistiques
 * 
 * @author BRIERE / CARDON
 *
 */
public class TraitementGestionStat implements ActionListener {
	;

	public FenetreChoixDateStat fenetreChoixDateStat;
	/**
	 * connexion à la BDD
	 */
	public Connect connect;

	/**
	 * constructeur de la class
	 * 
	 * @param fenetreChoixDateStat
	 * @param connect
	 *            connexion à la BDD
	 */
	public TraitementGestionStat(FenetreChoixDateStat fenetreChoixDateStat, Connect connect) {
		this.fenetreChoixDateStat = fenetreChoixDateStat;
		this.connect = connect;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		// bouton annuler
		if (source == this.fenetreChoixDateStat.bouttonAnnuler) {
			this.fenetreChoixDateStat.dispose();
			new FenetreAccueil(connect);
		}
		// bouton valider/voir
		if (source == this.fenetreChoixDateStat.bouttonVoir) {
			if (!this.fenetreChoixDateStat.date1.getText().equals("")
					&& !this.fenetreChoixDateStat.date2.getText().equals("")) {
				ArrayList<Ville> ville = new ArrayList<Ville>();
				int nbDeVoyageur;
				ArrayList<Trajet> trajet = new ArrayList<Trajet>();
				ville = this.connect.gestionStat.villeLesPlusDemandes(this.fenetreChoixDateStat.date1.getText(),
						this.fenetreChoixDateStat.date2.getText());
				nbDeVoyageur = this.connect.gestionStat.nbDeVoyageur(this.fenetreChoixDateStat.date1.getText(),
						this.fenetreChoixDateStat.date2.getText());
				trajet = this.connect.gestionStat.ligneNonUtilise(this.fenetreChoixDateStat.date1.getText(),
						this.fenetreChoixDateStat.date2.getText());
				this.fenetreChoixDateStat.dispose();
				new FenetreVoirStat(ville, nbDeVoyageur, trajet, connect);
			}
		}

	}

}
