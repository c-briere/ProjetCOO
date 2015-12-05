import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class TraitementSuppressionHotel implements ActionListener {

	FenetreSupprimerHotel fenetreSupprimerHotel;
	Connect connect;
	int cle;
	
	public TraitementSuppressionHotel(
			FenetreSupprimerHotel fenetreSupprimerHotel, Connect connect,
			int cle) {
		this.fenetreSupprimerHotel=fenetreSupprimerHotel;
		this.connect=connect;
		this.cle=cle;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object e = arg0.getSource();
		if(e==this.fenetreSupprimerHotel.bouttonValider){
			if(this.connect.gestionHotel.deleteHotel(cle,this.fenetreSupprimerHotel.hotel.getText())){
				JOptionPane.showMessageDialog(null,"Suppression réussi");
				this.fenetreSupprimerHotel.dispose();
				new FenetreGestionVille(this.connect);
			}
			else{
				JOptionPane.showMessageDialog(null, "echec suppression ou l'hotel n'existe pas" );
			}
		}
		if(e==this.fenetreSupprimerHotel.bouttonAnnuler){
			this.fenetreSupprimerHotel.dispose();
			new FenetreGestionVille(this.connect);
		}

	}

}
