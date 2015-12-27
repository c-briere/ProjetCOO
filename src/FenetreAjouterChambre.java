import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FenetreAjouterChambre extends JFrame{

	JTextField nom = new JTextField();
	
	
	public Connect connect;
	JButton bouttonValider = new JButton("Valider");
	JButton bouttonAnnuler = new JButton("Annuler");
	int cleCategorie;

	
	public FenetreAjouterChambre(int cleCategorie,Connect connect){
		super("Ajout une chambre");
		this.connect=connect;
		this.cleCategorie=cleCategorie;
		
		bouttonValider.addActionListener(new TraitementAjoutChambre(this,this.connect,cleCategorie));
		bouttonAnnuler.addActionListener(new TraitementAjoutChambre(this,this.connect,cleCategorie));
		
		nom.setPreferredSize(new Dimension(250,30));



		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));


		JPanel panel = new JPanel(new FlowLayout());

		
		JPanel panel6 = new JPanel(new BorderLayout());

		panel.add(new JLabel("nom"));
		panel.add(nom);
		panel6.add(panel,BorderLayout.NORTH);
		
		JPanel panel8 = new JPanel(new BorderLayout());
		panel8.add(panel6,BorderLayout.NORTH);
		
		
		JPanel panel7 = new JPanel();
		panel7.add(bouttonValider);
		panel7.add(bouttonAnnuler);
		
		panel2.add(panel8, BorderLayout.NORTH);
		panel2.add(panel7, BorderLayout.SOUTH);


		this.getContentPane().add(panel2);
		setSize(500,300);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
