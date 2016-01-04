package traitement.reservation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import BDD.Connect;
import classe_defaut.Categorie;
import classe_defaut.Chambre;
import classe_defaut.HotelRestant;
import classe_defaut.Ligne;
import classe_defaut.Reservation;
import classe_defaut.Trajet;
import classe_defaut.Ville;
import vue.FenetreAccueil;
import vue.reservation.FenetreGestionReservation;

/**
 * Traitement opur pouvoir passer une réservation
 * 
 * @author BRIERE / CARDON
 *
 */
public class TraitementReservation implements ActionListener {

	public FenetreGestionReservation fenetreGestionReservation;
	/**
	 * connexion pour la BDD
	 */
	public Connect connect;
	/**
	 * date du début du voyage
	 */
	public Date aller;
	/**
	 * date de fin du voyage
	 */
	public Date retour;

	/**
	 * Cosntructeur de la class
	 * 
	 * @param fenetreGestionReservation
	 * @param connect
	 *            connexion pour la BDD
	 */
	public TraitementReservation(FenetreGestionReservation fenetreGestionReservation, Connect connect) {
		this.fenetreGestionReservation = fenetreGestionReservation;
		this.connect = connect;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o = arg0.getSource();
		ArrayList<Integer> chambreNonDispo;
		// bouton suivant
		if (o == this.fenetreGestionReservation.getBouttonNextClient()) {
			int cle = 0;
			String nom = this.fenetreGestionReservation.getNom().getText();
			String prenom = this.fenetreGestionReservation.getPrenom().getText();
			String s = this.fenetreGestionReservation.getDate().getText();

			try {
				cle = this.connect.gestionClient.verifClientResa(nom, prenom, s);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (cle != 0) {
				this.fenetreGestionReservation.cleartSelectionClient();
				int cleVille = this.connect.gestionVille.cleVilleResaDepart(cle);
				Ville villeDepart = this.connect.gestionVille.getVille(cleVille);
				ArrayList<Ligne> ligne = this.connect.gestionLigne.voirLigneResaArrive(cleVille);
				this.fenetreGestionReservation.choixVilleDate(cle, cleVille, villeDepart, ligne);
			} else {
				JOptionPane.showMessageDialog(null, "Client Introuvable");

			}
		}
		// bouton annuler
		if (o == this.fenetreGestionReservation.getBouttonAnnuler()) {
			this.fenetreGestionReservation.dispose();
			new FenetreAccueil(this.connect);
		}
		// deuxième bouton suivant (le formulaire s'affiche étape par étape)
		if (o == this.fenetreGestionReservation.getBouttonNextChoixDate()) {
			if (!this.fenetreGestionReservation.getDateArrive().getText().equals("")
					&& !this.fenetreGestionReservation.getDateDepart().getText().equals("")
					&& !this.fenetreGestionReservation.getNbPersonne().getText().equals("")) {
				String jourDepart = this.connect.gestionDate
						.dateEnjours(this.fenetreGestionReservation.getDateDepart().getText());
				String jourArrivee = this.connect.gestionDate
						.dateEnjours(this.fenetreGestionReservation.getDateArrive().getText());
				String dateDepart = this.fenetreGestionReservation.getDateDepart().getText();
				String dateArrive = this.fenetreGestionReservation.getDateArrive().getText();
				int cleLigneAller = this.connect.gestionLigne.cleLigne(
						this.fenetreGestionReservation.getVilleDepart().getNom(),
						this.fenetreGestionReservation.getChoixVille().getSelectedItem().toString());
				int cleLigneRetour = this.connect.gestionLigne.cleLigne(
						this.fenetreGestionReservation.getChoixVille().getSelectedItem().toString(),
						this.fenetreGestionReservation.getVilleDepart().getNom());
				ArrayList<Trajet> ligne = this.connect.gestionTrajet.allTrajetResa(jourDepart, cleLigneAller);
				ArrayList<Trajet> ligneRetour = this.connect.gestionTrajet.allTrajetResa(jourArrivee, cleLigneRetour);
				String villeRetour = this.fenetreGestionReservation.getChoixVille().getSelectedItem().toString();
				int cleVilleArrive = this.connect.gestionVille
						.cleVille(this.fenetreGestionReservation.getChoixVille().getSelectedItem().toString());
				if (ligne.size() != 0 && ligneRetour.size() != 0) {
					this.fenetreGestionReservation.clearChoixDate();
					int nbPersonne = Integer.parseInt(this.fenetreGestionReservation.getNbPersonne().getText());
					this.fenetreGestionReservation.choixAller(cleVilleArrive, dateDepart, dateArrive, cleLigneAller,
							cleLigneRetour, ligne, ligneRetour, jourDepart, jourArrivee, nbPersonne, villeRetour);
				} else {
					JOptionPane.showMessageDialog(null, "Aucun aller et/ou retour disponible à ses dates");
				}
			}

		}
		// bouton suivant (sélection du premier trajet)
		if (o == this.fenetreGestionReservation.getBouttonNextChoixAller()) {
			String heureAller = (String) this.fenetreGestionReservation.getTableau().getModel()
					.getValueAt(this.fenetreGestionReservation.getTableau().getSelectedRow(), 1);
			String classeAller;
			double prixAller;
			if (this.fenetreGestionReservation.getChoixClasse().getSelectedItem().toString().equals("1ere classe")) {
				classeAller = "1 ere classe";
				prixAller = (Double) this.fenetreGestionReservation.getTableau().getModel()
						.getValueAt(this.fenetreGestionReservation.getTableau().getSelectedRow(), 8);
			} else {
				classeAller = "2 eme classe";
				prixAller = (Double) this.fenetreGestionReservation.getTableau().getModel()
						.getValueAt(this.fenetreGestionReservation.getTableau().getSelectedRow(), 9);

			}

			this.fenetreGestionReservation.clearChoixAller();
			this.fenetreGestionReservation.choixRetour(heureAller, classeAller, prixAller);
		}
		// bouton suivant (sélection du trajet retour)
		if (o == this.fenetreGestionReservation.getBouttonNextChoixRetour()) {
			String heureRetour = (String) this.fenetreGestionReservation.getTableau().getModel()
					.getValueAt(this.fenetreGestionReservation.getTableau().getSelectedRow(), 1);
			String classeRetour;
			double prixRetour;
			if (this.fenetreGestionReservation.getChoixClasse().getSelectedItem().toString().equals("1ere classe")) {
				classeRetour = "1 ere classe";
				prixRetour = (Double) this.fenetreGestionReservation.getTableau().getModel()
						.getValueAt(this.fenetreGestionReservation.getTableau().getSelectedRow(), 8);
			} else {
				classeRetour = "2 eme classe";
				prixRetour = (Double) this.fenetreGestionReservation.getTableau().getModel()
						.getValueAt(this.fenetreGestionReservation.getTableau().getSelectedRow(), 9);

			}
			conversationDate();
			chambreNonDispo = this.connect.gestionHotel
					.listChambreNonDipos(this.fenetreGestionReservation.getCleVilleArrive(), aller, retour);

			ArrayList<HotelRestant> hotel = this.connect.gestionHotel.listHotel(
					this.fenetreGestionReservation.getCleVilleArrive(),
					this.fenetreGestionReservation.getNbPersonneVoyage(), aller, retour, chambreNonDispo);
			this.fenetreGestionReservation.clearChoixRetour();
			this.fenetreGestionReservation.choixHotel(heureRetour, classeRetour, prixRetour, hotel);

		}
		// bouton suivant (sélection de l'hôtel)
		if (o == this.fenetreGestionReservation.getBouttonNextChoixHotel()) {
			int idHotel;
			idHotel = this.connect.gestionHotel.cleHotel(
					this.fenetreGestionReservation.getHotel()
							.get(this.fenetreGestionReservation.getChoixHotel().getSelectedIndex()).getNom(),
					this.fenetreGestionReservation.getCleVilleArrive());
			ArrayList<Categorie> categorie = new ArrayList<Categorie>();
			conversationDate();
			chambreNonDispo = this.connect.gestionHotel
					.listChambreNonDipos(this.fenetreGestionReservation.getCleVilleArrive(), aller, retour);

			categorie = this.connect.gestionCategorie.listCategorie(idHotel, chambreNonDispo,
					this.fenetreGestionReservation.getNbPersonneVoyage());
			this.fenetreGestionReservation.clearChoixHotel();
			this.fenetreGestionReservation.choixCategorie(idHotel, categorie);
		}
		// bouton suivant (sélection de la catégorie)
		if (o == this.fenetreGestionReservation.getBouttonNextChoixCategorie()) {
			int idCategorie;
			idCategorie = this.connect.gestionCategorie.cleCategorie(
					this.fenetreGestionReservation.getCategorie()
							.get(this.fenetreGestionReservation.getChoixCategorie().getSelectedIndex()).getNom(),
					this.fenetreGestionReservation.getIdHotel());
			conversationDate();
			ArrayList<Chambre> chambre = new ArrayList<Chambre>();
			chambreNonDispo = this.connect.gestionHotel
					.listChambreNonDipos(this.fenetreGestionReservation.getCleVilleArrive(), aller, retour);
			chambre = this.connect.gestionChambre.listChambre(idCategorie, chambreNonDispo);
			this.fenetreGestionReservation.clearChoixCategorie();
			this.fenetreGestionReservation.choixChambre(idCategorie, chambre);
		}
		// bouton suivant (sélection de la chambre)
		if (o == this.fenetreGestionReservation.getBouttonNextChoixChambre()) {
			int idChambre, nbJour;
			idChambre = this.connect.gestionChambre.cleChambre(
					this.fenetreGestionReservation.getChambre()
							.get(this.fenetreGestionReservation.getChoixChambre().getSelectedIndex()).getDenomination(),
					this.fenetreGestionReservation.getIdCategorie());
			nbJour = this.connect.gestionDate.nbDeJour(this.fenetreGestionReservation.getDateAller(),
					this.fenetreGestionReservation.getDateRetour());
			Reservation reservation = this.connect.gestionReservation
					.createReservation(this.fenetreGestionReservation.getHeureAller(),
							this.fenetreGestionReservation.getHeureRetour(),
							this.fenetreGestionReservation.getVilleDepart().getNom(),
							this.fenetreGestionReservation.getDateAller(), this.fenetreGestionReservation
									.getVilleRetour(),
							this.fenetreGestionReservation.getDateRetour(),
							this.fenetreGestionReservation.getPrixAller(),
							this.fenetreGestionReservation.getPrixRetour(),
							this.fenetreGestionReservation.getNbPersonneVoyage(),
							this.fenetreGestionReservation.getIdHotel(),
							this.fenetreGestionReservation.getIdCategorie(),
							this.fenetreGestionReservation.getCleClient(), idChambre, nbJour);
			this.fenetreGestionReservation.clearChoixChambre();
			this.fenetreGestionReservation.recapilutatif(idChambre, reservation);

		}
		// bouton valider
		if (o == this.fenetreGestionReservation.getBouttonValider()) {
			boolean verif = this.connect.gestionReservation.ajoutResa(this.fenetreGestionReservation.getCleClient(),
					this.fenetreGestionReservation.getCleVilleDepart(),
					this.fenetreGestionReservation.getCleVilleArrive(),
					this.fenetreGestionReservation.getCleLigneAller(),
					this.fenetreGestionReservation.getCleLigneRetour(), this.fenetreGestionReservation.getClasseAller(),
					this.fenetreGestionReservation.getClasseRetour(), this.fenetreGestionReservation.getIdHotel(),
					this.fenetreGestionReservation.getIdCategorie(), this.fenetreGestionReservation.getCleChambre(),
					this.fenetreGestionReservation.getDateAller(), this.fenetreGestionReservation.getDateRetour(),
					this.fenetreGestionReservation.getReservation().getPrixTotal(),
					this.fenetreGestionReservation.getReservation().getNbPersonne());
			if (verif) {
				int cleResa = this.connect.gestionReservation.cleResa();
				JOptionPane.showMessageDialog(null, "Insertion réussi : numero de resarvation : " + cleResa);
				this.fenetreGestionReservation.clearRecapitulatif();
				this.fenetreGestionReservation.dispose();
				new FenetreAccueil(connect);
			} else {
				JOptionPane.showMessageDialog(null, "Echec de l ajout");

			}
		}
	}

	public void conversationDate() {
		aller = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			aller = sdf.parse(this.fenetreGestionReservation.getDateAller());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		retour = null;
		try {
			retour = sdf2.parse(this.fenetreGestionReservation.getDateRetour());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
