package traitement.client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import BDD.Connect;
import vue.client.FenetreGestionClient;
import vue.client.FenetreModifierClient;


public class TraitementModificationClient implements ActionListener {

	protected FenetreModifierClient fenetreModifierClient;
	Connect connect;

	public TraitementModificationClient(
			FenetreModifierClient fenetreModifierClient, Connect connect) {
		this.fenetreModifierClient=fenetreModifierClient;
		this.connect=connect;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object e = arg0.getSource();
		int cle =0;
		if(e == this.fenetreModifierClient.getBouttonValider()){
			String s = this.fenetreModifierClient.getBouttonValider().getText();
			String nom = this.fenetreModifierClient.getNom().getText();
			String prenom = this.fenetreModifierClient.getPrenom().getText();
			String date = this.fenetreModifierClient.getDate().getText();
			String ville = this.fenetreModifierClient.getVille().getText();
			Date d = null;
			/*SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			try {
				d = sdf.parse(date);
			}catch (ParseException e1) {
				e1.printStackTrace();
			}*/
			if(s.equals("Rechercher")){
				
				if(!nom.equals("") && !prenom.equals("") && !date.equals("") && !ville.equals("")){
					try {
						cle=connect.gestionClient.verifClient(nom,prenom,date,ville);
						
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					if(cle != 0){
						this.fenetreModifierClient.getBouttonValider().setText("Modifier");
						this.fenetreModifierClient.setCle(cle);
					}
				}
			}
			if(s.equals("Modifier")){
				boolean modif;
				if(!nom.equals("") && !prenom.equals("") && !date.equals("") && !ville.equals("")){
					modif=connect.gestionClient.ModifClient(this.fenetreModifierClient.getCle(),nom,prenom,date,ville);
					if(modif){
						this.fenetreModifierClient.dispose();
						JOptionPane.showMessageDialog(null,"Modification réussi");

						new FenetreGestionClient(connect);
					}
				}
			}
		}
		if(e==this.fenetreModifierClient.getBouttonAnnuler()){
			this.fenetreModifierClient.dispose();
			new FenetreGestionClient(connect);
		}

	}

}
