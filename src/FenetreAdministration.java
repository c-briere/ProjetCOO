import java.awt.Component;
import java.awt.Dimension;
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


public class FenetreAdministration extends JFrame implements ActionListener{
	JButton boutonVille = new JButton("Ville");
	JButton boutonClient = new JButton("Client");
	JButton boutonLigne = new JButton("Ligne");
	JButton boutonAnnuler = new JButton("Annuler");
	
	public Connect connect;

	public FenetreAdministration(Connect connect){
		super("Panneau d'administration");
		this.connect=connect;



		boutonVille.setPreferredSize(new Dimension(250,30));
		boutonClient.setPreferredSize(new Dimension(250,30));
		boutonLigne.setPreferredSize(new Dimension(250,30));
		boutonAnnuler.setPreferredSize(new Dimension(250,30));
		
		boutonVille.addActionListener(this);
		boutonClient.addActionListener(this);
		boutonLigne.addActionListener(this);
		boutonAnnuler.addActionListener(this);
		JPanel panel = new JPanel();
		BoxLayout box = new BoxLayout(panel,BoxLayout.PAGE_AXIS);
		panel.setLayout(box);
		panel.add(Box.createVerticalGlue());
		panel.add(boutonVille);
		boutonVille.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.setLayout(box);
		panel.add(Box.createVerticalGlue());
		panel.add(boutonClient);
		boutonClient.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.setLayout(box);
		panel.add(Box.createVerticalGlue());
		panel.add(boutonLigne);
		boutonLigne.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.setLayout(box);
		panel.add(Box.createVerticalGlue());
		panel.add(boutonAnnuler);
		boutonAnnuler.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.setLayout(box);
		panel.add(Box.createVerticalGlue());




		this.getContentPane().add(panel);
		setSize(350,200);
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
