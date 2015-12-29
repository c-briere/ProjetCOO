import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FenetreGestionSuppressionReservation extends JFrame {
	Connect connect;
	JTextField nom, numeroResa;
	JButton valider, annuler;
	
	public FenetreGestionSuppressionReservation(Connect connect) {
		super("Suppression d'une reservation");
		this.connect = connect;
		nom = new JTextField();
		numeroResa = new JTextField();
		valider= new JButton("Valider");
		annuler=new JButton("Annuler");
		

		valider = new JButton("Valider");
		annuler = new JButton("Annuler");

		valider.addActionListener(new TraitementSuppressionReservation(this,this.connect));
		annuler.addActionListener(new TraitementSuppressionReservation(this,this.connect));

		nom.setPreferredSize(new Dimension(250,30));
		numeroResa.setPreferredSize(new Dimension(250,30));

		JPanel panelSuppResa = new JPanel();
		panelSuppResa.setLayout(new BoxLayout(panelSuppResa, BoxLayout.Y_AXIS));


		JPanel panel = new JPanel(new FlowLayout());
		JPanel panel1 = new JPanel(new FlowLayout());

		JPanel panel6 = new JPanel(new BorderLayout());

		panel.add(new JLabel("nom"));
		panel.add(nom);
		panel1.add(new JLabel("numero resarvation"));
		panel1.add(numeroResa);
		panel6.add(panel,BorderLayout.NORTH);
		panel6.add(panel1,BorderLayout.CENTER);

		JPanel panel8 = new JPanel(new BorderLayout());
		panel8.add(panel6,BorderLayout.NORTH);


		JPanel panel7 = new JPanel();
		panel7.add(valider);
		panel7.add(annuler);

		panelSuppResa.add(panel8, BorderLayout.NORTH);
		panelSuppResa.add(panel7, BorderLayout.SOUTH);


		this.getContentPane().add(panelSuppResa);
		setSize(500,300);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
