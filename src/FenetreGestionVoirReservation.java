import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FenetreGestionVoirReservation extends JFrame{
	Connect connect;
	public JTextField nom;
	public JTextField prenom;
	public JTextField date;
	public JButton bouttonVoir;
	public JButton bouttonAnnuler;
	private JPanel panelSelectionClient;
	
	public FenetreGestionVoirReservation(Connect connect) {
		this.connect=connect;
		nom = new JTextField();
		prenom = new JTextField();
		date = new JTextField();


		bouttonVoir = new JButton("Voir reservation");
		bouttonAnnuler = new JButton("Annuler");

		bouttonVoir.addActionListener(new TraitementVoirReservation(this,this.connect));
		bouttonAnnuler.addActionListener(new TraitementVoirReservation(this,this.connect));

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
		panel7.add(bouttonVoir);
		panel7.add(bouttonAnnuler);

		panelSelectionClient.add(panel8, BorderLayout.NORTH);
		panelSelectionClient.add(panel7, BorderLayout.SOUTH);


		this.getContentPane().add(panelSelectionClient);
		setSize(500,300);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	

}
