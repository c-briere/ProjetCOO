import java.awt.BorderLayout;
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


public class FenetreChoixCategorie extends JFrame implements ActionListener{
	JComboBox<String> choixCategorie;
	Connect connect;
	JButton bouttonValider = new JButton("Valider");
	JButton bouttonAnnuler = new JButton("Annuler");
	int cle;
	
	public FenetreChoixCategorie(int cle2, Connect connect, ArrayList<Categorie> categorie) {
		super("Choix de la categorie");
		this.connect=connect;
		choixCategorie = new JComboBox<>();
		for(int i =0;i<categorie.size();i++){
			choixCategorie.addItem(categorie.get(i).getNom());
		}
		
		this.cle=cle2;
		bouttonValider.addActionListener(this);
		bouttonAnnuler.addActionListener(this);
		
		

		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));


		
		JPanel panel3 = new JPanel(new FlowLayout());

		
		panel3.add(new JLabel("choix de la categorie"));
		panel3.add(choixCategorie);
		
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
			int cle2=this.connect.gestionCategorie.cleCategorie(choixCategorie.getSelectedItem().toString(),cle);
			dispose();
			new FenetreGestionChambre(choixCategorie.getSelectedItem().toString(),cle2,this.connect);
		}
		
	}
	
	

	

}
