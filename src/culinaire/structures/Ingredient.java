package culinaire.structures;

import java.beans.ConstructorProperties;

public class Ingredient {

	private String ingredient;
	
	public Ingredient() {}
	
	@ConstructorProperties("ingredient")
	public Ingredient(String ingredient) {
		this.ingredient=ingredient;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	
	public String toString() {
		return this.ingredient;
	}
	
	/*
	public static void main(String[] args) {
		culinaire.structures.Ingredient rizrisotto=new culinaire.structures.Ingredient("riz sp�cial risotto");
		culinaire.structures.Ingredient oignon=new culinaire.structures.Ingredient("oignon");
		culinaire.structures.Ingredient bouillondelegumes=new culinaire.structures.Ingredient("bouillon de l�gumes");
		culinaire.structures.Ingredient vinblancsec=new culinaire.structures.Ingredient("vin blanc sec");
		culinaire.structures.Ingredient parmesanrape=new culinaire.structures.Ingredient("parmesan r�p�");
		culinaire.structures.Ingredient beurredoux=new culinaire.structures.Ingredient("beurre doux");
		culinaire.structures.Ingredient huileolive=new culinaire.structures.Ingredient("huile d'olive");
		culinaire.structures.Ingredient sel=new culinaire.structures.Ingredient("sel");
		culinaire.structures.Ingredient poivre=new culinaire.structures.Ingredient("poivre");
	}
	*/

}
