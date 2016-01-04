package traitement.hotel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BDD.Connect;
import vue.hotel.FenetreAjouterHotel;
import vue.ville.FenetreGestionVille;


public class TraitementAjoutHotel implements ActionListener {

	FenetreAjouterHotel fenetreAjouterHotel;
	Connect connect;
	int cle;

	public TraitementAjoutHotel(FenetreAjouterHotel fenetreAjouterHotel,
			Connect connect, int cle) {
		this.fenetreAjouterHotel=fenetreAjouterHotel;
		this.connect=connect;
		this.cle=cle;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o==this.fenetreAjouterHotel.getBouttonAnnuler()){
			this.fenetreAjouterHotel.dispose();
			new FenetreGestionVille(connect);
		}
		if(o==this.fenetreAjouterHotel.getBouttonValider()){
			if(!this.fenetreAjouterHotel.getHotel().getText().equals("")){
				if(this.connect.gestionHotel.addHotel(cle,this.fenetreAjouterHotel.getHotel().getText())){
					JOptionPane.showMessageDialog(null,"Insertion réussi");
					this.fenetreAjouterHotel.dispose();
					new FenetreGestionVille(this.connect);

				}
			}
		}

	}

}
