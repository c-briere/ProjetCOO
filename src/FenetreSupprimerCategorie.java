import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FenetreSupprimerCategorie extends JFrame{
	
JTextField categorie = new JTextField();
	
	public Connect connect;
	JButton bouttonValider = new JButton("Valider");
	JButton bouttonAnnuler = new JButton("Annuler");
	int cleHotel;
		
	public FenetreSupprimerCategorie(int cleHotel, Connect connect) {
		super("Suppression d'une catégorie");
		this.connect=connect;
		this.cleHotel=cleHotel;
		
		bouttonValider.addActionListener(new TraitementSuppressionCategorie(this,this.connect,this.cleHotel));
		bouttonAnnuler.addActionListener(new TraitementSuppressionCategorie(this,this.connect,this.cleHotel));
		
		
		categorie.setPreferredSize(new Dimension(250,30));

		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));


		
		JPanel panel3 = new JPanel(new FlowLayout());

		
		panel3.add(new JLabel("categorie"));
		panel3.add(categorie);
		
		JPanel panel5 = new JPanel(new BorderLayout());
		panel5.add(panel3,BorderLayout.NORTH);
		
		
		
		
		
		JPanel panel7 = new JPanel();
		panel7.add(bouttonValider);
		panel7.add(bouttonAnnuler);
		
		panel2.add(panel5, BorderLayout.NORTH);
		panel2.add(panel7, BorderLayout.SOUTH);


		this.getContentPane().add(panel2);
		setSize(500,300);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}

}
