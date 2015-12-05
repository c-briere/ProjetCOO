import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FenetreSupprimerHotel extends JFrame{
	
JTextField hotel = new JTextField();
	
	public Connect connect;
	JButton bouttonValider = new JButton("Valider");
	JButton bouttonAnnuler = new JButton("Annuler");
	int cle;
		
	public FenetreSupprimerHotel(int cle, Connect connect) {
		super("Suppression d'un hotel");
		this.connect=connect;
		this.cle=cle;
		
		bouttonValider.addActionListener(new TraitementSuppressionHotel(this,this.connect,this.cle));
		bouttonAnnuler.addActionListener(new TraitementSuppressionHotel(this,this.connect,this.cle));
		
		
		hotel.setPreferredSize(new Dimension(250,30));

		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));


		
		JPanel panel3 = new JPanel(new FlowLayout());

		
		panel3.add(new JLabel("hotel"));
		panel3.add(hotel);
		
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
