import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * 
 * @author BRIERE / CARDON
 *
 */
public class FenetreAccueil extends JFrame implements ActionListener{
	JButton boutonReservation = new JButton("Reservation");
	JButton boutonAdministration = new JButton("Administration");
	
	public Connect connect;
	
	public FenetreAccueil(Connect connect){
		super("Panneau d'accueil");
		this.connect=connect;

		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color (0xCFBFAD);
		
		//Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 50);
		
		//Taille du bouton
		boutonReservation.setPreferredSize(new Dimension(383,550));
		//Fond transparent
		boutonReservation.setOpaque(false);
		boutonReservation.setContentAreaFilled(false);
		//Changement couleur bordure
		boutonReservation.setBorder(border);
		//Changement Police
		boutonReservation.setFont(font_bouton);
		//Changement couleur Police
		boutonReservation.setForeground(BlancPale);
		
		boutonAdministration.setPreferredSize(new Dimension(383,550));
		boutonAdministration.setOpaque(false);
		boutonAdministration.setContentAreaFilled(false);
		boutonAdministration.setBorder(border);
		boutonAdministration.setFont(font_bouton);
		boutonAdministration.setForeground(BlancPale);
		
		boutonReservation.addActionListener(this);
		boutonAdministration.addActionListener(this);
		
		JPanel panel = new JPanel();		
		
		//BoxLayout box = new BoxLayout(panel,BoxLayout.LINE_AXIS);
		

		//panel.setLayout(box);
		//panel.add(Box.createHorizontalGlue());
		panel.add(boutonReservation,BorderLayout.LINE_START);
		//boutonReservation.setAlignmentX(Component.CENTER_ALIGNMENT);
				
		
		//panel.setLayout(box);
		//panel.add(Box.createHorizontalGlue());
		panel.add(boutonAdministration,BorderLayout.LINE_END);
		//boutonAdministration.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//panel.setLayout(box);
		//panel.add(Box.createVerticalGlue());
	

		// Fond du panel
		// couleur : gris foncé
		panel.setBackground(GrisFonce);

		//Ajout du panel
		this.getContentPane().add(panel);
		//taille de la fenêtre
		setSize(800,600);
		//La fenêtre n'est pas redimensionnable
		setResizable(false);
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
