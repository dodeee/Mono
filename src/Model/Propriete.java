package Model;

public abstract class Propriete extends Carreaux {

	private Joueur proprietaire;
	private int prix;
	private String nomPropriete;

    
        public Propriete(int prix, int numero, String nomCarreau) {
        super(numero, nomCarreau);
        this.proprietaire = null;
        this.prix = prix;
    }

	/**
	 * 
	 * @param jCourant
	 */
	public void acheterPropriete(Joueur jCourant) {
		// TODO - implement Propriete.acheterPropriete
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param jAch
	 * @param JRec
	 * @param valDes
	 */
	public void payerLoyer(Joueur jAch, Joueur JRec, int valDes) {
		// TODO - implement Propriete.payerLoyer
		throw new UnsupportedOperationException();
	}

	public int getPrixAchat() {
		// TODO - implement Propriete.getPrixAchat
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param jCourant
	 */
	public void setProprietaire(Joueur jCourant) {
		this.proprietaire = jCourant;
	}

	public Joueur getProprietaire() {
		return this.proprietaire;
	}

	/**
	 * 
	 * @param valDes
	 */
	public int calculLoyer(int valDes) {
		// TODO - implement Propriete.calculLoyer
		throw new UnsupportedOperationException();
	}

	public void getValeurs() {
		// TODO - implement Propriete.getValeurs
		throw new UnsupportedOperationException();
	}

}