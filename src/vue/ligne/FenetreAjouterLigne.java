package vue.ligne;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import BDD.Connect;
import classe_defaut.Ville;
import traitement.ligne.TraitementAjoutLigne;

/**
 * Fenêtre pour ajouter une ligne
 * 
 * @author BRIERE / CARDON
 *
 */
public class FenetreAjouterLigne extends JFrame {
	private JComboBox<String> choixVilleAller;
	private JComboBox<String> choixVilleRetour;

	Connect connect;

	private JButton bouttonValider = new JButton("Valider");
	private JButton bouttonAnnuler = new JButton("Annuler");

	public FenetreAjouterLigne(Connect connect, ArrayList<Ville> ville) {
		super("Choix de la ville");
		this.connect = connect;
		setChoixVilleAller(new JComboBox<>());
		for (int i = 0; i < ville.size(); i++) {
			getChoixVilleAller().addItem(ville.get(i).getNom());
		}

		setChoixVilleRetour(new JComboBox<>());
		for (int i = 0; i < ville.size(); i++) {
			getChoixVilleRetour().addItem(ville.get(i).getNom());
		}

		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color(0xCFBFAD);

		// Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 24);

		getBouttonValider().addActionListener(new TraitementAjoutLigne(this, this.connect));
		getBouttonAnnuler().addActionListener(new TraitementAjoutLigne(this, this.connect));

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
		JLabel v = new JLabel("Choix de la ville de départ");
		v.setFont(font_bouton);
		v.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		v.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		panel3.add(v, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel3.add(getChoixVilleAller(), c);

		JPanel panel4 = new JPanel(new FlowLayout());
		panel4.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel p = new JLabel("Choix de la ville de retour");
		p.setFont(font_bouton);
		p.setForeground(BlancPale);
		// similaire à un margin-left
		p.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 30));
		panel4.add(p, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel4.add(getChoixVilleRetour(), c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(panel3, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(panel4, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(getBouttonValider(), c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 2;
		panel.add(getBouttonAnnuler(), c);

		// Fond du panel
		// couleur : gris foncé
		panel3.setBackground(GrisFonce);
		panel4.setBackground(GrisFonce);
		panel.setBackground(GrisFonce);

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
	 * @return the choixVilleAller
	 */
	public JComboBox<String> getChoixVilleAller() {
		return choixVilleAller;
	}

	/**
	 * @param choixVilleAller
	 *            the choixVilleAller to set
	 */
	public void setChoixVilleAller(JComboBox<String> choixVilleAller) {
		this.choixVilleAller = choixVilleAller;
	}

	/**
	 * @return the choixVilleRetour
	 */
	public JComboBox<String> getChoixVilleRetour() {
		return choixVilleRetour;
	}

	/**
	 * @param choixVilleRetour
	 *            the choixVilleRetour to set
	 */
	public void setChoixVilleRetour(JComboBox<String> choixVilleRetour) {
		this.choixVilleRetour = choixVilleRetour;
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
