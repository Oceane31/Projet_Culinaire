package culinaire.controleurs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import culinaire.Modele;

public class BoutonSurvole implements MouseListener {
	
	private Modele modele;
	
	public BoutonSurvole(Modele m) {
		this.modele = m;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Object source = e.getSource();
		JButton bsource = (JButton) source;
		System.out.println(bsource.getName());
		this.modele.imageRecette(bsource.getName());
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	
	
}
