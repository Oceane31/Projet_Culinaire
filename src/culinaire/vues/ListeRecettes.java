package culinaire.vues;

import culinaire.GUI;
import culinaire.Modele;
import culinaire.structures.Recette;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class ListeRecettes extends JPanel implements Observer {

	private Modele m;
	private HashMap<String, Recette> listeRecetes;

	public ListeRecettes(ActionListener ecouteur, Modele m, MouseListener mouse) {
		super();

		this.m = m;

		this.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
		
		JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);

		int largeur = (int) (GUI.LARGEUR * 0.5);
		int hauteur = (int) (GUI.HAUTEUR * 0.8);

		// Taille de chaque onglet
		Dimension tailleOnglets = new Dimension((int) (largeur * 0.8), (int) (hauteur * 0.24));

	    JPanel onglet1 = new JPanel();
	    onglet1.setLayout(new BorderLayout());
	    //onglet1.setPreferredSize(new Dimension(largeur, hauteur));
	    onglets.addTab("Entr�e", onglet1);
	    
	    JPanel onglet2 = new JPanel();
	    onglet2.setLayout(new BorderLayout());
		//onglet2.setPreferredSize(new Dimension(largeur, hauteur));
	    onglets.addTab("Plat", onglet2);

	    JPanel onglet3 = new JPanel();
	    onglet3.setLayout(new BorderLayout());
	    //onglet3.setPreferredSize(new Dimension(largeur, hauteur));
	    onglets.addTab("Dessert", onglet3);

	    // FlowLayout pour mettre en retour Ã  la ligne les boutons
	    Panel p=new Panel(new FlowLayout());
		p.setPreferredSize(tailleOnglets);

		JButton risotto_nature= new JButton("Risotto nature");
	    risotto_nature.setName("risotto");
	    risotto_nature.addMouseListener(mouse);
	    p.add(risotto_nature);
	    risotto_nature.addActionListener(ecouteur);
	    
		JButton poulet_au_curry= new JButton("Riz et poulet au curry");
		poulet_au_curry.setName("poulet_au_curry");
		poulet_au_curry.addMouseListener(mouse);
		poulet_au_curry.addActionListener(ecouteur);
		p.add(poulet_au_curry);

		JButton riz_cantonnais= new JButton("Riz Cantonnais");
		riz_cantonnais.setName("riz_cantonnais");
		riz_cantonnais.addMouseListener(mouse);
		riz_cantonnais.addActionListener(ecouteur);
		p.add(riz_cantonnais);
		
		JButton paella= new JButton("Paella");
		paella.setName("paella");
		paella.addMouseListener(mouse);
		paella.addActionListener(ecouteur);
		p.add(paella);
		
		JButton riz_senegalais = new JButton("Riz senegalais");
		riz_senegalais.setName("riz_senegalais");
		riz_senegalais.addMouseListener(mouse);
		riz_senegalais.addActionListener(ecouteur);
		p.add(riz_senegalais);
		onglet2.add(p, BorderLayout.NORTH);

		Panel p1=new Panel(new FlowLayout());
		p1.setPreferredSize(tailleOnglets);
		JButton riz_au_lait= new JButton("Riz au lait");
		riz_au_lait.setName("riz_au_lait");
		riz_au_lait.addMouseListener(mouse);
		riz_au_lait.addActionListener(ecouteur);
		p1.add(riz_au_lait);
		
		JButton riz_sucre_au_four= new JButton("Riz sucre au four");
		riz_sucre_au_four.setName("riz_sucre_au_four");
		riz_sucre_au_four.addMouseListener(mouse);
		riz_sucre_au_four.addActionListener(ecouteur);
		p1.add(riz_sucre_au_four);
		
		JButton gateau_caramel= new JButton("Gateau de riz au caramel");
		gateau_caramel.setName("gateau_caramel");
		gateau_caramel.addMouseListener(mouse);
		gateau_caramel.addActionListener(ecouteur);
		p1.add(gateau_caramel);
		
		JButton galette_de_riz = new JButton("Galette de riz");
		galette_de_riz.setName("galette_de_riz");
		galette_de_riz.addMouseListener(mouse);
		galette_de_riz.addActionListener(ecouteur);
		p1.add(galette_de_riz);
		onglet3.add(p1, BorderLayout.NORTH);


		
		Panel p2=new Panel(new FlowLayout());
		p2.setPreferredSize(tailleOnglets);
		JButton salade_fruits_secs= new JButton("Salade de riz aux fruits secs");
		salade_fruits_secs.setName("salade_fruits_secs");
		salade_fruits_secs.addMouseListener(mouse);
		salade_fruits_secs.addActionListener(ecouteur);
		p2.add(salade_fruits_secs);
		
		JButton salade_thon = new JButton("Salade de riz au thon");
		salade_thon.setName("salade_thon");
		salade_thon.addMouseListener(mouse);
		salade_thon.addActionListener(ecouteur);
		p2.add(salade_thon);
		
		JButton avocat_salade = new JButton("Avocat au riz en salade");
		avocat_salade.setName("avocat_salade");
		avocat_salade.addMouseListener(mouse);
		avocat_salade.addActionListener(ecouteur);
		p2.add(avocat_salade);
		onglet1.add(p2, BorderLayout.NORTH);



	    this.add(onglets);
	    this.setPreferredSize(new Dimension(largeur, hauteur));
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
