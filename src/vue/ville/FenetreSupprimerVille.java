package vue.ville;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import BDD.Connect;
import traitement.ville.TraitementSupprimerVille;

/**
 * 
 * @author BRIERE / CARDON
 *
 */
public class FenetreSupprimerVille extends JFrame{

	private JTextField ville = new JTextField();
	
	public Connect connect;
	private JButton bouttonValider = new JButton("Supprimer");
	private JButton bouttonAnnuler = new JButton("Annuler");


	
	public FenetreSupprimerVille(Connect connect){
		super("Suppression d'une ville");
		this.connect=connect;

		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color (0xCFBFAD);

		//Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 3);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 24);
		
		//Fond transparent
		getBouttonAnnuler().setOpaque(false);
		getBouttonAnnuler().setContentAreaFilled(false);
		//Changement couleur bordure
		getBouttonAnnuler().setBorder(border);
		//Changement Police
		getBouttonAnnuler().setFont(font_bouton);
		//Changement couleur Police
		getBouttonAnnuler().setForeground(BlancPale);
		
		//Fond transparent
		getBouttonValider().setOpaque(false);
		getBouttonValider().setContentAreaFilled(false);
		//Changement couleur bordure
		getBouttonValider().setBorder(border);
		//Changement Police
		getBouttonValider().setFont(font_bouton);
		//Changement couleur Police
		getBouttonValider().setForeground(BlancPale);
		
		getBouttonValider().addActionListener(new TraitementSupprimerVille(this,this.connect));
		getBouttonAnnuler().addActionListener(new TraitementSupprimerVille(this,this.connect));
		
		
		getVille().setPreferredSize(new Dimension(250,30));

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();


		
		JPanel panel3 = new JPanel(new FlowLayout());
		panel3.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		JLabel v = new JLabel("Ville");
		v.setFont(font_bouton);
		v.setForeground(BlancPale);
		// similaire à un margin-left : 25px;
		v.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		panel3.add(v,c);
			
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		panel3.add(getVille(),c);
		
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.50;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(panel3,c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(getBouttonValider(),c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 0.15;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 1;
		panel.add(getBouttonAnnuler(),c);
		

		// Fond du panel
		// couleur : gris foncé
		panel3.setBackground(GrisFonce);
		panel.setBackground(GrisFonce);
		
		this.getContentPane().add(panel);
		setSize(500,300);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}



	/**
	 * @return the bouttonValider
	 */
	public JButton getBouttonValider() {
		return bouttonValider;
	}



	/**
	 * @param bouttonValider the bouttonValider to set
	 */
	public void setBouttonValider(JButton bouttonValider) {
		this.bouttonValider = bouttonValider;
	}



	/**
	 * @return the ville
	 */
	public JTextField getVille() {
		return ville;
	}



	/**
	 * @param ville the ville to set
	 */
	public void setVille(JTextField ville) {
		this.ville = ville;
	}



	/**
	 * @return the bouttonAnnuler
	 */
	public JButton getBouttonAnnuler() {
		return bouttonAnnuler;
	}



	/**
	 * @param bouttonAnnuler the bouttonAnnuler to set
	 */
	public void setBouttonAnnuler(JButton bouttonAnnuler) {
		this.bouttonAnnuler = bouttonAnnuler;
	}

}
