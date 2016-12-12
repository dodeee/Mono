package Model;

public class ProprieteAConstruire extends Propriete {
    private int loyer;
    private Groupe groupe;
    public ProprieteAConstruire(int numero,String nomCarreau,int prix,int loyer, Groupe g) {
        super(prix, numero, nomCarreau);
        this.groupe=g;
        this.loyer=loyer;
    }

   



	public int getLoyerNu() {
		return this.loyer;
	}

	public Groupe getGroupe() {
		return groupe;
	}


    @Override
    public int calculLoyer(int valDes, Joueur jProprio) {
        if (jProprio.isGroupeComplet(groupe)){
           return 2*this.loyer;
        }
        else {
            return this.loyer;
        }
            
    }

}