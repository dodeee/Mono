package Model;

public class Gare extends Propriete {

    public Gare(int numero, String nomCarreau, int prix) {
        super(prix, numero, nomCarreau);
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