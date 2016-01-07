package vue.categorie;

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
import traitement.categorie.TraitementModificationCategorie;

/**
 * Fenêtre pour modifier une catégorie. D'abord on cherche la catégorie et
 * ensuite on la modifie
 * 
 * @author BRIERE / CARDON
 *
 */
public class FenetreModifCategorie extends JFrame {

	private JTextField nom = new JTextField();
	private JTextField place = new JTextField();
	private JTextField prix = new JTextField();
	public Connect connect;
	private JButton bouttonValider = new JButton("Rechercher");
	private JButton bouttonAnnuler = new JButton("Annuler");
	int cleHotel;
	private int cleCategorie;

	public FenetreModifCategorie(int cleHotel, Connect connect) {
		super("Modification d'une categorie");
		this.connect = connect;
		this.cleHotel = cleHotel;

		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color(0xCFBFAD);

		// Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 24);

		getBouttonValider().addActionListener(new TraitementModificationCategorie(this, this.connect, this.cleHotel));
		getBouttonAnnuler().addActionListener(new TraitementModificationCategorie(this, this.connect, this.cleHotel));

		// Fond transparent
		getBouttonAnnuler().setOpaque(false);
		getBouttonAnnuler().setContentAreaFilled(false);
		// Changement couleur bordure
		getBouttonAnnuler().setBorder(border);
		// Changement Police
		getBouttonAnnuler().setFont(font_bouton);
		// Changement couleur Police
		getBouttonAnnuler().setForeground(BlancPale);

		// Fond transparent
		getBouttonValider().setOpaque(false);
		getBouttonValider().setContentAreaFilled(false);
		// Changement couleur bordure
		getBouttonValider().setBorder(border);
		// Changement Police
		getBouttonValider().setFont(font_bouton);
		// Changement couleur Police
		getBouttonValider().setForeground(BlancPale);

		getNom().setPreferredSize(new Dimension(250, 30));
		getPlace().setPreferredSize(new Dimension(250, 30));
		getPrix().setPreferredSize(new Dimension(250, 30));

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
		panel3.add(v, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel3.add(getPlace(), c);

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
		panel4.add(n, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel4.add(getNom(), c);

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
		panel5.add(p, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		panel5.add(getPrix(), c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(panel3, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(panel4, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(panel5, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 3;
		panel.add(getBouttonValider(), c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 3;
		panel.add(getBouttonAnnuler(), c);

		// Fond du panel
		// couleur : gris foncé
		panel3.setBackground(GrisFonce);
		panel4.setBackground(GrisFonce);
		panel5.setBackground(GrisFonce);
		panel.setBackground(GrisFonce);

		getPrix().setVisible(false);
		getPlace().setVisible(false);

		this.getContentPane().add(panel);
		setSize(500, 300);
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
	 * @param bouttonValider
	 *            the bouttonValider to set
	 */
	public void setBouttonValider(JButton bouttonValider) {
		this.bouttonValider = bouttonValider;
	}

	/**
	 * @return the nom
	 */
	public JTextField getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(JTextField nom) {
		this.nom = nom;
	}

	/**
	 * @return the place
	 */
	public JTextField getPlace() {
		return place;
	}

	/**
	 * @param place
	 *            the place to set
	 */
	public void setPlace(JTextField place) {
		this.place = place;
	}

	/**
	 * @return the prix
	 */
	public JTextField getPrix() {
		return prix;
	}

	/**
	 * @param prix
	 *            the prix to set
	 */
	public void setPrix(JTextField prix) {
		this.prix = prix;
	}

	/**
	 * @return the cleCategorie
	 */
	public int getCleCategorie() {
		return cleCategorie;
	}

	/**
	 * @param cleCategorie
	 *            the cleCategorie to set
	 */
	public void setCleCategorie(int cleCategorie) {
		this.cleCategorie = cleCategorie;
	}

	/**
	 * @return the bouttonAnnuler
	 */
	public JButton getBouttonAnnuler() {
		return bouttonAnnuler;
	}

	/**
	 * @param bouttonAnnuler
	 *            the bouttonAnnuler to set
	 */
	public void setBouttonAnnuler(JButton bouttonAnnuler) {
		this.bouttonAnnuler = bouttonAnnuler;
	}

}
