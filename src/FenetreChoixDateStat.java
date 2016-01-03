import java.awt.BorderLayout;
import java.awt.Color;
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
		
		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color (0xCFBFAD);

		//Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 24);

		bouttonVoir = new JButton("Valider");
		bouttonAnnuler = new JButton("Annuler");

		bouttonVoir.addActionListener(new TraitementGestionStat(this,this.connect));
		bouttonAnnuler.addActionListener(new TraitementGestionStat(this,this.connect));

		date1.setPreferredSize(new Dimension(250,30));
		date2.setPreferredSize(new Dimension(250,30));

		panelSelectionClient = new JPanel();
		panelSelectionClient.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

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
		bouttonVoir.setOpaque(false);
		bouttonVoir.setContentAreaFilled(false);
		//Changement couleur bordure
		bouttonVoir.setBorder(border);
		//Changement Police
		bouttonVoir.setFont(font_bouton);
		//Changement couleur Police
		bouttonVoir.setForeground(BlancPale);

		JPanel panel3 = new JPanel(new FlowLayout());
		panel3.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel v = new JLabel("Début de la période");
		v.setFont(font_bouton);
		v.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		v.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 18));
		panel3.add(v,c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel3.add(date1,c);
		
		JPanel panel4 = new JPanel(new FlowLayout());
		panel4.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel d2 = new JLabel("Fin de la période");
		d2.setFont(font_bouton);
		d2.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		d2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 50));
		panel4.add(d2,c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel4.add(date2,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		panelSelectionClient.add(panel3,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		panelSelectionClient.add(panel4,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 2;
		panelSelectionClient.add(bouttonVoir,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 2;
		panelSelectionClient.add(bouttonAnnuler,c);

		// Fond du panel
		// couleur : gris foncé
		panel3.setBackground(GrisFonce);
		panel4.setBackground(GrisFonce);
		panelSelectionClient.setBackground(GrisFonce);

		this.getContentPane().add(panelSelectionClient);
		setSize(500,300);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
