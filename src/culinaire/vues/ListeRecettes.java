package culinaire.vues;

import culinaire.GUI;
import culinaire.Modele;
import culinaire.structures.Recette;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class ListeRecettes extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	
	private Modele m;
	private HashMap<String, Recette> listeRecetes;

	public ListeRecettes(ActionListener ecouteur, Modele m) {
		super();

		this.m = m;
		
		JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);

		int largeur = (int) (GUI.LARGEUR *0.5 );
		int hauteur = (int) (GUI.HAUTEUR*0.5 );

		// Taille de chaque onglet
		Dimension tailleOnglets = new Dimension((int) (largeur * 0.8), (int) (hauteur ));

	    JPanel onglet1 = new JPanel();
	    onglet1.setBackground(Color.WHITE);
	    onglet1.setLayout(new BorderLayout());
	    onglets.addTab("Entree", onglet1);
	    
	    JPanel onglet2 = new JPanel();
	    onglet2.setLayout(new BorderLayout());
	    onglet2.setBackground(Color.WHITE);
	    onglets.addTab("Plat", onglet2);

	    JPanel onglet3 = new JPanel();
	    onglet3.setLayout(new BorderLayout());
	    onglet3.setBackground(Color.WHITE);
	    onglets.addTab("Dessert", onglet3);
	    onglets.setBackground(Color.WHITE);

	    //Création d'un gridLayout
	    Panel p=new Panel();
	    p.setLayout(new GridLayout(3,2));
		p.setPreferredSize(tailleOnglets);
		
		// Liste des plats
        final ArrayList<String> mesPlats= new ArrayList<String>();
        mesPlats.add("Risotto");
        mesPlats.add("Riz et Poulet au curry");
        mesPlats.add("Riz Cantonnais");
        mesPlats.add("Paella");
        mesPlats.add("Riz senegalais");

        for(final String plat : mesPlats) {
            BouttonRecette buttonPlat = new BouttonRecette(plat);
            buttonPlat.setName(plat);
            buttonPlat.addActionListener(ecouteur);
            p.add(buttonPlat);
        }

		onglet2.add(p, BorderLayout.NORTH);

		Panel p1=new Panel(new GridLayout(2,2));
		p1.setPreferredSize(tailleOnglets);
		
		// Liste des desserts
        final ArrayList<String> mesDesserts = new ArrayList<String>();
        mesDesserts.add("Riz au lait");
        mesDesserts.add("Riz sucre au four");
        mesDesserts.add("Gateau de riz au caramel");
        mesDesserts.add("Galettes de riz");

        for(final String dessert : mesDesserts) {
            BouttonRecette buttonDesserts = new BouttonRecette(dessert);
            buttonDesserts.setName(dessert);
            buttonDesserts.addActionListener(ecouteur);
            p1.add(buttonDesserts);
        }

		onglet3.add(p1, BorderLayout.NORTH);

		Panel p2=new Panel(new GridLayout(2,2));
		p2.setPreferredSize(tailleOnglets);
		
		// Liste des entrees
        final ArrayList<String> mesEntrees = new ArrayList<String>();
        mesEntrees.add("Salade de riz aux fruits secs");
        mesEntrees.add("Salade de riz au thon");
        mesEntrees.add("Avocat au riz en salade");

        for(final String entree : mesEntrees) {
            BouttonRecette buttonEntree = new BouttonRecette(entree);
            buttonEntree.setName(entree);
            buttonEntree.addActionListener(ecouteur);
            p2.add(buttonEntree);
        }
        
		onglet1.add(p2, BorderLayout.NORTH);

	    this.add(onglets);
	    this.setPreferredSize(new Dimension(largeur, hauteur));
	    this.setBackground(Color.WHITE);
	}


	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof HashMap) {
			this.listeRecetes = (HashMap<String, Recette>) arg;
			this.repaint();
		}
	}


	
}
