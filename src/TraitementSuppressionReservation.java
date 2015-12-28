import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class TraitementSuppressionReservation implements ActionListener {

	FenetreGestionSuppressionReservation fenetreGestionSuppressionReservation;
	Connect connect;

	public TraitementSuppressionReservation(
			FenetreGestionSuppressionReservation fenetreGestionSuppressionReservation,
			Connect connect) {
		this.fenetreGestionSuppressionReservation=fenetreGestionSuppressionReservation;
		this.connect=connect;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source= arg0.getSource();
		if(source==this.fenetreGestionSuppressionReservation.annuler){
			this.fenetreGestionSuppressionReservation.dispose();
			FenetreChoixGestionReservation a = new FenetreChoixGestionReservation(connect);
		}
		if(source==this.fenetreGestionSuppressionReservation.valider){
			if(!this.fenetreGestionSuppressionReservation.nom.getText().equals("") && !this.fenetreGestionSuppressionReservation.numeroResa.getText().equals("")){
				boolean supp;
				supp=this.connect.gestionReservation.verifSuppResa(this.fenetreGestionSuppressionReservation.nom.getText(),this.fenetreGestionSuppressionReservation.numeroResa.getText());
				if(supp){
					supp=this.connect.gestionReservation.suppResa(this.fenetreGestionSuppressionReservation.numeroResa.getText());
					if(supp){
						this.fenetreGestionSuppressionReservation.dispose();
						JOptionPane.showMessageDialog(null,"Suppression réussi");
					}
					else{
						JOptionPane.showMessageDialog(null,"Echec suppression");

					}
				}
				else{
					JOptionPane.showMessageDialog(null,"Impossible de supprimer cette reservation/aucune reservation à ce nom ou  numéro");

				}
			}
		}
	}

}
