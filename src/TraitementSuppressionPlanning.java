import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


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
		if(o==this.fenetreSupprimerPlanning.bouttonAnnuler){
			this.fenetreSupprimerPlanning.dispose();
			new FenetreGestionLigne(connect);
		}
		if(o==this.fenetreSupprimerPlanning.bouttonValider){
			if(this.connect.gestionTrajet.deleteTrajet(cleLigne,Integer.parseInt(this.fenetreSupprimerPlanning.duree.getText()),this.fenetreSupprimerPlanning.heure.getText(),this.fenetreSupprimerPlanning.jour.getSelectedItem().toString())){
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
