package Model;

public class Compagnie extends Propriete {

    public Compagnie( int numero, String nomCarreau,int prix) {
        super(prix, numero, nomCarreau);
    }


	public int getValeur() {
		// TODO - implement Compagnie.getValeur
		throw new UnsupportedOperationException();
	}

    @Override
    public int getPrixAchat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int calculLoyer(int valDes, Joueur jProprio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}//