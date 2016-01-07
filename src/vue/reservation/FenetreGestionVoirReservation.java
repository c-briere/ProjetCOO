package vue.reservation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import BDD.Connect;
import traitement.reservation.TraitementVoirReservation;

/**
 * Fenêtre pour affiche les réservations dans un tableau
 * 
 * @author BRIERE / CARDON
 *
 */
public class FenetreGestionVoirReservation extends JFrame {
	Connect connect;
	public JTextField nom;
	public JTextField prenom;
	public JTextField date;
	public JButton bouttonVoir;
	public JButton bouttonAnnuler;

	public FenetreGestionVoirReservation(Connect connect) {
		super("Afficher réservation");
		this.connect = connect;
		nom = new JTextField();
		prenom = new JTextField();
		date = new JTextField();

		bouttonVoir = new JButton("Voir reservation");
		bouttonAnnuler = new JButton("Annuler");

		bouttonVoir.addActionListener(new TraitementVoirReservation(this, this.connect));
		bouttonAnnuler.addActionListener(new TraitementVoirReservation(this, this.connect));

		nom.setPreferredSize(new Dimension(250, 30));
		prenom.setPreferredSize(new Dimension(250, 30));
		date.setPreferredSize(new Dimension(250, 30));

		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color(0xCFBFAD);

		// Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 24);

		// Fond transparent
		bouttonAnnuler.setOpaque(false);
		bouttonAnnuler.setContentAreaFilled(false);
		// Changement couleur bordure
		bouttonAnnuler.setBorder(border);
		// Changement Police
		bouttonAnnuler.setFont(font_bouton);
		// Changement couleur Police
		bouttonAnnuler.setForeground(BlancPale);

		// Fond transparent
		bouttonVoir.setOpaque(false);
		bouttonVoir.setContentAreaFilled(false);
		// Changement couleur bordure
		bouttonVoir.setBorder(border);
		// Changement Police
		bouttonVoir.setFont(font_bouton);
		// Changement couleur Police
		bouttonVoir.setForeground(BlancPale);

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JPanel panel4 = new JPanel(new FlowLayout());
		panel4.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel d = new JLabel("Date de naissance");
		d.setFont(font_bouton);
		d.setForeground(BlancPale);
		// similaire à un margin-left
		d.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		panel4.add(d, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel4.add(date);

		JPanel panel5 = new JPanel(new FlowLayout());
		panel5.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel n = new JLabel("Nom");
		n.setFont(font_bouton);
		n.setForeground(BlancPale);
		// similaire à un margin-left
		n.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 170));
		panel5.add(n, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel5.add(nom);

		JPanel panel6 = new JPanel(new FlowLayout());
		panel6.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel p = new JLabel("Prénom");
		p.setFont(font_bouton);
		p.setForeground(BlancPale);
		// similaire à un margin-left
		p.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 140));
		panel6.add(p, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel6.add(prenom);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(panel4, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(panel5, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(panel6, c);

		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 3;
		panel.add(bouttonVoir, c);

		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 3;
		panel.add(bouttonAnnuler, c);

		// Fond du panel
		// couleur : gris foncé
		panel4.setBackground(GrisFonce);
		panel5.setBackground(GrisFonce);
		panel6.setBackground(GrisFonce);
		panel.setBackground(GrisFonce);

		this.getContentPane().add(panel);
		setSize(500, 300);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
