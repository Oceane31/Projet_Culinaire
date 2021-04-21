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
 * Affichage de droite pour le détail d'une recette, ou l'image au survol d'un bouton
 */
public class DetailRecette extends JPanel implements Observer {

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

		int largeur = (int) (GUI.LARGEUR * 0.6);
		int hauteur = (int) (GUI.HAUTEUR * 0.8);

		// Taille de 60% à droite
		this.setPreferredSize(new Dimension(largeur, hauteur));

		// Bordure pour distinguer les différents JPanel, à suppr lors du rendu final
		this.setBorder(BorderFactory.createLineBorder(Color.RED));

		// Définition d'une image par défaut
		try {
			image = ImageIO.read(new File("riz.jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Si une recette est sélectionnée, affiche la recette
	 * Sinon, si il y a une image à afficher, alors bahhh on l'affiche quoi ...
	 * @param g
	 */
	@Override
	public void paint(Graphics g) {
		// On efface tout
		super.paint(g);

		if (this.image != null) {
			g.drawImage(this.image, 0, 0, this.getWidth(), this.getHeight(), null);
		} else if (this.recette != null){
			afficheRecette(g);
		}
	}

	/**
	 * Affiche la recette enregistrée dans this.recette
	 * @param g
	 */
	public void afficheRecette(Graphics g) {
		Font font=new Font("Arial",Font.BOLD, 40);
		String titreRecette= new String(recette.getNom());
		g.setFont(font);
		g.drawString(titreRecette, 270, 100);

		Font fontTitre2=new Font("Arial",Font.BOLD, 35);
		g.setFont(fontTitre2);

		JButton demarrerRecette= new JButton("Démarrer la recette");
		demarrerRecette.setName("Démarrer la recette");
		this.add(demarrerRecette, BorderLayout.SOUTH);

		// String titre2= new String("Déroulement de la recette");
		// g.drawString(titre2, 150, 250);


		String listeingredients= new String("liste d'ingrédients:");
		String ustensiles=new String("Ustensiles nécessaires:");
		Map map = (new Font("Arial", Font.PLAIN, 14)).getAttributes();
		map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		Font newFont = new Font(map);
		g.setFont(newFont);
		g.drawString(listeingredients, 10, 170);
		g.drawString(ustensiles,270, 170);


		Font fontigd= new Font("Arial", Font.PLAIN, 14);
		g.setFont(fontigd);
		ArrayList<Ingredient> liste= new ArrayList<Ingredient>();
		for(int i = 0; i< recette.getEtapes().size(); i++) {
			Etape e= recette.getEtapes().get(i);
			liste=e.getIngredient();
		}
		for(int i=0; i<liste.size(); i++) {
			Ingredient igt=liste.get(i);
			String ingredient= new String(igt.getIngredient());
			g.drawString("- "+ingredient, 100, 190+20*i);
		}
		for(int i = 0; i< recette.getEtapes().size(); i++) {
			Etape e= recette.getEtapes().get(i);
			Ustensile u=e.getUstensile();
			if(u!=null) {
				String ustensile= new String(u.getUstensile());
				g.drawString("- " +ustensile,270 , 190+20*i);
			}
			else {
				g.drawString("pas d'ustensiles neécessaires", 270, 190);
			}
		}

		/*
		for(int i=0; i<r.getEtapes().size(); i++) {
			Etape e=r.getEtapes().get(i);
			String etape= new String(i+1 +") " +e.getIntitule());
			g.drawString(etape,10,300+20*i);
		}
		*/

		Font font2=new Font("Arial",Font.BOLD, 14);
		g.setFont(font2);
		g.setColor(Color.BLUE);

		String difficulte= new String("difficulté: ");
		g.drawString(difficulte, 10, 140);
		for(int i = 0; i< recette.getDifficulte(); i++) {
			String etoile=new String("*");
			g.drawString(etoile, 80+10*i, 140);
		}
		String cout= new String("coût: ");
		g.drawString(cout, 250, 140);
		for(int i = 0; i< recette.getCout(); i++) {
		String euros= new String("€");
		g.drawString(euros, 290+10*i, 140);
		}



		String nbpersonne= new String("recette pour "+ recette.getNbpersonne()+ " personnes");
		g.drawString(nbpersonne, 460, 140);
	}

	/**
	 * Met à jour les variables de notre classe
	 * @param o Ce sera toujours notre Modele normalement, on s'en fout ici
	 * @param arg Peut etre de plusieurs types
	 */
	@Override
	public void update(Observable o, Object arg) {
		// Si l'objet reçu est une recette, on efface l'image et on affiche la recette
		if (arg instanceof Recette) { // Toujours vérifier le type avant d'inférer
			this.recette = (Recette) arg;
			this.image = null;
			this.repaint(0, 0, this.getWidth(), this.getHeight());
		}

		// Si l'objet reçu est une Image, on affiche cette image
		else if (arg instanceof Image) {
			this.recette = null;
			this.image = (Image) arg;
			this.repaint(0, 0, this.getWidth(), this.getHeight());
		}
	}
	
	
	
	
}
