package culinaire.vues;

import culinaire.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Panneau au centre avec à gauche la liste des recettes et à droite le détail
 */
public class PanneauCentral extends JPanel {

    public PanneauCentral(Component listeRecettes, Component detailRecettes) {
        super();
        this.setLayout(new BorderLayout());
        

        this.add(listeRecettes, BorderLayout.WEST);
        this.add(detailRecettes, BorderLayout.EAST);

        this.setBorder(BorderFactory.createLineBorder(Color.GREEN));
    }

}
