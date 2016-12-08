package Model;

public class ProprieteAConstruire extends Propriete {

    	private Groupe Groupe;
    public ProprieteAConstruire(int numero,String nomCarreau,int prix, Groupe groupe) {
        super(prix, numero, nomCarreau);
        this.Groupe = groupe;
    }

   



	public int getLoyerNu() {
		return super.loyer*2;
	}

	public Groupe getGroupe() {
		return Groupe;
	}


    @Override
    public int calculLoyer(int valDes, Joueur jProprio) {
        if (jProprio.isGroupeComplet(Groupe)){
           return 2*this.getLoyerNu();
        }
        else {
            return this.getLoyerNu();
        }
            
    }

}