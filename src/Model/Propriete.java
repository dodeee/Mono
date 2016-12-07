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
            jCourant.setnvCash(this.prix);
            this.setProprietaire(jCourant);
            jCourant.addPropriete(this);            
	}

        
	public void payerLoyer(Joueur jAch, Joueur JRec){
            
        }

	public abstract int getPrixAchat();

        
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
	public abstract int calculLoyer(int valDes) ;
		

	public void getValeurs() {
		// TODO - implement Propriete.getValeurs
		throw new UnsupportedOperationException();
	}

}