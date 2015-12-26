import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * 
 * @author BRIERE / CARDON
 *
 */
public class FenetreAdministration extends JFrame implements ActionListener{
	JButton boutonVille = new JButton("Ville");
	JButton boutonClient = new JButton("Client");
	JButton boutonLigne = new JButton("Ligne");
	JButton boutonAnnuler = new JButton("Annuler");
	
	public Connect connect;

	public FenetreAdministration(Connect connect){
		super("Panneau d'administration");
		this.connect=connect;

		boutonVille.addActionListener(this);
		boutonClient.addActionListener(this);
		boutonAnnuler.addActionListener(this);
		boutonLigne.addActionListener(this);
		
		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color (0xCFBFAD);

		//Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 50);

		//Fond transparent
		boutonVille.setOpaque(false);
		boutonVille.setContentAreaFilled(false);
		//Changement couleur bordure
		boutonVille.setBorder(border);
		//Changement Police
		boutonVille.setFont(font_bouton);
		//Changement couleur Police
		boutonVille.setForeground(BlancPale);
		
		//Fond transparent
		boutonClient.setOpaque(false);
		boutonClient.setContentAreaFilled(false);
		//Changement couleur bordure
		boutonClient.setBorder(border);
		//Changement Police
		boutonClient.setFont(font_bouton);
		//Changement couleur Police
		boutonClient.setForeground(BlancPale);		
		
		//Fond transparent
		boutonAnnuler.setOpaque(false);
		boutonAnnuler.setContentAreaFilled(false);
		//Changement couleur bordure
		boutonAnnuler.setBorder(border);
		//Changement Police
		boutonAnnuler.setFont(font_bouton);
		//Changement couleur Police
		boutonAnnuler.setForeground(BlancPale);	
		
		//Fond transparent
		boutonLigne.setOpaque(false);
		boutonLigne.setContentAreaFilled(false);
		//Changement couleur bordure
		boutonLigne.setBorder(border);
		//Changement Police
		boutonLigne.setFont(font_bouton);
		//Changement couleur Police
		boutonLigne.setForeground(BlancPale);	
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();


		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(boutonVille,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(boutonClient,c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(boutonAnnuler,c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		panel.add(boutonLigne,c);



		// Fond du panel
		// couleur : gris foncé
		panel.setBackground(GrisFonce);

		//Ajout du panel
		this.getContentPane().add(panel);
		//taille de la fenêtre
		setSize(800,600);
		//La fenêtre n'est pas redimensionnable
		setResizable(false);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) { 
		Object source = e.getSource();
		if(source==boutonVille){
			dispose();
			new FenetreGestionVille(this.connect);
		}

	
		if(source==boutonClient){
			dispose();
			new FenetreGestionClient(this.connect);

		}
		
		if(source==boutonLigne){
			dispose();
			new FenetreGestionLigne(this.connect);
		}
		
		if(source==boutonAnnuler){
			dispose();
			new FenetreAccueil(this.connect);
		}
		
	} 

}
