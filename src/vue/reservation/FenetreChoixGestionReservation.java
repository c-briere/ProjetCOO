package vue.reservation;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import BDD.Connect;
import vue.FenetreAccueil;

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
		
		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color (0xCFBFAD);

		//Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 50);		

		//Fond transparent
		bouttonAjouter.setOpaque(false);
		bouttonAjouter.setContentAreaFilled(false);
		//Changement couleur bordure
		bouttonAjouter.setBorder(border);
		//Changement Police
		bouttonAjouter.setFont(font_bouton);
		//Changement couleur Police
		bouttonAjouter.setForeground(BlancPale);
		
		//Fond transparent
		bouttonSupprimer.setOpaque(false);
		bouttonSupprimer.setContentAreaFilled(false);
		//Changement couleur bordure
		bouttonSupprimer.setBorder(border);
		//Changement Police
		bouttonSupprimer.setFont(font_bouton);
		//Changement couleur Police
		bouttonSupprimer.setForeground(BlancPale);	
		
		//Fond transparent
		bouttonVoirResa.setOpaque(false);
		bouttonVoirResa.setContentAreaFilled(false);
		//Changement couleur bordure
		bouttonVoirResa.setBorder(border);
		//Changement Police
		bouttonVoirResa.setFont(font_bouton);
		//Changement couleur Police
		bouttonVoirResa.setForeground(BlancPale);
		
		//Fond transparent
		bouttonAnnuler.setOpaque(false);
		bouttonAnnuler.setContentAreaFilled(false);
		//Changement couleur bordure
		bouttonAnnuler.setBorder(border);
		//Changement Police
		bouttonAnnuler.setFont(font_bouton);
		//Changement couleur Police
		bouttonAnnuler.setForeground(BlancPale);

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(bouttonAjouter,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(bouttonSupprimer,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		panel.add(bouttonVoirResa,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(bouttonAnnuler,c);
		
		// Fond du panel
		// couleur : gris foncé
		panel.setBackground(GrisFonce);
		
		this.getContentPane().add(panel);
		setSize(800,600);
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
		if(source==bouttonAnnuler){
			dispose();
			new FenetreAccueil(connect);
		}
		
		if(source==bouttonVoirResa){
			dispose();
			new FenetreGestionVoirReservation(this.connect);
		}
		
	}
	

}
