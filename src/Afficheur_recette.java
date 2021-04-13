
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class Afficheur_recette extends Panel implements Observer, ActionListener{
	
	Modele m= new Modele();
	Recette ma_recette= new Recette();
	JButton risotto_nature= new JButton("Risotto nature");
	
	Panel panel_recette=new Panel(); //Panel où va s'afficher les recettes
	
	
	public Afficheur_recette(Frame window) {
		
		String newLine = System.getProperty("line.separator");
		JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);

	    JPanel onglet1 = new JPanel();
	    onglet1.setLayout(new BorderLayout());
	    onglet1.setPreferredSize(new Dimension(640, 360));
	    onglets.addTab("Entrée", onglet1);
	    
	    JPanel onglet2 = new JPanel();
	    onglet2.setLayout(new BorderLayout());
	    onglets.addTab("Plat", onglet2);
	    onglet2.add(panel_recette, BorderLayout.SOUTH);

	    JPanel onglet3 = new JPanel();
	    onglet3.setLayout(new BorderLayout());
	    onglet3.setPreferredSize(new Dimension(640, 360));
	    onglets.addTab("Dessert", onglet3);
	    
	    Panel p=new Panel();
	    p.add(risotto_nature);
	    risotto_nature.addActionListener(this);
	    
		JButton poulet_au_curry= new JButton("Poulet au curry");
		p.add(poulet_au_curry);

		JButton riz_cantonnais= new JButton("Riz Cantonnais");
		p.add(riz_cantonnais);
		
		JButton paella= new JButton("Paella");
		p.add(paella);
		onglet2.add(p, BorderLayout.NORTH);

		Panel p1=new Panel();
		JButton riz_au_lait= new JButton("Riz au lait");
		p1.add(riz_au_lait);
	
		
		JButton riz_sucré_au_four= new JButton("Riz sucré au four");
		p1.add(riz_sucré_au_four);
	
		
		JButton gateau_caramel= new JButton("Gâteau de riz au caramel");
		p1.add(gateau_caramel);
		onglet3.add(p1, BorderLayout.NORTH);
		
		
		Panel p2=new Panel();
		JButton salade_fruits_secs= new JButton("Salade de riz"+newLine+ " aux fruits secs");
		//le newLine est censé être un retour à la ligne mais ça marche pas 
		p2.add(salade_fruits_secs);
		onglet1.add(p2, BorderLayout.NORTH);
		
		
	    this.add(onglets);
	    
	
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source= e.getSource();
		if (source == risotto_nature){ // on peut mettre le try avant le if et tout mettre dedans
			try {
				final Recette recette_trouvee= this.getRecette("risotto"); // on récupère la recette obtenue grâce au getRecette et au nom de la recette ici "risotto"
				ma_recette.setCout(recette_trouvee.getCout()); //on récupère tous les attributs de la recette qui sont paramètres du constructeur 
				ma_recette.setDifficulte(recette_trouvee.getDifficulte());
				ma_recette.setEtapes(recette_trouvee.getEtapes());
				ma_recette.setNbpersonne(recette_trouvee.getNbpersonne());
				ma_recette.setNom(recette_trouvee.getNom());
				System.out.println(ma_recette.getNom());
				afficherRecette();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}

	}
	private Recette getRecette(String nom) throws ClassNotFoundException, IOException { //focntion qui va aller récupérer la recette
		m.chargerXML();
		for(int i=0;i<m.listeRecettes.size(); i++) {
			if(nom.equals(m.listeRecettes.get(i).getNom())) {
			 return(m.listeRecettes.get(i));
			
		}
		}
		return null;
		
		
		
	}
	private void afficherRecette() { // elle va afficher la recette au bon endroit donc dans le panel_recette
		System.out.println("recette " + ma_recette.getNom());
		JLabel recette= new JLabel("recette");
		panel_recette.add(recette);
	}
	
}
