package traitement.reservation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BDD.Connect;
import vue.reservation.FenetreChoixGestionReservation;
import vue.reservation.FenetreGestionSuppressionReservation;


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
		if(source==this.fenetreGestionSuppressionReservation.getAnnuler()){
			this.fenetreGestionSuppressionReservation.dispose();
			FenetreChoixGestionReservation a = new FenetreChoixGestionReservation(connect);
		}
		if(source==this.fenetreGestionSuppressionReservation.getValider()){
			if(!this.fenetreGestionSuppressionReservation.getNom().getText().equals("") && !this.fenetreGestionSuppressionReservation.getNumeroResa().getText().equals("")){
				boolean supp;
				supp=this.connect.gestionReservation.verifSuppResa(this.fenetreGestionSuppressionReservation.getNom().getText(),this.fenetreGestionSuppressionReservation.getNumeroResa().getText());
				if(supp){
					supp=this.connect.gestionReservation.suppResa(this.fenetreGestionSuppressionReservation.getNumeroResa().getText());
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
