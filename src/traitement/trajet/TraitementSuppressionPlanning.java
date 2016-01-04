package traitement.trajet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BDD.Connect;
import vue.ligne.FenetreGestionLigne;
import vue.trajet.FenetreSupprimerPlanning;


public class TraitementSuppressionPlanning implements ActionListener {
	FenetreSupprimerPlanning fenetreSupprimerPlanning;
	Connect connect;
	int cleLigne;
	

	public TraitementSuppressionPlanning(
			FenetreSupprimerPlanning fenetreSupprimerPlanning, Connect connect,
			int cleLigne) {
		this.fenetreSupprimerPlanning=fenetreSupprimerPlanning;
		this.connect=connect;
		this.cleLigne=cleLigne;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o = arg0.getSource();
		if(o==this.fenetreSupprimerPlanning.getBouttonAnnuler()){
			this.fenetreSupprimerPlanning.dispose();
			new FenetreGestionLigne(connect);
		}
		if(o==this.fenetreSupprimerPlanning.getBouttonValider()){
			if(this.connect.gestionTrajet.deleteTrajet(cleLigne,Integer.parseInt(this.fenetreSupprimerPlanning.getDuree().getText()),this.fenetreSupprimerPlanning.getHeure().getText(),this.fenetreSupprimerPlanning.getJour().getSelectedItem().toString())){
				JOptionPane.showMessageDialog(null,"Suppression réussi");
				this.fenetreSupprimerPlanning.dispose();
				new FenetreGestionLigne(this.connect);
			}
			else{
				JOptionPane.showMessageDialog(null, "echec suppression ou le trajet n'existe pas" );
			}
		}

	}

}
