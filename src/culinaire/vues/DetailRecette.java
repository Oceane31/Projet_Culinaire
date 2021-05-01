package culinaire.vues;

import culinaire.GUI;
import culinaire.Modele;
import culinaire.structures.Etape;
import culinaire.structures.Ingredient;
import culinaire.structures.Recette;
import culinaire.structures.Ustensile;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Affichage de droite pour le dï¿½tail d'une recette, ou l'image au survol d'un
 * bouton
 */
public class DetailRecette extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Recette recette = new Recette();
	Modele m;
	Image image;

	/**
	 * @param m Modele généré dans GUI
	 */
	public DetailRecette(Modele m) {
		super();
		this.m = m;
		this.setLayout(new BorderLayout());

		int largeur = (int) (GUI.LARGEUR * 0.5);
		int hauteur = (int) (GUI.HAUTEUR * 0.8);

		// Taille de 60% ï¿½ droite
		this.setPreferredSize(new Dimension(largeur, hauteur));

		// Bordure pour distinguer les diffï¿½rents JPanel, ï¿½ suppr lors du rendu
		// final
		this.setBorder(BorderFactory.createLineBorder(Color.RED));

		// Dï¿½finition d'une image par dï¿½faut
		try {
			image = ImageIO.read(new File("riz.jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Si une recette est sï¿½lectionnï¿½e, affiche la recette Sinon, si il y a une
	 * image ï¿½ afficher, alors bahhh on l'affiche quoi ...
	 * 
	 * @param g
	 */
	@Override
	public void paintComponent(Graphics g) {
		// On efface tout
		super.paintComponent(g);

		if (this.image != null) {
			g.drawImage(this.image, 0, 0, this.getWidth(), this.getHeight(), null);
		} else if (this.recette != null) {
			afficheRecette();
		}
	}

	/**
	 * Affiche la recette enregistrï¿½e dans this.recette
	 * 
	 * @param g
	 */
	public void afficheRecette() {

		// Creation de la fenetre
		JFrame frameDetailRecette = new JFrame();
		frameDetailRecette.setLayout(new BorderLayout());

		int largeur = (int) (GUI.LARGEUR);
		int hauteur = (int) (GUI.HAUTEUR);

		// Creation de la partie haute de la recette
		JPanel header = new JPanel();
		header.setLayout(new BorderLayout());

		// Titre recette
		String titreRecette = new String(recette.getNom());

		JLabel titre = new JLabel(titreRecette, JLabel.CENTER);
		Font fontTitre = new Font("Arial", Font.BOLD, 40);
		titre.setFont(fontTitre);
		header.add(titre, BorderLayout.NORTH);

		/* ----------------- ATTRIBUTS DE LA ZONE NORTH -------------------- */
		Font fontAttributs = new Font("Arial", Font.BOLD, 14);

		/* Attribut Difficulte sur la zone WEST */
		JLabel lDifficulte = new JLabel(getDifficulte(), JLabel.CENTER);
		lDifficulte.setFont(fontAttributs);
		lDifficulte.setForeground(Color.BLUE);
		header.add(lDifficulte, BorderLayout.WEST);

		// Attribut Cout sur la zone CENTER
		JLabel lCout = new JLabel(getCout(), JLabel.CENTER);
		lCout.setFont(fontAttributs);
		lCout.setForeground(Color.BLUE);
		header.add(lCout, BorderLayout.CENTER);

		// Attribut nb personnes sur la zone EAST
		JLabel lnbPersonnes = new JLabel("recette pour " + recette.getNbpersonne() + " personnes", JLabel.CENTER);
		lnbPersonnes.setFont(fontAttributs);
		lnbPersonnes.setForeground(Color.BLUE);
		header.add(lnbPersonnes, BorderLayout.EAST);

		// Ajout du header dans le panel de la recette
		frameDetailRecette.add(header, BorderLayout.NORTH);

		/* ----------------- FIN DES ATTRIBUTS DE LA ZONE NORTH -------------------- */

		// Creation de la font pour le titre des ingredients et des ustensiles
		Map map = (new Font("Arial", Font.PLAIN, 14)).getAttributes();
		map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		Font fontTitre2 = new Font(map);

		// Creation de la font pour les liste d'ingredients et d'ustensiles
		Font fontlistes = new Font("Arial", Font.PLAIN, 14);

		/* ----------------- PARTIE DE LA ZONE EAST -------------------- */
		/* ----------------- liste des ustensiles ---------------------- */
		JPanel east = new JPanel();
		east.setLayout(new BorderLayout());

		String ustensiles = new String("Ustensiles nécessaires:");
		JLabel ustensilesNecesssaires = new JLabel(ustensiles, JLabel.CENTER);
		ustensilesNecesssaires.setFont(fontTitre2);

		east.add(ustensilesNecesssaires, BorderLayout.NORTH);

		for (int i = 0; i < recette.getEtapes().size(); i++) {
			Etape e = recette.getEtapes().get(i);
			Ustensile u = e.getUstensile();
			if (u != null) {
				String ustensile = new String(u.getUstensile());
				JLabel labelUstensile = new JLabel(ustensile);
				labelUstensile.setFont(fontlistes);
				east.add(labelUstensile, BorderLayout.CENTER);
			} else {
				JLabel pasdUstensile = new JLabel("pas d'ustensile nécessaire");
				east.add(pasdUstensile, BorderLayout.CENTER);
			}
		}

		// ajout de east dans le panel de la recette
		frameDetailRecette.add(east, BorderLayout.EAST);

		/* ----------------- FIN DE LA ZONE EASTH -------------------- */

		/* ----------------- PARTIE DE LA ZONE WEST -------------------- */
		/* ----------------- liste des ingredients ---------------------- */
		JPanel west = new JPanel();
		west.setLayout(new BorderLayout());

		String listeIngredients = new String("Liste d'ingrédients:");
		JLabel titreigd = new JLabel(listeIngredients, JLabel.CENTER);
		titreigd.setFont(fontTitre2);

		west.add(titreigd, BorderLayout.NORTH);

		JPanel panelIngredients = new JPanel();
		panelIngredients.setLayout(new BoxLayout(panelIngredients, BoxLayout.Y_AXIS));
		for (int i = 0; i < this.recette.getEtapes().size(); i++) {
			Etape e = this.recette.getEtapes().get(i);
			Ingredient ingredient = e.getIngredient();
			if (ingredient != null && !ingredient.equals("")) {
				String ingredientStr = new String(ingredient.toString());
				JLabel labelIngredient = new JLabel(ingredientStr);
				labelIngredient.setFont(fontlistes);
				
				panelIngredients.add(labelIngredient);
				// west.add(labelIngredient, BorderLayout.CENTER);
			} else {
				JLabel pasdIgd = new JLabel("pas d'ingrédients nécessaire");
				east.add(pasdIgd, BorderLayout.CENTER);
			}
		}
		
		west.add(panelIngredients, BorderLayout.CENTER);

		// ajout de west dans le panel de la recette
		frameDetailRecette.add(west, BorderLayout.WEST);

		/* ----------------- FIN DE LA ZONE WEST -------------------- */

		/* ----------------- PARTIE DE LA ZONE SOUTH -------------------- */
		/* ----------------- liste des etapes ---------------------- */

		SliderEtapes slider = new SliderEtapes();
		
		// ajout de fausses etapes en attendant que le xml fonctionne
		/*ArrayList<String> faussesEtapes = new ArrayList<String>();
		faussesEtapes.add("Etape 1");
		faussesEtapes.add("Etape 2");
		faussesEtapes.add("Etape 3");
		
		for(int i=0; i < faussesEtapes.size(); i++) { 
			slider.addSliderComponent(new JLabel(faussesEtapes.get(i)));
		 }*/
		for(int i=0; i < this.recette.getEtapes().size(); i++) { 
			Etape e = this.recette.getEtapes().get(i);
			String etape= new String(i+1 +") " +e.getIntitule());
			slider.addSliderComponent(new JLabel(etape));
		 }
		
		slider.refresh();
		//south.setLayout(new BorderLayout());

		
		/*JButton flecheDroite = new JButton(">");
		south.add(flecheDroite, BorderLayout.EAST);

		JButton flecheGauche = new JButton("<");
		south.add(flecheGauche, BorderLayout.WEST);

		// Je mets juste un titre Etape pour montrer ou seront placer les Ã©tapes
		String titreEtape = new String("ETAPES");

		JLabel titreE = new JLabel(titreEtape, JLabel.CENTER);
		titreE.setFont(fontTitre);
		south.add(titreE, BorderLayout.NORTH);*/

		// ajout de south dans le panel de la recette
		frameDetailRecette.add(slider, BorderLayout.SOUTH);

		/* ----------------- FIN DE LA ZONE SOUTH -------------------- */

		// Dimensions
		frameDetailRecette.setPreferredSize(new Dimension(largeur, hauteur));
		frameDetailRecette.pack();

		// Affiche la fenetre
		frameDetailRecette.setVisible(true);

		/*
		 * for(int i=0; i<r.getEtapes().size(); i++) { Etape e=r.getEtapes().get(i);
		 * String etape= new String(i+1 +") " +e.getIntitule());
		 * g.drawString(etape,10,300+20*i); }
		 */

	}

	/**
	 * Met ï¿½ jour les variables de notre classe
	 * 
	 * @param o   Ce sera toujours notre Modele normalement, on s'en fout ici
	 * @param arg Peut etre de plusieurs types
	 */
	@Override
	public void update(Observable o, Object arg) {
		// Si l'objet reï¿½u est une recette, on efface l'image et on affiche la recette
		if (arg instanceof Recette) { // Toujours vï¿½rifier le type avant d'infï¿½rer
			this.recette = (Recette) arg;
			this.image = null;
			this.repaint(0, 0, this.getWidth(), this.getHeight());
		}

		// Si l'objet reï¿½u est une Image, on affiche cette image
		else if (arg instanceof Image) {
			this.recette = null;
			this.image = (Image) arg;
			this.repaint(0, 0, this.getWidth(), this.getHeight());
		}
	}

	private String getDifficulte() {
		String difficulte = "difficultï¿½: ";
		for (int i = 0; i < recette.getDifficulte(); i++) {
			String etoile = new String("*");
			difficulte = difficulte + etoile;
		}

		return difficulte;
	}

	private String getCout() {
		String cout = "cout: ";
		for (int i = 0; i < recette.getCout(); i++) {
			String euros = new String("â‚¬");
			cout = cout + euros;
		}

		return cout;
	}

}
