package vue.reservation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;

import BDD.Connect;
import classe_defaut.Categorie;
import classe_defaut.Chambre;
import classe_defaut.HotelRestant;
import classe_defaut.Ligne;
import classe_defaut.Reservation;
import classe_defaut.Trajet;
import classe_defaut.Ville;
import traitement.reservation.TraitementReservation;
import traitement.tableau.TableTrajetPrixTotal;

/**
 * Fenêtre pour pouvoir passer une réservation La formulaire est en plusieurs
 * partie qui apparait/disparait avec setVisible()
 * 
 * @author BRIERE / CARDON
 *
 */
public class FenetreGestionReservation extends JFrame {

	public Connect connect;
	private JTextField nom;
	private JTextField prenom;
	private JTextField date;
	public JTextField villeDepart;
	private JTextField dateDepart;
	private JTextField dateArrive;
	private JTextField nbPersonne;
	private JButton bouttonValider;
	private JButton bouttonNextChoixChambre;
	private JButton bouttonNextClient;
	private JButton bouttonAnnuler;
	private JButton bouttonNextChoixDate;
	private JButton bouttonNextChoixAller;
	private JButton bouttonNextChoixRetour;
	private JButton bouttonNextChoixHotel;
	private JButton bouttonNextChoixCategorie;
	public JPanel panel, panelChoixChambre, panelSelectionClient, panelSelectionDate, panelSelectionAller,
			panelSelectionRetour, panelChoixHotel, panelChoixCategorie;
	private int cleChambre;
	private int cleClient;
	private int cleVilleDepart;
	private int cleLigneAller;
	private int cleLigneRetour;
	private int nbPersonneVoyage;
	private int cleVilleArrive;
	private int idHotel;
	private int idCategorie;
	private Ville VilleDepart;
	public ArrayList<Ligne> ligne;
	private ArrayList<HotelRestant> hotel;
	private ArrayList<Categorie> categorie;
	private JComboBox<String> choixVille;
	private JComboBox<String> choixClasse;
	private JComboBox<String> choixHotel;
	private JComboBox<String> choixCategorie;
	private JComboBox<String> choixChambre;
	public ArrayList<Trajet> trajet, trajetRetour;
	public String jourDepart, jourArrivee;
	private String heureAller;
	private String classeAller;
	private String heureRetour;
	private String classeRetour;
	private String villeRetour;
	private String dateAller;
	private String dateRetour;
	private JTable tableau;
	private Double prixAller;
	private Double prixRetour;
	private ArrayList<Chambre> chambre;
	private Reservation reservation;

	public FenetreGestionReservation(Connect connect) {
		super("gestion reservation");
		this.connect = connect;
		this.choixClient();
		setVilleDepart(null);
	}

	/**
	 * Première partie du formulaire Ici on doit choisir le client
	 */
	public void choixClient() {
		setNom(new JTextField());
		setPrenom(new JTextField());
		setDate(new JTextField());

		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color(0xCFBFAD);

		// Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 24);

		setBouttonNextClient(new JButton("Next"));
		setBouttonAnnuler(new JButton("Annuler"));

		getBouttonNextClient().addActionListener(new TraitementReservation(this, this.connect));
		getBouttonAnnuler().addActionListener(new TraitementReservation(this, this.connect));

		getNom().setPreferredSize(new Dimension(250, 30));
		getPrenom().setPreferredSize(new Dimension(250, 30));
		getDate().setPreferredSize(new Dimension(250, 30));

		// Fond transparent
		getBouttonAnnuler().setOpaque(false);
		getBouttonAnnuler().setContentAreaFilled(false);
		// Changement couleur bordure
		getBouttonAnnuler().setBorder(border);
		// Changement Police
		getBouttonAnnuler().setFont(font_bouton);
		// Changement couleur Police
		getBouttonAnnuler().setForeground(BlancPale);

		// Fond transparent
		getBouttonNextClient().setOpaque(false);
		getBouttonNextClient().setContentAreaFilled(false);
		// Changement couleur bordure
		getBouttonNextClient().setBorder(border);
		// Changement Police
		getBouttonNextClient().setFont(font_bouton);
		// Changement couleur Police
		getBouttonNextClient().setForeground(BlancPale);

		panelSelectionClient = new JPanel();
		panelSelectionClient.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JPanel panel4 = new JPanel(new FlowLayout());
		panel4.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel d = new JLabel("Date de naissance");
		d.setFont(font_bouton);
		d.setForeground(BlancPale);
		// similaire à un margin-left
		d.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		panel4.add(d, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel4.add(getDate());

		JPanel panel5 = new JPanel(new FlowLayout());
		panel5.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel n = new JLabel("Nom");
		n.setFont(font_bouton);
		n.setForeground(BlancPale);
		// similaire à un margin-left
		n.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 170));
		panel5.add(n, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel5.add(getNom());

		JPanel panel6 = new JPanel(new FlowLayout());
		panel6.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel p = new JLabel("Prénom");
		p.setFont(font_bouton);
		p.setForeground(BlancPale);
		// similaire à un margin-left
		p.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 140));
		panel6.add(p, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel6.add(getPrenom());

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 2;
		panelSelectionClient.add(panel4, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		panelSelectionClient.add(panel5, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		panelSelectionClient.add(panel6, c);

		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 3;
		panelSelectionClient.add(getBouttonNextClient(), c);

		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 3;
		panelSelectionClient.add(getBouttonAnnuler(), c);

		// Fond du panel
		// couleur : gris foncé
		panel4.setBackground(GrisFonce);
		panel5.setBackground(GrisFonce);
		panel6.setBackground(GrisFonce);
		panelSelectionClient.setBackground(GrisFonce);

		this.getContentPane().add(panelSelectionClient);
		setSize(500, 300);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Cache la partie de selection du client
	 */
	public void cleartSelectionClient() {
		this.panelSelectionClient.setVisible(false);
	}

	/**
	 * Cache la partie sur la sélection des dates du voyage
	 */
	public void clearChoixDate() {
		this.panelSelectionDate.setVisible(false);
	}

	/**
	 * Cache la partie sur la sélection du trajet aller
	 */
	public void clearChoixAller() {
		this.panelSelectionAller.setVisible(false);
	}

	/**
	 * Cache la partie sur la sélection du trajet retour
	 */
	public void clearChoixRetour() {
		this.panelSelectionRetour.setVisible(false);
	}

	/**
	 * cache la partie sur la sélection de l'hôtel
	 */
	public void clearChoixHotel() {
		this.panelChoixHotel.setVisible(false);
	}

	/**
	 * Cache la partie sur la sélection de la catégorie
	 */
	public void clearChoixCategorie() {
		this.panelChoixCategorie.setVisible(false);
	}

	/**
	 * Cache la partie sur la sélection de la chambre
	 */
	public void clearChoixChambre() {
		this.panelChoixChambre.setVisible(false);
	}

	/**
	 * Cache la partie qui résume la réservation
	 */
	public void clearRecapitulatif() {
		this.panel.setVisible(false);
	}

	/**
	 * C'est ici que l'on choisit la transport et la date
	 * 
	 * @param cleClient
	 *            ID du client
	 * @param cleVilleDepart
	 *            ID de la ville de départ
	 * @param VilleDepart
	 * @param ligne
	 *            liste des lignes
	 */
	public void choixVilleDate(int cleClient, int cleVilleDepart, Ville VilleDepart, ArrayList<Ligne> ligne) {
		this.setCleClient(cleClient);
		this.setCleVilleDepart(cleVilleDepart);
		this.setVilleDepart(VilleDepart);
		this.ligne = ligne;
		setChoixVille(new JComboBox<>());
		for (int i = 0; i < ligne.size(); i++) {
			getChoixVille().addItem(ligne.get(i).getVilleRetour().getNom());
		}
		;

		setBouttonNextChoixDate(new JButton("next"));
		setBouttonAnnuler(new JButton("Annuler"));

		getBouttonNextChoixDate().addActionListener(new TraitementReservation(this, this.connect));
		getBouttonAnnuler().addActionListener(new TraitementReservation(this, this.connect));

		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color(0xCFBFAD);

		// Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 24);

		// Fond transparent
		getBouttonAnnuler().setOpaque(false);
		getBouttonAnnuler().setContentAreaFilled(false);
		// Changement couleur bordure
		getBouttonAnnuler().setBorder(border);
		// Changement Police
		getBouttonAnnuler().setFont(font_bouton);
		// Changement couleur Police
		getBouttonAnnuler().setForeground(BlancPale);

		// Fond transparent
		getBouttonNextChoixDate().setOpaque(false);
		getBouttonNextChoixDate().setContentAreaFilled(false);
		// Changement couleur bordure
		getBouttonNextChoixDate().setBorder(border);
		// Changement Police
		getBouttonNextChoixDate().setFont(font_bouton);
		// Changement couleur Police
		getBouttonNextChoixDate().setForeground(BlancPale);

		panelSelectionDate = new JPanel();
		panelSelectionDate.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		setDateDepart(new JTextField());
		setDateArrive(new JTextField());
		setNbPersonne(new JTextField());
		villeDepart = new JTextField();

		getChoixVille().setPreferredSize(new Dimension(250, 30));
		getDateDepart().setPreferredSize(new Dimension(250, 30));
		getDateArrive().setPreferredSize(new Dimension(250, 30));
		getNbPersonne().setPreferredSize(new Dimension(250, 30));
		villeDepart.setPreferredSize(new Dimension(250, 30));
		villeDepart.setText(VilleDepart.getNom());

		JPanel panel4 = new JPanel(new FlowLayout());
		panel4.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel d = new JLabel("Choix de la ville");
		d.setFont(font_bouton);
		d.setForeground(BlancPale);
		// similaire à un margin-left
		d.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 205));
		panel4.add(d, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel4.add(getChoixVille());

		JPanel panel5 = new JPanel(new FlowLayout());
		panel5.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel vd = new JLabel("Ville de départ");
		vd.setFont(font_bouton);
		vd.setForeground(BlancPale);
		// similaire à un margin-left
		vd.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 220));
		panel5.add(vd, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel5.add(villeDepart);

		JPanel panel6 = new JPanel(new FlowLayout());
		panel6.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel p = new JLabel("Choix date départ");
		p.setFont(font_bouton);
		p.setForeground(BlancPale);
		// similaire à un margin-left
		p.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 185));
		panel6.add(p, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel6.add(getDateDepart());

		JPanel panel7 = new JPanel(new FlowLayout());
		panel7.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel dr = new JLabel("Choix date retour");
		dr.setFont(font_bouton);
		dr.setForeground(BlancPale);
		// similaire à un margin-left
		dr.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 192));
		panel7.add(dr, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel7.add(getDateArrive());

		JPanel panel8 = new JPanel(new FlowLayout());
		panel8.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel nbp = new JLabel("Nombre de personnes");
		nbp.setFont(font_bouton);
		nbp.setForeground(BlancPale);
		// similaire à un margin-left
		nbp.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 140));
		panel8.add(nbp, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel8.add(getNbPersonne());

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		panelSelectionDate.add(panel5, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		panelSelectionDate.add(panel4, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 2;
		panelSelectionDate.add(panel6, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 3;
		panelSelectionDate.add(panel7, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 4;
		panelSelectionDate.add(panel8, c);

		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 5;
		panelSelectionDate.add(getBouttonNextChoixDate(), c);

		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 5;
		panelSelectionDate.add(getBouttonAnnuler(), c);

		// Fond du panel
		// couleur : gris foncé
		panel4.setBackground(GrisFonce);
		panel5.setBackground(GrisFonce);
		panel6.setBackground(GrisFonce);
		panel7.setBackground(GrisFonce);
		panel8.setBackground(GrisFonce);
		panelSelectionDate.setBackground(GrisFonce);

		this.getContentPane().add(panelSelectionDate);
		setSize(800, 300);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	/**
	 * On sélectionne la trajet retour
	 * 
	 * @param heureAller
	 * @param classeAller
	 * @param prixAller
	 */
	public void choixRetour(String heureAller, String classeAller, double prixAller) {
		this.setHeureAller(heureAller);
		this.setClasseAller(classeAller);
		this.setPrixAller(prixAller);

		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color(0xCFBFAD);

		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 16);

		String[] classe = { "1ere classe", "2eme classe" };
		setChoixClasse(new JComboBox<>(classe));
		setBouttonNextChoixRetour(new JButton("Next"));
		setBouttonAnnuler(new JButton("Annuler"));
		panelSelectionRetour = new JPanel();
		panelSelectionRetour.setLayout(new BoxLayout(panelSelectionRetour, BoxLayout.PAGE_AXIS));

		setTableau(new JTable(new TableTrajetPrixTotal(trajetRetour, getNbPersonneVoyage())));
		getTableau().setPreferredScrollableViewportSize(new Dimension(500, 200));
		getTableau().setFillsViewportHeight(true);
		// Modification du HEADER du tableau
		JTableHeader header = getTableau().getTableHeader();
		header.setBackground(GrisFonce);
		header.setForeground(BlancPale);
		JScrollPane scrollPane = new JScrollPane(getTableau());

		JPanel panel3 = new JPanel();
		JLabel v = new JLabel("Choix de la classe");
		v.setFont(font_bouton);
		v.setForeground(BlancPale);
		panel3.add(v);
		panel3.add(getChoixClasse());

		JPanel panel2 = new JPanel();
		panel2.add(getBouttonNextChoixRetour());
		getBouttonNextChoixRetour().addActionListener(new TraitementReservation(this, this.connect));
		panel2.add(getBouttonAnnuler());
		getBouttonAnnuler().addActionListener(new TraitementReservation(this, this.connect));

		panelSelectionRetour.add(scrollPane, BorderLayout.NORTH);
		panelSelectionRetour.add(panel3, BorderLayout.CENTER);
		panelSelectionRetour.add(panel2, BorderLayout.SOUTH);
		add(panelSelectionRetour);

		// Fond du panel
		// couleur : gris foncé
		panelSelectionRetour.setBackground(GrisFonce);
		panel3.setBackground(GrisFonce);
		panel2.setBackground(GrisFonce);

		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 250);
		setVisible(true);

	}

	/**
	 * On Choisit le trajet de l'aller
	 * 
	 * @param cleVilleArrive
	 * @param dateAller
	 * @param dateRetour
	 * @param cleLigneAller
	 * @param cleLigneRetour
	 * @param trajet
	 * @param trajetRetour
	 * @param jourDepart
	 * @param jourArrivee
	 * @param nbPersonneVoyage
	 * @param villeRetour
	 */
	public void choixAller(int cleVilleArrive, String dateAller, String dateRetour, int cleLigneAller,
			int cleLigneRetour, ArrayList<Trajet> trajet, ArrayList<Trajet> trajetRetour, String jourDepart,
			String jourArrivee, int nbPersonneVoyage, String villeRetour) {
		this.setCleVilleArrive(cleVilleArrive);
		this.setDateAller(dateAller);
		this.setDateRetour(dateRetour);
		this.setVilleRetour(villeRetour);
		this.setCleLigneAller(cleLigneAller);
		this.setCleLigneRetour(cleLigneRetour);
		this.trajet = trajet;
		this.trajetRetour = trajetRetour;
		this.jourDepart = jourDepart;
		this.jourArrivee = jourArrivee;
		this.setNbPersonneVoyage(nbPersonneVoyage);

		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color(0xCFBFAD);

		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 16);

		String[] classe = { "1ere classe", "2eme classe" };
		setChoixClasse(new JComboBox<>(classe));
		setBouttonNextChoixAller(new JButton("Next"));
		setBouttonAnnuler(new JButton("Annuler"));
		panelSelectionAller = new JPanel();
		panelSelectionAller.setLayout(new BoxLayout(panelSelectionAller, BoxLayout.PAGE_AXIS));
		setTableau(new JTable(new TableTrajetPrixTotal(trajet, nbPersonneVoyage)));
		getTableau().setPreferredScrollableViewportSize(new Dimension(500, 200));
		getTableau().setFillsViewportHeight(true);
		// Modification du HEADER du tableau
		JTableHeader header = getTableau().getTableHeader();
		header.setBackground(GrisFonce);
		header.setForeground(BlancPale);
		JScrollPane scrollPane = new JScrollPane(getTableau());

		JPanel panel3 = new JPanel();
		JLabel v = new JLabel("Choix de la classe");
		v.setFont(font_bouton);
		v.setForeground(BlancPale);
		panel3.add(v);
		panel3.add(getChoixClasse());
		JPanel panel2 = new JPanel();

		panel2.add(getBouttonNextChoixAller());
		getBouttonNextChoixAller().addActionListener(new TraitementReservation(this, this.connect));
		panel2.add(getBouttonAnnuler());
		getBouttonAnnuler().addActionListener(new TraitementReservation(this, this.connect));

		panelSelectionAller.add(scrollPane, BorderLayout.NORTH);
		panelSelectionAller.add(panel3, BorderLayout.CENTER);
		panelSelectionAller.add(panel2, BorderLayout.SOUTH);
		add(panelSelectionAller);

		// Fond du panel
		// couleur : gris foncé
		panelSelectionAller.setBackground(GrisFonce);
		panel3.setBackground(GrisFonce);
		panel2.setBackground(GrisFonce);

		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 250);
		setVisible(true);

	}

	@SuppressWarnings("unused")
	/**
	 * Formulaire pour pouvoir choisir l'hôtel
	 * 
	 * @param heureRetour
	 * @param classeRetour
	 * @param prixRetour
	 * @param hotel
	 */
	public void choixHotel(String heureRetour, String classeRetour, double prixRetour, ArrayList<HotelRestant> hotel) {
		this.setHeureRetour(heureRetour);
		this.setClasseRetour(classeRetour);
		this.setPrixRetour(prixRetour);
		setChoixHotel(new JComboBox<String>());
		if (hotel.size() != 0 || hotel != null) {
			this.setHotel(hotel);
			for (int i = 0; i < hotel.size(); i++) {
				getChoixHotel().addItem(
						hotel.get(i).getNom() + " " + hotel.get(i).getNbPlaceRestante() + " chambres restantes");
			}
			setBouttonNextChoixHotel(new JButton("Next"));
			setBouttonAnnuler(new JButton("Annuler"));

			Color GrisFonce = new Color(0x222222);
			Color BlancPale = new Color(0xCFBFAD);

			// Bordure blanche d'épaisseur 3
			Border border = new LineBorder(BlancPale, 3);
			// Regarder comment importer une police
			Font font_bouton = new Font("Roboto", Font.PLAIN, 24);

			// Fond transparent
			getBouttonAnnuler().setOpaque(false);
			getBouttonAnnuler().setContentAreaFilled(false);
			// Changement couleur bordure
			getBouttonAnnuler().setBorder(border);
			// Changement Police
			getBouttonAnnuler().setFont(font_bouton);
			// Changement couleur Police
			getBouttonAnnuler().setForeground(BlancPale);

			// Fond transparent
			getBouttonNextChoixHotel().setOpaque(false);
			getBouttonNextChoixHotel().setContentAreaFilled(false);
			// Changement couleur bordure
			getBouttonNextChoixHotel().setBorder(border);
			// Changement Police
			getBouttonNextChoixHotel().setFont(font_bouton);
			// Changement couleur Police
			getBouttonNextChoixHotel().setForeground(BlancPale);

			getBouttonNextChoixHotel().addActionListener(new TraitementReservation(this, this.connect));
			getBouttonAnnuler().addActionListener(new TraitementReservation(this, this.connect));

			panelChoixHotel = new JPanel();
			panelChoixHotel.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();

			JPanel panel3 = new JPanel(new FlowLayout());
			panel3.setLayout(new GridBagLayout());
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 0;
			c.gridy = 0;
			JLabel v = new JLabel("Choix de la l'hôtel");
			v.setFont(font_bouton);
			v.setForeground(BlancPale);
			// similaire à un margin-left : 25px;
			v.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
			panel3.add(v, c);

			c.fill = GridBagConstraints.BOTH;
			c.gridx = 1;
			c.gridy = 0;
			panel3.add(getChoixHotel(), c);

			c.fill = GridBagConstraints.BOTH;
			c.weightx = 0.25;
			c.weighty = 0.50;
			c.gridwidth = 2;
			c.gridx = 0;
			c.gridy = 0;
			panelChoixHotel.add(panel3, c);

			c.fill = GridBagConstraints.BOTH;
			c.weightx = 0.25;
			c.weighty = 0.15;
			c.gridwidth = 1;
			c.gridx = 0;
			c.gridy = 1;
			panelChoixHotel.add(getBouttonNextChoixHotel(), c);

			c.fill = GridBagConstraints.BOTH;
			c.weightx = 0.25;
			c.weighty = 0.15;
			c.gridwidth = 1;
			c.gridx = 1;
			c.gridy = 1;
			panelChoixHotel.add(getBouttonAnnuler(), c);

			// Fond du panel
			// couleur : gris foncé
			panel3.setBackground(GrisFonce);
			panelChoixHotel.setBackground(GrisFonce);

			add(panelChoixHotel);

			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(550, 250);
			setVisible(true);
		} else {
			Color GrisFonce = new Color(0x222222);
			Color BlancPale = new Color(0xCFBFAD);

			// Bordure blanche d'épaisseur 3
			Border border = new LineBorder(BlancPale, 3);
			// Regarder comment importer une police
			Font font_bouton = new Font("Roboto", Font.PLAIN, 24);

			// Fond transparent
			getBouttonAnnuler().setOpaque(false);
			getBouttonAnnuler().setContentAreaFilled(false);
			// Changement couleur bordure
			getBouttonAnnuler().setBorder(border);
			// Changement Police
			getBouttonAnnuler().setFont(font_bouton);
			// Changement couleur Police
			getBouttonAnnuler().setForeground(BlancPale);

			panelChoixHotel = new JPanel();
			panelChoixHotel.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();

			JPanel panel3 = new JPanel(new FlowLayout());
			panel3.setLayout(new GridBagLayout());
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 0;
			c.gridy = 0;
			JLabel v = new JLabel("Aucun hôtel disponible");
			v.setFont(font_bouton);
			v.setForeground(BlancPale);
			panel3.add(v, c);
			setBouttonAnnuler(new JButton("Annuler"));

			c.fill = GridBagConstraints.BOTH;
			c.weightx = 0.25;
			c.weighty = 0.50;
			c.gridwidth = 2;
			c.gridx = 0;
			c.gridy = 0;
			panelChoixHotel.add(panel3, c);

			c.fill = GridBagConstraints.BOTH;
			c.weightx = 0.25;
			c.weighty = 0.15;
			c.gridwidth = 1;
			c.gridx = 0;
			c.gridy = 1;
			panelChoixHotel.add(getBouttonAnnuler(), c);

			getBouttonAnnuler().addActionListener(new TraitementReservation(this, this.connect));

			// Fond du panel
			// couleur : gris foncé
			panel3.setBackground(GrisFonce);
			panelChoixHotel.setBackground(GrisFonce);

			add(panelChoixHotel);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(550, 250);
			setVisible(true);
		}
	}

	/**
	 * formulaire pour la sélection de la catégorie
	 * 
	 * @param idHotel
	 * @param categorie
	 */
	public void choixCategorie(int idHotel, ArrayList<Categorie> categorie) {

		setChoixCategorie(new JComboBox<String>());
		this.setIdHotel(idHotel);
		this.setCategorie(categorie);
		for (int i = 0; i < categorie.size(); i++) {
			getChoixCategorie().addItem(categorie.get(i).getNom() + " " + categorie.get(i).getPlace() + "places" + " "
					+ categorie.get(i).getPrix() + " euros");
		}

		setBouttonNextChoixCategorie(new JButton("Next"));
		setBouttonAnnuler(new JButton("Annuler"));

		getBouttonAnnuler().addActionListener(new TraitementReservation(this, this.connect));
		getBouttonNextChoixCategorie().addActionListener(new TraitementReservation(this, this.connect));

		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color(0xCFBFAD);

		// Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 24);

		// Fond transparent
		getBouttonAnnuler().setOpaque(false);
		getBouttonAnnuler().setContentAreaFilled(false);
		// Changement couleur bordure
		getBouttonAnnuler().setBorder(border);
		// Changement Police
		getBouttonAnnuler().setFont(font_bouton);
		// Changement couleur Police
		getBouttonAnnuler().setForeground(BlancPale);

		// Fond transparent
		getBouttonNextChoixCategorie().setOpaque(false);
		getBouttonNextChoixCategorie().setContentAreaFilled(false);
		// Changement couleur bordure
		getBouttonNextChoixCategorie().setBorder(border);
		// Changement Police
		getBouttonNextChoixCategorie().setFont(font_bouton);
		// Changement couleur Police
		getBouttonNextChoixCategorie().setForeground(BlancPale);

		panelChoixCategorie = new JPanel();
		panelChoixCategorie.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JPanel panel3 = new JPanel(new FlowLayout());
		panel3.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel v = new JLabel("Choix de la catégorie");
		v.setFont(font_bouton);
		v.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		v.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		panel3.add(v, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel3.add(getChoixCategorie(), c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		panelChoixCategorie.add(panel3, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 1;
		panelChoixCategorie.add(getBouttonNextChoixCategorie(), c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 1;
		panelChoixCategorie.add(getBouttonAnnuler(), c);

		// Fond du panel
		// couleur : gris foncé
		panel3.setBackground(GrisFonce);
		panelChoixCategorie.setBackground(GrisFonce);

		add(panelChoixCategorie);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(550, 250);
		setVisible(true);
	}

	/**
	 * Formulaire pour le choix de la chambre
	 * 
	 * @param idCategorie
	 * @param chambre
	 */
	public void choixChambre(int idCategorie, ArrayList<Chambre> chambre) {
		setChoixChambre(new JComboBox<String>());
		this.setIdCategorie(idCategorie);
		this.setChambre(chambre);
		for (int i = 0; i < chambre.size(); i++) {
			getChoixChambre().addItem(chambre.get(i).getDenomination());
		}

		setBouttonNextChoixChambre(new JButton("Next"));
		setBouttonAnnuler(new JButton("Annuler"));

		getBouttonNextChoixChambre().addActionListener(new TraitementReservation(this, this.connect));
		getBouttonAnnuler().addActionListener(new TraitementReservation(this, this.connect));

		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color(0xCFBFAD);

		// Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 24);
		setBouttonValider(new JButton("Valider"));
		setBouttonAnnuler(new JButton("Annuler"));
		getBouttonValider().addActionListener(new TraitementReservation(this, this.connect));
		getBouttonAnnuler().addActionListener(new TraitementReservation(this, this.connect));

		// Fond transparent
		getBouttonAnnuler().setOpaque(false);
		getBouttonAnnuler().setContentAreaFilled(false);
		// Changement couleur bordure
		getBouttonAnnuler().setBorder(border);
		// Changement Police
		getBouttonAnnuler().setFont(font_bouton);
		// Changement couleur Police
		getBouttonAnnuler().setForeground(BlancPale);

		// Fond transparent
		getBouttonNextChoixChambre().setOpaque(false);
		getBouttonNextChoixChambre().setContentAreaFilled(false);
		// Changement couleur bordure
		getBouttonNextChoixChambre().setBorder(border);
		// Changement Police
		getBouttonNextChoixChambre().setFont(font_bouton);
		// Changement couleur Police
		getBouttonNextChoixChambre().setForeground(BlancPale);

		panelChoixChambre = new JPanel();
		panelChoixChambre.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JPanel panel3 = new JPanel(new FlowLayout());
		panel3.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel v = new JLabel("Choix de la chambre");
		v.setFont(font_bouton);
		v.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		v.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		panel3.add(v, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel3.add(getChoixChambre(), c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		panelChoixChambre.add(panel3, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 1;
		panelChoixChambre.add(getBouttonNextChoixChambre(), c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 1;
		panelChoixChambre.add(getBouttonAnnuler(), c);

		// Fond du panel
		// couleur : gris foncé
		panel3.setBackground(GrisFonce);
		panelChoixChambre.setBackground(GrisFonce);

		add(panelChoixChambre);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(550, 250);
		setVisible(true);
	}

	/**
	 * Dernière fenêtre de la réservation On trouve un résumé de la réservation
	 * avant de la valider
	 * 
	 * @param cleChambre
	 * @param reservation
	 */
	public void recapilutatif(int cleChambre, Reservation reservation) {
		this.setCleChambre(cleChambre);
		this.setReservation(reservation);
		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color(0xCFBFAD);

		// Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 24);
		setBouttonValider(new JButton("Valider"));
		setBouttonAnnuler(new JButton("Annuler"));
		getBouttonValider().addActionListener(new TraitementReservation(this, this.connect));
		getBouttonAnnuler().addActionListener(new TraitementReservation(this, this.connect));

		// Fond transparent
		getBouttonAnnuler().setOpaque(false);
		getBouttonAnnuler().setContentAreaFilled(false);
		// Changement couleur bordure
		getBouttonAnnuler().setBorder(border);
		// Changement Police
		getBouttonAnnuler().setFont(font_bouton);
		// Changement couleur Police
		getBouttonAnnuler().setForeground(BlancPale);

		// Fond transparent
		getBouttonValider().setOpaque(false);
		getBouttonValider().setContentAreaFilled(false);
		// Changement couleur bordure
		getBouttonValider().setBorder(border);
		// Changement Police
		getBouttonValider().setFont(font_bouton);
		// Changement couleur Police
		getBouttonValider().setForeground(BlancPale);

		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JPanel panel3 = new JPanel(new FlowLayout());
		panel3.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel GJLVilleAller = new JLabel("Ville Aller ");
		GJLVilleAller.setFont(font_bouton);
		GJLVilleAller.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		GJLVilleAller.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		panel3.add(GJLVilleAller, c);

		c.fill = GridBagConstraints.BOTH;
		JLabel DJLVilleAller = new JLabel("" + reservation.getVilleAller().getNom());
		DJLVilleAller.setFont(font_bouton);
		DJLVilleAller.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		DJLVilleAller.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		c.gridx = 1;
		c.gridy = 0;
		panel3.add(DJLVilleAller, c);

		JPanel panel4 = new JPanel(new FlowLayout());
		panel4.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel GJLVilleRetour = new JLabel("Ville Retour");
		GJLVilleRetour.setFont(font_bouton);
		GJLVilleRetour.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		GJLVilleRetour.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		panel4.add(GJLVilleRetour, c);

		c.fill = GridBagConstraints.BOTH;
		JLabel DJLVilleRetour = new JLabel("" + reservation.getVilleRetour().getNom());
		DJLVilleRetour.setFont(font_bouton);
		DJLVilleRetour.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		DJLVilleRetour.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		c.gridx = 1;
		c.gridy = 0;
		panel4.add(DJLVilleRetour, c);

		JPanel panel5 = new JPanel(new FlowLayout());
		panel5.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel GJLDateAller = new JLabel("Date Aller");
		GJLDateAller.setFont(font_bouton);
		GJLDateAller.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		GJLDateAller.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		panel5.add(GJLDateAller, c);

		c.fill = GridBagConstraints.BOTH;
		JLabel DJLDateAller = new JLabel("" + reservation.getDateAller());
		DJLDateAller.setFont(font_bouton);
		DJLDateAller.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		DJLDateAller.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		c.gridx = 1;
		c.gridy = 0;
		panel5.add(DJLDateAller, c);

		JPanel panel6 = new JPanel(new FlowLayout());
		panel6.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel GJLDateRetour = new JLabel("Date Retour");
		GJLDateRetour.setFont(font_bouton);
		GJLDateRetour.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		GJLDateRetour.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		panel6.add(GJLDateRetour, c);

		c.fill = GridBagConstraints.BOTH;
		JLabel DJLDateRetour = new JLabel("" + reservation.getDateRetour());
		DJLDateRetour.setFont(font_bouton);
		DJLDateRetour.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		DJLDateRetour.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		c.gridx = 1;
		c.gridy = 0;
		panel6.add(DJLDateRetour, c);

		JPanel panel7 = new JPanel(new FlowLayout());
		panel7.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel GJLPrixTransport = new JLabel("Prix Transport");
		GJLPrixTransport.setFont(font_bouton);
		GJLPrixTransport.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		GJLPrixTransport.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		panel7.add(GJLPrixTransport, c);

		c.fill = GridBagConstraints.BOTH;
		JLabel DJLPrixTransport = new JLabel("" + reservation.getPrixTransport());
		DJLPrixTransport.setFont(font_bouton);
		DJLPrixTransport.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		DJLPrixTransport.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		c.gridx = 1;
		c.gridy = 0;
		panel7.add(DJLPrixTransport, c);

		JPanel panel8 = new JPanel(new FlowLayout());
		panel8.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel GJLNbPersonnes = new JLabel("Nombre de personnes");
		GJLNbPersonnes.setFont(font_bouton);
		GJLNbPersonnes.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		GJLNbPersonnes.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		panel8.add(GJLNbPersonnes, c);

		c.fill = GridBagConstraints.BOTH;
		JLabel DJLNbPersonnes = new JLabel("" + reservation.getNbPersonne());
		DJLNbPersonnes.setFont(font_bouton);
		DJLNbPersonnes.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		DJLNbPersonnes.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		c.gridx = 1;
		c.gridy = 0;
		panel8.add(DJLNbPersonnes, c);

		JPanel panel9 = new JPanel(new FlowLayout());
		panel9.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel GJLHotel = new JLabel("Hotel");
		GJLHotel.setFont(font_bouton);
		GJLHotel.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		GJLHotel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		panel9.add(GJLHotel, c);

		c.fill = GridBagConstraints.BOTH;
		JLabel DJLHotel = new JLabel("" + reservation.getHotel().getNom());
		DJLHotel.setFont(font_bouton);
		DJLHotel.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		DJLHotel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		c.gridx = 1;
		c.gridy = 0;
		panel9.add(DJLHotel, c);

		JPanel panel10 = new JPanel(new FlowLayout());
		panel10.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel GJLCategorie = new JLabel("Catégorie");
		GJLCategorie.setFont(font_bouton);
		GJLCategorie.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		GJLCategorie.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		panel10.add(GJLHotel, c);

		c.fill = GridBagConstraints.BOTH;
		JLabel DJLCategorie = new JLabel("" + reservation.getCategorie().getNom());
		DJLCategorie.setFont(font_bouton);
		DJLCategorie.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		DJLCategorie.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		c.gridx = 1;
		c.gridy = 0;
		panel10.add(DJLCategorie, c);

		JPanel panel11 = new JPanel(new FlowLayout());
		panel11.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel GJLChambre = new JLabel("Chambre");
		GJLChambre.setFont(font_bouton);
		GJLChambre.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		GJLChambre.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		panel11.add(GJLChambre, c);

		c.fill = GridBagConstraints.BOTH;
		JLabel DJLChambre = new JLabel("" + reservation.getChambre().getDenomination());
		DJLChambre.setFont(font_bouton);
		DJLChambre.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		DJLChambre.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		c.gridx = 1;
		c.gridy = 0;
		panel11.add(DJLChambre, c);

		JPanel panel12 = new JPanel(new FlowLayout());
		panel12.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel GJLNbNuits = new JLabel("Nombre de nuits");
		GJLNbNuits.setFont(font_bouton);
		GJLNbNuits.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		GJLNbNuits.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		panel12.add(GJLNbNuits, c);

		c.fill = GridBagConstraints.BOTH;
		JLabel DJLNbNuits = new JLabel("" + reservation.getNbDeNuit());
		DJLNbNuits.setFont(font_bouton);
		DJLNbNuits.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		DJLNbNuits.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		c.gridx = 1;
		c.gridy = 0;
		panel12.add(DJLNbNuits, c);

		JPanel panel13 = new JPanel(new FlowLayout());
		panel13.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel GJLPrixHotel = new JLabel("Prix Hotel");
		GJLPrixHotel.setFont(font_bouton);
		GJLPrixHotel.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		GJLPrixHotel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		panel13.add(GJLPrixHotel, c);

		c.fill = GridBagConstraints.BOTH;
		JLabel DJLPrixHotel = new JLabel("" + reservation.getPrixHotel());
		DJLPrixHotel.setFont(font_bouton);
		DJLPrixHotel.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		DJLPrixHotel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		c.gridx = 1;
		c.gridy = 0;
		panel13.add(DJLPrixHotel, c);

		JPanel panel14 = new JPanel(new FlowLayout());
		panel14.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel GJLPrixTotal = new JLabel("Prix total");
		GJLPrixTotal.setFont(font_bouton);
		GJLPrixTotal.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		GJLPrixTotal.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		panel14.add(GJLPrixTotal, c);

		c.fill = GridBagConstraints.BOTH;
		JLabel DJLPrixTotal = new JLabel("" + reservation.getPrixTotal());
		DJLPrixTotal.setFont(font_bouton);
		DJLPrixTotal.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		DJLPrixTotal.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		c.gridx = 1;
		c.gridy = 0;
		panel14.add(DJLPrixTotal, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(panel3, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(panel4, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(panel5, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 3;
		panel.add(panel6, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 4;
		panel.add(panel7, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 5;
		panel.add(panel8, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 6;
		panel.add(panel9, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 7;
		panel.add(panel10, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 8;
		panel.add(panel11, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 9;
		panel.add(panel12, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 10;
		panel.add(panel13, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 11;
		panel.add(panel14, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 12;
		panel.add(getBouttonValider(), c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 12;
		panel.add(getBouttonAnnuler(), c);

		// Fond du panel
		// couleur : gris foncé

		panel3.setBackground(GrisFonce);
		panel4.setBackground(GrisFonce);
		panel5.setBackground(GrisFonce);
		panel6.setBackground(GrisFonce);
		panel7.setBackground(GrisFonce);
		panel8.setBackground(GrisFonce);
		panel9.setBackground(GrisFonce);
		panel10.setBackground(GrisFonce);
		panel11.setBackground(GrisFonce);
		panel12.setBackground(GrisFonce);
		panel13.setBackground(GrisFonce);
		panel14.setBackground(GrisFonce);
		panel.setBackground(GrisFonce);

		this.getContentPane().add(panel);
		setSize(800, 600);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * @return the bouttonNextClient
	 */
	public JButton getBouttonNextClient() {
		return bouttonNextClient;
	}

	/**
	 * @param bouttonNextClient
	 *            the bouttonNextClient to set
	 */
	public void setBouttonNextClient(JButton bouttonNextClient) {
		this.bouttonNextClient = bouttonNextClient;
	}

	/**
	 * @return the nom
	 */
	public JTextField getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(JTextField nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public JTextField getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(JTextField prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the date
	 */
	public JTextField getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(JTextField date) {
		this.date = date;
	}

	/**
	 * @return the bouttonAnnuler
	 */
	public JButton getBouttonAnnuler() {
		return bouttonAnnuler;
	}

	/**
	 * @param bouttonAnnuler
	 *            the bouttonAnnuler to set
	 */
	public void setBouttonAnnuler(JButton bouttonAnnuler) {
		this.bouttonAnnuler = bouttonAnnuler;
	}

	/**
	 * @return the bouttonNextChoixDate
	 */
	public JButton getBouttonNextChoixDate() {
		return bouttonNextChoixDate;
	}

	/**
	 * @param bouttonNextChoixDate
	 *            the bouttonNextChoixDate to set
	 */
	public void setBouttonNextChoixDate(JButton bouttonNextChoixDate) {
		this.bouttonNextChoixDate = bouttonNextChoixDate;
	}

	/**
	 * @return the dateArrive
	 */
	public JTextField getDateArrive() {
		return dateArrive;
	}

	/**
	 * @param dateArrive
	 *            the dateArrive to set
	 */
	public void setDateArrive(JTextField dateArrive) {
		this.dateArrive = dateArrive;
	}

	/**
	 * @return the dateDepart
	 */
	public JTextField getDateDepart() {
		return dateDepart;
	}

	/**
	 * @param dateDepart
	 *            the dateDepart to set
	 */
	public void setDateDepart(JTextField dateDepart) {
		this.dateDepart = dateDepart;
	}

	/**
	 * @return the villeDepart
	 */
	public Ville getVilleDepart() {
		return VilleDepart;
	}

	/**
	 * @param villeDepart
	 *            the villeDepart to set
	 */
	public void setVilleDepart(Ville villeDepart) {
		VilleDepart = villeDepart;
	}

	/**
	 * @return the choixVille
	 */
	public JComboBox<String> getChoixVille() {
		return choixVille;
	}

	/**
	 * @param choixVille
	 *            the choixVille to set
	 */
	public void setChoixVille(JComboBox<String> choixVille) {
		this.choixVille = choixVille;
	}

	/**
	 * @return the nbPersonne
	 */
	public JTextField getNbPersonne() {
		return nbPersonne;
	}

	/**
	 * @param nbPersonne
	 *            the nbPersonne to set
	 */
	public void setNbPersonne(JTextField nbPersonne) {
		this.nbPersonne = nbPersonne;
	}

	/**
	 * @return the bouttonNextChoixAller
	 */
	public JButton getBouttonNextChoixAller() {
		return bouttonNextChoixAller;
	}

	/**
	 * @param bouttonNextChoixAller
	 *            the bouttonNextChoixAller to set
	 */
	public void setBouttonNextChoixAller(JButton bouttonNextChoixAller) {
		this.bouttonNextChoixAller = bouttonNextChoixAller;
	}

	/**
	 * @return the choixClasse
	 */
	public JComboBox<String> getChoixClasse() {
		return choixClasse;
	}

	/**
	 * @param choixClasse
	 *            the choixClasse to set
	 */
	public void setChoixClasse(JComboBox<String> choixClasse) {
		this.choixClasse = choixClasse;
	}

	/**
	 * @return the tableau
	 */
	public JTable getTableau() {
		return tableau;
	}

	/**
	 * @param tableau
	 *            the tableau to set
	 */
	public void setTableau(JTable tableau) {
		this.tableau = tableau;
	}

	/**
	 * @return the bouttonNextChoixRetour
	 */
	public JButton getBouttonNextChoixRetour() {
		return bouttonNextChoixRetour;
	}

	/**
	 * @param bouttonNextChoixRetour
	 *            the bouttonNextChoixRetour to set
	 */
	public void setBouttonNextChoixRetour(JButton bouttonNextChoixRetour) {
		this.bouttonNextChoixRetour = bouttonNextChoixRetour;
	}

	/**
	 * @return the bouttonNextChoixHotel
	 */
	public JButton getBouttonNextChoixHotel() {
		return bouttonNextChoixHotel;
	}

	/**
	 * @param bouttonNextChoixHotel
	 *            the bouttonNextChoixHotel to set
	 */
	public void setBouttonNextChoixHotel(JButton bouttonNextChoixHotel) {
		this.bouttonNextChoixHotel = bouttonNextChoixHotel;
	}

	/**
	 * @return the cleVilleArrive
	 */
	public int getCleVilleArrive() {
		return cleVilleArrive;
	}

	/**
	 * @param cleVilleArrive
	 *            the cleVilleArrive to set
	 */
	public void setCleVilleArrive(int cleVilleArrive) {
		this.cleVilleArrive = cleVilleArrive;
	}

	/**
	 * @return the hotel
	 */
	public ArrayList<HotelRestant> getHotel() {
		return hotel;
	}

	/**
	 * @param hotel
	 *            the hotel to set
	 */
	public void setHotel(ArrayList<HotelRestant> hotel) {
		this.hotel = hotel;
	}

	/**
	 * @return the choixHotel
	 */
	public JComboBox<String> getChoixHotel() {
		return choixHotel;
	}

	/**
	 * @param choixHotel
	 *            the choixHotel to set
	 */
	public void setChoixHotel(JComboBox<String> choixHotel) {
		this.choixHotel = choixHotel;
	}

	/**
	 * @return the nbPersonneVoyage
	 */
	public int getNbPersonneVoyage() {
		return nbPersonneVoyage;
	}

	/**
	 * @param nbPersonneVoyage
	 *            the nbPersonneVoyage to set
	 */
	public void setNbPersonneVoyage(int nbPersonneVoyage) {
		this.nbPersonneVoyage = nbPersonneVoyage;
	}

	/**
	 * @return the bouttonNextChoixCategorie
	 */
	public JButton getBouttonNextChoixCategorie() {
		return bouttonNextChoixCategorie;
	}

	/**
	 * @param bouttonNextChoixCategorie
	 *            the bouttonNextChoixCategorie to set
	 */
	public void setBouttonNextChoixCategorie(JButton bouttonNextChoixCategorie) {
		this.bouttonNextChoixCategorie = bouttonNextChoixCategorie;
	}

	/**
	 * @return the categorie
	 */
	public ArrayList<Categorie> getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie
	 *            the categorie to set
	 */
	public void setCategorie(ArrayList<Categorie> categorie) {
		this.categorie = categorie;
	}

	/**
	 * @return the bouttonNextChoixChambre
	 */
	public JButton getBouttonNextChoixChambre() {
		return bouttonNextChoixChambre;
	}

	/**
	 * @param bouttonNextChoixChambre
	 *            the bouttonNextChoixChambre to set
	 */
	public void setBouttonNextChoixChambre(JButton bouttonNextChoixChambre) {
		this.bouttonNextChoixChambre = bouttonNextChoixChambre;
	}

	/**
	 * @return the chambre
	 */
	public ArrayList<Chambre> getChambre() {
		return chambre;
	}

	/**
	 * @param chambre
	 *            the chambre to set
	 */
	public void setChambre(ArrayList<Chambre> chambre) {
		this.chambre = chambre;
	}

	/**
	 * @return the dateAller
	 */
	public String getDateAller() {
		return dateAller;
	}

	/**
	 * @param dateAller
	 *            the dateAller to set
	 */
	public void setDateAller(String dateAller) {
		this.dateAller = dateAller;
	}

	/**
	 * @return the bouttonValider
	 */
	public JButton getBouttonValider() {
		return bouttonValider;
	}

	/**
	 * @param bouttonValider
	 *            the bouttonValider to set
	 */
	public void setBouttonValider(JButton bouttonValider) {
		this.bouttonValider = bouttonValider;
	}

	/**
	 * @return the cleClient
	 */
	public int getCleClient() {
		return cleClient;
	}

	/**
	 * @param cleClient
	 *            the cleClient to set
	 */
	public void setCleClient(int cleClient) {
		this.cleClient = cleClient;
	}

	/**
	 * @return the cleLigneAller
	 */
	public int getCleLigneAller() {
		return cleLigneAller;
	}

	/**
	 * @param cleLigneAller
	 *            the cleLigneAller to set
	 */
	public void setCleLigneAller(int cleLigneAller) {
		this.cleLigneAller = cleLigneAller;
	}

	/**
	 * @return the classeAller
	 */
	public String getClasseAller() {
		return classeAller;
	}

	/**
	 * @param classeAller
	 *            the classeAller to set
	 */
	public void setClasseAller(String classeAller) {
		this.classeAller = classeAller;
	}

	/**
	 * @return the dateRetour
	 */
	public String getDateRetour() {
		return dateRetour;
	}

	/**
	 * @param dateRetour
	 *            the dateRetour to set
	 */
	public void setDateRetour(String dateRetour) {
		this.dateRetour = dateRetour;
	}

	/**
	 * @return the villeRetour
	 */
	public String getVilleRetour() {
		return villeRetour;
	}

	/**
	 * @param villeRetour
	 *            the villeRetour to set
	 */
	public void setVilleRetour(String villeRetour) {
		this.villeRetour = villeRetour;
	}

	/**
	 * @return the heureRetour
	 */
	public String getHeureRetour() {
		return heureRetour;
	}

	/**
	 * @param heureRetour
	 *            the heureRetour to set
	 */
	public void setHeureRetour(String heureRetour) {
		this.heureRetour = heureRetour;
	}

	/**
	 * @return the heureAller
	 */
	public String getHeureAller() {
		return heureAller;
	}

	/**
	 * @param heureAller
	 *            the heureAller to set
	 */
	public void setHeureAller(String heureAller) {
		this.heureAller = heureAller;
	}

	/**
	 * @return the cleVilleDepart
	 */
	public int getCleVilleDepart() {
		return cleVilleDepart;
	}

	/**
	 * @param cleVilleDepart
	 *            the cleVilleDepart to set
	 */
	public void setCleVilleDepart(int cleVilleDepart) {
		this.cleVilleDepart = cleVilleDepart;
	}

	/**
	 * @return the choixChambre
	 */
	public JComboBox<String> getChoixChambre() {
		return choixChambre;
	}

	/**
	 * @param choixChambre
	 *            the choixChambre to set
	 */
	public void setChoixChambre(JComboBox<String> choixChambre) {
		this.choixChambre = choixChambre;
	}

	/**
	 * @return the idCategorie
	 */
	public int getIdCategorie() {
		return idCategorie;
	}

	/**
	 * @param idCategorie
	 *            the idCategorie to set
	 */
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	/**
	 * @return the reservation
	 */
	public Reservation getReservation() {
		return reservation;
	}

	/**
	 * @param reservation
	 *            the reservation to set
	 */
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	/**
	 * @return the cleChambre
	 */
	public int getCleChambre() {
		return cleChambre;
	}

	/**
	 * @param cleChambre
	 *            the cleChambre to set
	 */
	public void setCleChambre(int cleChambre) {
		this.cleChambre = cleChambre;
	}

	/**
	 * @return the choixCategorie
	 */
	public JComboBox<String> getChoixCategorie() {
		return choixCategorie;
	}

	/**
	 * @param choixCategorie
	 *            the choixCategorie to set
	 */
	public void setChoixCategorie(JComboBox<String> choixCategorie) {
		this.choixCategorie = choixCategorie;
	}

	/**
	 * @return the idHotel
	 */
	public int getIdHotel() {
		return idHotel;
	}

	/**
	 * @param idHotel
	 *            the idHotel to set
	 */
	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	/**
	 * @return the prixRetour
	 */
	public Double getPrixRetour() {
		return prixRetour;
	}

	/**
	 * @param prixRetour
	 *            the prixRetour to set
	 */
	public void setPrixRetour(Double prixRetour) {
		this.prixRetour = prixRetour;
	}

	/**
	 * @return the prixAller
	 */
	public Double getPrixAller() {
		return prixAller;
	}

	/**
	 * @param prixAller
	 *            the prixAller to set
	 */
	public void setPrixAller(Double prixAller) {
		this.prixAller = prixAller;
	}

	/**
	 * @return the cleLigneRetour
	 */
	public int getCleLigneRetour() {
		return cleLigneRetour;
	}

	/**
	 * @param cleLigneRetour
	 *            the cleLigneRetour to set
	 */
	public void setCleLigneRetour(int cleLigneRetour) {
		this.cleLigneRetour = cleLigneRetour;
	}

	/**
	 * @return the classeRetour
	 */
	public String getClasseRetour() {
		return classeRetour;
	}

	/**
	 * @param classeRetour
	 *            the classeRetour to set
	 */
	public void setClasseRetour(String classeRetour) {
		this.classeRetour = classeRetour;
	}
}
