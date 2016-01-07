package vue.client;

import java.awt.Color;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import BDD.Connect;
import classe_defaut.Client;
import vue.FenetreAdministration;

/**
 * Menu de la partie des clients. On peut y ajouter, supprimer, modifier ou
 * visualiser des clients
 * 
 * @author BRIERE / CARDON
 *
 */
public class FenetreGestionClient extends JFrame implements ActionListener {
	JButton boutonAdd = new JButton("Ajouter");
	JButton boutonDelete = new JButton("Supprimer");
	JButton boutonModifier = new JButton("Modifier");
	JButton boutonVoir = new JButton("Voir la liste des clients");
	JButton boutonAnnuler = new JButton("Annuler");
	public Connect connect;

	public FenetreGestionClient(Connect connect) {
		super("Gestion des clients");
		this.connect = connect;

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
		boutonModifier.setOpaque(false);
		boutonModifier.setContentAreaFilled(false);
		// Changement couleur bordure
		boutonModifier.setBorder(border);
		// Changement Police
		boutonModifier.setFont(font_bouton);
		// Changement couleur Police
		boutonModifier.setForeground(BlancPale);

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
		boutonModifier.addActionListener(this);
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
		// c.weightx = 0.15;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(boutonDelete, c);

		c.fill = GridBagConstraints.BOTH;
		// c.weightx = 0.15;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(boutonVoir, c);

		c.fill = GridBagConstraints.BOTH;
		// c.weightx = 0.15;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 1;
		panel.add(boutonModifier, c);

		c.fill = GridBagConstraints.BOTH;
		// c.weightx = 0.15;
		c.weighty = 0.02;
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

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == boutonAdd) {
			dispose();
			new FenetreAjouterClient(this.connect);
		}

		if (source == boutonVoir) {
			ArrayList<Client> client = new ArrayList<Client>();
			try {
				client = connect.gestionClient.voirListeClient();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			dispose();
			new FenetreVoirListClient(this.connect, client);

		}
		if (source == boutonDelete) {
			dispose();
			new FenetreSupprimerClient(connect);
		}
		if (source == boutonModifier) {
			dispose();
			new FenetreModifierClient(connect);
		}
		if (source == boutonAnnuler) {
			dispose();
			new FenetreAdministration(this.connect);
		}
	}

}
