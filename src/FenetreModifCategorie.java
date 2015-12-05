import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FenetreModifCategorie extends JFrame{

	JTextField nom = new JTextField();
	JTextField place = new JTextField();
	JTextField prix = new JTextField();
	public Connect connect;
	JButton bouttonValider = new JButton("Rechercher");
	JButton bouttonAnnuler = new JButton("Annuler");
	int cleHotel;
	int cleCategorie;


	
	public FenetreModifCategorie(int cleHotel,Connect connect){
		super("Modification d'une categorie");
		this.connect=connect;
		this.cleHotel=cleHotel;
		bouttonValider.addActionListener(new TraitementModificationCategorie(this,this.connect,this.cleHotel));
		bouttonAnnuler.addActionListener(new TraitementModificationCategorie(this,this.connect,this.cleHotel));
		
		nom.setPreferredSize(new Dimension(250,30));
		place.setPreferredSize(new Dimension(250,30));
		prix.setPreferredSize(new Dimension(250,30));
				JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));


		JPanel panel = new JPanel(new FlowLayout());
		JPanel panel1 = new JPanel(new FlowLayout());
		JPanel panel3 = new JPanel(new FlowLayout());
		
		JPanel panel5 = new JPanel(new BorderLayout());
		
		panel3.add(new JLabel("prix"));
		panel3.add(prix);
		panel5.add(panel3,BorderLayout.NORTH);
		
		JPanel panel6 = new JPanel(new BorderLayout());

		panel.add(new JLabel("nom"));
		panel.add(nom);
		panel1.add(new JLabel("place"));
		panel1.add(place);
		panel6.add(panel,BorderLayout.NORTH);
		panel6.add(panel1,BorderLayout.CENTER);
		
		JPanel panel8 = new JPanel(new BorderLayout());
		panel8.add(panel6,BorderLayout.NORTH);
		panel8.add(panel5,BorderLayout.CENTER);
		
		
		JPanel panel7 = new JPanel();
		panel7.add(bouttonValider);
		panel7.add(bouttonAnnuler);
		
		panel2.add(panel8, BorderLayout.NORTH);
		panel2.add(panel7, BorderLayout.SOUTH);
		
		prix.hide();
		place.hide();


		this.getContentPane().add(panel2);
		setSize(500,300);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
