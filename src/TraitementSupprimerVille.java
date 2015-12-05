import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


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
		if(e==this.fenetreSupprimerVille.bouttonValider){
			if(connect.gestionVille.supVille(this.fenetreSupprimerVille.ville.getText())){
				JOptionPane.showMessageDialog(null,"Suppression réussi");
				this.fenetreSupprimerVille.dispose();
				FenetreGestionVille c = new FenetreGestionVille(this.connect);
			}
			else{
				JOptionPane.showMessageDialog(null,"Echec suppression ou la ville n'existe pas");

			}
		}
		if(e==this.fenetreSupprimerVille.bouttonAnnuler){
			this.fenetreSupprimerVille.dispose();
			new FenetreGestionVille(this.connect);
		}

	}

}
