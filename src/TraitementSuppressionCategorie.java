import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


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
		if(o==this.fenetreSupprimerCategorie.bouttonValider){
			if(!this.fenetreSupprimerCategorie.categorie.getText().equals("")){
				if(this.connect.gestionCategorie.suppCategorie(this.fenetreSupprimerCategorie.categorie.getText(),this.cleHotel)){
					JOptionPane.showMessageDialog(null,"Suppression réussi");
					this.fenetreSupprimerCategorie.dispose();
					new FenetreGestionVille(this.connect);
				}
				else{
					JOptionPane.showMessageDialog(null,"Suppression échouée ou catégorie introuvable");

				}
			}
		}
		if(o==this.fenetreSupprimerCategorie.bouttonAnnuler){
			this.fenetreSupprimerCategorie.dispose();
			new FenetreGestionVille(this.connect);
		}
				
	}

}
