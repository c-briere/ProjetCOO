package traitement.ville;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BDD.Connect;
import vue.ville.FenetreGestionVille;
import vue.ville.FenetreSupprimerVille;


public class TraitementSupprimerVille implements ActionListener {
	
	FenetreSupprimerVille fenetreSupprimerVille;
	Connect connect;

	public TraitementSupprimerVille(
			FenetreSupprimerVille fenetreSupprimerVille, Connect connect) {
		this.fenetreSupprimerVille=fenetreSupprimerVille;
		this.connect=connect;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object e = arg0.getSource();
		if(e==this.fenetreSupprimerVille.getBouttonValider()){
			if(connect.gestionVille.supVille(this.fenetreSupprimerVille.getVille().getText())){
				JOptionPane.showMessageDialog(null,"Suppression réussi");
				this.fenetreSupprimerVille.dispose();
				FenetreGestionVille c = new FenetreGestionVille(this.connect);
			}
			else{
				JOptionPane.showMessageDialog(null,"Echec suppression ou la ville n'existe pas");

			}
		}
		if(e==this.fenetreSupprimerVille.getBouttonAnnuler()){
			this.fenetreSupprimerVille.dispose();
			new FenetreGestionVille(this.connect);
		}

	}

}
