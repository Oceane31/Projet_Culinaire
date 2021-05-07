package culinaire;

import culinaire.structures.Etape;
import culinaire.structures.Ingredient;
import culinaire.structures.Recette;
import culinaire.structures.Ustensile;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.*;

public class Modele extends Observable {

	public HashMap<String, Recette> dicoRecettes;
	private Recette recetteSelectionee;
	private int etapeEnCours;
	private ArrayList<Recette> recetteTrouvees = new ArrayList<Recette>();

	public Modele() {
		this.dicoRecettes = new HashMap<String, Recette>();
	}

	public void init() {
		this.chargerXML();
	}

	@SuppressWarnings("unchecked")
	public void chargerXML() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File("recettes.xml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedInputStream bis = new BufferedInputStream(fis);
		XMLDecoder decoder = new XMLDecoder(bis);
		this.dicoRecettes = (HashMap<String, Recette>) decoder.readObject();
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

	@SuppressWarnings("deprecation")
	public void selectionRecette(String nom) {
		this.recetteSelectionee = dicoRecettes.get(nom);
		this.recetteTrouvees.clear();
		this.setChanged();
		this.notifyObservers(recetteSelectionee);
	}

	@SuppressWarnings("deprecation")
	public void trouveRecettes(ArrayList<Recette> recettes) {
		this.recetteTrouvees = recettes;
		this.setChanged();
		this.notifyObservers(recetteTrouvees);
	}

	@SuppressWarnings("deprecation")
	public void suiviRecette() {
		this.etapeEnCours = 0;
		Etape initalise = this.recetteSelectionee.getEtapes().get(0); // Renvoie l'étape 0 (étape 1)
		this.notifyObservers(initalise);
	}

	public ArrayList<Recette> getRecetteTrouvees() {
		return this.recetteTrouvees;
	}

	public void suivant() {
		// Incrémente étape en cours (ATTENTION PAS DE DEPASSEMENT) et notifie
	}

	public void imageRecette(String nomRecette) {
		Recette recette = dicoRecettes.get(nomRecette);
	}

	public void enregistrerXML() {
		try {
			FileOutputStream fos = new FileOutputStream(new File("recettes.xml"));
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			XMLEncoder encoder = new XMLEncoder(bos);
			encoder.writeObject(this.dicoRecettes);

			// Attention il faut regarder comment serializer le Array d'etapes
			encoder.flush();
			encoder.close();
			bos.close();
			fos.close();

		} catch (IOException e) {
			throw new RuntimeException("Impossible d'écrire les données");
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Modele m = new Modele();

		try (BufferedReader br = new BufferedReader(new FileReader("risotto.csv"))) {
			String line;
			String nomRecette = null;
			int difficulte = 0;
			int cout = 0;
			int nb = 0;
			ArrayList<Etape> listeEtapes = null;
			ArrayList<Ingredient> ingredients = new ArrayList<>();
			ArrayList<Ustensile> ustensiles = new ArrayList<>();
			while ((line = br.readLine()) != null) {

				String[] values = line.split(",");
				if (values[0].equals("recette")) {
					if (nomRecette != null) {
						m.dicoRecettes.put(nomRecette, new Recette(nomRecette, difficulte, cout, nb, listeEtapes));
					}
					nomRecette = values[1];
					difficulte = Integer.parseInt(values[2]);
					cout = Integer.parseInt(values[3]);
					nb = Integer.parseInt(values[4]);
					listeEtapes = new ArrayList<Etape>();
				} else {
					Ingredient ingr = null;
					if (values.length > 1) {
						for (Ingredient i : ingredients) {

							if (i.getIngredient().equals(values[2])) {

								ingr = i;
								break;
							}
						}
						if (ingr == null) {
							ingr = new Ingredient(values[2]);
							ingredients.add(ingr);
						}

						Ustensile ust = null;
						for (Ustensile i : ustensiles) {
							if (i.getUstensile().equals(values[4])) {
								ust = i;
								break;
							}
						}
						if (ust == null) {
							ust = new Ustensile(values[4]);
							ustensiles.add(ust);
						}

						listeEtapes.add(new Etape(values[0], values[1], ingr, Integer.parseInt(values[3]), ust));
					}
				}
				if (nomRecette != null) {
					m.dicoRecettes.put(nomRecette, new Recette(nomRecette, difficulte, cout, nb, listeEtapes));
				}
				m.enregistrerXML();
			}
		}
	}
}
