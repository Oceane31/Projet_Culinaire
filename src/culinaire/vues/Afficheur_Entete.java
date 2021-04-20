package culinaire.vues;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.TextField;
import java.util.Observable;
import java.util.Observer;

import culinaire.controleurs.BarreDeRecherche;

public class Afficheur_Entete extends Panel implements Observer{

	public Afficheur_Entete(BarreDeRecherche c) {
		super();
		this.setLayout(new GridLayout(1,2));
		Label titre = new Label("De nouveaux hoRizons");
		titre.setBounds(new Rectangle(500,40));
		titre.setAlignment(Label.CENTER);
		this.add(titre);
		TextField recherche = new TextField("Tapez votre recherche",25);
		
		recherche.addFocusListener(c);
		this.add(recherche);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}

