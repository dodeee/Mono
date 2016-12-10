package Model;

public class ProprieteAConstruire extends Propriete {
    private int loyer;
    private Groupe Groupe;
    public ProprieteAConstruire(int numero,String nomCarreau,int prix,int loyer, CouleurPropriete c) {
        super(prix, numero, nomCarreau);
        
        this.loyer=loyer;
    }

   



	public int getLoyerNu() {
		return this.loyer;
	}

	public Groupe getGroupe() {
		return Groupe;
	}


    @Override
    public int calculLoyer(int valDes, Joueur jProprio) {
        if (jProprio.isGroupeComplet(Groupe)){
           return 2*this.loyer;
        }
        else {
            return this.loyer;
        }
            
    }

}