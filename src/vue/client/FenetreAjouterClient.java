package vue.client;
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
import traitement.client.TraitementAjoutClient;

/**
 * 
 * @author BRIERE / CARDON
 *
 */
public class FenetreAjouterClient extends JFrame{

	private JTextField nom = new JTextField();
	private JTextField prenom = new JTextField();
	private JTextField date = new JTextField();
	private JTextField ville = new JTextField();
	
	public Connect connect;
	
	private JButton bouttonValider = new JButton("Valider");
	private JButton bouttonAnnuler = new JButton("Annuler");


	
	public FenetreAjouterClient(Connect connect){
		super("Ajout d'un client");
		this.connect=connect;
		
		getBouttonValider().addActionListener(new TraitementAjoutClient(this,this.connect));
		getBouttonAnnuler().addActionListener(new TraitementAjoutClient(this,this.connect));
		
		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color (0xCFBFAD);

		//Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 24);

		//Fond transparent
		getBouttonAnnuler().setOpaque(false);
		getBouttonAnnuler().setContentAreaFilled(false);
		//Changement couleur bordure
		getBouttonAnnuler().setBorder(border);
		//Changement Police
		getBouttonAnnuler().setFont(font_bouton);
		//Changement couleur Police
		getBouttonAnnuler().setForeground(BlancPale);
		
		//Fond transparent
		getBouttonValider().setOpaque(false);
		getBouttonValider().setContentAreaFilled(false);
		//Changement couleur bordure
		getBouttonValider().setBorder(border);
		//Changement Police
		getBouttonValider().setFont(font_bouton);
		//Changement couleur Police
		getBouttonValider().setForeground(BlancPale);

		getNom().setPreferredSize(new Dimension(250,30));
		getPrenom().setPreferredSize(new Dimension(250,30));
		getDate().setPreferredSize(new Dimension(250,30));
		getVille().setPreferredSize(new Dimension(250,30));
		
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
		panel3.add(getVille(),c);

		
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
		panel4.add(getDate());
		
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
		panel5.add(getNom());
		
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
		panel6.add(getPrenom());		
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 1;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(panel3,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 1;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(panel4,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 1;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(panel4,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 1;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 3;
		panel.add(panel5,c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 1;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 4;
		panel.add(panel6,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth= 1;
		c.gridx = 0;
		c.gridy = 5;
		panel.add(getBouttonValider(),c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 5;
		panel.add(getBouttonAnnuler(),c);
		
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



	/**
	 * @return the bouttonValider
	 */
	public JButton getBouttonValider() {
		return bouttonValider;
	}



	/**
	 * @param bouttonValider the bouttonValider to set
	 */
	public void setBouttonValider(JButton bouttonValider) {
		this.bouttonValider = bouttonValider;
	}



	/**
	 * @return the date
	 */
	public JTextField getDate() {
		return date;
	}



	/**
	 * @param date the date to set
	 */
	public void setDate(JTextField date) {
		this.date = date;
	}



	/**
	 * @return the nom
	 */
	public JTextField getNom() {
		return nom;
	}



	/**
	 * @param nom the nom to set
	 */
	public void setNom(JTextField nom) {
		this.nom = nom;
	}



	/**
	 * @return the prenom
	 */
	public JTextField getPrenom() {
		return prenom;
	}



	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(JTextField prenom) {
		this.prenom = prenom;
	}



	/**
	 * @return the ville
	 */
	public JTextField getVille() {
		return ville;
	}



	/**
	 * @param ville the ville to set
	 */
	public void setVille(JTextField ville) {
		this.ville = ville;
	}



	/**
	 * @return the bouttonAnnuler
	 */
	public JButton getBouttonAnnuler() {
		return bouttonAnnuler;
	}



	/**
	 * @param bouttonAnnuler the bouttonAnnuler to set
	 */
	public void setBouttonAnnuler(JButton bouttonAnnuler) {
		this.bouttonAnnuler = bouttonAnnuler;
	}

}
