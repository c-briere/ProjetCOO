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


public class FenetreGestionChambre  extends JFrame implements ActionListener{
	JButton boutonAdd = new JButton("Ajouter chambre");
	JButton boutonDelete = new JButton("Supprimer chambre");
	JButton boutonVoir = new JButton("Voir les chambres");
	JButton boutonAnnuler = new JButton("Annuler");
	Connect connect;
	int cleCategorie;

	public FenetreGestionChambre(String categorie, int cleCategorie, Connect connect) {
		super("gestion de la categorie  "+categorie);
		this.connect=connect;
		this.cleCategorie=cleCategorie;
		boutonAdd.setPreferredSize(new Dimension(250,30));
		boutonDelete.setPreferredSize(new Dimension(250,30));
		boutonVoir.setPreferredSize(new Dimension(250,30));
		boutonAnnuler.setPreferredSize(new Dimension(250,30));
		boutonAdd.addActionListener(this);
		boutonDelete.addActionListener(this);
		boutonVoir.addActionListener(this);
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
		if(o==this.boutonAdd){
			dispose();
			new FenetreAjouterChambre(cleCategorie,this.connect);
		}
			if(o==this.boutonDelete){
			dispose();
			new FenetreSupprimerChambre(cleCategorie,this.connect);
		}
		if(o==this.boutonAnnuler){
			dispose();
			new FenetreGestionVille(this.connect);
		}
		if(o==this.boutonVoir){
			dispose();
			ArrayList<Chambre>  chambre;
			chambre = this.connect.gestionChambre.voirChambre(cleCategorie);
			new FenetreVoirChambre(this.connect,chambre);
		}


	}


}
