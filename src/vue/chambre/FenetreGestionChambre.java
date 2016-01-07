package vue.chambre;

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
import classe_defaut.Chambre;
import vue.ville.FenetreGestionVille;

/**
 * Menu des chambres. On peut y ajouter, supprimer et visualiser des chambres
 * 
 * @author BRIERE / CARDON
 *
 */
public class FenetreGestionChambre extends JFrame implements ActionListener {
	JButton boutonAdd = new JButton("Ajouter chambre");
	JButton boutonDelete = new JButton("Supprimer chambre");
	JButton boutonVoir = new JButton("Voir les chambres");
	JButton boutonAnnuler = new JButton("Annuler");
	Connect connect;
	int cleCategorie;

	public FenetreGestionChambre(String categorie, int cleCategorie, Connect connect) {
		super("gestion de la categorie  " + categorie);
		this.connect = connect;
		this.cleCategorie = cleCategorie;

		boutonAdd.addActionListener(this);
		boutonDelete.addActionListener(this);
		boutonVoir.addActionListener(this);
		boutonAnnuler.addActionListener(this);

		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color(0xCFBFAD);

		// Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 36);

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
		boutonAdd.setOpaque(false);
		boutonAdd.setContentAreaFilled(false);
		// Changement couleur bordure
		boutonAdd.setBorder(border);
		// Changement Police
		boutonAdd.setFont(font_bouton);
		// Changement couleur Police
		boutonAdd.setForeground(BlancPale);

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
		boutonVoir.setOpaque(false);
		boutonVoir.setContentAreaFilled(false);
		// Changement couleur bordure
		boutonVoir.setBorder(border);
		// Changement Police
		boutonVoir.setFont(font_bouton);
		// Changement couleur Police
		boutonVoir.setForeground(BlancPale);

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
		c.gridx = 1;
		c.gridy = 1;
		panel.add(boutonVoir, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(boutonAnnuler, c);

		this.getContentPane().add(panel);

		// Fond du panel
		// couleur : gris foncé
		panel.setBackground(GrisFonce);

		setSize(800, 600);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == this.boutonAdd) {
			dispose();
			new FenetreAjouterChambre(cleCategorie, this.connect);
		}
		if (o == this.boutonDelete) {
			dispose();
			new FenetreSupprimerChambre(cleCategorie, this.connect);
		}
		if (o == this.boutonAnnuler) {
			dispose();
			new FenetreGestionVille(this.connect);
		}
		if (o == this.boutonVoir) {
			dispose();
			ArrayList<Chambre> chambre;
			chambre = this.connect.gestionChambre.voirChambre(cleCategorie);
			new FenetreVoirChambre(this.connect, chambre);
		}

	}

}
