package vue.ligne;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import BDD.Connect;
import classe_defaut.Ligne;
import classe_defaut.Ville;
import vue.FenetreAdministration;

/**
 * Menu de la partie Ligne On peut ajouter, supprimer ou modifier une ligne
 * 
 * @author BRIERE / CARDON
 *
 */
public class FenetreGestionLigne extends JFrame implements ActionListener {
	JButton boutonAdd = new JButton("Ajouter une ligne");
	JButton boutonDelete = new JButton("Supprimer une ligne");
	JButton boutonModification = new JButton("Modifier une ligne");
	JButton boutonAnnuler = new JButton("Annuler");

	Connect connect;

	public FenetreGestionLigne(Connect connect) {
		super("gestion des lignes");
		this.connect = connect;

		boutonAdd.addActionListener(this);
		boutonDelete.addActionListener(this);
		boutonModification.addActionListener(this);
		boutonAnnuler.addActionListener(this);

		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color(0xCFBFAD);

		// Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 36);

		// Fond transparent
		boutonAdd.setOpaque(false);
		boutonAdd.setContentAreaFilled(false);
		// Changement couleur bordure
		boutonAdd.setBorder(border);
		// Changement Police
		boutonAdd.setFont(font_bouton);
		// Changement couleur Police
		boutonAdd.setForeground(BlancPale);

		// Fond transparent
		boutonDelete.setOpaque(false);
		boutonDelete.setContentAreaFilled(false);
		// Changement couleur bordure
		boutonDelete.setBorder(border);
		// Changement Police
		boutonDelete.setFont(font_bouton);
		// Changement couleur Police
		boutonDelete.setForeground(BlancPale);

		// Fond transparent
		boutonAnnuler.setOpaque(false);
		boutonAnnuler.setContentAreaFilled(false);
		// Changement couleur bordure
		boutonAnnuler.setBorder(border);
		// Changement Police
		boutonAnnuler.setFont(font_bouton);
		// Changement couleur Police
		boutonAnnuler.setForeground(BlancPale);

		// Fond transparent
		boutonModification.setOpaque(false);
		boutonModification.setContentAreaFilled(false);
		// Changement couleur bordure
		boutonModification.setBorder(border);
		// Changement Police
		boutonModification.setFont(font_bouton);
		// Changement couleur Police
		boutonModification.setForeground(BlancPale);

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(boutonAdd, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(boutonDelete, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(boutonAnnuler, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		panel.add(boutonModification, c);

		// Fond du panel
		// couleur : gris foncé
		panel.setBackground(GrisFonce);

		// Ajout du panel
		this.getContentPane().add(panel);
		// taille de la fenêtre
		setSize(800, 600);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		ArrayList<Ville> ville = this.connect.gestionVille.voirListeVille();

		if (o == this.boutonAdd) {
			dispose();
			new FenetreAjouterLigne(this.connect, ville);
		}
		if (o == this.boutonDelete) {
			dispose();
			new FenetreSupprimerLigne(this.connect, ville);
		}
		if (o == this.boutonAnnuler) {
			dispose();
			new FenetreAdministration(this.connect);
		}
		if (o == this.boutonModification) {
			ArrayList<Ligne> ligne = this.connect.gestionLigne.allLigne();
			dispose();
			new FenetreChoixLigne(this.connect, ligne);
		}

	}

}
