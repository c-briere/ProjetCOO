import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
	JButton boutonReservation = new JButton("Réservation");
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
		

		//Fond transparent
		boutonReservation.setOpaque(false);
		boutonReservation.setContentAreaFilled(false);
		//Changement couleur bordure
		boutonReservation.setBorder(border);
		//Changement Police
		boutonReservation.setFont(font_bouton);
		//Changement couleur Police
		boutonReservation.setForeground(BlancPale);
		

		boutonAdministration.setOpaque(false);
		boutonAdministration.setContentAreaFilled(false);
		boutonAdministration.setBorder(border);
		boutonAdministration.setFont(font_bouton);
		boutonAdministration.setForeground(BlancPale);
		
		boutonReservation.addActionListener(this);
		boutonAdministration.addActionListener(this);
		
		JPanel panel = new JPanel();		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();		

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(boutonReservation,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 1;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(boutonAdministration,c);
	

		// Fond du panel
		// couleur : gris foncé
		panel.setBackground(GrisFonce);

		//Ajout du panel
		this.getContentPane().add(panel);
		//taille de la fenêtre
		setSize(800,600);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) { 
		Object source = e.getSource();
		if(source==boutonReservation){
			dispose();
			new FenetreChoixGestionReservation(this.connect);
			
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
