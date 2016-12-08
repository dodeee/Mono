package Model;

import java.util.*;

public class Joueur {

	private ArrayList<Propriete> proprietes;
	private Carreaux positionCourante;	
	private String nomJoueur;
	private int cash = 1500;

    public Joueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

	/**
	 * 
	 * @param l
	 */
	public void payerLoyer(int l) {
		// TODO - implement Joueur.payerLoyer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param l
	 */
	public void recevoirLoyer(int l) {
		// TODO - implement Joueur.recevoirLoyer
		throw new UnsupportedOperationException();
	}

	public int getCash() {
		return this.cash;
	}

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

	/**
	 * 
	 * @param prix
	 * @param cash
	 */
    public void setCash(int prix) {
	this.cash=prix;
    }

	/**
	 * 
	 * @param p
	 */
	public void addPropriete(Propriete p) {
		this.proprietes.add(p);
	}

	public int getnbGare() {
            int nbgare=0;
            
            for (Propriete g:proprietes) {
                if(g instanceof Gare){
                    nbgare++;
                }
            }
            return nbgare;
	}

	public Carreaux getPositionCourante() {
		return this.positionCourante;
	}

	/**
	 * 
	 * @param nc
	 */
	public void setPositionCourante(Carreaux nc) {
		this.positionCourante = nc;
	}

	public int getNBCompagnie() {
            int nbcompagnie=0;
            
            for (Propriete p:proprietes) {
                if(p instanceof Compagnie){
                    nbcompagnie++;
                }
            }
            return nbcompagnie;
	}

	/**
	 * 
	 * @param g
        * @return 
	 */
	public boolean isGroupeComplet(Groupe g) {
            return this.getNbPropCeGroupe(g)==g.getNbProprieteGr();
	}

	public int getNbPropCeGroupe(Groupe g) {
            int nb=0;
		for (Propriete p : proprietes){
                    if (p instanceof ProprieteAConstruire){
                        ProprieteAConstruire c = (ProprieteAConstruire) p;
                        if(c.getGroupe()==g){
                            nb=nb+1;
                        }
                    }
                } 
                return nb;    
	}

}
