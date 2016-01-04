package traitement.trajet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BDD.Connect;
import classe_defaut.Trajet;
import vue.ligne.FenetreGestionLigne;
import vue.trajet.FenetreModifPlanning;

/**
 * 
 * @author BRIERE / CARDON
 *
 */
public class TraitementModifTrajet implements ActionListener {

	FenetreModifPlanning fenetreModifPlanning;
	Connect connect;
	int cleLigne;



	public TraitementModifTrajet(FenetreModifPlanning fenetreModifPlanning,
			Connect connect, int cleLigne) {
		this.fenetreModifPlanning=fenetreModifPlanning;
		this.connect=connect;
		this.cleLigne=cleLigne;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o = arg0.getSource();
		Trajet trajet = null;
		if(o==this.fenetreModifPlanning.getBouttonValider()){
			String s =this.fenetreModifPlanning.getBouttonValider().getText();
			if(s.equals("Rechercher")){
				if(!this.fenetreModifPlanning.getDuree().getText().equals("") && !this.fenetreModifPlanning.getHeure().getText().equals("")){
					trajet = this.connect.gestionTrajet.searchTrajet(cleLigne,this.fenetreModifPlanning.getJour().getSelectedItem().toString()
							,Integer.parseInt(this.fenetreModifPlanning.getDuree().getText()),this.fenetreModifPlanning.getHeure().getText());
					if(trajet!=null){
						this.fenetreModifPlanning.getPassager1ereclasse().show();
						this.fenetreModifPlanning.getPassager1ereclasse().setText(Integer.toString(trajet.nbPassager1ere));
						this.fenetreModifPlanning.getPrix1ereclasse().show();
						this.fenetreModifPlanning.getPrix1ereclasse().setText(Double.toString(trajet.prixPassager1ere));
						this.fenetreModifPlanning.getPassager2emeclasse().show();
						this.fenetreModifPlanning.getPassager2emeclasse().setText(Integer.toString(trajet.nbPassager2eme));
						this.fenetreModifPlanning.getPrix2emeclasse().show();
						this.fenetreModifPlanning.getPrix2emeclasse().setText(Double.toString(trajet.prixPassager2eme));
						this.fenetreModifPlanning.getAnnulable().show();
						this.fenetreModifPlanning.getAnnulable().setText(Integer.toString(trajet.annulage));
						this.fenetreModifPlanning.getBouttonValider().setText("Modifier");
						this.fenetreModifPlanning.setTrajet(trajet);
					}
				}
			}

			if(s.equals("Modifier")){

				boolean modif;
				int duree =0;
				int nbPassager1 =0;
				double prixPassager1 =0;
				int nbPassager2 =0;
				double prixPassager2 =0;
				int annulable =0;
				String jour = fenetreModifPlanning.getJour().getSelectedItem().toString();
				String heure = fenetreModifPlanning.getHeure().getText();
				duree = Integer.parseInt(fenetreModifPlanning.getDuree().getText());
				nbPassager1 = Integer.parseInt(fenetreModifPlanning.getPassager1ereclasse().getText());
				prixPassager1 = Double.parseDouble(fenetreModifPlanning.getPrix1ereclasse().getText());
				nbPassager2 = Integer.parseInt(fenetreModifPlanning.getPassager2emeclasse().getText());
				prixPassager2 = Double.parseDouble(fenetreModifPlanning.getPrix2emeclasse().getText());
				annulable = Integer.parseInt(fenetreModifPlanning.getAnnulable().getText());
				if(!jour.equals("") && !heure.equals("") && duree!=0 && prixPassager1!=0 && prixPassager2!=0 && nbPassager1 !=0 && nbPassager2!=0 && annulable!=0 ){
					modif=connect.gestionTrajet.modifTrajet(this.fenetreModifPlanning.getTrajet(),cleLigne,jour,heure,duree,nbPassager1,prixPassager1,nbPassager2,prixPassager2,annulable);
					if(modif){
						this.fenetreModifPlanning.dispose();
						JOptionPane.showMessageDialog(null,"Modification réussi");

						new FenetreGestionLigne(connect);
					}
				}
			}
		}
		if(o==this.fenetreModifPlanning.getBouttonAnnuler()){
			this.fenetreModifPlanning.dispose();
			new FenetreGestionLigne(connect);
		}
	}

}

