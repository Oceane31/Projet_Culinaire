package culinaire.vues;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import culinaire.GUI;
import culinaire.controleurs.SliderLayout;

public class SliderEtapes extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JPanel panelEtapes = new JPanel(new SliderLayout());
	MyButton flecheDroite = new MyButton(">");
	MyButton flecheGauche = new MyButton("<");
	static int largeur = (int) (DetailRecette.largeur );
	static int hauteur = (int) (DetailRecette.hauteur*0.5);

	public SliderEtapes() {
		this.setLayout(new BorderLayout());
		panelEtapes.setBackground(Color.WHITE);
		JPanel panelFleches = new JPanel(new BorderLayout());
		panelFleches.setBackground(Color.WHITE);
		this.add(panelEtapes, BorderLayout.NORTH);
		panelFleches.add(flecheGauche, BorderLayout.WEST);
		panelFleches.add(flecheDroite, BorderLayout.EAST);
		this.add(panelFleches, BorderLayout.SOUTH);
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(largeur,hauteur));

		// Au clic sur le bouton fleche de gauche, on appelle la methode previous
		flecheGauche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previous();
			}
		});

		// Au clic sur le bouton fleche de droite, on appelle la methode next
		flecheDroite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next();
			}
		});
	}


	public void previous() {
		SliderLayout sl = (SliderLayout)this.panelEtapes.getLayout();
		Component currentComp = sl.getCurrentComponent(this.panelEtapes);
        Component previousComp = sl.getPreviousComponent(this.panelEtapes);
        Rectangle b = currentComp.getBounds();
        previousComp.setVisible(true);
        SliderListener slistener = new SliderListener(10, currentComp, previousComp, false);
        Timer t=new Timer(40,slistener);
        slistener.timer=t;
        t.start();
	}

	public void next() {
		SliderLayout sl= (SliderLayout)this.panelEtapes.getLayout();
        Component currentComp = sl.getCurrentComponent(this.panelEtapes);
        Component nextComp = sl.getNextComponent(this.panelEtapes);
        // Rectangle b = currentComp.getBounds();
        nextComp.setVisible(true);
        SliderListener slistener = new SliderListener(10, currentComp, nextComp, true);
        Timer t = new Timer(40,slistener);
        slistener.timer=t;
        t.start();
	}
	
	public void addSliderComponent(JComponent c) {
		this.panelEtapes.add(c,"" + getComponentCount());
    }
 
    public void refresh() {
        revalidate();
        repaint();
    }
    
    public class SliderListener implements ActionListener{

    	Component c1;
        Component c2;
        int steps;
        int step=0;
        Timer timer;
        boolean isNext;

        public SliderListener(int steps, Component c1, Component c2, boolean isNext) {
            this.steps = steps;
            this.c1 = c1;
            this.c2 = c2;
            this.isNext = isNext;
        }

        public void actionPerformed(ActionEvent e) {
            Rectangle bounds = c1.getBounds();
            int shift=bounds.width/steps;
            if (!isNext) {
                c1.setLocation(bounds.x-shift, bounds.y);
                c2.setLocation(bounds.x-shift+bounds.width, bounds.y);
            }
            else {
                c1.setLocation(bounds.x+shift, bounds.y);
                c2.setLocation(bounds.x+shift-bounds.width, bounds.y);
            }
            panelEtapes.repaint();
            step++;
            if (step==steps) {
                timer.stop();
                c2.setVisible(false);
                CardLayout cl=(CardLayout)panelEtapes.getLayout();
                if (isNext) {
                    cl.next(panelEtapes);
                }
                else {
                    cl.previous(panelEtapes);
                }
            }
        }
    }
}
