package Model;

public abstract class Propriete extends Carreaux {

	private Joueur proprietaire;
	protected int prix;
        
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
            //if (proprietaire==null){
                if (jCourant.getCash()>this.prix){
                    jCourant.setCash(jCourant.getCash()-this.prix);
                    this.setProprietaire(jCourant);
                    jCourant.addPropriete(this);
                }else{
                    System.out.println("Vous n'avez pas asser d'argent.");
                }                                   
            //}
	}

        
	public void payerLoyer(Joueur jCourant, Joueur jProprio, int valDes){
            int Loyer=this.calculLoyer(valDes,jProprio);
            if(Loyer<jCourant.getCash()){
                jProprio.setCash(Loyer+jProprio.getCash());
                jCourant.setCash(jCourant.getCash()-Loyer);                
            }else {
                jProprio.setCash(jProprio.getCash()+jCourant.getCash());
                jCourant.setCash(0);
                System.out.println("J'ai plus de thune");
            }
        }

	public int getPrix(){
            return this.prix;
        }

        
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
	public abstract int calculLoyer(int valDes, Joueur jProprio) ;


}