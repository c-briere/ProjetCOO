import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class FenetreAjouterPlanning extends JFrame{

	JComboBox<String> jour ;
	JTextField heure = new JTextField();
	JTextField duree = new JTextField();
	JTextField passager1ereclasse = new JTextField();
	JTextField prix1ereclasse = new JTextField();
	JTextField passager2emeclasse = new JTextField();
	JTextField prix2emeclasse = new JTextField();
	JTextField annulable = new JTextField();
	
	int cleLigne;
	
	
	public Connect connect;
	JButton bouttonValider = new JButton("Valider");
	JButton bouttonAnnuler = new JButton("Annuler");


	
	public FenetreAjouterPlanning(Connect connect,int cleLigne){
		super("Ajout d'un trajet");
		this.connect=connect;
		this.cleLigne=cleLigne;
		bouttonValider.addActionListener(new TraitementAjoutTrajet(this,this.connect,this.cleLigne));
		bouttonAnnuler.addActionListener(new TraitementAjoutTrajet(this,this.connect,this.cleLigne));
		
		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color (0xCFBFAD);

		//Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 24);
		
		
		heure.setPreferredSize(new Dimension(250,30));
		duree.setPreferredSize(new Dimension(250,30));
		passager1ereclasse.setPreferredSize(new Dimension(250,30));
		prix1ereclasse.setPreferredSize(new Dimension(250,30));
		passager2emeclasse.setPreferredSize(new Dimension(250,30));
		prix2emeclasse.setPreferredSize(new Dimension(250,30));
		annulable.setPreferredSize(new Dimension(250,30));

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

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		
		JPanel panel3 = new JPanel(new FlowLayout());
		panel3.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;		
		JLabel j = new JLabel("Jour de la semaine");
		j.setFont(font_bouton);
		j.setForeground(BlancPale);
		// similaire à un margin-left
		j.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 285));
		panel3.add(j,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		String [] jourSemaine = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
		jour = new JComboBox(jourSemaine);
		jour.setPreferredSize(new Dimension(250,30));
		panel3.add(jour,c);

		
		JPanel panel4 = new JPanel(new FlowLayout());
		panel4.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;		
		JLabel h = new JLabel("Heure");
		h.setFont(font_bouton);
		h.setForeground(BlancPale);
		// similaire à un margin-left
		h.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 425));
		panel4.add(h,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel4.add(heure,c);
		
		JPanel panel5 = new JPanel(new FlowLayout());
		panel5.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;		
		JLabel d = new JLabel("Durée en min");
		d.setFont(font_bouton);
		d.setForeground(BlancPale);
		// similaire à un margin-left
		d.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 347));
		panel5.add(d,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;		
		panel5.add(duree,c);
		
		
		JPanel panel6 = new JPanel(new FlowLayout());
		panel6.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;		
		JLabel nb1 = new JLabel("Nombre de passagers en 1ère classe");
		nb1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 95));
		nb1.setFont(font_bouton);
		nb1.setForeground(BlancPale);
		panel6.add(nb1,c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel6.add(passager1ereclasse,c);
		
		JPanel panel7 = new JPanel(new FlowLayout());
		panel7.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;		
		JLabel prix1 = new JLabel("Prix en 1ère classe");
		prix1.setFont(font_bouton);
		prix1.setForeground(BlancPale);
		// similaire à un margin-left
		prix1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 290));
		panel7.add(prix1,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel7.add(prix1ereclasse,c);
		
		JPanel panel8 = new JPanel(new FlowLayout());
		panel8.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;		
		JLabel nb2 = new JLabel("Nombre de passagers en 2nd classe");
		nb2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 102));
		nb2.setFont(font_bouton);
		nb2.setForeground(BlancPale);
		panel8.add(nb2,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel8.add(passager2emeclasse,c);
		
		JPanel panel9 = new JPanel(new FlowLayout());
		panel9.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;		
		JLabel prix2 = new JLabel("Prix en 2nd classe");
		prix2.setFont(font_bouton);
		prix2.setForeground(BlancPale);
		// similaire à un margin-left
		prix2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 297));
		panel9.add(prix2,c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel9.add(prix2emeclasse,c);
		
		JPanel panel10 = new JPanel(new FlowLayout());
		panel10.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;		
		JLabel a = new JLabel("Nombre de jours pour annuler");
		a.setFont(font_bouton);
		a.setForeground(BlancPale);
		// similaire à un margin-left
		a.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 175));
		panel10.add(a,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel10.add(annulable,c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		panel.add(panel3,c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		panel.add(panel4,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		panel.add(panel5,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		panel.add(panel6,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 2;
		panel.add(panel7,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 2;
		panel.add(panel8,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 2;
		panel.add(panel9,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 7;
		c.gridwidth = 2;
		panel.add(panel10,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 8;
		c.gridwidth = 1;
		panel.add(bouttonValider,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 8;
		c.gridwidth = 1;		
		panel.add(bouttonAnnuler,c);

		// Fond du panel
		// couleur : gris foncé
		panel3.setBackground(GrisFonce);
		panel4.setBackground(GrisFonce);
		panel5.setBackground(GrisFonce);
		panel6.setBackground(GrisFonce);
		panel7.setBackground(GrisFonce);
		panel8.setBackground(GrisFonce);
		panel9.setBackground(GrisFonce);
		panel10.setBackground(GrisFonce);
		panel.setBackground(GrisFonce);

		this.getContentPane().add(panel);
		setSize(800,600);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
