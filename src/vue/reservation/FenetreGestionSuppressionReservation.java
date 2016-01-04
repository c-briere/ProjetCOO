package vue.reservation;
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

import BDD.Connect;
import traitement.reservation.TraitementSuppressionReservation;

/**
 * 
 * @author BRIERE / CARDON
 *
 */
public class FenetreGestionSuppressionReservation extends JFrame {
	Connect connect;
	private JTextField nom;
	private JTextField numeroResa;
	private JButton valider;
	private JButton annuler;
	
	public FenetreGestionSuppressionReservation(Connect connect) {
		super("Suppression d'une reservation");
		this.connect = connect;
		setNom(new JTextField());
		setNumeroResa(new JTextField());
		setValider(new JButton("Valider"));
		setAnnuler(new JButton("Annuler"));
		

		setValider(new JButton("Valider"));
		setAnnuler(new JButton("Annuler"));

		getValider().addActionListener(new TraitementSuppressionReservation(this,this.connect));
		getAnnuler().addActionListener(new TraitementSuppressionReservation(this,this.connect));

		getNom().setPreferredSize(new Dimension(200,30));
		getNumeroResa().setPreferredSize(new Dimension(200,30));

		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color (0xCFBFAD);

		//Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 24);

		//Fond transparent
		getAnnuler().setOpaque(false);
		getAnnuler().setContentAreaFilled(false);
		//Changement couleur bordure
		getAnnuler().setBorder(border);
		//Changement Police
		getAnnuler().setFont(font_bouton);
		//Changement couleur Police
		getAnnuler().setForeground(BlancPale);
		
		//Fond transparent
		getValider().setOpaque(false);
		getValider().setContentAreaFilled(false);
		//Changement couleur bordure
		getValider().setBorder(border);
		//Changement Police
		getValider().setFont(font_bouton);
		//Changement couleur Police
		getValider().setForeground(BlancPale);

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
		// similaire à un margin-left
		d.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 185));
		panel4.add(d,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel4.add(getNom());
		
		JPanel panel6 = new JPanel(new FlowLayout());
		panel6.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;		
		JLabel p = new JLabel("Numéro réservation");
		p.setFont(font_bouton);
		p.setForeground(BlancPale);
		// similaire à un margin-left
		p.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		panel6.add(p,c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;	
		panel6.add(getNumeroResa());	

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
		panel.add(getValider(),c);
		
		c.gridwidth= 1;
		c.gridx = 1;
		c.gridy = 2;
		panel.add(getAnnuler(),c);

		// Fond du panel
		// couleur : gris foncé
		panel4.setBackground(GrisFonce);
		panel6.setBackground(GrisFonce);
		panel.setBackground(GrisFonce);

		this.getContentPane().add(panel);
		setSize(500,300);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * @return the annuler
	 */
	public JButton getAnnuler() {
		return annuler;
	}

	/**
	 * @param annuler the annuler to set
	 */
	public void setAnnuler(JButton annuler) {
		this.annuler = annuler;
	}

	/**
	 * @return the valider
	 */
	public JButton getValider() {
		return valider;
	}

	/**
	 * @param valider the valider to set
	 */
	public void setValider(JButton valider) {
		this.valider = valider;
	}

	/**
	 * @return the nom
	 */
	public JTextField getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(JTextField nom) {
		this.nom = nom;
	}

	/**
	 * @return the numeroResa
	 */
	public JTextField getNumeroResa() {
		return numeroResa;
	}

	/**
	 * @param numeroResa the numeroResa to set
	 */
	public void setNumeroResa(JTextField numeroResa) {
		this.numeroResa = numeroResa;
	}

}
