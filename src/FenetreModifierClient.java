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

/**
 * 
 * @author BRIERE / CARDON
 *
 */
public class FenetreModifierClient extends JFrame{

	JTextField nom = new JTextField();
	JTextField prenom = new JTextField();
	JTextField date = new JTextField();
	JTextField ville = new JTextField();
	
	public Connect connect;
	
	JButton bouttonValider = new JButton("Rechercher");
	JButton bouttonAnnuler = new JButton("Annuler");
	
	int cle;


	
	public FenetreModifierClient(Connect connect){
		super("Modification d'un client");
		this.connect=connect;
		
		bouttonValider.addActionListener(new TraitementModificationClient(this,this.connect));
		bouttonAnnuler.addActionListener(new TraitementModificationClient(this,this.connect));
		
		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color (0xCFBFAD);

		//Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 24);

		//Fond transparent
		bouttonAnnuler.setOpaque(false);
		bouttonAnnuler.setContentAreaFilled(false);
		//Changement couleur bordure
		bouttonAnnuler.setBorder(border);
		//Changement Police
		bouttonAnnuler.setFont(font_bouton);
		//Changement couleur Police
		bouttonAnnuler.setForeground(BlancPale);
		
		//Fond transparent
		bouttonValider.setOpaque(false);
		bouttonValider.setContentAreaFilled(false);
		//Changement couleur bordure
		bouttonValider.setBorder(border);
		//Changement Police
		bouttonValider.setFont(font_bouton);
		//Changement couleur Police
		bouttonValider.setForeground(BlancPale);

		nom.setPreferredSize(new Dimension(250,30));
		prenom.setPreferredSize(new Dimension(250,30));
		date.setPreferredSize(new Dimension(250,30));
		ville.setPreferredSize(new Dimension(250,30));
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		
		JPanel panel3 = new JPanel(new FlowLayout());
		panel3.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;		
		JLabel v = new JLabel("Ville");
		v.setFont(font_bouton);
		v.setForeground(BlancPale);
		// similaire à un margin-left
		v.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 175));
		panel3.add(v,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel3.add(ville,c);

		
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
		panel4.add(d,c);
		
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
		panel5.add(n,c);
		
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
		panel6.add(p,c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;	
		panel6.add(prenom);		
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 1;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(panel3,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 1;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 3;
		panel.add(panel4,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 1;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(panel5,c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 1;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(panel6,c);
		
		c.gridwidth= 1;
		c.gridx = 0;
		c.gridy = 5;
		panel.add(bouttonValider,c);
		
		c.gridx = 1;
		c.gridy = 5;
		panel.add(bouttonAnnuler,c);
		
		// Fond du panel
		// couleur : gris foncé
		panel3.setBackground(GrisFonce);
		panel4.setBackground(GrisFonce);
		panel5.setBackground(GrisFonce);
		panel6.setBackground(GrisFonce);
		panel.setBackground(GrisFonce);

		
		this.getContentPane().add(panel);
		setSize(500,300);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
