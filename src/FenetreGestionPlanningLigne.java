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


public class FenetreGestionPlanningLigne extends JFrame implements ActionListener {
	JButton boutonAdd = new JButton("Ajouter trajet");
	JButton boutonDelete = new JButton("Supprimer trajet");
	JButton boutonVoir = new JButton("Voir les trajet");
	JButton boutonModifier = new JButton("Modifier trajet");;
	JButton boutonAnnuler = new JButton("Annuler");
	public Connect connect;
	int cleLigne;

	public FenetreGestionPlanningLigne(Connect connect, int cleLigne, String[] str){
		super("Gestion de la ligne "+str[0]+" "+str[1]);
		this.connect=connect;
		this.cleLigne=cleLigne;

		boutonAdd.setPreferredSize(new Dimension(250,30));
		boutonDelete.setPreferredSize(new Dimension(250,30));
		boutonVoir.setPreferredSize(new Dimension(250,30));
		boutonModifier.setPreferredSize(new Dimension(250,30));
		boutonAnnuler.setPreferredSize(new Dimension(250,30));
		boutonAdd.addActionListener(this);
		boutonDelete.addActionListener(this);
		boutonVoir.addActionListener(this);
		boutonModifier.addActionListener(this);
		boutonAnnuler.addActionListener(this);
		JPanel panel = new JPanel();
		BoxLayout box = new BoxLayout(panel,BoxLayout.PAGE_AXIS);
		panel.setLayout(box);
		panel.add(Box.createVerticalGlue());
		panel.add(boutonAdd);
		boutonAdd.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.setLayout(box);
		panel.add(Box.createVerticalGlue());
		panel.add(boutonDelete);
		boutonDelete.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.setLayout(box);
		panel.add(Box.createVerticalGlue());
		panel.add(boutonVoir);
		boutonVoir.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.setLayout(box);
		panel.add(Box.createVerticalGlue());
		panel.add(boutonModifier);
		boutonModifier.setAlignmentX(Component.CENTER_ALIGNMENT);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o =e.getSource();
		if(o==boutonAdd){
			dispose();
			new FenetreAjouterPlanning(this.connect,this.cleLigne);
		}
		
		if(o==boutonDelete){
			dispose();
			new FenetreSupprimerPlanning(this.connect,this.cleLigne);
		} 
		if(o==boutonVoir){
			ArrayList<Trajet> trajet = new ArrayList<Trajet>();
			trajet = connect.gestionTrajet.voirListeVille(this.cleLigne);
			dispose();
			new FenetreVoirPlanning(this.connect, trajet);
			
		}
		if(o==boutonAnnuler){
			dispose();
			new FenetreGestionLigne(connect);
		}
		if(o==boutonModifier){
			dispose();
			new FenetreModifPlanning(this.connect,cleLigne);
		}
		
	}


}
