package culinaire.controleurs;

import culinaire.Modele;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class BarreDeRecherche implements FocusListener {

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
}
