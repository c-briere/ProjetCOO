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
import javax.swing.table.JTableHeader;


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

		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color (0xCFBFAD);

		//Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 24);
		
		bouttonNextClient = new JButton("Next");
		bouttonAnnuler = new JButton("Annuler");

		bouttonNextClient.addActionListener(new TraitementReservation(this,this.connect));
		bouttonAnnuler.addActionListener(new TraitementReservation(this,this.connect));

		nom.setPreferredSize(new Dimension(250,30));
		prenom.setPreferredSize(new Dimension(250,30));
		date.setPreferredSize(new Dimension(250,30));

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
		bouttonNextClient.setOpaque(false);
		bouttonNextClient.setContentAreaFilled(false);
		//Changement couleur bordure
		bouttonNextClient.setBorder(border);
		//Changement Police
		bouttonNextClient.setFont(font_bouton);
		//Changement couleur Police
		bouttonNextClient.setForeground(BlancPale);
		
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
		panel4.add(d,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel4.add(date);

		
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
		panel5.add(n,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;		
		panel5.add(nom);
		
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
		panel6.add(p,c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;	
		panel6.add(prenom);	


		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 2;
		panelSelectionClient.add(panel4,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		panelSelectionClient.add(panel5,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		panelSelectionClient.add(panel6,c);
		
		c.gridwidth= 1;
		c.gridx = 0;
		c.gridy = 3;
		panelSelectionClient.add(bouttonNextClient,c);
		
		c.gridwidth= 1;
		c.gridx = 1;
		c.gridy = 3;
		panelSelectionClient.add(bouttonAnnuler,c);

		// Fond du panel
		// couleur : gris foncé
		panel4.setBackground(GrisFonce);
		panel5.setBackground(GrisFonce);
		panel6.setBackground(GrisFonce);
		panelSelectionClient.setBackground(GrisFonce);



		this.getContentPane().add(panelSelectionClient);
		setSize(500,300);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void cleartSelectionClient(){
		this.panelSelectionClient.setVisible(false);
	}

	public void clearChoixDate(){
		this.panelSelectionDate.setVisible(false);
	}

	public void clearChoixAller(){
		this.panelSelectionAller.setVisible(false);
	}

	public void clearChoixRetour(){
		this.panelSelectionRetour.setVisible(false);
	}
	public void clearChoixHotel(){
		this.panelChoixHotel.setVisible(false);
	}
	public void clearChoixCategorie(){
		this.panelChoixCategorie.setVisible(false);
	}
	public void clearChoixChambre(){
		this.panelChoixChambre.setVisible(false);
	}

	public void clearRecapitulatif(){
		this.panel.setVisible(false);
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

		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color (0xCFBFAD);

		//Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 24);
		
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
		bouttonNextChoixDate.setOpaque(false);
		bouttonNextChoixDate.setContentAreaFilled(false);
		//Changement couleur bordure
		bouttonNextChoixDate.setBorder(border);
		//Changement Police
		bouttonNextChoixDate.setFont(font_bouton);
		//Changement couleur Police
		bouttonNextChoixDate.setForeground(BlancPale);


		panelSelectionDate = new JPanel();
		panelSelectionDate.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();


		dateDepart= new JTextField();
		dateArrive= new JTextField();
		nbPersonne = new JTextField();
		villeDepart = new JTextField();
		
		choixVille.setPreferredSize(new Dimension (250,30));
		dateDepart.setPreferredSize(new Dimension(250,30));
		dateArrive.setPreferredSize(new Dimension(250,30));
		nbPersonne.setPreferredSize(new Dimension(250,30));
		villeDepart.setPreferredSize(new Dimension(250,30));
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
		panel4.add(d,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel4.add(choixVille);
		

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
		panel5.add(vd,c);
		
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
		panel6.add(p,c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;	
		panel6.add(dateDepart);	

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
		panel7.add(dr,c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;	
		panel7.add(dateArrive);	

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
		panel8.add(nbp,c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;	
		panel8.add(nbPersonne);	
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		panelSelectionDate.add(panel5,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		panelSelectionDate.add(panel4,c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 2;
		panelSelectionDate.add(panel6,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 3;
		panelSelectionDate.add(panel7,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 4;
		panelSelectionDate.add(panel8,c);
		
		c.gridwidth= 1;
		c.gridx = 0;
		c.gridy = 5;
		panelSelectionDate.add(bouttonNextChoixDate,c);
		
		c.gridwidth= 1;
		c.gridx = 1;
		c.gridy = 5;
		panelSelectionDate.add(bouttonAnnuler,c);

		// Fond du panel
		// couleur : gris foncé
		panel4.setBackground(GrisFonce);
		panel5.setBackground(GrisFonce);
		panel6.setBackground(GrisFonce);
		panel7.setBackground(GrisFonce);
		panel8.setBackground(GrisFonce);
		panelSelectionDate.setBackground(GrisFonce);


		this.getContentPane().add(panelSelectionDate);
		setSize(800,300);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public void choixRetour(String heureAller, String classeAller,
			double prixAller) {
		this.heureAller=heureAller;
		this.classeAller=classeAller;
		this.prixAller=prixAller;

		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color (0xCFBFAD);
		
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 16);
		
		String [] classe = {"1ere classe" , "2eme classe"};
		choixClasse = new JComboBox<>(classe);
		bouttonNextChoixRetour = new JButton("Next");
		bouttonAnnuler = new JButton("Annuler");
		panelSelectionRetour = new JPanel();
		panelSelectionRetour.setLayout(new BoxLayout(panelSelectionRetour,BoxLayout.PAGE_AXIS));

		tableau = new JTable(new TableTrajetPrixTotal(trajetRetour,nbPersonneVoyage));
		tableau.setPreferredScrollableViewportSize(new Dimension(500, 200));
		tableau.setFillsViewportHeight(true);
        //Modification du HEADER du tableau
        JTableHeader header = tableau.getTableHeader();
        header.setBackground(GrisFonce);
        header.setForeground(BlancPale);
		JScrollPane scrollPane = new JScrollPane(tableau);

		JPanel panel3 = new JPanel();
		JLabel v = new JLabel("Choix de la classe");
		v.setFont(font_bouton);
		v.setForeground(BlancPale);
		panel3.add(v);
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

		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color (0xCFBFAD);
		
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 16);
		
		String [] classe = {"1ere classe" , "2eme classe"};
		choixClasse = new JComboBox<>(classe);
		bouttonNextChoixAller = new JButton("Next");
		bouttonAnnuler = new JButton("Annuler");
		panelSelectionAller = new JPanel();
		panelSelectionAller.setLayout(new BoxLayout(panelSelectionAller,BoxLayout.PAGE_AXIS));
		tableau = new JTable(new TableTrajetPrixTotal(trajet,nbPersonneVoyage));
		tableau.setPreferredScrollableViewportSize(new Dimension(500, 200));
		tableau.setFillsViewportHeight(true);
        //Modification du HEADER du tableau
        JTableHeader header = tableau.getTableHeader();
        header.setBackground(GrisFonce);
        header.setForeground(BlancPale);
		JScrollPane scrollPane = new JScrollPane(tableau);

		JPanel panel3 = new JPanel();
		JLabel v = new JLabel("Choix de la classe");
		v.setFont(font_bouton);
		v.setForeground(BlancPale);
		panel3.add(v);
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
	public void choixHotel(String heureRetour,String classeRetour,double prixRetour, ArrayList<HotelRestant> hotel){
		this.heureRetour=heureRetour;
		this.classeRetour=classeRetour;
		this.prixRetour=prixRetour;
		choixHotel = new JComboBox<String>();
		if(hotel.size()!=0 || hotel!=null){
			this.hotel=hotel;
			for(int i =0;i<hotel.size();i++){
				choixHotel.addItem(hotel.get(i).getNom()+" "+hotel.get(i).getNbPlaceRestante()+" chambres restantes");
			}
			bouttonNextChoixHotel = new JButton("Next");
			bouttonAnnuler = new JButton("Annuler");

			Color GrisFonce = new Color(0x222222);
			Color BlancPale = new Color (0xCFBFAD);

			//Bordure blanche d'épaisseur 3
			Border border = new LineBorder(BlancPale, 3);
			// Regarder comment importer une police
			Font font_bouton = new Font("Roboto", Font.PLAIN, 24);

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
			bouttonNextChoixHotel.setOpaque(false);
			bouttonNextChoixHotel.setContentAreaFilled(false);
			//Changement couleur bordure
			bouttonNextChoixHotel.setBorder(border);
			//Changement Police
			bouttonNextChoixHotel.setFont(font_bouton);
			//Changement couleur Police
			bouttonNextChoixHotel.setForeground(BlancPale);
			
			bouttonNextChoixHotel.addActionListener(new TraitementReservation(this,this.connect));
			bouttonAnnuler.addActionListener(new TraitementReservation(this,this.connect));

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
			panel3.add(v,c);
			
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 1;
			c.gridy = 0;
			panel3.add(choixHotel,c);

			c.fill = GridBagConstraints.BOTH;
			c.weightx = 0.25;
			c.weighty = 0.50;
			c.gridwidth = 2;
			c.gridx = 0;
			c.gridy = 0;
			panelChoixHotel.add(panel3,c);
			
			c.fill = GridBagConstraints.BOTH;
			c.weightx = 0.25;
			c.weighty = 0.15;
			c.gridwidth = 1;
			c.gridx = 0;
			c.gridy = 1;
			panelChoixHotel.add(bouttonNextChoixHotel,c);
			
			c.fill = GridBagConstraints.BOTH;
			c.weightx = 0.25;
			c.weighty = 0.15;
			c.gridwidth = 1;
			c.gridx = 1;
			c.gridy = 1;		
			panelChoixHotel.add(bouttonAnnuler,c);

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
		else{
			Color GrisFonce = new Color(0x222222);
			Color BlancPale = new Color (0xCFBFAD);

			//Bordure blanche d'épaisseur 3
			Border border = new LineBorder(BlancPale, 3);
			// Regarder comment importer une police
			Font font_bouton = new Font("Roboto", Font.PLAIN, 24);

			//Fond transparent
			bouttonAnnuler.setOpaque(false);
			bouttonAnnuler.setContentAreaFilled(false);
			//Changement couleur bordure
			bouttonAnnuler.setBorder(border);
			//Changement Police
			bouttonAnnuler.setFont(font_bouton);
			//Changement couleur Police
			bouttonAnnuler.setForeground(BlancPale);
			
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
			panel3.add(v,c);
			bouttonAnnuler = new JButton("Annuler");
			
			c.fill = GridBagConstraints.BOTH;
			c.weightx = 0.25;
			c.weighty = 0.50;
			c.gridwidth = 2;
			c.gridx = 0;
			c.gridy = 0;
			panelChoixHotel.add(panel3,c);
			
			c.fill = GridBagConstraints.BOTH;
			c.weightx = 0.25;
			c.weighty = 0.15;
			c.gridwidth = 1;
			c.gridx = 0;
			c.gridy = 1;		
			panelChoixHotel.add(bouttonAnnuler,c);

			bouttonAnnuler.addActionListener(new TraitementReservation(this,this.connect));

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

	public void choixCategorie(int idHotel, ArrayList<Categorie> categorie){

		choixCategorie = new JComboBox<String>();
		this.idHotel=idHotel;
		this.categorie=categorie;
		for(int i =0;i<categorie.size();i++){
			choixCategorie.addItem(categorie.get(i).getNom()+" "+categorie.get(i).getPlace()+"places"+" "+categorie.get(i).getPrix()+" euros");
		}
		
		bouttonNextChoixCategorie = new JButton("Next");
		bouttonAnnuler = new JButton("Annuler");
		
		bouttonAnnuler.addActionListener(new TraitementReservation(this,this.connect));
		bouttonNextChoixCategorie.addActionListener(new TraitementReservation(this,this.connect));
		
		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color (0xCFBFAD);

		//Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 24);

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
		bouttonNextChoixCategorie.setOpaque(false);
		bouttonNextChoixCategorie.setContentAreaFilled(false);
		//Changement couleur bordure
		bouttonNextChoixCategorie.setBorder(border);
		//Changement Police
		bouttonNextChoixCategorie.setFont(font_bouton);
		//Changement couleur Police
		bouttonNextChoixCategorie.setForeground(BlancPale);
		
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
		panel3.add(v,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel3.add(choixCategorie,c);
		

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		panelChoixCategorie.add(panel3,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 1;
		panelChoixCategorie.add(bouttonNextChoixCategorie,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 1;		
		panelChoixCategorie.add(bouttonAnnuler,c);

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

	public void choixChambre(int idCategorie,ArrayList<Chambre> chambre){
		choixChambre = new JComboBox<String>();
		this.idCategorie=idCategorie;
		this.chambre=chambre;
		for(int i =0;i<chambre.size();i++){
			choixChambre.addItem(chambre.get(i).getDenomination());
		}
		
		bouttonNextChoixChambre = new JButton("Next");
		bouttonAnnuler = new JButton("Annuler");
		
		bouttonNextChoixChambre.addActionListener(new TraitementReservation(this,this.connect));
		bouttonAnnuler.addActionListener(new TraitementReservation(this,this.connect));
		
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
		bouttonNextChoixChambre.setOpaque(false);
		bouttonNextChoixChambre.setContentAreaFilled(false);
		//Changement couleur bordure
		bouttonNextChoixChambre.setBorder(border);
		//Changement Police
		bouttonNextChoixChambre.setFont(font_bouton);
		//Changement couleur Police
		bouttonNextChoixChambre.setForeground(BlancPale);
		
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
		panel3.add(v,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel3.add(choixChambre,c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		panelChoixChambre.add(panel3,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 1;
		panelChoixChambre.add(bouttonNextChoixChambre,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 1;		
		panelChoixChambre.add(bouttonAnnuler,c);

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
		JLabel GJLVilleAller = new JLabel("Ville Aller ");
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





