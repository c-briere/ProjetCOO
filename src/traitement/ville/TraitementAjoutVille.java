package traitement.ville;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BDD.Connect;
import vue.ville.FenetreAjouterVille;
import vue.ville.FenetreGestionVille;


public class TraitementAjoutVille implements ActionListener {

	FenetreAjouterVille fenetreAjouterVille;
	Connect connect;

	public TraitementAjoutVille(FenetreAjouterVille fenetreAjouterVille,
			Connect connect) {
		this.fenetreAjouterVille=fenetreAjouterVille;
		this.connect=connect;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o==this.fenetreAjouterVille.getBouttonValider()){
			if(!this.fenetreAjouterVille.getVille().getText().equals("")){
				if(this.connect.gestionVille.addVille(this.fenetreAjouterVille.getVille().getText())){
					JOptionPane.showMessageDialog(null,"Insertion réussi");
					this.fenetreAjouterVille.dispose();
					new FenetreGestionVille(this.connect);

				}
			}
		}
		
		if(o==this.fenetreAjouterVille.getBouttonAnnuler()){
			this.fenetreAjouterVille.dispose();
			new FenetreGestionVille(this.connect);
		}

	}

}
