import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class TraitementAjoutCategorie implements ActionListener {

	FenetreAjouterCategorie fenetreAjouterCategorie;
	Connect connect;
	int cleHotel;

	public TraitementAjoutCategorie(
			FenetreAjouterCategorie fenetreAjouterCategorie, Connect connect,
			int cleHotel) {
		this.fenetreAjouterCategorie=fenetreAjouterCategorie;
		this.connect=connect;
		this.cleHotel=cleHotel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) throws  NumberFormatException {
		Object o = arg0.getSource();
		if(o==this.fenetreAjouterCategorie.bouttonValider){
			if(!this.fenetreAjouterCategorie.nom.getText().equals("") && !this.fenetreAjouterCategorie.place.getText().equals("") && !this.fenetreAjouterCategorie.prix.getText().equals("")){
				String nom = this.fenetreAjouterCategorie.nom.getText();
				double prix =0;
				int place =0;
				try{
					prix = Double.parseDouble(this.fenetreAjouterCategorie.prix.getText().trim());				
					place = Integer.parseInt(this.fenetreAjouterCategorie.place.getText().trim());
				}
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "mettre le bon format pour le prix/le nombre de place");


				}
				if(prix!=0 && place != 0){
					if(this.connect.gestionCategorie.addCategorie(cleHotel,nom,prix,place)){
						JOptionPane.showMessageDialog(null, "insertion effectu�e");
						this.fenetreAjouterCategorie.dispose();
						new FenetreGestionVille(this.connect);
					}
					else{
						JOptionPane.showMessageDialog(null, "Insertion �chou�e");
					}
				}
			}
		}
		if(o==this.fenetreAjouterCategorie.bouttonAnnuler){
			this.fenetreAjouterCategorie.dispose();
			new FenetreGestionVille(this.connect);
		}

	}

}
