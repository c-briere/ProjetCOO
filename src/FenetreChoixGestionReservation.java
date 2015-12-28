import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class FenetreChoixGestionReservation extends JFrame implements ActionListener{

	JButton bouttonAjouter=new JButton("Ajouter");
	JButton bouttonSupprimer=new JButton("Supprimer");
	JButton bouttonVoirResa=new JButton("Voir reservation");
	JButton bouttonAnnuler=new JButton("Annuler");
	Connect connect;
	
	public FenetreChoixGestionReservation(Connect connect) {
		super("Reservation");
		this.connect=connect;
		bouttonAjouter.addActionListener(this);
		bouttonSupprimer.addActionListener(this);
		bouttonVoirResa.addActionListener(this);
		bouttonAnnuler.addActionListener(this);
		JPanel panel5 = new JPanel(new BorderLayout());
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(bouttonAjouter,BorderLayout.NORTH);
		panel.add(bouttonSupprimer,BorderLayout.CENTER);
		panel5.add(panel,BorderLayout.NORTH);
		panel5.add(bouttonVoirResa,BorderLayout.CENTER);
		panel5.add(bouttonAnnuler,BorderLayout.SOUTH);
		this.getContentPane().add(panel5);
		setSize(500,300);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);


	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if(source==bouttonAjouter){
			dispose();
			new FenetreGestionReservation(this.connect);
		}
		if(source==bouttonSupprimer){
			dispose();
			new FenetreGestionSuppressionReservation(this.connect);
		}
		
	}
	

}
