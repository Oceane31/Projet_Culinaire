package culinaire.vues;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.TextField;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import culinaire.controleurs.BarreDeRecherche;

public class BarreDuHaut extends Panel implements Observer{

	public BarreDuHaut(BarreDeRecherche c) {
		super();
		this.setLayout(new GridLayout(1,2));
		Label titre = new Label("De nouveaux hoRizons");
		titre.setBounds(new Rectangle(500,40));
		titre.setFont(new Font("Calibri", Font.BOLD|Font.ITALIC , 20));
		titre.setAlignment(Label.CENTER);
		this.add(titre);
		TextField recherche = new TextField("Tapez votre recherche",25);
		this.setBackground(Color.WHITE);
		recherche.addFocusListener(c);
		this.add(recherche);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}

