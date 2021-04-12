
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Afficheur_recette extends Panel implements Observer, LayoutManager{
	
	public Afficheur_recette() {
		super();
		this.setLayout(null);
		this.setPreferredSize(new Dimension(640,360));
		JLabel type = new JLabel("Type");
		this.add(type);
		type.setBounds(300, 0, 640, 72);
		JLabel difficulte = new JLabel("Difficulte");
		this.add(difficulte);
		
		difficulte.setBounds(290, 154, 640, 72);
		JButton entree= new JButton("Entrees");
		this.add(entree);
		entree.setBounds(30, 72, 150, 82);
		JButton plat= new JButton("Plats");
		this.add(plat);
		plat.setBounds(210, 72, 150, 82);
		JButton dessert= new JButton("Desserts");
		this.add(dessert);
		dessert.setBounds(390, 72, 150, 82);
		
		JButton facile= new JButton("Facile");
		this.add(facile);
		facile.setBounds(30, 226, 150, 82);
		JButton moyen= new JButton("Moyen");
		this.add(moyen);
		moyen.setBounds(210, 226, 150, 82);
		JButton difficile= new JButton("Difficile");
		this.add(difficile);
		difficile.setBounds(390, 226, 150, 82);
       
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLayoutComponent(String name, Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeLayoutComponent(Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void layoutContainer(Container parent) {
		// TODO Auto-generated method stub
		
	}

}
