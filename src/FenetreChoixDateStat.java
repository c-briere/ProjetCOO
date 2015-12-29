import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FenetreChoixDateStat extends JFrame{
	Connect connect;
	public JTextField date1;
	public JTextField date2;
	public JButton bouttonVoir;
	public JButton bouttonAnnuler;
	private JPanel panelSelectionClient;
	
	public FenetreChoixDateStat(Connect connect) {
		this.connect=connect;
		date1 = new JTextField();
		date2 = new JTextField();
		


		bouttonVoir = new JButton("Valider");
		bouttonAnnuler = new JButton("Annuler");

		bouttonVoir.addActionListener(new TraitementGestionStat(this,this.connect));
		bouttonAnnuler.addActionListener(new TraitementGestionStat(this,this.connect));

		date1.setPreferredSize(new Dimension(250,30));
		date2.setPreferredSize(new Dimension(250,30));

		panelSelectionClient = new JPanel();
		panelSelectionClient.setLayout(new BoxLayout(panelSelectionClient, BoxLayout.Y_AXIS));


		JPanel panel = new JPanel(new FlowLayout());
		JPanel panel1 = new JPanel(new FlowLayout());

		JPanel panel6 = new JPanel(new BorderLayout());

		panel.add(new JLabel("date1"));
		panel.add(date1);
		panel1.add(new JLabel("date2"));
		panel1.add(date2);
		
		panel6.add(panel,BorderLayout.NORTH);
		panel6.add(panel1,BorderLayout.CENTER);

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
