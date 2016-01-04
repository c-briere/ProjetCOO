package vue.ville;
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
import classe_defaut.Ville;
import vue.FenetreAdministration;

/**
 * 
 * @author BRIERE / CARDON
 *
 */
public class FenetreGestionVille extends JFrame implements ActionListener {
	JButton boutonAdd = new JButton("Ajouter ville");
	JButton boutonDelete = new JButton("Supprimer ville");
	JButton boutonVoir = new JButton("Voir les villes");
	JButton boutonGestionHotel = new JButton("Gestion hotels");;
	JButton boutonAnnuler = new JButton("Annuler");
	public Connect connect;

	public FenetreGestionVille(Connect connect){
		super("Gestion des villes");
		this.connect=connect;

		boutonAdd.addActionListener(this);
		boutonDelete.addActionListener(this);
		boutonVoir.addActionListener(this);
		boutonGestionHotel.addActionListener(this);
		boutonAnnuler.addActionListener(this);

		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color (0xCFBFAD);

		//Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 38);
		
		//Fond transparent
		boutonVoir.setOpaque(false);
		boutonVoir.setContentAreaFilled(false);
		//Changement couleur bordure
		boutonVoir.setBorder(border);
		//Changement Police
		boutonVoir.setFont(font_bouton);
		//Changement couleur Police
		boutonVoir.setForeground(BlancPale);
		
		//Fond transparent
		boutonAdd.setOpaque(false);
		boutonAdd.setContentAreaFilled(false);
		//Changement couleur bordure
		boutonAdd.setBorder(border);
		//Changement Police
		boutonAdd.setFont(font_bouton);
		//Changement couleur Police
		boutonAdd.setForeground(BlancPale);
		
		//Fond transparent
		boutonDelete.setOpaque(false);
		boutonDelete.setContentAreaFilled(false);
		//Changement couleur bordure
		boutonDelete.setBorder(border);
		//Changement Police
		boutonDelete.setFont(font_bouton);
		//Changement couleur Police
		boutonDelete.setForeground(BlancPale);
		
		//Fond transparent
		boutonGestionHotel.setOpaque(false);
		boutonGestionHotel.setContentAreaFilled(false);
		//Changement couleur bordure
		boutonGestionHotel.setBorder(border);
		//Changement Police
		boutonGestionHotel.setFont(font_bouton);
		//Changement couleur Police
		boutonGestionHotel.setForeground(BlancPale);
		
		//Fond transparent
		boutonAnnuler.setOpaque(false);
		boutonAnnuler.setContentAreaFilled(false);
		//Changement couleur bordure
		boutonAnnuler.setBorder(border);
		//Changement Police
		boutonAnnuler.setFont(font_bouton);
		//Changement couleur Police
		boutonAnnuler.setForeground(BlancPale);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();		

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.25;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(boutonVoir,c);
		
		c.fill = GridBagConstraints.BOTH;
		//c.weightx = 0.25;
		//c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(boutonAdd,c);
		
		c.fill = GridBagConstraints.BOTH;
		//c.weightx = 0.25;
		//c.weighty = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		panel.add(boutonDelete,c);
		
		c.fill = GridBagConstraints.BOTH;
		//c.weightx = 0.5;
		//c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		panel.add(boutonGestionHotel,c);
		
		c.fill = GridBagConstraints.BOTH;
		//c.weightx = 0.5;
		c.weighty = 0.05;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(boutonAnnuler,c);

		
		// Fond du panel
		// couleur : gris foncé
		panel.setBackground(GrisFonce);
		
		this.getContentPane().add(panel);
		setSize(800,600);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o =e.getSource();
		if(o==boutonAdd){
			dispose();
			new FenetreAjouterVille(this.connect);
		}
		
		if(o==boutonDelete){
			dispose();
			new FenetreSupprimerVille(this.connect);
		}
		if(o==boutonVoir){
			ArrayList<Ville> ville = new ArrayList<Ville>();
			ville = connect.gestionVille.voirListeVille();
			dispose();
			new FenetreVoirVille(this.connect, ville);
			
		}
		if(o==boutonAnnuler){
			dispose();
			new FenetreAdministration(connect);
		}
		if(o==boutonGestionHotel){
			ArrayList<Ville> ville = new ArrayList<Ville>();
			ville = connect.gestionVille.voirListeVille();
			dispose();
			new FenetreChoixVille(this.connect,ville);
		}
		
	}


}
