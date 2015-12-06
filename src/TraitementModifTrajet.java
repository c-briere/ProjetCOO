import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


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
		if(o==this.fenetreModifPlanning.bouttonValider){
			String s =this.fenetreModifPlanning.bouttonValider.getText();
			if(s.equals("Rechercher")){
				if(!this.fenetreModifPlanning.duree.getText().equals("") && !this.fenetreModifPlanning.heure.getText().equals("")){
					trajet = this.connect.gestionTrajet.searchTrajet(cleLigne,this.fenetreModifPlanning.jour.getSelectedItem().toString()
							,Integer.parseInt(this.fenetreModifPlanning.duree.getText()),this.fenetreModifPlanning.heure.getText());
					if(trajet!=null){
						this.fenetreModifPlanning.passager1ereclasse.show();
						this.fenetreModifPlanning.passager1ereclasse.setText(Integer.toString(trajet.nbPassager1ere));
						this.fenetreModifPlanning.prix1ereclasse.show();
						this.fenetreModifPlanning.prix1ereclasse.setText(Double.toString(trajet.prixPassager1ere));
						this.fenetreModifPlanning.passager2emeclasse.show();
						this.fenetreModifPlanning.passager2emeclasse.setText(Integer.toString(trajet.nbPassager2eme));
						this.fenetreModifPlanning.prix2emeclasse.show();
						this.fenetreModifPlanning.prix2emeclasse.setText(Double.toString(trajet.prixPassager2eme));
						this.fenetreModifPlanning.annulable.show();
						this.fenetreModifPlanning.annulable.setText(Integer.toString(trajet.annulage));
						this.fenetreModifPlanning.bouttonValider.setText("Modifier");
						this.fenetreModifPlanning.trajet=trajet;
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
				String jour = fenetreModifPlanning.jour.getSelectedItem().toString();
				String heure = fenetreModifPlanning.heure.getText();
				duree = Integer.parseInt(fenetreModifPlanning.duree.getText());
				nbPassager1 = Integer.parseInt(fenetreModifPlanning.passager1ereclasse.getText());
				prixPassager1 = Double.parseDouble(fenetreModifPlanning.prix1ereclasse.getText());
				nbPassager2 = Integer.parseInt(fenetreModifPlanning.passager2emeclasse.getText());
				prixPassager2 = Double.parseDouble(fenetreModifPlanning.prix2emeclasse.getText());
				annulable = Integer.parseInt(fenetreModifPlanning.annulable.getText());
				if(!jour.equals("") && !heure.equals("") && duree!=0 && prixPassager1!=0 && prixPassager2!=0 && nbPassager1 !=0 && nbPassager2!=0 && annulable!=0 ){
					modif=connect.gestionTrajet.modifTrajet(this.fenetreModifPlanning.trajet,cleLigne,jour,heure,duree,nbPassager1,prixPassager1,nbPassager2,prixPassager2,annulable);
					if(modif){
						this.fenetreModifPlanning.dispose();
						JOptionPane.showMessageDialog(null,"Modification réussi");

						new FenetreGestionLigne(connect);
					}
				}
			}
		}
		if(o==this.fenetreModifPlanning.bouttonAnnuler){
			this.fenetreModifPlanning.dispose();
			new FenetreGestionLigne(connect);
		}
	}

}

