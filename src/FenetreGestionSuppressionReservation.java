import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * 
 * @author BRIERE / CARDON
 *
 */
public class FenetreGestionSuppressionReservation extends JFrame {
	Connect connect;
	JTextField nom, numeroResa;
	JButton valider, annuler;
	
	public FenetreGestionSuppressionReservation(Connect connect) {
		super("Suppression d'une reservation");
		this.connect = connect;
		nom = new JTextField();
		numeroResa = new JTextField();
		valider= new JButton("Valider");
		annuler=new JButton("Annuler");
		

		valider = new JButton("Valider");
		annuler = new JButton("Annuler");

		valider.addActionListener(new TraitementSuppressionReservation(this,this.connect));
		annuler.addActionListener(new TraitementSuppressionReservation(this,this.connect));

		nom.setPreferredSize(new Dimension(200,30));
		numeroResa.setPreferredSize(new Dimension(200,30));

		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color (0xCFBFAD);

		//Bordure blanche d'�paisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 24);

		//Fond transparent
		annuler.setOpaque(false);
		annuler.setContentAreaFilled(false);
		//Changement couleur bordure
		annuler.setBorder(border);
		//Changement Police
		annuler.setFont(font_bouton);
		//Changement couleur Police
		annuler.setForeground(BlancPale);
		
		//Fond transparent
		valider.setOpaque(false);
		valider.setContentAreaFilled(false);
		//Changement couleur bordure
		valider.setBorder(border);
		//Changement Police
		valider.setFont(font_bouton);
		//Changement couleur Police
		valider.setForeground(BlancPale);

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JPanel panel4 = new JPanel(new FlowLayout());
		panel4.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;		
		JLabel d = new JLabel("Nom");
		d.setFont(font_bouton);
		d.setForeground(BlancPale);
		// similaire � un margin-left
		d.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 185));
		panel4.add(d,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel4.add(nom);
		
		JPanel panel6 = new JPanel(new FlowLayout());
		panel6.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;		
		JLabel p = new JLabel("Num�ro r�servation");
		p.setFont(font_bouton);
		p.setForeground(BlancPale);
		// similaire � un margin-left
		p.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		panel6.add(p,c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;	
		panel6.add(numeroResa);	

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(panel4,c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(panel6,c);
		
		c.gridwidth= 1;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(valider,c);
		
		c.gridwidth= 1;
		c.gridx = 1;
		c.gridy = 2;
		panel.add(annuler,c);

		// Fond du panel
		// couleur : gris fonc�
		panel4.setBackground(GrisFonce);
		panel6.setBackground(GrisFonce);
		panel.setBackground(GrisFonce);

		this.getContentPane().add(panel);
		setSize(500,300);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
