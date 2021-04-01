import java.io.Serializable;
import java.util.ArrayList;

public class Recette implements Serializable{

	private static final long serialVersionUID=1L;
	
	String nom;
	ArrayList<Etape> etapes;
	int difficulte;
	int cout;
	int nbpersonne;
	
	public Recette() {
		this.etapes=new ArrayList();
	}
	
	public String toString() {
		return this.nom + " ("+this.difficulte + ")";
	}
	
	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public ArrayList<Etape> getEtapes() {
		return etapes;
	}



	public void setEtapes(ArrayList<Etape> etapes) {
		this.etapes = etapes;
	}



	public int getDifficulte() {
		return difficulte;
	}



	public void setDifficulte(int difficulte) {
		this.difficulte = difficulte;
	}



	public int getCout() {
		return cout;
	}



	public void setCout(int cout) {
		this.cout = cout;
	}



	public int getNbpersonne() {
		return nbpersonne;
	}



	public void setNbpersonne(int nbpersonne) {
		this.nbpersonne = nbpersonne;
	}



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
		Ingredients bouillondelegumes=new Ingredients("bouillon de l�gumes");
		ArrayList<Ingredients> ingredients=new ArrayList<Ingredients>();
		ingredients.add(new Ingredients("bouillon de l�gumes"));
		etape.add(new Etape ("Verser le bouillon de l�gumes",ingredients));
		Recette risotto=new Recette("risotto",2,5,4,etape);
		System.out.println(risotto);
	}
	
	

}
