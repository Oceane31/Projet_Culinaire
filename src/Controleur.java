import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

public class Controleur implements ActionListener {
	Modele modele;
	
	public Controleur(Modele m) {
		this.modele=m;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source= e.getSource();
		JButton bsource= (JButton) source;
		//System.out.println(bsource.getName());
		this.modele.selectionRecette(bsource.getName());
		/*if (source == risotto_nature){ // on peut mettre le try avant le if et tout mettre dedans
			try {
				final Recette recette_trouvee= this.getRecette("risotto"); // on récupère la recette obtenue grâce au getRecette et au nom de la recette ici "risotto"
				ma_recette.setCout(recette_trouvee.getCout()); //on récupère tous les attributs de la recette qui sont paramètres du constructeur 
				ma_recette.setDifficulte(recette_trouvee.getDifficulte());
				ma_recette.setEtapes(recette_trouvee.getEtapes());
				ma_recette.setNbpersonne(recette_trouvee.getNbpersonne());
				ma_recette.setNom(recette_trouvee.getNom());
				System.out.println(ma_recette.getNom());
				afficherRecette();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}*/

	}

}
