package culinaire.vues;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;

public class Afficheur_Image extends Canvas implements Observer{

	String image = "riz.jpeg";
	Image img = null;
	
	public Afficheur_Image() {
		super();
		this.setPreferredSize(new Dimension(640,360));
		try {
			img=ImageIO.read(new File("riz.jpeg"));
		}
		catch (IOException e) {
			System.out.println("pb image");
		}
		
	}
	
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
	}
	
	
	
}
