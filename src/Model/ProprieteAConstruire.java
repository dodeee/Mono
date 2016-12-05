package Model;

public class ProprieteAConstruire extends Propriete {

    public ProprieteAConstruire(Groupe Groupe, Joueur proprietaire, int prix, int numero, String nomCarreau) {
        super(proprietaire, prix, numero, nomCarreau);
        this.Groupe = Groupe;
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