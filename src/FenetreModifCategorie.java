import java.awt.BorderLayout;
<<<<<<< HEAD
import java.awt.Color;
=======
>>>>>>> origin/master
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
public class FenetreModifCategorie extends JFrame{

	JTextField nom = new JTextField();
	JTextField place = new JTextField();
	JTextField prix = new JTextField();
	public Connect connect;
	JButton bouttonValider = new JButton("Rechercher");
	JButton bouttonAnnuler = new JButton("Annuler");
	int cleHotel;
	int cleCategorie;


	
	public FenetreModifCategorie(int cleHotel,Connect connect){
		super("Modification d'une categorie");
		this.connect=connect;
		this.cleHotel=cleHotel;
		
		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color (0xCFBFAD);

		//Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 24);
		
		
		bouttonValider.addActionListener(new TraitementModificationCategorie(this,this.connect,this.cleHotel));
		bouttonAnnuler.addActionListener(new TraitementModificationCategorie(this,this.connect,this.cleHotel));
		
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
		place.setPreferredSize(new Dimension(250,30));
		prix.setPreferredSize(new Dimension(250,30));
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();


		JPanel panel3 = new JPanel(new FlowLayout());
		panel3.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;		
		JLabel v = new JLabel("Nombre de place");
		v.setFont(font_bouton);
		v.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		v.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		panel3.add(v,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel3.add(place,c);
		

		JPanel panel4 = new JPanel(new FlowLayout());
		panel4.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;		
		JLabel n = new JLabel("Nom");
		n.setFont(font_bouton);
		n.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		n.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 155));
		panel4.add(n,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel4.add(nom,c);
		
		
		JPanel panel5 = new JPanel(new FlowLayout());
		panel5.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;	
		JLabel p = new JLabel("Prix");
		p.setFont(font_bouton);
		p.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		p.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 163));
		panel5.add(p,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		panel5.add(prix,c);
		
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(panel3,c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(panel4,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(panel5,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 3;
		panel.add(bouttonValider,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 3;
		panel.add(bouttonAnnuler,c);

		

		// Fond du panel
		// couleur : gris foncé
		panel3.setBackground(GrisFonce);
		panel4.setBackground(GrisFonce);
		panel5.setBackground(GrisFonce);
		panel.setBackground(GrisFonce);
		
		prix.hide();
		place.hide();


		this.getContentPane().add(panel);
		setSize(500,300);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
