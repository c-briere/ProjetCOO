import java.awt.BorderLayout;
<<<<<<< HEAD
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
=======
import java.awt.FlowLayout;
>>>>>>> origin/master
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * 
 * @author BRIERE / CARDON
 *
 */
public class FenetreSupprimerLigne extends JFrame {
	JComboBox<String> choixVilleAller;
	JComboBox<String> choixVilleRetour;
	
	Connect connect;
	
	JButton bouttonValider = new JButton("Valider");
	JButton bouttonAnnuler = new JButton("Annuler");

	public FenetreSupprimerLigne(Connect connect, ArrayList<Ville> ville) {
		super("Choix de la ville");
		this.connect=connect;
		choixVilleAller = new JComboBox<>();
		for(int i =0;i<ville.size();i++){
			choixVilleAller.addItem(ville.get(i).getNom());
		}

		choixVilleRetour = new JComboBox<>();
		for(int i =0;i<ville.size();i++){
			choixVilleRetour.addItem(ville.get(i).getNom());
		}

		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color (0xCFBFAD);

		//Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 24);		


		bouttonValider.addActionListener(new TraitementSupprimerLigne(this, this.connect));
		bouttonAnnuler.addActionListener(new TraitementSupprimerLigne(this, this.connect));

		//Fond transparent
		bouttonAnnuler.setOpaque(false);
		bouttonAnnuler.setContentAreaFilled(false);
		//Changement couleur bordure
		bouttonAnnuler.setBorder(border);
		//Changement Police
		bouttonAnnuler.setFont(font_bouton);
		//Changement couleur Police
		bouttonAnnuler.setForeground(BlancPale);
		
		//Fond transparent
		bouttonValider.setOpaque(false);
		bouttonValider.setContentAreaFilled(false);
		//Changement couleur bordure
		bouttonValider.setBorder(border);
		//Changement Police
		bouttonValider.setFont(font_bouton);
		//Changement couleur Police
		bouttonValider.setForeground(BlancPale);

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
		panel3.add(v,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel3.add(choixVilleAller,c);


		
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
		panel4.add(p,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel4.add(choixVilleRetour,c);


		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(panel3,c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(panel4,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(bouttonValider,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 2;
		panel.add(bouttonAnnuler,c);

		// Fond du panel
		// couleur : gris foncé
		panel3.setBackground(GrisFonce);
		panel4.setBackground(GrisFonce);
		panel.setBackground(GrisFonce);

		this.getContentPane().add(panel);
		setSize(500,300);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);



	}

}
