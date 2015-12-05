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


public class FenetreGestionHotel  extends JFrame implements ActionListener{
	JButton boutonAdd = new JButton("Ajouter hotel");
	JButton boutonDelete = new JButton("Supprimer hotel");
	JButton boutonVoir = new JButton("Voir les hotels");
	JButton boutonGestionCatégorie = new JButton("Gestion catégories");;
	JButton boutonAnnuler = new JButton("Annuler");
	Connect connect;
	int cle;

	public FenetreGestionHotel(String ville, int cle, Connect connect) {
		super("gestion des hotels de la ville de "+ville);
		this.connect=connect;
		this.cle=cle;
		boutonAdd.setPreferredSize(new Dimension(250,30));
		boutonDelete.setPreferredSize(new Dimension(250,30));
		boutonVoir.setPreferredSize(new Dimension(250,30));
		boutonGestionCatégorie.setPreferredSize(new Dimension(250,30));
		boutonAnnuler.setPreferredSize(new Dimension(250,30));
		boutonAdd.addActionListener(this);
		boutonDelete.addActionListener(this);
		boutonVoir.addActionListener(this);
		boutonGestionCatégorie.addActionListener(this);
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
		panel.add(boutonGestionCatégorie);
		boutonGestionCatégorie.setAlignmentX(Component.CENTER_ALIGNMENT);
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
			new FenetreAjouterHotel(cle,this.connect);
		}
		if(o==this.boutonDelete){
			dispose();
			new FenetreSupprimerHotel(cle,this.connect);
		}
		if(o==this.boutonAnnuler){
			dispose();
			new FenetreGestionVille(this.connect);
		}
		if(o==this.boutonVoir){
			dispose();
			ArrayList<Hotel>  hotel;
			hotel = this.connect.gestionHotel.voirHotel(cle);
			new FenetreVoirHotel(this.connect,hotel);
		}
		if(o==this.boutonGestionCatégorie){
			dispose();
			ArrayList<Hotel>  hotel;
			hotel = this.connect.gestionHotel.voirHotel(cle);
			new FenetreChoixHotel(cle,this.connect,hotel);
		}
		
	}

	
}
