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


public class FenetreAjouterVille extends JFrame{

	JTextField ville = new JTextField();
	
	public Connect connect;
	JButton bouttonValider = new JButton("Valider");
	JButton bouttonAnnuler = new JButton("Annuler");


	
	public FenetreAjouterVille(Connect connect){
		super("Ajout d'une ville");
		this.connect=connect;
		
		bouttonValider.addActionListener(new TraitementAjoutVille(this,this.connect));
		bouttonAnnuler.addActionListener(new TraitementAjoutVille(this,this.connect));
		
		
		ville.setPreferredSize(new Dimension(250,30));

		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));


		
		JPanel panel3 = new JPanel(new FlowLayout());

		
		panel3.add(new JLabel("ville"));
		panel3.add(ville);
		
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
