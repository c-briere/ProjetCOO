import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
=======

>>>>>>> origin/master
import javax.swing.JOptionPane;


public class TraitementModificationCategorie implements ActionListener {

	FenetreModifCategorie fenetreModifCategorie;
	Connect connect;
	int cleHotel;

	public TraitementModificationCategorie(
			FenetreModifCategorie fenetreModifCategorie, Connect connect,
			int cleHotel) {
		this.fenetreModifCategorie=fenetreModifCategorie;
		this.connect=connect;
		this.cleHotel=cleHotel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object e = arg0.getSource();
		int cle =0;
		if(e == this.fenetreModifCategorie.bouttonValider){
			String s = this.fenetreModifCategorie.bouttonValider.getText();
			String nom = this.fenetreModifCategorie.nom.getText();
			if(s.equals("Rechercher")){

				if(!nom.equals("")){
					cle=connect.gestionCategorie.verifCategorie(cleHotel,nom);
					System.out.println(cle);

					if(cle != 0){
						this.fenetreModifCategorie.bouttonValider.setText("Modifier");
						this.fenetreModifCategorie.place.show();
						this.fenetreModifCategorie.prix.show();
						this.fenetreModifCategorie.cleCategorie=cle;
					}
				}
			}
			if(s.equals("Modifier")){
				boolean modif;
				if(!this.fenetreModifCategorie.nom.equals("") && !this.fenetreModifCategorie.place.equals("") && !this.fenetreModifCategorie.prix.equals("") ){
					String nom2=this.fenetreModifCategorie.nom.getText();
					Double place = Double.parseDouble(this.fenetreModifCategorie.place.getText());
					int prix = Integer.parseInt(this.fenetreModifCategorie.prix.getText());
					modif=connect.gestionCategorie.ModifClient(this.fenetreModifCategorie.cleCategorie,nom,place,prix);
					if(modif){
						this.fenetreModifCategorie.dispose();
						JOptionPane.showMessageDialog(null,"Modification réussi");

						new FenetreGestionVille(connect);
					}
					else{
						JOptionPane.showMessageDialog(null,"Echec modification");

					}
				}
			}
		}
		if(e == this.fenetreModifCategorie.bouttonAnnuler){
			this.fenetreModifCategorie.dispose();
			new FenetreGestionVille(connect);

		}

	}
}
