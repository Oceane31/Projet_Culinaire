import java.util.ArrayList;

public class Etape {

	String intitule;
	int duree;
	ArrayList<Ingredient> ingredient;
	Ustensiles ustensile;
	
	public Etape() {
		this.ingredient = new ArrayList<>();
	}
	
	public Etape(String i, ArrayList<Ingredient> l) {
		this.intitule=i;
		this.ingredient=l;
		//this.duree=d;
	}
	
	public String toString() {
		return this.intitule + "duree : "+this.duree+ "listeIngredients: "+this.ingredient+"ustensiles:"+this.ustensile;
	}
	
	public void ajouterIngredient(Ingredient i) {
		this.ingredient.add(i);
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

	public ArrayList<Ingredient> getIngredient() {
		return ingredient;
	}

	public void setIngredient(ArrayList<Ingredient> ingredient) {
		this.ingredient = ingredient;
	}

	public Ustensiles getUstensile() {
		return ustensile;
	}

	public void setUstensile(Ustensiles ustensile) {
		this.ustensile = ustensile;
	}
	
	

	
}
