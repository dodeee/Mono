package Model;

public class Gare extends Propriete {

    public Gare(int numero, String nomCarreau, int prix) {
        super(prix, numero, nomCarreau);
    }

  

    @Override
    public int calculLoyer(int valDes, Joueur jProprio) {        
        return 25*jProprio.getnbGare();
        
    }
}
