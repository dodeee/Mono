package Model;

public class ProprieteAConstruire extends Propriete {
//
    public ProprieteAConstruire(int numero,String nomCarreau,int prix  ) {
        super(prix, numero, nomCarreau);
    //    this.Groupe = Groupe;
    }

   

	private Groupe Groupe;

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
    public int calculLoyer(int valDes) {
        if 
    }

}