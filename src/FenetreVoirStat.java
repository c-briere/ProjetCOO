import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

public class FenetreVoirStat extends JFrame implements ActionListener {

	ArrayList<Ville> ville;
	int nbDeVoyageur;
	ArrayList<Trajet> trajet;
	Connect connect;
	JButton boutonCancel;

	public FenetreVoirStat(ArrayList<Ville> ville, int nbDeVoyageur, ArrayList<Trajet> trajet, Connect connect) {
		super("Statistiques");
		this.ville = ville;
		this.nbDeVoyageur = nbDeVoyageur;
		this.trajet = trajet;
		this.connect = connect;

		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color (0xCFBFAD);
		
		boutonCancel = new JButton("Annuler");
				
		String villeNom = "";
		for (int i = 0; i < ville.size(); i++) {
			villeNom += ville.get(i).getNom() + " ";
		}
		
		JLabel jlabel = new JLabel("Ville(s) les plus voyagées " + villeNom);
		jlabel.setForeground(BlancPale);
		JLabel jlabel2 = new JLabel("Nombres de voyageurs " + nbDeVoyageur);
		jlabel2.setForeground(BlancPale);

		JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
		panel1.add(jlabel, BorderLayout.NORTH);
		panel1.add(jlabel2, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		JTable tableau = new JTable(new TableTrajet(trajet));
		tableau.setPreferredScrollableViewportSize(new Dimension(500, 200));
		tableau.setFillsViewportHeight(true);
        //Modification du HEADER du tableau
        JTableHeader header = tableau.getTableHeader();
        header.setBackground(GrisFonce);
        header.setForeground(BlancPale);
		JScrollPane scrollPane = new JScrollPane(tableau);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
		panel2.add(boutonCancel, BorderLayout.EAST);
		boutonCancel.addActionListener(this);
		
		panel.add(panel1, BorderLayout.NORTH);
		panel.add(scrollPane, BorderLayout.CENTER);
		panel.add(panel2, BorderLayout.SOUTH);
		
		add(panel);
		
		// Fond du panel
		// couleur : gris foncé
		panel.setBackground(GrisFonce);
		panel1.setBackground(GrisFonce);
		panel2.setBackground(GrisFonce);
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 250);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (source == boutonCancel) {
			this.dispose();
			new FenetreAccueil(this.connect);
		}
	}

}
