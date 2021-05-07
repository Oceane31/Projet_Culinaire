package culinaire.vues;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class BouttonRecette extends JButton {
 
    private static final long serialVersionUID = 1L;
 
    public BouttonRecette(String txt) {
        super(txt);
        setBackground(Color.WHITE);
        setHorizontalAlignment(SwingConstants.CENTER);
        setHorizontalTextPosition(SwingConstants.CENTER);
         
        
    }
}
