package Model;
import java.util.*;


public class Groupe {

	private ArrayList<ProprieteAConstruire> proprietes;
	private CouleurPropriete couleur;

	public int getNbProprieteGr() {
            int nb=0;
		for (ProprieteAConstruire p : proprietes ){
                    nb=nb+1;
                }
                return nb;
                    
	}

    public CouleurPropriete getCouleur() {
        return couleur;
    }

    public void setCouleur(CouleurPropriete couleur) {
        this.couleur = couleur;
    }

}//