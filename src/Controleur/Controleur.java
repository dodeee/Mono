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

    public int getValDes() {
        return valDes;
    }

    public void setValDes() {
        int res=Utilitaire.lancerDes();
        this.valDes = res;
    }

    public Controleur(Ihm ihm) {
        this.carreaux=new HashMap<>();
        this.joueurs=new ArrayList<>();
        this.ihm=ihm;
        groupes=new ArrayList<>();
        
    }
        
    public void setPositionDep(){
        for(Joueur j:joueurs){
            j.setPositionCourante(carreaux.get(0));
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
                                                carreaux.put(i,c);
                                            }
                                        }
                                        if (b==false){
                                            Groupe groupe =new Groupe(CouleurPropriete.valueOf(data.get(i)[3]));
                                            this.groupes.add(groupe);
                                            Carreaux c = new ProprieteAConstruire(Integer.parseInt(data.get(i)[1]), data.get(i)[2], Integer.parseInt(data.get(i)[4]),Integer.parseInt(data.get(i)[5]),groupe);
                                            carreaux.put(i,c);
                                        }
                                        //ProprieteAConstruire(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Integer.parseInt(data.get(i)[4]));
                                        
                                       
				}
				else if(caseType.compareTo("G") == 0){
					
                                        Carreaux c = new Gare(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Integer.parseInt(data.get(i)[3]));
                                        carreaux.put(i,c);
				}
				else if(caseType.compareTo("C") == 0){
					
                                        Carreaux c = new Compagnie(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Integer.parseInt(data.get(i)[3]));
                                        carreaux.put(i,c);
				}
				else if(caseType.compareTo("AU") == 0){
					
                                        Carreaux c = new AutreCarreau(Integer.parseInt(data.get(i)[1]),data.get(i)[2]);
                                        carreaux.put(i,c);
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
	public void avancer(Joueur j) {
           this.setValDes();
          int numC= calculNouvPos(j.getPositionCourante().getNumCarreau(),valDes);
           Carreaux nc=this.carreaux.get(numC);
            j.setPositionCourante(nc);
            // si a = b then recommencer tour
	}

	/**
	 * 
	 * @param type
	 */
	public void miseAJour(TypeCommande type) {
		// TODO - implement Controleur.miseAJour
		throw new UnsupportedOperationException();
	}

	public Joueur getJoueurCourant() {
		// TODO - implement Controleur.getJoueurCourant
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param num
	 * @param nb
	 */
	public int calculNouvPos(int num, int nbA) {
		return num+nbA;
	}

	/**
	 * 
	 * @param b
	 */
	public Carreaux getCarreau(int b) {
		// TODO - implement Controleur.getCarreau
		throw new UnsupportedOperationException();
	}


        public void affichec(){
        for (Integer i: carreaux.keySet()){
            System.out.println(carreaux.get(i).getNumCarreau()+" "+carreaux.get(i).getNomCarreau());
        }
        
        }
         public void affichej(){
        for (Joueur c: joueurs){
            System.out.println("joueurs : "+c.getNomJoueur()+c.getPositionCourante().getNumCarreau());
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
                joueurs.add(j);
            }
            else if(arg == TypeCommande.LANCER_PARTIE){
                
            }
        }    
        
             
    

}
