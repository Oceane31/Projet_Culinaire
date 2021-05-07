package culinaire.structures;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;

public class Recette implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nom;
    private ArrayList<Etape> etapes;
    private int difficulte;
    private int cout;
    private int nbpersonne;
    
    public enum Type implements Serializable {
    	ENTREE, PLAT, DESSERT
    }
    
    private Type type;

    public Recette() {
        this.etapes = new ArrayList();
    }

    public Recette(String n, int d, int c, int nb, ArrayList<Etape> l) {
        this.nom = n;
        this.difficulte = d;
        this.cout = c;
        this.nbpersonne = nb;
        this.etapes = l;
    }

    public String toString() {
        return this.nom + this.etapes + " (difficulte :" + this.difficulte + ", cout: " + this.cout + ", nb_personnes: " + this.nbpersonne + ")";
    }

    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    public ArrayList<Etape> getEtapes() {
        return etapes;
    }


    public void setEtapes(ArrayList<Etape> etapes) {
        this.etapes = etapes;
    }


    public int getDifficulte() {
        return difficulte;
    }
    
    public Type getType() {
    	return type;
    }


    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }


    public int getCout() {
        return cout;
    }


    public void setCout(int cout) {
        this.cout = cout;
    }


    public int getNbpersonne() {
        return nbpersonne;
    }


    public void setNbpersonne(int nbpersonne) {
        this.nbpersonne = nbpersonne;
    }

    public void ajouterEtape(Etape e) {
        this.etapes.add(e);
    }

    
}

