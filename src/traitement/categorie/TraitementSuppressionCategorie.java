package traitement.categorie;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BDD.Connect;
import vue.categorie.FenetreSupprimerCategorie;
import vue.ville.FenetreGestionVille;


public class TraitementSuppressionCategorie implements ActionListener {
	
	FenetreSupprimerCategorie fenetreSupprimerCategorie;
	Connect connect;
	int cleHotel;

	public TraitementSuppressionCategorie(
			FenetreSupprimerCategorie fenetreSupprimerCategorie,
			Connect connect, int cleHotel) {
		this.fenetreSupprimerCategorie=fenetreSupprimerCategorie;
		this.connect=connect;
		this.cleHotel=cleHotel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o = arg0.getSource();
		if(o==this.fenetreSupprimerCategorie.getBouttonValider()){
			if(!this.fenetreSupprimerCategorie.getCategorie().getText().equals("")){
				if(this.connect.gestionCategorie.suppCategorie(this.fenetreSupprimerCategorie.getCategorie().getText(),this.cleHotel)){
					JOptionPane.showMessageDialog(null,"Suppression réussi");
					this.fenetreSupprimerCategorie.dispose();
					new FenetreGestionVille(this.connect);
				}
				else{
					JOptionPane.showMessageDialog(null,"Suppression échouée ou catégorie introuvable");

				}
			}
		}
		if(o==this.fenetreSupprimerCategorie.getBouttonAnnuler()){
			this.fenetreSupprimerCategorie.dispose();
			new FenetreGestionVille(this.connect);
		}
				
	}

}
