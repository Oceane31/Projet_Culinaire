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


public class DetailRecette extends JPanel implements Observer {

	//panel pour l'affichage de l'intitulé des recettes
	
	private static final long serialVersionUID = 1L;
	Recette recette = new Recette();
	Modele m;
	Image image;
	static int largeur = (int) (GUI.LARGEUR * 0.5);
	static int hauteur = (int) (GUI.HAUTEUR * 0.8);

	
	public DetailRecette(Modele m) {
		super();
		this.m = m;
		this.setLayout(new BorderLayout());

		this.setPreferredSize(new Dimension(largeur, hauteur));



		// Definition d'une image par defaut
		try {
			image = ImageIO.read(new File("riz.jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (this.image != null) {
			g.drawImage(this.image, 0, 0, this.getWidth(), this.getHeight(), null);

		} 
		if (this.recette.getNom() != null && !this.recette.getNom().isEmpty()) {
			afficheRecette();
		}
	}


	public void afficheRecette() {

		// Si plusieurs recettes sont trouvees par la barre de recherche
		if(this.m.getRecetteTrouvees().size() > 0) {
			for(final Recette recetteTrouvee : this.m.getRecetteTrouvees()) {
				this.createRecetteFrame(recetteTrouvee);
			}
			
		} else { // sinon on affiche la recette qui provient du clic de la recette
			this.createRecetteFrame(recette);
		}

	}


	private void createRecetteFrame(Recette maRecette) {
		
		// Creation de la fenetre
		JFrame frameDetailRecette = new JFrame();
		frameDetailRecette.setLayout(new BorderLayout());


		int largeur = (int) (GUI.LARGEUR*0.5);
		int hauteur = (int) (GUI.HAUTEUR*1.20);

		// Creation de la partie haute de la recette
		JPanel header = new JPanel();
		header.setLayout(new BorderLayout());
		header.setBackground(Color.WHITE);

		// Titre recette
		String titreRecette = new String(maRecette.getNom());

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
		JLabel lnbPersonnes = new JLabel("recette pour " + maRecette.getNbpersonne() + " personnes", JLabel.CENTER);
		lnbPersonnes.setFont(fontAttributs);
		lnbPersonnes.setForeground(Color.BLUE);
		header.add(lnbPersonnes, BorderLayout.EAST);

		// Ajout du header dans le panel de la recette
		frameDetailRecette.add(header, BorderLayout.NORTH);

		/* ----------------- FIN DES ATTRIBUTS DE LA ZONE NORTH -------------------- */
		/* ----------------- PARTIE DE LA ZONE CENTER -------------------- */
		JPanel center = new JPanel();
		center.setBackground(Color.WHITE);
		
		
		frameDetailRecette.add(center, BorderLayout.CENTER);

		/* ----------------- FIN DES ATTRIBUTS DE LA ZONE CENTER -------------------- */
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
		east.setBackground(Color.WHITE);

		String ustensiles = new String("Ustensiles necessaires:");


		JLabel ustensilesNecesssaires = new JLabel(ustensiles, JLabel.LEFT);
		ustensilesNecesssaires.setFont(fontTitre2);

		east.add(ustensilesNecesssaires, BorderLayout.NORTH);
		
		JPanel panelUstensiles = new JPanel();
		panelUstensiles.setBackground(Color.WHITE);
		panelUstensiles.setLayout(new BoxLayout(panelUstensiles, BoxLayout.Y_AXIS));
		ArrayList<String> ustensilespresents= new ArrayList<String>();
		for (int i = 0; i < maRecette.getEtapes().size(); i++) {
			Etape e = maRecette.getEtapes().get(i);
			Ustensile u = e.getUstensile();
			if (u != null) {
				String ustensile = new String(u.getUstensile());
				JLabel labelUstensile = new JLabel(ustensile);
				labelUstensile.setFont(fontlistes);

				if (ustensilespresents.contains(u.getUstensile())==false) {
					ustensilespresents.add(u.getUstensile());
					panelUstensiles.add(labelUstensile);
				}
			} else {

				JLabel pasdUstensile = new JLabel("pas d'ustensile necessaire");

				east.add(pasdUstensile, BorderLayout.CENTER);
			}
		}
		east.add(panelUstensiles, BorderLayout.CENTER);

		// ajout de east dans le panel de la recette
		frameDetailRecette.add(east, BorderLayout.EAST);

		/* ----------------- FIN DE LA ZONE EASTH -------------------- */

		/* ----------------- PARTIE DE LA ZONE WEST -------------------- */
		/* ----------------- liste des ingredients ---------------------- */
		JPanel west = new JPanel();
		west.setLayout(new BorderLayout());
		west.setBackground(Color.WHITE);


		String listeIngredients = new String("Liste d'ingredients:");

		JLabel titreigd = new JLabel(listeIngredients);
		titreigd.setFont(fontTitre2);

		west.add(titreigd, BorderLayout.NORTH);

		JPanel panelIngredients = new JPanel();
		panelIngredients.setBackground(Color.WHITE);
		panelIngredients.setLayout(new BoxLayout(panelIngredients, BoxLayout.Y_AXIS));
		for (int i = 0; i < maRecette.getEtapes().size(); i++) {
			Etape e = maRecette.getEtapes().get(i);
			Ingredient ingredient = e.getIngredient();
			String quantite = e.getQuantite();
			if (ingredient != null && !ingredient.equals("")) {
				if (!quantite.equals("") && quantite!= null) {
					if(quantite.length()==1) {
					String ingredientStr = new String(ingredient.toString());
					JLabel labelIngredient = new JLabel(quantite+ " " +ingredientStr);
					labelIngredient.setFont(fontlistes);
					panelIngredients.add(labelIngredient);
					}
					else {
						String ingredientStr = new String(ingredient.toString());
						JLabel labelIngredient = new JLabel(quantite + " de " +ingredientStr);
						labelIngredient.setFont(fontlistes);
						panelIngredients.add(labelIngredient);
					
					}
				}
				else {
					String ingredientStr = new String(ingredient.toString());
					JLabel labelIngredient = new JLabel(ingredientStr);
					labelIngredient.setFont(fontlistes);
					panelIngredients.add(labelIngredient);
				}
			} else {

				JLabel pasdIgd = new JLabel("pas d'ingredients n�cessaire");

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
		
	
		for(int i=0; i < maRecette.getEtapes().size(); i++) { 
			Etape e = maRecette.getEtapes().get(i);
			String etape = new String(i+1 +") " +e.getIntitule());
			slider.addSliderComponent(new JLabel(etape, JLabel.CENTER));
		 }
		
		slider.refresh();
		

		// ajout de south dans le panel de la recette
		frameDetailRecette.add(slider, BorderLayout.SOUTH);

		/* ----------------- FIN DE LA ZONE SOUTH -------------------- */

		// Dimensions
		frameDetailRecette.setPreferredSize(new Dimension(largeur, hauteur));
		frameDetailRecette.pack();

		// Affiche la fenetre
		frameDetailRecette.setVisible(true);

	}


	@Override
	public void update(Observable o, Object arg) {
		// Si l'objet recu est une recette, on affiche la recette
		if (arg instanceof Recette) { // Toujours verifier le type avant d'inferer
			this.recette = (Recette) arg;
			this.repaint(0, 0, this.getWidth(), this.getHeight());
		}
	}
	
	private String getDifficulte() {
		String difficulte = "difficulte: ";
		for (int i = 0; i < recette.getDifficulte(); i++) {
			String etoile = new String("*");
			difficulte = difficulte + etoile;
		}

		return difficulte;
	}

	private String getCout() {
		String cout = "cout: ";
		for (int i = 0; i < recette.getCout(); i++) {
			String euros = new String("€");
			cout = cout + euros;
		}

		return cout;
	}

}
