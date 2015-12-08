import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class FenetreAccueil extends JFrame implements ActionListener{
	JButton boutonReservation = new JButton("Reservation");
	JButton boutonAdministration = new JButton("Administration");
	
	public Connect connect;

	public FenetreAccueil(Connect connect){
		super("Panneau d'accueil");
		this.connect=connect;



		boutonReservation.setPreferredSize(new Dimension(250,30));
		boutonAdministration.setPreferredSize(new Dimension(250,30));
		
		boutonReservation.addActionListener(this);
		boutonAdministration.addActionListener(this);
		JPanel panel = new JPanel();
		BoxLayout box = new BoxLayout(panel,BoxLayout.PAGE_AXIS);
		panel.setLayout(box);
		panel.add(Box.createVerticalGlue());
		panel.add(boutonReservation);
		boutonReservation.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.setLayout(box);
		panel.add(Box.createVerticalGlue());
		panel.add(boutonAdministration);
		boutonAdministration.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.setLayout(box);
		panel.add(Box.createVerticalGlue());
	



		this.getContentPane().add(panel);
		setSize(350,200);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) { 
		Object source = e.getSource();
		if(source==boutonReservation){
			dispose();
			new FenetreGestionReservation(this.connect);
		}

	
		if(source==boutonAdministration){
			dispose();
			new FenetreAdministration(this.connect);

		}
		
		
	} 

	public static void main(String [] args){
		Connect connect = new Connect();
		JFrame frame = new FenetreAccueil(connect);


	}
}
