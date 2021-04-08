import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.util.Observable;
import java.util.Observer;

public class Afficheur_Entete extends Panel implements Observer{

	public Afficheur_Entete() {
		super();
		this.setLayout(new GridLayout());
		Label titre = new Label("Riz");
		this.add(titre);
		TextField recherche = new TextField("Tapez votre recherche",25);
		this.add(recherche);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}

