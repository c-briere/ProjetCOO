package vue.hotel;

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
import classe_defaut.Hotel;
import vue.ville.FenetreGestionVille;

/**
 * Menu de l'hôtel. On peut ajouter, supprimer, visualiser les hôtels. Mais
 * aussi passer aux catégories
 * 
 * @author BRIERE / CARDON
 *
 */
public class FenetreGestionHotel extends JFrame implements ActionListener {
	JButton boutonAdd = new JButton("Ajouter hotel");
	JButton boutonDelete = new JButton("Supprimer hotel");
	JButton boutonVoir = new JButton("Voir les hotels");
	JButton boutonGestionCatégorie = new JButton("Gestion catégories");;
	JButton boutonAnnuler = new JButton("Retour");
	Connect connect;
	int cle;

	public FenetreGestionHotel(String ville, int cle, Connect connect) {
		super("gestion des hotels de la ville de " + ville);
		this.connect = connect;
		this.cle = cle;

		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color(0xCFBFAD);

		// Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 24);

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
		boutonGestionCatégorie.setOpaque(false);
		boutonGestionCatégorie.setContentAreaFilled(false);
		// Changement couleur bordure
		boutonGestionCatégorie.setBorder(border);
		// Changement Police
		boutonGestionCatégorie.setFont(font_bouton);
		// Changement couleur Police
		boutonGestionCatégorie.setForeground(BlancPale);

		// Fond transparent
		boutonAnnuler.setOpaque(false);
		boutonAnnuler.setContentAreaFilled(false);
		// Changement couleur bordure
		boutonAnnuler.setBorder(border);
		// Changement Police
		boutonAnnuler.setFont(font_bouton);
		// Changement couleur Police
		boutonAnnuler.setForeground(BlancPale);

		boutonAdd.addActionListener(this);
		boutonDelete.addActionListener(this);
		boutonVoir.addActionListener(this);
		boutonGestionCatégorie.addActionListener(this);
		boutonAnnuler.addActionListener(this);

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

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(boutonDelete, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(boutonVoir, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 1;
		panel.add(boutonGestionCatégorie, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.05;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 2;
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
			new FenetreAjouterHotel(cle, this.connect);
		}
		if (o == this.boutonDelete) {
			dispose();
			new FenetreSupprimerHotel(cle, this.connect);
		}
		if (o == this.boutonAnnuler) {
			dispose();
			new FenetreGestionVille(this.connect);
		}
		if (o == this.boutonVoir) {
			dispose();
			ArrayList<Hotel> hotel;
			hotel = this.connect.gestionHotel.voirHotel(cle);
			new FenetreVoirHotel(this.connect, hotel);
		}
		if (o == this.boutonGestionCatégorie) {
			dispose();
			ArrayList<Hotel> hotel;
			hotel = this.connect.gestionHotel.voirHotel(cle);
			new FenetreChoixHotel(cle, this.connect, hotel);
		}

	}

}
