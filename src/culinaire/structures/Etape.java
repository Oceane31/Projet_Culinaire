package culinaire.structures;

import java.io.Serializable;
import java.util.ArrayList;

public class Etape implements Serializable {

	private static final long serialVersionUID = 1L;

	private String intitule;
	private int duree;
	private Ingredient ingredient;
	private Ustensile ustensile;
	private String quantite;
	
	public Etape(String i, String qt, Ingredient l, int d, Ustensile u) {
		this.intitule=i;
		this.quantite = qt;
		this.ingredient=l;
		this.duree=d;
		this.ustensile = u;
	}
	
	public String toString() {
		return "etape: "+this.intitule +"\n" + "duree : "+this.duree+"\n" + "listeIngredients: "+this.ingredient+"\n" +"ustensiles:"+this.ustensile+"\n" ;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public Ustensile getUstensile() {
		return ustensile;
	}

	public void setUstensile(Ustensile ustensile) {
		this.ustensile = ustensile;
	}
	
	

	
}
