package culinaire.vues;

import culinaire.Modele;
import culinaire.structures.Etape;
import culinaire.structures.Ingredient;
import culinaire.structures.Recette;
import culinaire.structures.Ustensile;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JPanel;

public class Panneau_Recette extends JPanel{

	Recette r= new Recette();
	Modele m;
	
	
	public Panneau_Recette(Modele m) {
		this.m = m;
		
	}
	public void afficheRecette(Recette r, Graphics g) {
		try {
			m.chargerXML();
			Font font=new Font("Arial",Font.BOLD, 40);
			String titreRecette= new String(r.getNom());
			g.setFont(font);
			g.drawString(titreRecette, 270, 100);
			
			Font fontTitre2=new Font("Arial",Font.BOLD, 35);
			g.setFont(fontTitre2);
			String titre2= new String("Déroulement de la recette");
			g.drawString(titre2, 150, 250);
			
			
			String listeingredients= new String("liste d'ingrédients:");
			String ustensiles=new String("Ustensiles nécessaires:");
			Map map = (new Font("Arial", Font.PLAIN, 14)).getAttributes();
            map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            Font newFont = new Font(map);
            g.setFont(newFont);
            g.drawString(listeingredients, 10, 170);
            g.drawString(ustensiles,270, 170);
            
            
            Font fontigd= new Font("Arial", Font.PLAIN, 14);
            g.setFont(fontigd);
            ArrayList<Ingredient> liste= new ArrayList<Ingredient>();
			for(int i=0; i<r.getEtapes().size(); i++) {
				Etape e=r.getEtapes().get(i);
				liste=e.getIngredient();
			}
			for(int i=0; i<liste.size(); i++) {
				Ingredient igt=liste.get(i);
				String ingredient= new String(igt.getIngredient());
				g.drawString("- "+ingredient, 100, 190+20*i);
			}
			for(int i=0; i<r.getEtapes().size(); i++) {
				Etape e=r.getEtapes().get(i);
				Ustensile u=e.getUstensile();
				if(u!=null) {
					String ustensile= new String(u.getUstensile());
					g.drawString("- " +ustensile,270 , 190+20*i);
				}
				else {
					g.drawString("pas d'ustensiles neécessaires", 270, 190);
				}
			}
			
			for(int i=0; i<r.getEtapes().size(); i++) {
				Etape e=r.getEtapes().get(i);
				String etape= new String(i+1 +") " +e.getIntitule());
				g.drawString(etape,10,300+20*i);
			}
			
			Font font2=new Font("Arial",Font.BOLD, 14);
			g.setFont(font2);
			g.setColor(Color.BLUE);
			
			String difficulte= new String("difficulté: ");
			g.drawString(difficulte, 10, 140);
			for(int i=0;i<r.getDifficulte();i++) {
				String etoile=new String("*");
				g.drawString(etoile, 80+10*i, 140);
			}
			String cout= new String("coût: ");
			g.drawString(cout, 250, 140);
			for(int i=0;i<r.getCout();i++) {
			String euros= new String("€");
			g.drawString(euros, 290+10*i, 140);
			}
			
			
			
			String nbpersonne= new String("recette pour "+ r.getNbpersonne()+ " personnes");
			g.drawString(nbpersonne, 460, 140);
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	
}
