import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.AbstractButton;
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


public class FenetreGestionReservation extends JFrame{

	Connect connect;
	JTextField nom,prenom,date,villeDepart,dateDepart, dateArrive, nbPersonne;
	JButton bouttonValider,bouttonNextChoixChambre,bouttonNextClient,bouttonAnnuler,bouttonNextChoixDate,bouttonNextChoixAller,bouttonNextChoixRetour,bouttonNextChoixHotel,bouttonNextChoixCategorie;
	JPanel panel,panelChoixChambre,panelSelectionClient,panelSelectionDate,panelSelectionAller,panelSelectionRetour,panelChoixHotel,panelChoixCategorie;
	int cleChambre,cleClient,cleVilleDepart,cleLigneAller,cleLigneRetour,nbPersonneVoyage,cleVilleArrive,idHotel,idCategorie;
	Ville VilleDepart;
	ArrayList<Ligne> ligne;
	ArrayList<HotelRestant> hotel;
	ArrayList<Categorie> categorie;
	JComboBox<String> choixVille,choixClasse,choixHotel,choixCategorie,choixChambre;
	ArrayList<Trajet> trajet,trajetRetour;
	String jourDepart,jourArrivee, heureAller,classeAller, heureRetour,classeRetour, villeRetour,dateAller,dateRetour;
	JTable tableau;
	Double prixAller, prixRetour;
	ArrayList<Chambre> chambre;
	Reservation reservation;
	


	public FenetreGestionReservation(Connect connect) {
		super("gestion reservation");
		this.connect = connect;
		this.choixClient();
		VilleDepart=null;
	}

	public void choixClient(){
		nom = new JTextField();
		prenom = new JTextField();
		date = new JTextField();


		bouttonNextClient = new JButton("Next");
		bouttonAnnuler = new JButton("Annuler");

		bouttonNextClient.addActionListener(new TraitementReservation(this,this.connect));
		bouttonAnnuler.addActionListener(new TraitementReservation(this,this.connect));

		nom.setPreferredSize(new Dimension(250,30));
		prenom.setPreferredSize(new Dimension(250,30));
		date.setPreferredSize(new Dimension(250,30));

		panelSelectionClient = new JPanel();
		panelSelectionClient.setLayout(new BoxLayout(panelSelectionClient, BoxLayout.Y_AXIS));


		JPanel panel = new JPanel(new FlowLayout());
		JPanel panel1 = new JPanel(new FlowLayout());
		JPanel panel3 = new JPanel(new FlowLayout());

		JPanel panel6 = new JPanel(new BorderLayout());

		panel.add(new JLabel("nom"));
		panel.add(nom);
		panel1.add(new JLabel("prenom"));
		panel1.add(prenom);
		panel3.add(new JLabel("Date de naissance"));
		panel3.add(date);
		panel6.add(panel,BorderLayout.NORTH);
		panel6.add(panel1,BorderLayout.CENTER);
		panel6.add(panel3,BorderLayout.SOUTH);

		JPanel panel8 = new JPanel(new BorderLayout());
		panel8.add(panel6,BorderLayout.NORTH);


		JPanel panel7 = new JPanel();
		panel7.add(bouttonNextClient);
		panel7.add(bouttonAnnuler);

		panelSelectionClient.add(panel8, BorderLayout.NORTH);
		panelSelectionClient.add(panel7, BorderLayout.SOUTH);


		this.getContentPane().add(panelSelectionClient);
		setSize(500,300);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void cleartSelectionClient(){
		panelSelectionClient.hide();
	}

	public void clearChoixDate(){
		panelSelectionDate.hide();
	}

	public void clearChoixAller(){
		panelSelectionAller.hide();
	}

	public void clearChoixRetour(){
		panelSelectionRetour.hide();
	}
	public void clearChoixHotel(){
		panelChoixHotel.hide();
	}
	public void clearChoixCategorie(){
		panelChoixCategorie.hide();
	}
	public void clearChoixChambre(){
		panelChoixChambre.hide();
	}

	public void clearRecapitulatif(){
		panel.hide();
	}


	public void choixVilleDate(int cleClient, int cleVilleDepart, Ville VilleDepart, ArrayList<Ligne> ligne){
		this.cleClient=cleClient;
		this.cleVilleDepart=cleVilleDepart;
		this.VilleDepart=VilleDepart;
		this.ligne=ligne;
		choixVille = new JComboBox<>();
		for(int i =0;i<ligne.size();i++){
			choixVille.addItem(ligne.get(i).getVilleRetour().getNom());
		};

		bouttonNextChoixDate = new JButton("next");
		bouttonAnnuler = new JButton("Annuler");

		bouttonNextChoixDate.addActionListener(new TraitementReservation(this,this.connect));
		bouttonAnnuler.addActionListener(new TraitementReservation(this,this.connect));




		panelSelectionDate = new JPanel();
		panelSelectionDate.setLayout(new BoxLayout(panelSelectionDate, BoxLayout.Y_AXIS));



		JPanel panel3 = new JPanel(new FlowLayout());
		JPanel panel1= new JPanel(new FlowLayout());
		JPanel panel2 = new JPanel(new FlowLayout());
		dateDepart= new JTextField();
		dateArrive= new JTextField();
		nbPersonne = new JTextField();
		villeDepart = new JTextField();
		dateDepart.setPreferredSize(new Dimension(250,30));
		dateArrive.setPreferredSize(new Dimension(250,30));
		nbPersonne.setPreferredSize(new Dimension(250,30));
		villeDepart.setPreferredSize(new Dimension(250,30));
		villeDepart.setText(VilleDepart.getNom());

		panel3.add(new JLabel("choix de la ville"));
		panel3.add(choixVille);
		panel1.add(new JLabel("ville de depart"));

		panel1.add(villeDepart);

		panel2.add(new JLabel("choix date depart"));
		panel2.add(dateDepart);
		JPanel panel5 = new JPanel(new BorderLayout());
		panel5.add(panel1,BorderLayout.NORTH);
		panel5.add(panel3,BorderLayout.CENTER);
		panel5.add(panel2,BorderLayout.SOUTH);

		JPanel panel4 = new JPanel(new FlowLayout());
		JPanel panel6= new JPanel(new FlowLayout());
		panel4.add(new JLabel("choix date retour"));

		panel4.add(dateArrive);
		panel6.add(new JLabel("nombre de personne"));
		panel6.add(nbPersonne);
		JPanel panel8 = new JPanel(new BorderLayout());
		panel8.add(panel4,BorderLayout.NORTH);
		panel8.add(panel6,BorderLayout.CENTER);

		JPanel panel9 = new JPanel(new BorderLayout());
		panel9.add(panel5,BorderLayout.NORTH);
		panel9.add(panel8,BorderLayout.CENTER);




		JPanel panel7 = new JPanel();
		panel7.add(bouttonNextChoixDate);
		panel7.add(bouttonAnnuler);

		panelSelectionDate.add(panel9, BorderLayout.NORTH);
		panelSelectionDate.add(panel7, BorderLayout.SOUTH);


		this.getContentPane().add(panelSelectionDate);
		setSize(500,300);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public void choixRetour(String heureAller, String classeAller,
			double prixAller) {
		this.heureAller=heureAller;
		this.classeAller=classeAller;
		this.prixAller=prixAller;

		String [] classe = {"1ere classe" , "2eme classe"};
		choixClasse = new JComboBox<>(classe);
		bouttonNextChoixRetour = new JButton("Next");
		bouttonAnnuler = new JButton("Annuler");
		panelSelectionRetour = new JPanel();
		panelSelectionRetour.setLayout(new BoxLayout(panelSelectionRetour,BoxLayout.PAGE_AXIS));

		tableau = new JTable(new TableTrajetPrixTotal(trajetRetour,nbPersonneVoyage));
		tableau.setPreferredScrollableViewportSize(new Dimension(500, 200));
		tableau.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(tableau);

		JPanel panel3 = new JPanel();
		panel3.add(new JLabel("choix de la classe"));
		panel3.add(choixClasse);
		JPanel panel2 = new JPanel();

		panel2.add(bouttonNextChoixRetour);
		bouttonNextChoixRetour.addActionListener(new TraitementReservation(this,this.connect));
		panel2.add(bouttonAnnuler);
		bouttonAnnuler.addActionListener(new TraitementReservation(this,this.connect));

		panelSelectionRetour.add(scrollPane, BorderLayout.NORTH);
		panelSelectionRetour.add(panel3, BorderLayout.CENTER);
		panelSelectionRetour.add(panel2, BorderLayout.SOUTH);
		add(panelSelectionRetour);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(550, 250);
		setVisible(true);




	}

	public void choixAller(int cleVilleArrive,String dateAller, String dateRetour,int cleLigneAller,int cleLigneRetour, ArrayList<Trajet> trajet,
			ArrayList<Trajet> trajetRetour, String jourDepart, String jourArrivee, int nbPersonneVoyage, String villeRetour) {
		this.cleVilleArrive=cleVilleArrive;
		this.dateAller=dateAller;
		this.dateRetour=dateRetour;
		this.villeRetour=villeRetour;
		this.cleLigneAller=cleLigneAller;
		this.cleLigneRetour=cleLigneRetour;
		this.trajet=trajet;
		this.trajetRetour=trajetRetour;
		this.jourDepart=jourDepart;
		this.jourArrivee=jourArrivee;
		this.nbPersonneVoyage=nbPersonneVoyage;

		String [] classe = {"1ere classe" , "2eme classe"};
		choixClasse = new JComboBox<>(classe);
		bouttonNextChoixAller = new JButton("Next");
		bouttonAnnuler = new JButton("Annuler");
		panelSelectionAller = new JPanel();
		panelSelectionAller.setLayout(new BoxLayout(panelSelectionAller,BoxLayout.PAGE_AXIS));
		tableau = new JTable(new TableTrajetPrixTotal(trajet,nbPersonneVoyage));
		tableau.setPreferredScrollableViewportSize(new Dimension(500, 200));
		tableau.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(tableau);

		JPanel panel3 = new JPanel();
		panel3.add(new JLabel("choix de la classe"));
		panel3.add(choixClasse);
		JPanel panel2 = new JPanel();

		panel2.add(bouttonNextChoixAller);
		bouttonNextChoixAller.addActionListener(new TraitementReservation(this,this.connect));
		panel2.add(bouttonAnnuler);
		bouttonAnnuler.addActionListener(new TraitementReservation(this,this.connect));

		panelSelectionAller.add(scrollPane, BorderLayout.NORTH);
		panelSelectionAller.add(panel3, BorderLayout.CENTER);
		panelSelectionAller.add(panel2, BorderLayout.SOUTH);
		add(panelSelectionAller);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(550, 250);
		setVisible(true);




	}


	@SuppressWarnings("unused")
	public void choixHotel(String heureRetour,String classeRetour,double prixRetour, ArrayList<HotelRestant> hotel){
		this.heureRetour=heureRetour;
		this.classeRetour=classeRetour;
		this.prixRetour=prixRetour;
		choixHotel = new JComboBox<String>();
		if(hotel.size()!=0 || hotel!=null){
			this.hotel=hotel;
			for(int i =0;i<hotel.size();i++){
				choixHotel.addItem(hotel.get(i).getNom()+" "+hotel.get(i).getNbPlaceRestante()+"chambres restantes");
			}
			bouttonNextChoixHotel = new JButton("Next");
			bouttonAnnuler = new JButton("Annuler");
			JPanel panel3 = new JPanel();
			panel3.add(new JLabel("choix de l'hotel"));
			panel3.add(choixHotel);
			JPanel panel2 = new JPanel();
			panelChoixHotel = new JPanel();
			panelChoixHotel.setLayout(new BoxLayout(panelChoixHotel,BoxLayout.PAGE_AXIS));

			panel2.add(bouttonNextChoixHotel);
			bouttonNextChoixHotel.addActionListener(new TraitementReservation(this,this.connect));
			panel2.add(bouttonAnnuler);
			bouttonAnnuler.addActionListener(new TraitementReservation(this,this.connect));
			panelChoixHotel.add(panel3, BorderLayout.CENTER);
			panelChoixHotel.add(panel2, BorderLayout.SOUTH);
			add(panelChoixHotel);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(550, 250);
			setVisible(true);
		}
		else{
			JPanel panel3 = new JPanel();
			JPanel panel2 = new JPanel();

			panel3.add(new JLabel("pas d hotel disponible"));
			bouttonAnnuler = new JButton("Annuler");
			panel2.add(bouttonAnnuler);
			bouttonAnnuler.addActionListener(new TraitementReservation(this,this.connect));

			panelChoixHotel = new JPanel();
			panelChoixHotel.setLayout(new BoxLayout(panelChoixHotel,BoxLayout.PAGE_AXIS));
			panelChoixHotel.add(panel3, BorderLayout.CENTER);
			panelChoixHotel.add(panel2, BorderLayout.SOUTH);
			add(panelChoixHotel);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(550, 250);
			setVisible(true);
		}
	}

	public void choixCategorie(int idHotel, ArrayList<Categorie> categorie){

		choixCategorie = new JComboBox<String>();
		this.idHotel=idHotel;
		this.categorie=categorie;
		for(int i =0;i<categorie.size();i++){
			choixCategorie.addItem(categorie.get(i).getNom()+" "+categorie.get(i).getPlace()+"places"+" "+categorie.get(i).getPrix()+" euros");
		}
		bouttonNextChoixCategorie = new JButton("Next");
		bouttonAnnuler = new JButton("Annuler");
		JPanel panel3 = new JPanel();
		panel3.add(new JLabel("choix de la categorie"));
		panel3.add(choixCategorie);
		JPanel panel2 = new JPanel();
		panelChoixCategorie = new JPanel();
		panelChoixCategorie.setLayout(new BoxLayout(panelChoixCategorie,BoxLayout.PAGE_AXIS));

		panel2.add(bouttonNextChoixCategorie);
		bouttonNextChoixCategorie.addActionListener(new TraitementReservation(this,this.connect));
		panel2.add(bouttonAnnuler);
		bouttonAnnuler.addActionListener(new TraitementReservation(this,this.connect));
		panelChoixCategorie.add(panel3, BorderLayout.CENTER);
		panelChoixCategorie.add(panel2, BorderLayout.SOUTH);
		add(panelChoixCategorie);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(550, 250);
		setVisible(true);
	}

	public void choixChambre(int idCategorie,ArrayList<Chambre> chambre){
		choixChambre = new JComboBox<String>();
		this.idCategorie=idCategorie;
		this.chambre=chambre;
		for(int i =0;i<chambre.size();i++){
			choixChambre.addItem(chambre.get(i).getDenomination());
		}
		bouttonNextChoixChambre = new JButton("Next");
		bouttonAnnuler = new JButton("Annuler");
		JPanel panel3 = new JPanel();
		panel3.add(new JLabel("choix de la chambre"));
		panel3.add(choixChambre);
		JPanel panel2 = new JPanel();
		panelChoixChambre = new JPanel();
		panelChoixChambre.setLayout(new BoxLayout(panelChoixChambre,BoxLayout.PAGE_AXIS));

		panel2.add(bouttonNextChoixChambre);
		bouttonNextChoixChambre.addActionListener(new TraitementReservation(this,this.connect));
		panel2.add(bouttonAnnuler);
		bouttonAnnuler.addActionListener(new TraitementReservation(this,this.connect));
		panelChoixChambre.add(panel3, BorderLayout.CENTER);
		panelChoixChambre.add(panel2, BorderLayout.SOUTH);
		add(panelChoixChambre);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(550, 250);
		setVisible(true);
	}

	public void recapilutatif(int cleChambre, Reservation reservation){
		this.cleChambre=cleChambre;
		this.reservation=reservation;
		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color (0xCFBFAD);

		//Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 24);
		bouttonValider = new JButton("Valider");
		bouttonAnnuler= new JButton("Annuler");
		bouttonValider.addActionListener(new TraitementReservation(this,this.connect));
		bouttonAnnuler.addActionListener(new TraitementReservation(this,this.connect));

		//Fond transparent
		bouttonAnnuler.setOpaque(false);
		bouttonAnnuler.setContentAreaFilled(false);
		//Changement couleur bordure
		bouttonAnnuler.setBorder(border);
		//Changement Police
		bouttonAnnuler.setFont(font_bouton);
		//Changement couleur Police
		bouttonAnnuler.setForeground(BlancPale);

		//Fond transparent
		bouttonValider.setOpaque(false);
		bouttonValider.setContentAreaFilled(false);
		//Changement couleur bordure
		bouttonValider.setBorder(border);
		//Changement Police
		bouttonValider.setFont(font_bouton);
		//Changement couleur Police
		bouttonValider.setForeground(BlancPale);


		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();


		JPanel panel3 = new JPanel(new FlowLayout());
		panel3.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;		
		JLabel GJLVilleAller = new JLabel("Ville Aller :");
		GJLVilleAller.setFont(font_bouton);
		GJLVilleAller.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		GJLVilleAller.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		panel3.add(GJLVilleAller,c);

		c.fill = GridBagConstraints.BOTH;
		JLabel DJLVilleAller = new JLabel(""+reservation.getVilleAller().getNom());
		DJLVilleAller.setFont(font_bouton);
		DJLVilleAller.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		DJLVilleAller.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		c.gridx = 1;
		c.gridy = 0;
		panel3.add(DJLVilleAller,c);


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
		panel4.add(GJLVilleRetour,c);

		c.fill = GridBagConstraints.BOTH;
		JLabel DJLVilleRetour = new JLabel(""+reservation.getVilleRetour().getNom());
		DJLVilleRetour.setFont(font_bouton);
		DJLVilleRetour.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		DJLVilleRetour.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		c.gridx = 1;
		c.gridy = 0;
		panel4.add(DJLVilleRetour,c);


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
		panel5.add(GJLDateAller,c);

		c.fill = GridBagConstraints.BOTH;
		JLabel DJLDateAller = new JLabel(""+reservation.getDateAller());
		DJLDateAller.setFont(font_bouton);
		DJLDateAller.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		DJLDateAller.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		c.gridx = 1;
		c.gridy = 0;
		panel5.add(DJLDateAller,c);

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
		panel6.add(GJLDateRetour,c);

		c.fill = GridBagConstraints.BOTH;
		JLabel DJLDateRetour = new JLabel(""+reservation.getDateRetour());
		DJLDateRetour.setFont(font_bouton);
		DJLDateRetour.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		DJLDateRetour.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		c.gridx = 1;
		c.gridy = 0;
		panel6.add(DJLDateRetour,c);

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
		panel7.add(GJLPrixTransport,c);

		c.fill = GridBagConstraints.BOTH;
		JLabel DJLPrixTransport = new JLabel(""+reservation.getPrixTransport());
		DJLPrixTransport.setFont(font_bouton);
		DJLPrixTransport.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		DJLPrixTransport.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		c.gridx = 1;
		c.gridy = 0;
		panel7.add(DJLPrixTransport,c);		

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
		panel8.add(GJLNbPersonnes,c);

		c.fill = GridBagConstraints.BOTH;
		JLabel DJLNbPersonnes = new JLabel(""+reservation.getNbPersonne());
		DJLNbPersonnes.setFont(font_bouton);
		DJLNbPersonnes.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		DJLNbPersonnes.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		c.gridx = 1;
		c.gridy = 0;
		panel8.add(DJLNbPersonnes,c);

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
		panel9.add(GJLHotel,c);

		c.fill = GridBagConstraints.BOTH;
		JLabel DJLHotel = new JLabel(""+reservation.getHotel().getNom());
		DJLHotel.setFont(font_bouton);
		DJLHotel.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		DJLHotel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		c.gridx = 1;
		c.gridy = 0;
		panel9.add(DJLHotel,c);


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
		panel10.add(GJLHotel,c);

		c.fill = GridBagConstraints.BOTH;
		JLabel DJLCategorie = new JLabel(""+reservation.getCategorie().getNom());
		DJLCategorie.setFont(font_bouton);
		DJLCategorie.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		DJLCategorie.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		c.gridx = 1;
		c.gridy = 0;
		panel10.add(DJLCategorie,c);

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
		panel11.add(GJLChambre,c);

		c.fill = GridBagConstraints.BOTH;
		JLabel DJLChambre = new JLabel(""+reservation.getChambre().getDenomination());
		DJLChambre.setFont(font_bouton);
		DJLChambre.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		DJLChambre.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		c.gridx = 1;
		c.gridy = 0;
		panel11.add(DJLChambre,c);

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
		panel12.add(GJLNbNuits,c);

		c.fill = GridBagConstraints.BOTH;
		JLabel DJLNbNuits = new JLabel(""+reservation.getNbDeNuit());
		DJLNbNuits.setFont(font_bouton);
		DJLNbNuits.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		DJLNbNuits.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		c.gridx = 1;
		c.gridy = 0;
		panel12.add(DJLNbNuits,c);

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
		panel13.add(GJLPrixHotel,c);

		c.fill = GridBagConstraints.BOTH;
		JLabel DJLPrixHotel = new JLabel(""+reservation.getPrixHotel());
		DJLPrixHotel.setFont(font_bouton);
		DJLPrixHotel.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		DJLPrixHotel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		c.gridx = 1;
		c.gridy = 0;
		panel13.add(DJLPrixHotel,c);				

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
		panel14.add(GJLPrixTotal,c);

		c.fill = GridBagConstraints.BOTH;
		JLabel DJLPrixTotal = new JLabel(""+reservation.getPrixTotal());
		DJLPrixTotal.setFont(font_bouton);
		DJLPrixTotal.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		DJLPrixTotal.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		c.gridx = 1;
		c.gridy = 0;
		panel14.add(DJLPrixTotal,c);	


		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(panel3,c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(panel4,c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(panel5,c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 3;
		panel.add(panel6,c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 4;
		panel.add(panel7,c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 5;
		panel.add(panel8,c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 6;
		panel.add(panel9,c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 7;
		panel.add(panel10,c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 8;
		panel.add(panel11,c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 9;
		panel.add(panel12,c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 10;
		panel.add(panel13,c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 11;
		panel.add(panel14,c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 12;
		panel.add(bouttonValider,c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 12;
		panel.add(bouttonAnnuler,c);

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
		setSize(800,600);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}





