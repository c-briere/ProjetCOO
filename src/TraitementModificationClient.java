import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;


public class TraitementModificationClient implements ActionListener {

	FenetreModifierClient fenetreModifierClient;
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
		if(e == this.fenetreModifierClient.bouttonValider){
			String s = this.fenetreModifierClient.bouttonValider.getText();
			String nom = this.fenetreModifierClient.nom.getText();
			String prenom = this.fenetreModifierClient.prenom.getText();
			String date = this.fenetreModifierClient.date.getText();
			String ville = this.fenetreModifierClient.ville.getText();
			Date d = null;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			try {
				d = sdf.parse(date);
			}catch (ParseException e1) {
				e1.printStackTrace();
			}
			if(s.equals("Rechercher")){
				
				if(!nom.equals("") && !prenom.equals("") && !date.equals("") && !ville.equals("")){
					try {
						cle=connect.gestionClient.verifClient(nom,prenom,d,ville);
						
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(cle != 0){
						this.fenetreModifierClient.bouttonValider.setText("Modifier");
						this.fenetreModifierClient.cle=cle;
					}
				}
			}
			if(s.equals("Modifier")){
				boolean modif;
				if(!nom.equals("") && !prenom.equals("") && !date.equals("") && !ville.equals("")){
					modif=connect.gestionClient.ModifClient(this.fenetreModifierClient.cle,nom,prenom,d,ville);
					if(modif){
						this.fenetreModifierClient.dispose();
						JOptionPane.showMessageDialog(null,"Modification réussi");

						new FenetreGestionClient(connect);
					}
				}
			}
		}
		if(e==this.fenetreModifierClient.bouttonAnnuler){
			this.fenetreModifierClient.dispose();
			new FenetreGestionClient(connect);
		}

	}

}
