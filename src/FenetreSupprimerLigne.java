import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class FenetreSupprimerLigne extends JFrame {
	JComboBox<String> choixVilleAller;
	JComboBox<String> choixVilleRetour;
	Connect connect;
	JButton bouttonValider = new JButton("Valider");
	JButton bouttonAnnuler = new JButton("Annuler");

	public FenetreSupprimerLigne(Connect connect, ArrayList<Ville> ville) {
		super("Choix de la ville");
		this.connect=connect;
		choixVilleAller = new JComboBox<>();
		for(int i =0;i<ville.size();i++){
			choixVilleAller.addItem(ville.get(i).getNom());
		}

		choixVilleRetour = new JComboBox<>();
		for(int i =0;i<ville.size();i++){
			choixVilleRetour.addItem(ville.get(i).getNom());
		}

		


		bouttonValider.addActionListener(new TraitementSupprimerLigne(this, this.connect));
		bouttonAnnuler.addActionListener(new TraitementSupprimerLigne(this, this.connect));



		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));



		JPanel panel3 = new JPanel(new FlowLayout());


		panel3.add(new JLabel("choix de la ville aller"));
		panel3.add(choixVilleAller);

		JPanel panel4 = new JPanel(new FlowLayout());

		panel4.add(new JLabel("choix de la ville retour"));
		panel4.add(choixVilleRetour);

		JPanel panel5 = new JPanel(new BorderLayout());
		panel5.add(panel3,BorderLayout.NORTH);
		panel5.add(panel4,BorderLayout.CENTER);





		JPanel panel7 = new JPanel();
		panel7.add(bouttonValider);
		panel7.add(bouttonAnnuler);

		panel2.add(panel5, BorderLayout.NORTH);
		panel2.add(panel7, BorderLayout.SOUTH);


		this.getContentPane().add(panel2);
		setSize(500,300);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);



	}

}
