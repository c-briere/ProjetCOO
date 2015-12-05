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


public class FenetreGestionLigne  extends JFrame implements ActionListener{
	JButton boutonAdd = new JButton("Ajouter une ligne");
	JButton boutonDelete = new JButton("Supprimer une ligne");
	JButton boutonModification = new JButton("Modifier une ligne");
	JButton boutonAnnuler = new JButton("Annuler");
	Connect connect;

	public FenetreGestionLigne( Connect connect) {
		super("gestion des lignes");
		this.connect=connect;
		boutonAdd.setPreferredSize(new Dimension(250,30));
		boutonDelete.setPreferredSize(new Dimension(250,30));
		boutonModification.setPreferredSize(new Dimension(250,30));
		boutonAnnuler.setPreferredSize(new Dimension(250,30));
		boutonAdd.addActionListener(this);
		boutonDelete.addActionListener(this);
		boutonModification.addActionListener(this);
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
		panel.add(boutonModification);
		boutonModification.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.setLayout(box);
		panel.add(Box.createVerticalGlue());
		panel.add(boutonAnnuler);
		boutonAnnuler.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.setLayout(box);
		panel.add(Box.createVerticalGlue());


		this.getContentPane().add(panel);

		setSize(500,300);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		ArrayList<Ville> ville = this.connect.gestionVille.voirListeVille();

		if(o==this.boutonAdd){
			dispose();
			new FenetreAjouterLigne(this.connect,ville);
		}
		if(o==this.boutonDelete){
			dispose();
			new FenetreSupprimerLigne(this.connect,ville);
		}
		if(o==this.boutonAnnuler){
			dispose();
			new FenetreAdministration(this.connect);
		}
		if(o==this.boutonModification){
			ArrayList<Ligne> ligne = this.connect.gestionLigne.allLigne();
			dispose();
			new FenetreChoixLigne(this.connect, ligne);
		}

	}


}


