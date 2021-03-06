package culinaire;

import culinaire.controleurs.BarreDeRecherche;
import culinaire.controleurs.SelectionRecettes;
import culinaire.vues.*;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
	
	// Création de la fenêtre générale

	private static final long serialVersionUID = 1L;
	public static int LARGEUR = 1200;
	public static int HAUTEUR = 500;

	public static void main(String[] args) {
		new GUI();
	}

	@SuppressWarnings({ "deprecation"})
	public GUI() {
		
		Modele modele= new Modele();

		SelectionRecettes c=new SelectionRecettes(modele);
		BarreDeRecherche b = new BarreDeRecherche(modele);
		
		this.setLayout(new BorderLayout());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("application");

		// VUES
		BarreDuHaut entete = new BarreDuHaut(b);


		ListeRecettes listeRecettes = new ListeRecettes(c, modele);
		modele.addObserver(listeRecettes);

		DetailRecette afficheurDetails = new DetailRecette(modele);
		modele.addObserver(afficheurDetails);
		
		PanneauCentral panneau = new PanneauCentral(listeRecettes, afficheurDetails);

		this.add(entete,BorderLayout.NORTH);
		this.add(panneau, BorderLayout.CENTER);

		this.setSize(new Dimension(GUI.LARGEUR, GUI.HAUTEUR));
		modele.init();
		this.setVisible(true);
		
	}
	
}
