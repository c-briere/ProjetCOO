import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FenetreSupprimerPlanning extends JFrame{

	

	JComboBox<String> jour ;
	JTextField heure = new JTextField();
	JTextField duree = new JTextField();
	Connect connect;
	int cleLigne;
	JButton bouttonValider = new JButton("Valider");
	JButton bouttonAnnuler = new JButton("Annuler");

	
	public FenetreSupprimerPlanning(Connect connect, int cleLigne){
		super("Suppression d'un trajet");
		this.connect=connect;
		this.cleLigne=cleLigne;
		heure.setPreferredSize(new Dimension(250,30));
		duree.setPreferredSize(new Dimension(250,30));
		JPanel panel4 = new JPanel(new FlowLayout());
		JPanel panel9 = new JPanel(new FlowLayout());
		JPanel panel3 = new JPanel(new FlowLayout());
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
		
		JPanel panel7 = new JPanel();
		panel7.add(bouttonValider);
		panel7.add(bouttonAnnuler);
		JPanel panel2 = new JPanel(new BorderLayout());
		panel2.add(panel5, BorderLayout.NORTH);
		
		panel2.add(panel7, BorderLayout.SOUTH);
		
		bouttonValider.addActionListener(new TraitementSuppressionPlanning(this,this.connect,this.cleLigne));
		bouttonAnnuler.addActionListener(new TraitementSuppressionPlanning(this,this.connect,this.cleLigne));
		
		this.getContentPane().add(panel2);
		setSize(600,400);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
}
