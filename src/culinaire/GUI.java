package culinaire;

import culinaire.Modele;
import culinaire.controleurs.BarreDeRecherche;
import culinaire.controleurs.BoutonSurvole;
import culinaire.controleurs.SelectionRecettes;
import culinaire.vues.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GUI extends JFrame {

	public static int LARGEUR = 1200;
	public static int HAUTEUR = 500;

	public static void main(String[] args) {
		new GUI();
	}

	public GUI() {
		
		Modele modele= new Modele();

		SelectionRecettes c=new SelectionRecettes(modele);
		BarreDeRecherche b = new BarreDeRecherche(modele);
		
		this.setLayout(new BorderLayout());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("application");

		// VUES

		BarreDuHaut entete = new BarreDuHaut(b);

		BoutonSurvole bs = new BoutonSurvole(modele);
		ListeRecettes listeRecettes = new ListeRecettes(c, modele, bs);
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
