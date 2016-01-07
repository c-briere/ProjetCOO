package vue.trajet;

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

import BDD.Connect;
import traitement.trajet.TraitementSuppressionPlanning;

/**
 * Fenêtre pour supprimer un trajet
 * 
 * @author BRIERE / CARDON
 *
 */
public class FenetreSupprimerPlanning extends JFrame {

	private JComboBox<String> jour;
	private JTextField heure = new JTextField();
	private JTextField duree = new JTextField();
	Connect connect;
	int cleLigne;
	private JButton bouttonValider = new JButton("Valider");
	private JButton bouttonAnnuler = new JButton("Annuler");

	public FenetreSupprimerPlanning(Connect connect, int cleLigne) {
		super("Suppression d'un trajet");
		this.connect = connect;
		this.cleLigne = cleLigne;
		getHeure().setPreferredSize(new Dimension(250, 30));
		getDuree().setPreferredSize(new Dimension(250, 30));

		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color(0xCFBFAD);

		// Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 24);

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
		j.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 85));
		panel3.add(j, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		String[] jourSemaine = { "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche" };
		setJour(new JComboBox<String>(jourSemaine));
		getJour().setPreferredSize(new Dimension(250, 30));
		panel3.add(getJour(), c);

		JPanel panel4 = new JPanel(new FlowLayout());
		panel4.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel h = new JLabel("Heure");
		h.setFont(font_bouton);
		h.setForeground(BlancPale);
		// similaire à un margin-left
		h.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 225));
		panel4.add(h, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel4.add(getHeure(), c);

		JPanel panel5 = new JPanel(new FlowLayout());
		panel5.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel d = new JLabel("Durée en min");
		d.setFont(font_bouton);
		d.setForeground(BlancPale);
		// similaire à un margin-left
		d.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 147));
		panel5.add(d, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel5.add(getDuree(), c);

		getBouttonValider().addActionListener(new TraitementSuppressionPlanning(this, this.connect, this.cleLigne));
		getBouttonAnnuler().addActionListener(new TraitementSuppressionPlanning(this, this.connect, this.cleLigne));

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		panel.add(panel3, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		panel.add(panel4, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		panel.add(panel5, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		panel.add(getBouttonValider(), c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		panel.add(getBouttonAnnuler(), c);

		// Fond du panel
		// couleur : gris foncé
		panel3.setBackground(GrisFonce);
		panel4.setBackground(GrisFonce);
		panel5.setBackground(GrisFonce);
		panel.setBackground(GrisFonce);

		this.getContentPane().add(panel);
		setSize(600, 400);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

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
	 * @return the duree
	 */
	public JTextField getDuree() {
		return duree;
	}

	/**
	 * @param duree
	 *            the duree to set
	 */
	public void setDuree(JTextField duree) {
		this.duree = duree;
	}

	/**
	 * @return the heure
	 */
	public JTextField getHeure() {
		return heure;
	}

	/**
	 * @param heure
	 *            the heure to set
	 */
	public void setHeure(JTextField heure) {
		this.heure = heure;
	}

	/**
	 * @return the jour
	 */
	public JComboBox<String> getJour() {
		return jour;
	}

	/**
	 * @param jour
	 *            the jour to set
	 */
	public void setJour(JComboBox<String> jour) {
		this.jour = jour;
	}
}
