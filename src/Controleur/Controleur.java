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
        System.out.println("Des A : "+des[0]);
        this.des[1]=Utilitaire.lancesDes();
        System.out.println("Des B : "+des[1]);
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
        
        Joueur j1test =new Joueur("Ken");
        j1test.addPropriete((Propriete)this.carreaux.get(2));
        j1test.addPropriete((Propriete)this.carreaux.get(4));
        ((Propriete)this.carreaux.get(2)).setProprietaire(j1test);
        ((Propriete)this.carreaux.get(4)).setProprietaire(j1test);
        Joueur j2test =new Joueur("Barbie");
        this.joueurs.add(j1test);
        this.joueurs.add(j2test);
        
        this.ihm.affichDep();
        this.setPositionDep();
        while(this.joueurs.size()!=1){ // 1 seul joueur restant signifie qu'il est le gagnant           
            
            for (Joueur j : joueurs) {
                System.out.println("cash // "+j.getCash());
                this.jouerTour(j);
            }
            for (Joueur j : jasupp) { // joueurs qui ont 0 de cash sont dans cette liste, supprimés à chaque tour de jeu
                this.joueurs.remove(j);
            System.out.println(j.getNomJoueur()+" a été éliminé");
                
            }
            this.jasupp.clear();
            this.affichej();
            }
        
        this.ihm.finPartie(this.joueurs.get(0));
    }
    public void jouerTour(Joueur j){
        this.jCourant=j;
        boolean rejouer = true;
        while(rejouer && j.getCash()!=0){ // la condition sur le cash sert à empêcher un joueur qui aurait fait un double et "perdu" 
            avancer(j);
            if (!Utilitaire.desEgaux(des[0], des[1])){ // si pas de double :
                rejouer=false;
                
            }else {
                     System.out.println("DOUBLE, "+jCourant.getNomJoueur()+"va rejouer");
            }
            
            System.out.println("case :: "+this.jCourant.getPositionCourante().getNumCarreau()+"       "+this.jCourant.getPositionCourante().getNomCarreau());
            int i = jCourant.getPositionCourante().getNumCarreau();

            if (carreaux.get(i) instanceof AutreCarreau){
                System.out.println("**** Le carreau sur lequel vous êtes tombé est un carreaux incategorisé. ****");
            }
            else {
                if(((Propriete)this.carreaux.get(this.jCourant.getPositionCourante().getNumCarreau())).getProprietaire()!=null){ // proprio?
                    if(((Propriete)this.carreaux.get(this.jCourant.getPositionCourante().getNumCarreau())).getProprietaire()!=jCourant){  // est-ce moi?         
                        this.ihm.affichePayerLoyer();   
                    }
                }
                else{
                    this.ihm.affichetourdejeu(this.jCourant.getNomJoueur()); // on va acheter la propriete si on veut/peut
                }      
            }
        }
        if(this.jCourant.getCash()==0){
            for (Propriete p : jCourant.getProprietes()) {
                p.setProprietaire(null); // 
           } 
            System.out.println("Toutes les proprietes de "+jCourant.getNomJoueur()+" ont ete réinitialisé");
            this.jasupp.add(jCourant); // il sera supprimé à la fin du tout de jeu
            
            
        }
    }
    
    
        
    public void setPositionDep(){ // tous les joueurs commencent à la case 1 : Départ
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
                                            if (g.getCouleur().name()==data.get(i)[3]){
                                                Carreaux c = new ProprieteAConstruire(Integer.parseInt(data.get(i)[1]), data.get(i)[2], Integer.parseInt(data.get(i)[4]),Integer.parseInt(data.get(i)[5]),g);
                                                b=true;
                                                carreaux.put(i+1,c); // remplit la liste avec le numéro des carreaux et le carreau
                                            }
                                        }
                                        if (b==false){
                                            Groupe groupe =new Groupe(CouleurPropriete.valueOf(data.get(i)[3]));
                                            this.groupes.add(groupe);
                                            Carreaux c = new ProprieteAConstruire(Integer.parseInt(data.get(i)[1]), data.get(i)[2], Integer.parseInt(data.get(i)[4]),Integer.parseInt(data.get(i)[5]),groupe);
                                            carreaux.put(i+1,c); 
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
	
	private ArrayList<String[]> readDataFile(String filename, String token) throws FileNotFoundException, IOException
	{
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
	public void avancer(Joueur j) { // un joueur passe d'un case à une autre
            System.out.println(j.getNomJoueur());
            this.setValDes();
            System.out.println(valDes);
            int numC= calculNouvPos(j.getPositionCourante().getNumCarreau(),3);
            j.setPositionCourante(this.carreaux.get(numC));
	}

	/**
	 * 
	 * @param num
	 * @param nb
	 */
	public int calculNouvPos(int num, int nbA) {
            if(num+nbA<=40){ // on ne passe pas par la case Départ
                return num+nbA;
            }
            else{ // on passe à/par la case départ
                return ((num+nbA)%41)+1;
            }
        }



        public void affichec(){
        for (Integer i: carreaux.keySet()){
            System.out.println(carreaux.get(i).getNumCarreau()+" "+carreaux.get(i).getNomCarreau());
        }
        
        }
         public void affichej(){
            for (Joueur c: joueurs){
                System.out.println("joueurs : "+c.getNomJoueur()+"  "+c.getPositionCourante().getNumCarreau()+" indice : "+joueurs.indexOf(c));
            }
        }
         
   
        

   
         public ArrayList<Joueur> getJoueurs() {
        return joueurs;
   
         }

   
         public void setJoueurs(ArrayList<Joueur> joueurs) {
   
        this.joueurs = joueurs;
   
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
                ((Propriete)this.carreaux.get(this.jCourant.getPositionCourante().getNumCarreau())).payerLoyer(jCourant, ((Propriete)this.carreaux.get(this.jCourant.getPositionCourante().getNumCarreau())).getProprietaire(), valDes); // le joueur paye le proprio
            }else {
            }
        }    
        
             
    

}

          
    
