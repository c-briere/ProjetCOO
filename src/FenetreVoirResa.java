import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;


public class FenetreVoirResa extends JFrame implements ActionListener{
	public Connect connect;
	public List<Reservation> reservation ;
	public JButton boutonCancel = new JButton("Annuler");

	public FenetreVoirResa(Connect connect, ArrayList<Reservation> reservation) {
		super("Reservation");
		this.connect=connect;
		this.reservation=reservation;

		Color GrisFonce = new Color(0x222222);
		Color BlancPale = new Color (0xCFBFAD);
		
		//Bordure blanche d'épaisseur 3
		Border border = new LineBorder(BlancPale, 1);
		// Regarder comment importer une police
		Font font_bouton = new Font("Roboto", Font.PLAIN, 16);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
	    JTable tableau = new JTable(new TableReservation(reservation));
	    tableau.setPreferredScrollableViewportSize(new Dimension(500, 200));
        tableau.setFillsViewportHeight(true);
        //Modification du HEADER du tableau
        JTableHeader header = tableau.getTableHeader();
        header.setBackground(GrisFonce);
        header.setForeground(BlancPale);
        JScrollPane scrollPane = new JScrollPane(tableau);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2,BoxLayout.LINE_AXIS));
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
		if(source == boutonCancel){
			this.dispose();
			new FenetreAccueil(this.connect);
		}
	}

}
