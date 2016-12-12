package Model;
import java.util.*;


public class Groupe {

	private ArrayList<ProprieteAConstruire> proprietes;
	private CouleurPropriete couleur;
        public Groupe (CouleurPropriete couleur){
            this.couleur=couleur;
            this.proprietes=new ArrayList<>();
        }

	public int getNbProprieteGr() { 
            int nb=0;
            for (ProprieteAConstruire p : proprietes ){
                nb=nb+1;
            }
            System.out.println(nb+" ça doit etre 2"); //0
            return nb;
            
                    
	}

    public ArrayList<ProprieteAConstruire> getProprietes() {
        return proprietes;
    }

    public CouleurPropriete getCouleur() {
        return couleur;
    }

    public void setCouleur(CouleurPropriete couleur) {
        this.couleur = couleur;
    }
    public void addPropriete(ProprieteAConstruire p){
        this.proprietes.add(p);
    }

}