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


public class FenetreChoixVille extends JFrame implements ActionListener{
	JComboBox<String> choixVille;
	Connect connect;
	JButton bouttonValider = new JButton("Valider");
	JButton bouttonAnnuler = new JButton("Annuler");
	
	public FenetreChoixVille(Connect connect, ArrayList<Ville> ville) {
		super("Choix de la ville");
		this.connect=connect;
		choixVille = new JComboBox<>();
		for(int i =0;i<ville.size();i++){
			choixVille.addItem(ville.get(i).getNom());
		}
		
		int cle=0;
		bouttonValider.addActionListener(this);
		bouttonAnnuler.addActionListener(this);
		
		

		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));


		
		JPanel panel3 = new JPanel(new FlowLayout());

		
		panel3.add(new JLabel("choix de la ville"));
		panel3.add(choixVille);
		
		JPanel panel5 = new JPanel(new BorderLayout());
		panel5.add(panel3,BorderLayout.NORTH);
		
		
		
		
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o==bouttonAnnuler){
			dispose();
			new FenetreGestionVille(connect);
		}
		
		if(o==bouttonValider){
			
			int cle = this.connect.gestionVille.cleVille(choixVille.getSelectedItem().toString());
			dispose();
			System.out.println(cle);
			new FenetreGestionHotel(choixVille.getSelectedItem().toString(),cle,this.connect);
		}
		
	}
	
	

	

}
