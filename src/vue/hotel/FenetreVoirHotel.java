package vue.hotel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import BDD.Connect;
import classe_defaut.Hotel;
import traitement.tableau.TableHotel;
import vue.ville.FenetreGestionVille;

/**
 * Fenêtre pour afficher toutes les chambres
 * 
 * @author BRIERE / CARDON
 *
 */
public class FenetreVoirHotel extends JFrame implements ActionListener {
	public Connect connect;
	public List<Hotel> hotel;
	public JButton boutonCancel = new JButton("Retour");

	public FenetreVoirHotel(Connect connect, ArrayList<Hotel> hotel2) {
		super("Liste des hotels");
		this.connect = connect;
		this.hotel = hotel2;

		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color(0xCFBFAD);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		JTable tableau = new JTable(new TableHotel(hotel2));
		tableau.setPreferredScrollableViewportSize(new Dimension(500, 200));
		tableau.setFillsViewportHeight(true);
		// Modification du HEADER du tableau
		JTableHeader header = tableau.getTableHeader();
		header.setBackground(GrisFonce);
		header.setForeground(BlancPale);
		JScrollPane scrollPane = new JScrollPane(tableau);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
		panel2.add(boutonCancel, BorderLayout.EAST);
		boutonCancel.addActionListener(this);

		panel.add(scrollPane, BorderLayout.NORTH);
		panel.add(panel2, BorderLayout.SOUTH);
		add(panel);

		// Fond du panel
		// couleur : gris foncé
		panel.setBackground(GrisFonce);

		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(550, 250);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == boutonCancel) {
			this.dispose();
			new FenetreGestionVille(this.connect);
		}
	}

}
