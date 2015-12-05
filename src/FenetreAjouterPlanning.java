import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FenetreAjouterPlanning extends JFrame{

	JComboBox<String> jour ;
	JTextField heure = new JTextField();
	JTextField duree = new JTextField();
	JTextField passager1ereclasse = new JTextField();
	JTextField prix1ereclasse = new JTextField();
	JTextField passager2emeclasse = new JTextField();
	JTextField prix2emeclasse = new JTextField();
	JTextField annulable = new JTextField();
	
	int cleLigne;
	
	
	public Connect connect;
	JButton bouttonValider = new JButton("Valider");
	JButton bouttonAnnuler = new JButton("Annuler");


	
	public FenetreAjouterPlanning(Connect connect,int cleLigne){
		super("Ajout d'un trajet");
		this.connect=connect;
		this.cleLigne=cleLigne;
		bouttonValider.addActionListener(new TraitementAjoutTrajet(this,this.connect,this.cleLigne));
		bouttonAnnuler.addActionListener(new TraitementAjoutTrajet(this,this.connect,this.cleLigne));
		
		heure.setPreferredSize(new Dimension(250,30));
		duree.setPreferredSize(new Dimension(250,30));
		passager1ereclasse.setPreferredSize(new Dimension(250,30));
		prix1ereclasse.setPreferredSize(new Dimension(250,30));
		passager2emeclasse.setPreferredSize(new Dimension(250,30));
		prix2emeclasse.setPreferredSize(new Dimension(250,30));
		annulable.setPreferredSize(new Dimension(250,30));


		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));


		JPanel panel = new JPanel(new FlowLayout());
		JPanel panel1 = new JPanel(new FlowLayout());
		JPanel panel3 = new JPanel(new FlowLayout());
		JPanel panel4 = new JPanel(new FlowLayout());
		JPanel panel9 = new JPanel(new FlowLayout());
		
		JPanel panel5 = new JPanel(new BorderLayout());
		String [] jourSemaine = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
		jour = new JComboBox(jourSemaine);
		panel4.add(new JLabel("jour de la semaine"));
		panel4.add(jour);
		panel3.add(new JLabel("heure"));
		panel3.add(heure);
		panel9.add(new JLabel("duree (en) min"));
		panel9.add(duree);
		panel5.add(panel4,BorderLayout.NORTH);
		panel5.add(panel3,BorderLayout.CENTER);
		panel5.add(panel9,BorderLayout.SOUTH);
		
		JPanel panel6 = new JPanel(new BorderLayout());
		JPanel panel10 = new JPanel(new FlowLayout());

		panel.add(new JLabel("nombre passager 1ere clase"));
		panel.add(passager1ereclasse);
		panel1.add(new JLabel("prix 1ere classe"));
		panel1.add(prix1ereclasse);
		panel10.add(new JLabel("nombre passager 2eme classe"));
		panel10.add(passager2emeclasse);
		panel6.add(panel,BorderLayout.NORTH);
		panel6.add(panel1,BorderLayout.CENTER);
		panel6.add(panel10,BorderLayout.SOUTH);
		
		
		JPanel panel11 = new JPanel(new BorderLayout());
		JPanel panel12 = new JPanel(new FlowLayout());
		JPanel panel13 = new JPanel(new FlowLayout());

		panel12.add(new JLabel("prix 2eme clase"));
		panel12.add(prix2emeclasse);
		panel13.add(new JLabel("Annulable à J moins"));
		panel13.add(annulable);
	;
		panel11.add(panel12,BorderLayout.NORTH);
		panel11.add(panel13,BorderLayout.CENTER);
		
		JPanel panel8 = new JPanel(new BorderLayout());
		panel8.add(panel5,BorderLayout.NORTH);
		panel8.add(panel6,BorderLayout.CENTER);
		panel8.add(panel11,BorderLayout.SOUTH);
		
		
		JPanel panel7 = new JPanel();
		panel7.add(bouttonValider);
		panel7.add(bouttonAnnuler);
		
		panel2.add(panel8, BorderLayout.NORTH);
		panel2.add(panel7, BorderLayout.SOUTH);


		this.getContentPane().add(panel2);
		setSize(600,400);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
