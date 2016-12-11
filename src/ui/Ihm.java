package ui;
import Controleur.*;
import Model.Joueur;
import Utilitaire.TypeCommande;
import Utilitaire.Utilitaire;
import java.util.Observable;
import java.util.Scanner;
/**
 *
 * @author dodee
 */
public class Ihm extends Observable{
    
    
    public void affichDep(){
        
         Scanner sc = new Scanner(System.in);
	        	
	    	
	    	int j = 0;
			int choix =1;
			while (j < 6 && choix!=0){
			System.out.println("\n***************************************************************");
			System.out.println("                 *  Monopoly               *");
			System.out.println("*****************************************************************");
			System.out.println("      * 1- Ajouter un joueur                                    *");
			
			
			
			System.out.println("      * 0- Lancer la partie                                     *");
			System.out.println("*****************************************************************");
			System.out.print("      Votre Choix : ");
			
                        choix = sc.nextInt();
                          
                        if (choix==1){
                                    System.out.println("Veuillez entrer un nom de Joueur");
                                    String nomJ = sc.nextLine();
                                    setChanged();
                                    notifyObservers(nomJ);
                                    clearChanged();
                                    j++;
                        }                      
                        if (choix==0){
                            if (j<2){
                                System.out.println("Il n'y a pas assez de joueurs...");
                                choix=1;
                            }
                            else{
                                setChanged();
                                notifyObservers(TypeCommande.LANCER_PARTIE);
                                clearChanged();
                            }
                        }
                                    
                         
                        }
         
        
    }

    public void affichSituationJoueur(Joueur j) {
        
        System.out.println("*****************************************************************");
        System.out.println(j.getNomJoueur()+" cash : "+j.getCash());
        System.out.println(j.getPositionCourante().getNomCarreau()+" au num "+j.getPositionCourante().getNumCarreau());
    }
    
    
  
}
