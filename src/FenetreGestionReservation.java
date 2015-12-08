import java.awt.BorderLayout;
import java.awt.Component;
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


public class FenetreGestionReservation extends JFrame{

	Connect connect;
	JTextField nom,prenom,date,villeDepart,dateDepart, dateArrive, nbPersonne;
	JButton bouttonNextClient,bouttonAnnuler,bouttonNextChoixDate,bouttonNextChoixAller,bouttonNextChoixRetour;
	JPanel panelSelectionClient,panelSelectionDate,panelSelectionAller,panelSelectionRetour,recapitulatif;
	int cleClient,cleVilleDepart,cleLigneAller,cleLigneRetour,nbPersonneVoyage;
	Ville VilleDepart;
	ArrayList<Ligne> ligne;
	JComboBox<String> choixVille,choixClasse;
	ArrayList<Trajet> trajet,trajetRetour;
	String jourDepart,jourArrivee, heureAller,classeAller, heureRetour,classeRetour, villeRetour,dateAller,dateRetour;
	JTable tableau;
	Double prixAller, prixRetour;

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

	public void choixAller(String dateAller, String dateRetour,int cleLigneAller,int cleLigneRetour, ArrayList<Trajet> trajet,
			ArrayList<Trajet> trajetRetour, String jourDepart, String jourArrivee, int nbPersonneVoyage, String villeRetour) {
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
		System.out.println(nbPersonneVoyage);
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

	public void recapitulatif(String heureRetour, String classeRetour,
			double prixRetour){
		this.heureRetour=heureRetour;
		this.classeRetour=classeRetour;
		this.prixRetour=prixRetour;

		recapitulatif = new JPanel();
		recapitulatif.add(new JLabel(this.VilleDepart.getNom()));
		recapitulatif.add(new JLabel(this.dateAller));
		recapitulatif.add(new JLabel(this.jourDepart));
		recapitulatif.add(new JLabel(this.heureAller));
		recapitulatif.add(new JLabel(this.classeAller));
		recapitulatif.add(new JLabel(Double.toString(this.prixAller)));
		recapitulatif.add(new JLabel(this.villeRetour));
		recapitulatif.add(new JLabel(this.dateRetour));
		recapitulatif.add(new JLabel(this.jourArrivee));
		recapitulatif.add(new JLabel(this.heureRetour));
		recapitulatif.add(new JLabel(this.classeRetour));
		recapitulatif.add(new JLabel(Double.toString(this.prixRetour)));
		add(recapitulatif);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(550, 250);
		setVisible(true);


	}



}
