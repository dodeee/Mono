package Controleur;

import Model.*;
import java.util.*;
import Utilitaire.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import ui.Ihm;
public class Controleur implements Observer{	   

	private HashMap<Integer,Carreaux> carreaux;
	private ArrayList<Joueur> joueurs;
        private Ihm ihm;
        private int valDes;
        private ArrayList<Groupe> groupes;
        private Joueur jCourant;
        private int des[]={0,0};
        private ArrayList<Joueur> jasupp;

    public void setValDes() { // lancer chaque dés
        this.des[0]=Utilitaire.lancesDes();
        this.des[1]=Utilitaire.lancesDes();
        this.valDes=des[0]+des[1];
    }

    public Controleur() {
        this.carreaux=new HashMap<>();
        this.joueurs=new ArrayList<>();
        this.ihm= new Ihm();
        this.groupes=new ArrayList<>();
        this.jasupp=new ArrayList<>();
        ihm.addObserver(this);    
    }
    public void jouer(){
 //      this.testPropriete();
 //      this.testGare();
 //     this.testCompagnie();
      
        
        this.ihm.affichDep();
        this.setPositionDep();
        while(this.joueurs.size()!=1){
            for (Joueur j : joueurs) {
                this.jouerTour(j);
            }
            for (Joueur j : jasupp) { // joueurs qui ont 0 de cash sont dans cette liste, supprimés à chaque tour de jeu
                this.joueurs.remove(j);
                this.ihm.afficheJoueurAPerdu(j);
            }
            this.jasupp.clear();
            this.ihm.afficheFinTourDesJoueurs(joueurs);
            }
        
        this.ihm.finPartie(this.joueurs.get(0));
    }
    public void jouerTour(Joueur j){
        this.jCourant=j;
        boolean rejouer = true;
        while(rejouer && j.getCash()!=0){ // le test sur le cash a 0 sert à empêcher un joueur qui fait un double et "meurt" de rejouer
            this.ihm.afficheAuTourDuJoueur(jCourant);
            avancer(j);
            if (!Utilitaire.desEgaux(des[0], des[1])){ // si pas de double :
                rejouer=false;
                
            }else {
                this.ihm.afficheDouble();
            }
            this.ihm.afficheCaseCouranteJoueur(jCourant);
            
            int i = jCourant.getPositionCourante().getNumCarreau();

            if (carreaux.get(i) instanceof AutreCarreau){
                this.ihm.afficheAutreCarreau((AutreCarreau)carreaux.get(i));
            }
            else {
                if(((Propriete)this.carreaux.get(this.jCourant.getPositionCourante().getNumCarreau())).getProprietaire()!=null){ // proprio?
                    if(((Propriete)this.carreaux.get(this.jCourant.getPositionCourante().getNumCarreau())).getProprietaire()!=jCourant){  // est-ce moi?         
                        this.ihm.affichePayerLoyer();   
                    }
                }
                else{
                    this.ihm.affichetourdejeu(this.jCourant.getNomJoueur());
                }
            }
            this.ihm.affichSituationJoueur(jCourant);
        }
        if(this.jCourant.getCash()==0){
            for (Propriete p : jCourant.getProprietes()) {
                p.setProprietaire(null);
           } 
            System.out.println("Toutes les proprietes de "+jCourant.getNomJoueur()+" ont ete réinitialisé");
            this.jasupp.add(jCourant); // il sera supprimé à la fin du tout de jeu
            
            
        }
        this.ihm.afficheAuJoueurSuivant();
    }
    
    
        
    public void setPositionDep(){
        for(Joueur j:joueurs){
            j.setPositionCourante(carreaux.get(1));
        }
    }

    public void creerPlateau(String dataFilename){
		buildGamePlateau(dataFilename);
	}
	
	private void buildGamePlateau(String dataFilename)
	{
		try{
			ArrayList<String[]> data = readDataFile(dataFilename, ",");
			
			//TODO: create cases instead of displaying
			for(int i=0; i<data.size(); ++i){
				String caseType = data.get(i)[0];
                                
				if(caseType.compareTo("P") == 0){
                                        boolean b=false;
					for (Groupe g:groupes){
                                            if (g.getCouleur().name().equals(data.get(i)[3])){
                                                Carreaux c = new ProprieteAConstruire(Integer.parseInt(data.get(i)[1]), data.get(i)[2], Integer.parseInt(data.get(i)[4]),Integer.parseInt(data.get(i)[5]),g);
                                                b=true;
                                                g.addPropriete((ProprieteAConstruire) c);
                                                carreaux.put(i+1,c); // remplit la liste avec le numéro des carreaux et le carreau
                                            }
                                        }
                                        if (b==false){
                                            Groupe groupe =new Groupe(CouleurPropriete.valueOf(data.get(i)[3]));
                                            this.groupes.add(groupe);
                                            Carreaux c = new ProprieteAConstruire(Integer.parseInt(data.get(i)[1]), data.get(i)[2], Integer.parseInt(data.get(i)[4]),Integer.parseInt(data.get(i)[5]),groupe);
                                            carreaux.put(i+1,c); 
                                            groupe.addPropriete((ProprieteAConstruire) c);
                                        }
                                        
                                        
                                       
				}
				else if(caseType.compareTo("G") == 0){
					
                                        Carreaux c = new Gare(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Integer.parseInt(data.get(i)[3]));
                                        carreaux.put(i+1,c);
				}
				else if(caseType.compareTo("C") == 0){
					
                                        Carreaux c = new Compagnie(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Integer.parseInt(data.get(i)[3]));
                                        carreaux.put(i+1,c);
				}
				else if(caseType.compareTo("AU") == 0){
					
                                        Carreaux c = new AutreCarreau(Integer.parseInt(data.get(i)[1]),data.get(i)[2]);
                                        carreaux.put(i+1,c);
                                        
				}
				else
					System.err.println("[buildGamePleateau()] : Invalid Data type");
			}
			
		} 
		catch(FileNotFoundException e){
			System.err.println("[buildGamePlateau()] : File is not found!");
		}
		catch(IOException e){
			System.err.println("[buildGamePlateau()] : Error while reading file!");
		}
                

	}
	
	private ArrayList<String[]> readDataFile(String filename, String token) throws FileNotFoundException, IOException{
		ArrayList<String[]> data = new ArrayList<String[]>();
		
		BufferedReader reader  = new BufferedReader(new FileReader(filename));
		String line = null;
		while((line = reader.readLine()) != null){
			data.add(line.split(token));
		}
		reader.close();
		
		return data;
	}

	

	/**
	 * 
	 * @param j
	 * @param nb
	 */
	public void avancer(Joueur j) {            
            this.ihm.afficheAvLanceDes(j);
            this.setValDes();
 
            int numC= calculNouvPos(j.getPositionCourante().getNumCarreau(),valDes);
             // POUR TEST GROUPE : mettre 3 à la place de valDes
             // POUR TEST GARE : mettre 5 à la place de valDes
             // POUR TEST COMPAGNIE : mettre 12 à la place de valDes 
             //                       System.out.println("valDes :"+valDes); 
            j.setPositionCourante(this.carreaux.get(numC));
	}

	public int calculNouvPos(int num, int nbA) {
            if(num+nbA<=40){ // on ne passe pas par la case Départ
                return num+nbA;
            }
            else{ // on passe à/par la case départ
                return ((num+nbA)%41)+1;
            }
        }
        public ArrayList<Joueur> getJoueurs() {
            return joueurs;
        }

   
         public void setJoueurs(ArrayList<Joueur> joueurs) {
   
        this.joueurs = joueurs;
   
         }
         // POUR TOUS LES TEST : modifier avancer() et l'ihm : affichDep() où c'est indiqué
         public void testPropriete(){
             // POUR TEST : barbie doit payer 8  
        Joueur j1test =new Joueur("Ken");
        j1test.addPropriete((Propriete)this.carreaux.get(2));
        j1test.addPropriete((Propriete)this.carreaux.get(4));   
        ((Propriete)this.carreaux.get(2)).setProprietaire(j1test);
        ((Propriete)this.carreaux.get(4)).setProprietaire(j1test);
        Joueur j2test =new Joueur("Barbie");
        this.joueurs.add(j1test);
        this.joueurs.add(j2test);
         }
            public void testCompagnie(){
             // POUR TEST : barbie doit payer 10*valDes 
        Joueur j1test =new Joueur("Ken");
        j1test.addPropriete((Propriete)this.carreaux.get(13));
        j1test.addPropriete((Propriete)this.carreaux.get(29));   
        ((Propriete)this.carreaux.get(13)).setProprietaire(j1test);
        ((Propriete)this.carreaux.get(29)).setProprietaire(j1test);
        Joueur j2test =new Joueur("Barbie");
        this.joueurs.add(j1test);
        this.joueurs.add(j2test);
         }
               public void testGare(){
             // POUR TEST : barbie doit payer 50  
        Joueur j1test =new Joueur("Ken");
        j1test.addPropriete((Propriete)this.carreaux.get(6));
        j1test.addPropriete((Propriete)this.carreaux.get(16));   
        ((Propriete)this.carreaux.get(6)).setProprietaire(j1test);
        ((Propriete)this.carreaux.get(16)).setProprietaire(j1test);
        Joueur j2test =new Joueur("Barbie");
        this.joueurs.add(j1test);
        this.joueurs.add(j2test);
         }

   
        @Override
        public void update(Observable o, Object arg) {
            if (arg instanceof String){
                Joueur j=new Joueur((String)arg);
                this.joueurs.add(j);
                j.setPositionCourante(this.carreaux.get(0));
            }
            else if(arg == TypeCommande.LANCER_PARTIE){
                this.jCourant=this.joueurs.get(0);
            }else if(arg == TypeCommande.ACHETER_CASE){               
                ((Propriete)this.carreaux.get(this.jCourant.getPositionCourante().getNumCarreau())).acheterPropriete(jCourant); // le joueur tente une acquisition
            }else if(arg == TypeCommande.PAYER_LOYER){
                if (this.jCourant.getCash()>((Propriete)this.carreaux.get(this.jCourant.getPositionCourante().getNumCarreau())).getPrix()){
                    ((Propriete)this.carreaux.get(this.jCourant.getPositionCourante().getNumCarreau())).payerLoyer(jCourant, ((Propriete)this.carreaux.get(this.jCourant.getPositionCourante().getNumCarreau())).getProprietaire(), valDes);    
                }else {
                    this.ihm.affichePasDeSous();
                }
            }else if(arg==TypeCommande.JOUEUR_SUIVANT){
            }
        }    
}

          
    
