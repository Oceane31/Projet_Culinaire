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
	    onglets.addTab("Entr�e", onglet1);
	    
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
		BouttonRecette risotto_nature= new BouttonRecette("Risotto nature");
	    risotto_nature.setName("risotto");
	    risotto_nature.addMouseListener(mouse);
	    p.add(risotto_nature);
	    risotto_nature.addActionListener(ecouteur);
	
		BouttonRecette poulet_au_curry= new BouttonRecette("Poulet au curry");
		p.add(poulet_au_curry);
		

		BouttonRecette riz_cantonnais= new BouttonRecette("Riz Cantonnais");
		p.add(riz_cantonnais);
		
		BouttonRecette paella= new BouttonRecette("Paella");
		p.add(paella);
		
		BouttonRecette riz_senegalais = new BouttonRecette("Riz senegalais");
		p.add(riz_senegalais);
		onglet2.add(p, BorderLayout.NORTH);

		Panel p1=new Panel(new FlowLayout());
		p1.setPreferredSize(tailleOnglets);
		JButton riz_au_lait= new JButton("Riz au lait");
		p1.add(riz_au_lait);
		
		JButton riz_sucre_au_four= new JButton("Riz sucre au four");
		p1.add(riz_sucre_au_four);
		
		JButton gateau_caramel= new JButton("Gateau de riz au caramel");
		p1.add(gateau_caramel);
		
		JButton galette_de_riz = new JButton("Galette de riz");
		p1.add(galette_de_riz);
		onglet3.add(p1, BorderLayout.NORTH);


		
		Panel p2=new Panel(new FlowLayout());
		p2.setPreferredSize(tailleOnglets);
		JButton salade_fruits_secs= new JButton("Salade de riz aux fruits secs");
		//le newLine est cense etre un retour aï¿½ la ligne mais ca marche pas 
		p2.add(salade_fruits_secs);
		
		JButton salade_thon = new JButton("Salade de riz au thon");
		p2.add(salade_thon);
		
		JButton avocat_salade = new JButton("Avocat au riz en salade");
		p2.add(avocat_salade);
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
