package culinaire.vues;

import culinaire.GUI;
import culinaire.Modele;
import culinaire.structures.Recette;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ListeRecettes extends JPanel implements Observer {

	private Modele m;
	private HashMap<String, Recette> listeRecetes;

	public ListeRecettes(ActionListener ecouteur, Modele m, MouseListener mouse) {
		super();

		this.m = m;

		this.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
		
		JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);

		int largeur = (int) (GUI.LARGEUR *0.5 );
		int hauteur = (int) (GUI.HAUTEUR*0.5 );

		// Taille de chaque onglet
		Dimension tailleOnglets = new Dimension((int) (largeur * 0.8), (int) (hauteur ));

	    JPanel onglet1 = new JPanel();
	    onglet1.setBackground(Color.WHITE);
	    onglet1.setLayout(new BorderLayout());
	    //onglet1.setPreferredSize(new Dimension(largeur, hauteur));
	    onglets.addTab("Entree", onglet1);
	    
	    JPanel onglet2 = new JPanel();
	    onglet2.setLayout(new BorderLayout());
	    onglet2.setBackground(Color.WHITE);
		//onglet2.setPreferredSize(new Dimension(largeur, hauteur));
	    onglets.addTab("Plat", onglet2);

	    JPanel onglet3 = new JPanel();
	    onglet3.setLayout(new BorderLayout());
	    onglet3.setBackground(Color.WHITE);
	    //onglet3.setPreferredSize(new Dimension(largeur, hauteur));
	    onglets.addTab("Dessert", onglet3);
	    onglets.setBackground(Color.WHITE);

	    // FlowLayout pour mettre en retour Ã  la ligne les boutons
	    Panel p=new Panel();
	    p.setLayout(new GridLayout(3,2));
		p.setPreferredSize(tailleOnglets);
		
		// Liste des plats
        final ArrayList<String> mesPlats= new ArrayList<String>();
        mesPlats.add("risotto");
        mesPlats.add("riz et poulet au curry");
        mesPlats.add("Riz Cantonnais");
        mesPlats.add("Paella");
        mesPlats.add("Riz sénégalais");

        for(final String plat : mesPlats) {
            BouttonRecette buttonPlat = new BouttonRecette(plat);
            buttonPlat.setName(plat);
            buttonPlat.addMouseListener(mouse);
            buttonPlat.addActionListener(ecouteur);
            p.add(buttonPlat);
        }

		/*BouttonRecette risotto_nature= new BouttonRecette("Risotto nature");

	    risotto_nature.setName("risotto");
	    risotto_nature.addMouseListener(mouse);
	    p.add(risotto_nature);
	    risotto_nature.addActionListener(ecouteur);

	
		BouttonRecette poulet_au_curry= new BouttonRecette("Poulet au curry");

		poulet_au_curry.setName("riz et poulet au curry");
		poulet_au_curry.addMouseListener(mouse);
		poulet_au_curry.addActionListener(ecouteur);

		p.add(poulet_au_curry);


		BouttonRecette riz_cantonnais= new BouttonRecette("Riz Cantonnais");
		p.add(riz_cantonnais);
		

		riz_cantonnais.setName("riz_cantonnais");
		riz_cantonnais.addMouseListener(mouse);
		riz_cantonnais.addActionListener(ecouteur);
		p.add(riz_cantonnais);
		
		BouttonRecette paella= new BouttonRecette("Paella");
		p.add(paella);
		paella.setName("paella");
		paella.addMouseListener(mouse);
		paella.addActionListener(ecouteur);
		p.add(paella);

		
		BouttonRecette riz_senegalais = new BouttonRecette("Riz senegalais");
		riz_senegalais.setName("riz_senegalais");
		riz_senegalais.addMouseListener(mouse);
		riz_senegalais.addActionListener(ecouteur);

		p.add(riz_senegalais);*/
		
		onglet2.add(p, BorderLayout.NORTH);

		Panel p1=new Panel(new GridLayout(2,2));
		p1.setPreferredSize(tailleOnglets);
		
		// Liste des desserts
        final ArrayList<String> mesDesserts = new ArrayList<String>();
        mesDesserts.add("Riz au lit");
        mesDesserts.add("Riz sucre au four");
        mesDesserts.add("Gateau de riz au caramel");
        mesDesserts.add("Galette de riz");

        for(final String entree : mesDesserts) {
            BouttonRecette buttonDesserts = new BouttonRecette(entree);
            buttonDesserts.setName(entree);
            buttonDesserts.addMouseListener(mouse);
            buttonDesserts.addActionListener(ecouteur);
            p1.add(buttonDesserts);
        }
		
		/*BouttonRecette riz_au_lait= new BouttonRecette("Riz au lait");
		riz_au_lait.setName("riz_au_lait");
		riz_au_lait.addMouseListener(mouse);
		riz_au_lait.addActionListener(ecouteur);
		p1.add(riz_au_lait);
		
		BouttonRecette riz_sucre_au_four= new BouttonRecette("Riz sucre au four");
		riz_sucre_au_four.setName("riz_sucre_au_four");
		riz_sucre_au_four.addMouseListener(mouse);
		riz_sucre_au_four.addActionListener(ecouteur);
		p1.add(riz_sucre_au_four);
		
		BouttonRecette gateau_caramel= new BouttonRecette("Gateau de riz au caramel");
		gateau_caramel.setName("Gateau de riz au caramel");
		gateau_caramel.addMouseListener(mouse);
		gateau_caramel.addActionListener(ecouteur);
		p1.add(gateau_caramel);
		
		BouttonRecette galette_de_riz = new BouttonRecette("Galette de riz");
		galette_de_riz.setName("galette_de_riz");
		galette_de_riz.addMouseListener(mouse);
		galette_de_riz.addActionListener(ecouteur);
		p1.add(galette_de_riz);*/
        
        
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
            buttonEntree.addMouseListener(mouse);
            buttonEntree.addActionListener(ecouteur);
            p2.add(buttonEntree);
        }
        /*
		BouttonRecette salade_fruits_secs= new BouttonRecette("Salade de riz aux fruits secs");
		salade_fruits_secs.setName("salade_fruits_secs");
		salade_fruits_secs.addMouseListener(mouse);
		salade_fruits_secs.addActionListener(ecouteur);
		p2.add(salade_fruits_secs);
		
		BouttonRecette salade_thon = new BouttonRecette("Salade de riz au thon");
		salade_thon.setName("Salade de riz au thon");
		salade_thon.addMouseListener(mouse);
		salade_thon.addActionListener(ecouteur);
		p2.add(salade_thon);
		
		BouttonRecette avocat_salade = new BouttonRecette("Avocat au riz en salade");
		avocat_salade.setName("avocat_salade");
		avocat_salade.addMouseListener(mouse);
		avocat_salade.addActionListener(ecouteur);
		p2.add(avocat_salade);*/
        
		onglet1.add(p2, BorderLayout.NORTH);



	    this.add(onglets);
	    this.setPreferredSize(new Dimension(largeur, hauteur));
	    this.setBackground(Color.WHITE);
	}


	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		if (this.listeRecetes != null) {
			
			// Créer les onglets
			
			this.listeRecetes.forEach((nom, recette) -> {
				// Créer le bouton et ajouter les Listeners
				
				// Si entrée ou plat ou dessert
				// On ajoute dans le bon onglet
			});
			
			// Ajouter les onglets au JPanel
			
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof HashMap) {
			this.listeRecetes = (HashMap<String, Recette>) arg;
			this.repaint();
		}
	}


	
}
