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

}
