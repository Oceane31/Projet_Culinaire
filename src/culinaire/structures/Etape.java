package culinaire.structures;

import java.beans.ConstructorProperties;
import java.io.Serializable;

public class Etape implements Serializable {

	private static final long serialVersionUID = 1L;

	private String intitule;
	private int duree;
	private Ingredient ingredient;
	private Ustensile ustensile;
	private String quantite;
	
	@ConstructorProperties({"intitule", "quantite", "ingredient", "duree", "ustensile"})
	public Etape(String intitule, String quantite, Ingredient ingredient, int duree, Ustensile ustensile) {
		this.intitule=intitule;
		this.quantite = quantite;
		this.ingredient=ingredient;
		this.duree=duree;
		this.ustensile = ustensile;
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
	
	public String getQuantite() {
		return quantite;
	}
	public void Quantite(String quantite) {
		this.quantite = quantite;
	}
	
	

	
}
