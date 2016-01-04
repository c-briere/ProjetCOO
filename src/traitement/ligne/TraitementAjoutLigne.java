package traitement.ligne;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BDD.Connect;
import vue.ligne.FenetreAjouterLigne;
import vue.ligne.FenetreGestionLigne;


public class TraitementAjoutLigne implements ActionListener {

	FenetreAjouterLigne fenetreAjouterLigne;
	Connect connect;


	public TraitementAjoutLigne(FenetreAjouterLigne fenetreAjouterLigne,
			Connect connect) {
		this.fenetreAjouterLigne=fenetreAjouterLigne;
		this.connect=connect;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o==fenetreAjouterLigne.getBouttonValider()){
			int cleVilleAller;
			int cleVilleRetour;
			String VilleAller = fenetreAjouterLigne.getChoixVilleAller().getSelectedItem().toString();
			String VilleRetour = fenetreAjouterLigne.getChoixVilleRetour().getSelectedItem().toString();
			if(!VilleAller.equals(VilleRetour) && !VilleAller.equals("") && !VilleRetour.equals("")){
				VilleAller = fenetreAjouterLigne.getChoixVilleAller().getSelectedItem().toString();
				VilleRetour = fenetreAjouterLigne.getChoixVilleRetour().getSelectedItem().toString();
				cleVilleAller = this.connect.gestionVille.cleVille(VilleAller);
				cleVilleRetour = this.connect.gestionVille.cleVille(VilleRetour);
				if(this.connect.gestionLigne.addLigne(VilleAller,VilleRetour,cleVilleAller,cleVilleRetour)){
					JOptionPane.showMessageDialog(null,"Insertion réussi");
					this.fenetreAjouterLigne.dispose();
					new FenetreGestionLigne(this.connect);

				}
			}
		}
		
		if(o==this.fenetreAjouterLigne.getBouttonAnnuler()){
			this.fenetreAjouterLigne.dispose();
			new FenetreGestionLigne(this.connect);
		}


	}

}
