import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


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
		if(o==this.fenetreAjouterHotel.bouttonAnnuler){
			this.fenetreAjouterHotel.dispose();
			new FenetreGestionVille(connect);
		}
		if(o==this.fenetreAjouterHotel.bouttonValider){
			if(!this.fenetreAjouterHotel.hotel.getText().equals("")){
				if(this.connect.gestionHotel.addHotel(cle,this.fenetreAjouterHotel.hotel.getText())){
					JOptionPane.showMessageDialog(null,"Insertion réussi");
					this.fenetreAjouterHotel.dispose();
					new FenetreGestionVille(this.connect);

				}
			}
		}

	}

}
