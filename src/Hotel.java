import java.util.ArrayList;


public class Hotel {

   String nom;
   ArrayList<Categorie> categorieChambre;
   
   public Hotel(String nom){
	   this.nom=nom;
	   categorieChambre =new ArrayList<Categorie>();
	   
   }

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public ArrayList<Categorie> getCategorieChambre() {
	return categorieChambre;
}

public void setCategorieChambre(ArrayList<Categorie> categorieChambre) {
	this.categorieChambre = categorieChambre;
}
   
   
public void addCategorieChambre(Categorie c){
	categorieChambre.add(c);
}

public void suppCategorieChambre(Categorie c){
	categorieChambre.remove(c);
}
   
}
