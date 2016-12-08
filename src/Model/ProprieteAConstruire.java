package Model;

public class ProprieteAConstruire extends Propriete {

    	private Groupe Groupe;
    public ProprieteAConstruire(int numero,String nomCarreau,int prix, Groupe groupe) {
        super(prix, numero, nomCarreau);
        this.Groupe = groupe;
    }

   



	public int getLoyerNu() {
		return super.prix;
	}

	public Groupe getGroupe() {
		return Groupe;
	}

    @Override
    public int getPrixAchat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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