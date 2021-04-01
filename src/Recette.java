import java.io.Serializable;
import java.util.ArrayList;

public class Recette implements Serializable{

	private static final long serialVersionUID=1L;
	
	String nom;
	ArrayList<Etape> etapes;
	int difficulte;
	int cout;
	int nbpersonne;
	
	
	public Recette(String n, int d, int c, int nb, ArrayList<Etape> l) {
		this.nom=n;
		this.difficulte=d;
		this.cout=c;
		this.nbpersonne=nb;
		this.etapes=l ;
	}
	
	public void ajouterEtape(Etape e){
		this.etapes.add(e);
	}
	
	public static void main(String[] args) {
		ArrayList<Etape> etape = new ArrayList<Etape>();
		Ingredients bouillondelegumes=new Ingredients("bouillon de légumes");
		ArrayList<Ingredients> ingredients=new ArrayList<Ingredients>();
		ingredients.add(new Ingredients("bouillon de légumes"));
		etape.add(new Etape ("Verser le bouillon de légumes",ingredients));
		Recette risotto=new Recette("risotto",2,5,4,etape);
		System.out.println(risotto);
	}
	
	

}

