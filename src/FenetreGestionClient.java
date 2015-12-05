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


public class FenetreGestionClient extends JFrame implements ActionListener{
	JButton boutonAdd = new JButton("Ajouter");
	JButton boutonDelete = new JButton("Supprimer");
	JButton boutonModifier = new JButton("Modifier");
	JButton boutonVoir = new JButton("Voir la liste des clients");
	JButton boutonAnnuler = new JButton("Annuler");
	public Connect connect;

	public FenetreGestionClient(Connect connect){
		super("Gestion des clients");
		this.connect=connect;



		boutonAdd.setPreferredSize(new Dimension(250,30));
		boutonDelete.setPreferredSize(new Dimension(250,30));
		boutonModifier.setPreferredSize(new Dimension(250,30));
		boutonVoir.setPreferredSize(new Dimension(250,30));
		boutonAnnuler.setPreferredSize(new Dimension(250,30));
		boutonAdd.addActionListener(this);
		boutonVoir.addActionListener(this);
		boutonDelete.addActionListener(this);
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
		panel.add(boutonModifier);
		boutonModifier.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.setLayout(box);
		panel.add(Box.createVerticalGlue());
		panel.add(boutonVoir);
		boutonVoir.setAlignmentX(Component.CENTER_ALIGNMENT);
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
		if(source==boutonAdd){
			dispose();
			new FenetreAjouterClient(this.connect);
		}

		if(source==boutonVoir){
			ArrayList<Client> client = new ArrayList<Client>();
			try {
				client = connect.gestionClient.voirListeClient();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dispose();
			new FenetreVoirListClient(this.connect,client);

		}
		if(source==boutonDelete){
			dispose();
			new FenetreSupprimerClient(connect);
		}
		if(source == boutonModifier){
			dispose();
			new FenetreModifierClient(connect);
		}
		if(source == boutonAnnuler){
			dispose();
			new FenetreAdministration(this.connect);
		}
	} 

}
