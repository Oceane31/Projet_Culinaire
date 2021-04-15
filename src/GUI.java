import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class GUI extends Frame implements WindowListener{

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		

		new GUI();
	}

	public GUI() throws ClassNotFoundException, IOException {
		
		Modele modele= new Modele();
		modele.chargerXML();
		Controleur c=new Controleur(modele);
		
		this.setLayout(new BorderLayout());
		this.addWindowListener(this);
		this.setTitle("application");
		
		Afficheur_Entete entete=new Afficheur_Entete();
		this.add(entete,BorderLayout.NORTH);
		
		Afficheur_Image im=new Afficheur_Image();
		this.add(im,BorderLayout.EAST);
		
		Afficheur_recette panneauGauche = new Afficheur_recette(c);
		modele.addObserver(panneauGauche);
		this.add(panneauGauche, BorderLayout.WEST);
		
		this.pack();
		this.setVisible(true);
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		 
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
