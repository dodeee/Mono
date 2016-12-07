package Model;

import java.util.*;

public class Joueur {

	private ArrayList<Propriete> gares;
	private Carreaux positionCourante;
	private ArrayList<Propriete> proprietes;
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
		// TODO - implement Joueur.getnbGare
		throw new UnsupportedOperationException();
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

	public void getNBCompagnie() {
		// TODO - implement Joueur.getNBCompagnie
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param g
	 */
	public void isGroupeComplet(int g) {
		// TODO - implement Joueur.isGroupeComplet
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param g
	 */
	public int getNbPropCeGroupe(Groupe g) {
		// TODO - implement Joueur.getNbPropCeGroupe
		throw new UnsupportedOperationException();
	}

}