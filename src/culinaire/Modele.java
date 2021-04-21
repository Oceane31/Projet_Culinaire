package culinaire;

import culinaire.structures.Etape;
import culinaire.structures.Ingredient;
import culinaire.structures.Recette;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

public class Modele extends Observable {

	private HashMap<String,Recette> dicoRecettes;
	private Recette recetteSelectionee;
	private int etapeEnCours;

	public Modele() {
		this.dicoRecettes =new HashMap<String,Recette>();
	}

	public void init() {
		this.chargerXML();
	}
	
	public void chargerXML() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File("recettes.xml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedInputStream bis = new BufferedInputStream(fis);
		XMLDecoder decoder = new XMLDecoder(bis);
		this.dicoRecettes = (HashMap<String,Recette>)decoder.readObject();
		decoder.close();
		try {
			bis.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String toString() {
		return this.dicoRecettes.toString();
	}
	
	public void selectionRecette(String nom) {
		this.recetteSelectionee = dicoRecettes.get(nom);
		this.setChanged();
		this.notifyObservers(recetteSelectionee);
	}

	public void suiviRecette() {
		this.etapeEnCours = 0;
		Etape initalise = this.recetteSelectionee.getEtapes().get(0); // Renvoie l'étape 0 (étape 1)
		this.notifyObservers(initalise);
	}

	public void suivant() {
		// Incrémente étape en cours (ATTENTION PAS DE DEPASSEMENT) et notifie
	}

	public void imageRecette(String nomRecette){

	}

	public void enregistrerXML() {
		try {
			FileOutputStream fos = new FileOutputStream(new File("recettes.xml"));
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			XMLEncoder encoder = new XMLEncoder(bos);
			encoder.writeObject(this.dicoRecettes);
			encoder.flush();
			encoder.close();
			bos.close();
			fos.close();

		} catch (IOException e) {
			throw new RuntimeException("Impossible d'écrire les données");
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Modele m =new Modele();
		
		Ingredient bouillondelegumes=new Ingredient("bouillon de l�gumes");
		ArrayList<Ingredient> ingredients=new ArrayList<Ingredient>();
		ingredients.add(bouillondelegumes);
		
		Ingredient oignon = new Ingredient("oignon");
		ingredients.add(oignon);
		
		ArrayList<Etape> listeEtapes = new ArrayList<Etape>();
		listeEtapes.add(new Etape ("Verser le bouillon de l�gumes",ingredients));
		listeEtapes.add(new Etape ("Faire revenir les oignons", ingredients));
		
		Recette risotto=new Recette("risotto",2,5,4,listeEtapes);
		System.out.println(risotto);
		
		m.dicoRecettes.put("risotto",risotto);
		m.enregistrerXML();
		//m.chargerXML();
		System.out.println(m);
	}
}
