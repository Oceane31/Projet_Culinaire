
public class Ingredient {

	String ingredient;
	
	public Ingredient() {}
	
	public Ingredient(String i) {
		this.ingredient=i;
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
		Ingredient rizrisotto=new Ingredient("riz sp�cial risotto");
		Ingredient oignon=new Ingredient("oignon");
		Ingredient bouillondelegumes=new Ingredient("bouillon de l�gumes");
		Ingredient vinblancsec=new Ingredient("vin blanc sec");
		Ingredient parmesanrape=new Ingredient("parmesan r�p�");
		Ingredient beurredoux=new Ingredient("beurre doux");
		Ingredient huileolive=new Ingredient("huile d'olive");
		Ingredient sel=new Ingredient("sel");
		Ingredient poivre=new Ingredient("poivre");
	}
	*/

}
