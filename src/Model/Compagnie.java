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
    public int calculLoyer(int valDes, Joueur jProprio) {
        if(jProprio.getNBCompagnie()==2){
            return valDes*10;
        }else {
            return valDes*6;
        }
        
    }

}//