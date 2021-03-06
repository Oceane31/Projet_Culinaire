package culinaire.vues;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MyButton extends JButton {
	//Création du bouton pour les flèches pour faire défiler les étapes
 
    private static final long serialVersionUID = 1L;
 
    public MyButton(String txt) {
        super(txt);
        setForeground(Color.BLACK);
         
        setOpaque(false);
        setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
        setBorderPainted(false); // De même, on ne veut pas afficher les bordures.
        setFocusPainted(false); // On n'affiche pas l'effet de focus.
         
        setHorizontalAlignment(SwingConstants.CENTER);
        setHorizontalTextPosition(SwingConstants.CENTER);
         
        
    }
}
