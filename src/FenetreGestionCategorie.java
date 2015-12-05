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


public class FenetreGestionCategorie  extends JFrame implements ActionListener{
	JButton boutonAdd = new JButton("Ajouter categorie");
	JButton boutonModif = new JButton("Modifier categorie");
	JButton boutonDelete = new JButton("Supprimer categorie");
	JButton boutonVoir = new JButton("Voir les categories");
	JButton boutonGestionChambre = new JButton("Gestion chambres");;
	JButton boutonAnnuler = new JButton("Annuler");
	Connect connect;
	int cleHotel;

	public FenetreGestionCategorie(String hotel, int cleHotel, Connect connect) {
		super("gestion de l'hotel :"+hotel);
		this.connect=connect;
		this.cleHotel=cleHotel;
		boutonAdd.setPreferredSize(new Dimension(250,30));
		boutonDelete.setPreferredSize(new Dimension(250,30));
		boutonVoir.setPreferredSize(new Dimension(250,30));
		boutonGestionChambre.setPreferredSize(new Dimension(250,30));
		boutonAnnuler.setPreferredSize(new Dimension(250,30));
		boutonAdd.addActionListener(this);
		boutonDelete.addActionListener(this);
		boutonVoir.addActionListener(this);
		boutonGestionChambre.addActionListener(this);
		boutonModif.addActionListener(this);
		boutonAnnuler.addActionListener(this);
		JPanel panel = new JPanel();
		BoxLayout box = new BoxLayout(panel,BoxLayout.PAGE_AXIS);
		panel.setLayout(box);
		panel.add(Box.createVerticalGlue());
		panel.add(boutonAdd);
		boutonAdd.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.setLayout(box);
		panel.add(Box.createVerticalGlue());
		panel.add(boutonModif);
		boutonModif.setAlignmentX(Component.CENTER_ALIGNMENT);
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
		panel.add(boutonGestionChambre);
		boutonGestionChambre.setAlignmentX(Component.CENTER_ALIGNMENT);
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
			new FenetreAjouterCategorie(cleHotel,this.connect);
		}
		if(o==this.boutonDelete){
			dispose();
			new FenetreSupprimerCategorie(cleHotel,this.connect);
		}
		if(o==this.boutonAnnuler){
			dispose();
			new FenetreGestionVille(this.connect);
		}
		if(o==this.boutonVoir){
			dispose();
			ArrayList<Categorie>  categorie;
			categorie = this.connect.gestionCategorie.voirCategorie(cleHotel);
			new FenetreVoirCategorie(this.connect,categorie);
		}
		if(o==this.boutonGestionChambre){
			dispose();
			ArrayList<Categorie>  categorie;
			categorie = this.connect.gestionCategorie.voirCategorie(cleHotel);
			new FenetreChoixCategorie(cleHotel,this.connect,categorie);
		}
		if(o==this.boutonModif){
			dispose();
			new FenetreModifCategorie(cleHotel,this.connect);
		}
		
	}

	
}
