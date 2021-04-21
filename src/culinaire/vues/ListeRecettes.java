package culinaire.vues;

import culinaire.GUI;
import culinaire.Modele;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class ListeRecettes extends JPanel implements Observer{

	private Modele m;

	public ListeRecettes(ActionListener ecouteur, Modele m) {
		super();

		this.m = m;

		this.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
		
		JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);

		int largeur = (int) (GUI.LARGEUR * 0.4);
		int hauteur = (int) (GUI.HAUTEUR * 0.8);

		// Taille de chaque onglet
		Dimension tailleOnglets = new Dimension((int) (largeur * 0.8), (int) (hauteur * 0.95));

	    JPanel onglet1 = new JPanel();
	    onglet1.setLayout(new BorderLayout());
	    //onglet1.setPreferredSize(new Dimension(largeur, hauteur));
	    onglets.addTab("Entrée", onglet1);
	    
	    JPanel onglet2 = new JPanel();
	    onglet2.setLayout(new BorderLayout());
		//onglet2.setPreferredSize(new Dimension(largeur, hauteur));
	    onglets.addTab("Plat", onglet2);

	    JPanel onglet3 = new JPanel();
	    onglet3.setLayout(new BorderLayout());
	    //onglet3.setPreferredSize(new Dimension(largeur, hauteur));
	    onglets.addTab("Dessert", onglet3);

	    // FlowLayout pour mettre en retour à la ligne les boutons
	    Panel p=new Panel(new FlowLayout());
		p.setPreferredSize(tailleOnglets);
	    JButton risotto_nature= new JButton("Risotto nature");
	    risotto_nature.setName("risotto");
	    p.add(risotto_nature);
	    risotto_nature.addActionListener(ecouteur);
	    
		JButton poulet_au_curry= new JButton("Poulet au curry");
		p.add(poulet_au_curry);
		

		JButton riz_cantonnais= new JButton("Riz Cantonnais");
		p.add(riz_cantonnais);
		
		JButton paella= new JButton("Paella");
		p.add(paella);
		
		JButton riz_senegalais = new JButton("Riz senegalais");
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
		//le newLine est cense etre un retour a� la ligne mais ca marche pas 
		p2.add(salade_fruits_secs);
		
		JButton salade_thon = new JButton("Salade de riz au thon");
		p2.add(salade_thon);
		
		JButton avocat_salade = new JButton("Avocat au riz en salade");
		p2.add(avocat_salade);
		onglet1.add(p2, BorderLayout.NORTH);
		
	    this.add(onglets);
	    this.setPreferredSize(new Dimension(largeur, hauteur));
	}
	
	@Override
	public void update(Observable o, Object arg) {

	}



	
	
	private void afficherRecette() { // elle va afficher la recette au bon endroit donc dans le panel_recette
		/*System.out.println("recette " + ma_recette.getNom());
		JLabel recette= new JLabel("recette");
		panel_recette.add(recette);*/
	}
	
}
