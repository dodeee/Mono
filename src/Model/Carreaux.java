package Model;

public abstract class Carreaux {

	private int numero;
	private String nomCarreau;

	public int getNumCarreau() {
		return numero;
	}

    public Carreaux(int numero, String nomCarreau) {
        this.numero = numero;
        this.nomCarreau = nomCarreau;
    }

    public String getNomCarreau() {
        return nomCarreau;
    }

    public void setNomCarreau(String nomCarreau) {
        this.nomCarreau = nomCarreau;
    }

        
}//