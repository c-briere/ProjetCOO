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
import javax.swing.JTextField;


public class FenetreGestionReservation extends JFrame{

	Connect connect;
	JTextField nom,prenom,date,villeDepart,dateDepart, dateArrive, nbPersonne;
	JButton bouttonNextClient,bouttonAnnuler,bouttonNextChoixDate;
	JPanel panelSelectionClient,panelSelectionDate;
	int cleClient,cleVilleDepart;
	Ville VilleDepart;
	ArrayList<Ligne> ligne;
	JComboBox<String> choixVille;

	public FenetreGestionReservation(Connect connect) {
		super("gestion reservation");
		this.connect = connect;
		this.choixClient();
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
	
	public void CleartSelectionClient(){
		panelSelectionClient.hide();
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
		panel4.add(new JLabel("choix date arrive"));
 	
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

}
