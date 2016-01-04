package traitement.chambre;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BDD.Connect;
import vue.chambre.FenetreSupprimerChambre;
import vue.ville.FenetreGestionVille;


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
		if(o==this.fenetreSupprimerChambre.getBouttonValider()){
			if(!this.fenetreSupprimerChambre.getNom().getText().equals("")){
				if(this.connect.gestionChambre.suppChambre(this.fenetreSupprimerChambre.getNom().getText(),this.cleCategorie)){
					JOptionPane.showMessageDialog(null,"Suppression réussi");
					this.fenetreSupprimerChambre.dispose();
					new FenetreGestionVille(this.connect);
				}
				else{
					JOptionPane.showMessageDialog(null,"Suppression échouée ou catégorie introuvable");

				}
			}
		}
		if(o==this.fenetreSupprimerChambre.getBouttonAnnuler()){
			this.fenetreSupprimerChambre.dispose();
			new FenetreGestionVille(this.connect);
		}

	}

}


