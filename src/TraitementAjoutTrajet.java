import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class TraitementAjoutTrajet implements ActionListener {

	FenetreAjouterPlanning fenetreAjouterPlanning;
	Connect connect;
	int cleLigne;

	public TraitementAjoutTrajet(FenetreAjouterPlanning fenetreAjouterPlanning,
			Connect connect, int cleLigne) {
		this.fenetreAjouterPlanning=fenetreAjouterPlanning;
		this.connect=connect;
		this.cleLigne=cleLigne;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o =arg0.getSource();
		int duree =0;
		double prixPassager1 =0;
		double prixPassager2=0;
		int nbPassager1 =0;
		int nbPassager2=0;
		int annulable=0;

		if(o==fenetreAjouterPlanning.bouttonValider){
	
			String jour = fenetreAjouterPlanning.jour.getSelectedItem().toString();
			String heure = fenetreAjouterPlanning.heure.getText();
			duree = Integer.parseInt(fenetreAjouterPlanning.duree.getText());
			nbPassager1 = Integer.parseInt(fenetreAjouterPlanning.passager1ereclasse.getText());
			prixPassager1 = Double.parseDouble(fenetreAjouterPlanning.prix1ereclasse.getText());
			nbPassager2 = Integer.parseInt(fenetreAjouterPlanning.passager2emeclasse.getText());
			prixPassager2 = Double.parseDouble(fenetreAjouterPlanning.prix2emeclasse.getText());
			annulable = Integer.parseInt(fenetreAjouterPlanning.annulable.getText());
			if(!jour.equals("") && !heure.equals("") && duree!=0 && prixPassager1!=0 && prixPassager2!=0 && nbPassager1 !=0 && nbPassager2!=0 && annulable!=0 ){
				if(this.connect.gestionTrajet.addTrajet(cleLigne,jour,heure,duree,nbPassager1,prixPassager1,nbPassager2,prixPassager2,annulable)){
					JOptionPane.showMessageDialog(null,"Insertion réussi");
					this.fenetreAjouterPlanning.dispose();
					new FenetreGestionLigne(this.connect);

				}
			}

		}
		if(o==fenetreAjouterPlanning.bouttonAnnuler){
			this.fenetreAjouterPlanning.dispose();
			new FenetreGestionLigne(this.connect);
		}

	}
}
