package vue.categorie;

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
import classe_defaut.Categorie;
import vue.ville.FenetreGestionVille;

/**
 * Menu des catégories il y a plusieurs boutons qui peuvent ajouter, modifier,
 * supprimer des catégories. Un autre bouton donne accès aux chambres
 * 
 * @author BRIERE / CARDON
 *
 */
public class FenetreGestionCategorie extends JFrame implements ActionListener {
	JButton boutonAdd = new JButton("Ajouter categorie");
	JButton boutonModif = new JButton("Modifier categorie");
	JButton boutonDelete = new JButton("Supprimer categorie");
	JButton boutonVoir = new JButton("Voir les categories");
	JButton boutonGestionChambre = new JButton("Gestion chambres");;
	JButton boutonAnnuler = new JButton("Retour");
	Connect connect;
	int cleHotel;

	public FenetreGestionCategorie(String hotel, int cleHotel, Connect connect) {
		super("gestion de l'hotel " + hotel);
		this.connect = connect;
		this.cleHotel = cleHotel;

		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color(0xCFBFAD);

		// Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 24);

		boutonAdd.addActionListener(this);
		boutonDelete.addActionListener(this);
		boutonVoir.addActionListener(this);
		boutonGestionChambre.addActionListener(this);
		boutonModif.addActionListener(this);
		boutonAnnuler.addActionListener(this);

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
		boutonVoir.setOpaque(false);
		boutonVoir.setContentAreaFilled(false);
		// Changement couleur bordure
		boutonVoir.setBorder(border);
		// Changement Police
		boutonVoir.setFont(font_bouton);
		// Changement couleur Police
		boutonVoir.setForeground(BlancPale);

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
		boutonVoir.setOpaque(false);
		boutonVoir.setContentAreaFilled(false);
		// Changement couleur bordure
		boutonVoir.setBorder(border);
		// Changement Police
		boutonVoir.setFont(font_bouton);
		// Changement couleur Police
		boutonVoir.setForeground(BlancPale);

		// Fond transparent
		boutonModif.setOpaque(false);
		boutonModif.setContentAreaFilled(false);
		// Changement couleur bordure
		boutonModif.setBorder(border);
		// Changement Police
		boutonModif.setFont(font_bouton);
		// Changement couleur Police
		boutonModif.setForeground(BlancPale);

		// Fond transparent
		boutonGestionChambre.setOpaque(false);
		boutonGestionChambre.setContentAreaFilled(false);
		// Changement couleur bordure
		boutonGestionChambre.setBorder(border);
		// Changement Police
		boutonGestionChambre.setFont(font_bouton);
		// Changement couleur Police
		boutonGestionChambre.setForeground(BlancPale);

		// Fond transparent
		boutonAnnuler.setOpaque(false);
		boutonAnnuler.setContentAreaFilled(false);
		// Changement couleur bordure
		boutonAnnuler.setBorder(border);
		// Changement Police
		boutonAnnuler.setFont(font_bouton);
		// Changement couleur Police
		boutonAnnuler.setForeground(BlancPale);

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(boutonAdd, c);

		c.gridx = 1;
		c.gridy = 0;
		panel.add(boutonModif, c);

		c.gridx = 2;
		c.gridy = 0;
		panel.add(boutonDelete, c);

		c.gridx = 0;
		c.gridy = 1;
		panel.add(boutonVoir, c);

		c.gridx = 1;
		c.gridy = 1;
		panel.add(boutonGestionChambre, c);

		c.gridx = 0;
		c.gridy = 2;
		c.weighty = 0.05;
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
			new FenetreAjouterCategorie(cleHotel, this.connect);
		}
		if (o == this.boutonDelete) {
			dispose();
			new FenetreSupprimerCategorie(cleHotel, this.connect);
		}
		if (o == this.boutonAnnuler) {
			dispose();
			new FenetreGestionVille(this.connect);
		}
		if (o == this.boutonVoir) {
			dispose();
			ArrayList<Categorie> categorie;
			categorie = this.connect.gestionCategorie.voirCategorie(cleHotel);
			new FenetreVoirCategorie(this.connect, categorie);
		}
		if (o == this.boutonGestionChambre) {
			dispose();
			ArrayList<Categorie> categorie;
			categorie = this.connect.gestionCategorie.voirCategorie(cleHotel);
			new FenetreChoixCategorie(cleHotel, this.connect, categorie);
		}
		if (o == this.boutonModif) {
			dispose();
			new FenetreModifCategorie(cleHotel, this.connect);
		}

	}

}
