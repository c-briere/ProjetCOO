
public class Trajet {
	
	public String jour;
	public String heure;
	public int duree;
	public int nbPassager1ere;
	public double prixPassager1ere;
	public int nbPassager2eme;
	public double prixPassager2eme;
	public int annulage;
	
	public Trajet(String jour,String heure, int duree,int nbPassager1ere,double prixPassager1er, 
			int nbPassager2eme, double prixPassager2eme,int annulable){
		this.jour=jour;
		this.heure=heure;
		this.duree=duree;
		this.nbPassager1ere=nbPassager1ere;
		this.prixPassager1ere=prixPassager1er;
		this.nbPassager2eme=nbPassager2eme;
		this.prixPassager2eme=prixPassager2eme;
		this.annulage=annulable;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getNbPassager1ere() {
		return nbPassager1ere;
	}

	public void setNbPassager1ere(int nbPassager1ere) {
		this.nbPassager1ere = nbPassager1ere;
	}

	public double getPrixPassager1ere() {
		return prixPassager1ere;
	}

	public void setPrixPassager1ere(double prixPassager1ere) {
		this.prixPassager1ere = prixPassager1ere;
	}

	public int getNbPassager2eme() {
		return nbPassager2eme;
	}

	public void setNbPassager2eme(int nbPassager2eme) {
		this.nbPassager2eme = nbPassager2eme;
	}

	public double getPrixPassager2eme() {
		return prixPassager2eme;
	}

	public void setPrixPassager2eme(double prixPassager2eme) {
		this.prixPassager2eme = prixPassager2eme;
	}

	public int getAnnulage() {
		return annulage;
	}

	public void setAnnulage(int annulage) {
		this.annulage = annulage;
	}
	
	

}
