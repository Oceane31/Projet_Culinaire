package culinaire.controleurs;

import culinaire.Modele;
import culinaire.structures.Etape;
import culinaire.structures.Recette;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Map;

public class BarreDeRecherche implements FocusListener, ActionListener {

    Modele modele;

    public BarreDeRecherche(Modele m) {
        this.modele=m;
    }

    @Override
    public void focusGained(FocusEvent arg0) {
        TextField t = (TextField)arg0.getSource();
        t.setText("");


    }
    @Override
    public void focusLost(FocusEvent arg0) {
        // TODO Auto-generated method stub
        TextField t = (TextField)arg0.getSource();
        t.setText("Tapez votre recherche");

    }
    
    @Override
	public void actionPerformed(ActionEvent e) {
		TextField texteRecherche = (TextField)e.getSource();
		ArrayList<Recette> recetteTrouvees = new ArrayList<Recette>();
		
		// JList<Recette> recetteTrouvees = new JList<Recette>();
		for(Map.Entry val : this.modele.dicoRecettes.entrySet()) {
			
			String mesEtapesStr = "";
			
			for(final Etape etape: ((Recette)val.getValue()).getEtapes()) {
				mesEtapesStr += etape.toString();
			}
			
			if (val.getKey().toString().toLowerCase().contains(texteRecherche.getText().toLowerCase()) 
					|| mesEtapesStr.toLowerCase().contains(texteRecherche.getText().toLowerCase())) {
				
				recetteTrouvees.add((Recette)val.getValue());
				this.modele.selectionRecette(val.getKey().toString());
			}	
			
		}
		
		this.modele.trouveRecettes(recetteTrouvees);
		
	}

}
