package vue.ligne;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import classe_defaut.Ligne;
import vue.trajet.FenetreGestionPlanningLigne;

/**
 * Fenêtre qui permet de choix la ligne
 * 
 * @author BRIERE / CARDON
 *
 */
public class FenetreChoixLigne extends JFrame implements ActionListener {
	JComboBox<String> choixLigne;
	Connect connect;
	JButton bouttonValider = new JButton("Valider");
	JButton bouttonAnnuler = new JButton("Annuler");

	public FenetreChoixLigne(Connect connect, ArrayList<Ligne> ligne) {
		super("Choix de la ligne");
		this.connect = connect;
		choixLigne = new JComboBox<>();
		for (int i = 0; i < ligne.size(); i++) {
			choixLigne.addItem(ligne.get(i).getVilleAller().getNom() + " " + ligne.get(i).getVilleRetour().getNom());
		}

		bouttonValider.addActionListener(this);
		bouttonAnnuler.addActionListener(this);

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
		bouttonValider.setOpaque(false);
		bouttonValider.setContentAreaFilled(false);
		// Changement couleur bordure
		bouttonValider.setBorder(border);
		// Changement Police
		bouttonValider.setFont(font_bouton);
		// Changement couleur Police
		bouttonValider.setForeground(BlancPale);

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JPanel panel3 = new JPanel(new FlowLayout());
		panel3.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel v = new JLabel("Choix de la ligne");
		v.setFont(font_bouton);
		v.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		v.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		panel3.add(v, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel3.add(choixLigne, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(panel3, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(bouttonValider, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 1;
		panel.add(bouttonAnnuler, c);

		// Fond du panel
		// couleur : gris foncé
		panel3.setBackground(GrisFonce);
		panel.setBackground(GrisFonce);

		this.getContentPane().add(panel);
		setSize(500, 300);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == bouttonAnnuler) {
			dispose();
			new FenetreGestionLigne(connect);
		}

		if (o == bouttonValider) {
			String str[] = choixLigne.getSelectedItem().toString().split(" ");
			String villeD = str[0];
			String villeA = str[1];
			int cleLigne = this.connect.gestionLigne.cleLigne(villeD, villeA);
			dispose();
			new FenetreGestionPlanningLigne(this.connect, cleLigne, str);
		}

	}

}
