import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class TraitementAjoutVille implements ActionListener {

	FenetreAjouterVille fenetreAjouterVille;
	Connect connect;

	public TraitementAjoutVille(FenetreAjouterVille fenetreAjouterVille,
			Connect connect) {
		this.fenetreAjouterVille=fenetreAjouterVille;
		this.connect=connect;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o==this.fenetreAjouterVille.bouttonValider){
			if(!this.fenetreAjouterVille.ville.getText().equals("")){
				if(this.connect.gestionVille.addVille(this.fenetreAjouterVille.ville.getText())){
					JOptionPane.showMessageDialog(null,"Insertion réussi");
					this.fenetreAjouterVille.dispose();
					new FenetreGestionVille(this.connect);

				}
			}
		}
		
		if(o==this.fenetreAjouterVille.bouttonAnnuler){
			this.fenetreAjouterVille.dispose();
			new FenetreGestionVille(this.connect);
		}

	}

}
