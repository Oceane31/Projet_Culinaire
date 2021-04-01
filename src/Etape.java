import java.util.ArrayList;

public class Etape {

	String intitule;
	int duree;
	ArrayList<Ingredients> ingredient;
	Ustensiles ustensile;
	
	public Etape(String i, ArrayList<Ingredients> l) {
		this.intitule=i;
		this.ingredient=l;
		//this.duree=d;
	}
	
	public void ajouterIngredient(Ingredients i) {
		this.ingredient.add(i);
	}
	
	public static void main(String[] args) {
		ArrayList<Ingredients> ingredients=new ArrayList<Ingredients>();
		ingredients.add(new Ingredients("bouillon de légumes"));
		Etape verserbouillonlegumes=new Etape ("Verser le bouillon de légumes",ingredients);
		
	}

	
}
