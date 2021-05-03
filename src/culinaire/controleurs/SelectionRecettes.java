package culinaire.controleurs;

import culinaire.Modele;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;

public class SelectionRecettes implements ActionListener {
	Modele modele;
	
	public SelectionRecettes(Modele m) {
		this.modele=m;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		JButton bsource = (JButton) source;
		//System.out.println(bsource.getName());
		this.modele.selectionRecette(bsource.getName());
		
	}
}
