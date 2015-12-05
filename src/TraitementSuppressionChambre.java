import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class TraitementSuppressionChambre implements ActionListener {

	FenetreSupprimerChambre fenetreSupprimerChambre;
	Connect connect;
	int cleCategorie;

	public TraitementSuppressionChambre(
			FenetreSupprimerChambre fenetreSupprimerChambre, Connect connect,
			int cleCategorie) {
		this.fenetreSupprimerChambre=fenetreSupprimerChambre;
		this.connect=connect;
		this.cleCategorie=cleCategorie;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o = arg0.getSource();
		if(o==this.fenetreSupprimerChambre.bouttonValider){
			if(!this.fenetreSupprimerChambre.nom.getText().equals("")){
				if(this.connect.gestionChambre.suppChambre(this.fenetreSupprimerChambre.nom.getText(),this.cleCategorie)){
					JOptionPane.showMessageDialog(null,"Suppression réussi");
					this.fenetreSupprimerChambre.dispose();
					new FenetreGestionVille(this.connect);
				}
				else{
					JOptionPane.showMessageDialog(null,"Suppression échouée ou catégorie introuvable");

				}
			}
		}
		if(o==this.fenetreSupprimerChambre.bouttonAnnuler){
			this.fenetreSupprimerChambre.dispose();
			new FenetreGestionVille(this.connect);
		}

	}

}


