package Model;

public class ProprieteAConstruire extends Propriete {
//
    public ProprieteAConstruire(int numero,String nomCarreau,int prix  ) {
        super(prix, numero, nomCarreau);
    //    this.Groupe = Groupe;
    }

   

	private Groupe Groupe;

	public int getLoyerNu() {
		// TODO - implement ProprieteAConstruire.getLoyerNu
		throw new UnsupportedOperationException();
	}

	public Groupe getGroupe() {
		// TODO - implement ProprieteAConstruire.getGroupe
		throw new UnsupportedOperationException();
	}

}