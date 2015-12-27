import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


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



		boutonAdd.setPreferredSize(new Dimension(250,30));
		boutonDelete.setPreferredSize(new Dimension(250,30));
		boutonVoir.setPreferredSize(new Dimension(250,30));
		boutonGestionHotel.setPreferredSize(new Dimension(250,30));
		boutonAnnuler.setPreferredSize(new Dimension(250,30));
		boutonAdd.addActionListener(this);
		boutonDelete.addActionListener(this);
		boutonVoir.addActionListener(this);
		boutonGestionHotel.addActionListener(this);
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
		panel.add(boutonGestionHotel);
		boutonGestionHotel.setAlignmentX(Component.CENTER_ALIGNMENT);
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
