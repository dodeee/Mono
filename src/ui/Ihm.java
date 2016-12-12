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
                Scanner s=new Scanner(System.in);
                System.out.println("Veuillez entrer un nom de Joueur");
                String nomJ = s.nextLine();
                setChanged();
                notifyObservers(nomJ);
                clearChanged();
                j++;
            }                      
            if (choix==0){
               // POUR TEST GROUPE
//                if (j<2){
//                    System.out.println("Il n'y a pas assez de joueurs...");
//                    choix=1;
//                }
//                else{
                    setChanged();
                    notifyObservers(TypeCommande.LANCER_PARTIE);
                    clearChanged();
               // }
            }
        }
    }
    
    public void affichetourdejeu(String nomjoueur){
        Scanner sc = new Scanner(System.in);   	
        System.out.println("\n***************************************************************");
        System.out.println("                 *  Monopoly               *");
        System.out.println("           Joueur :"+nomjoueur);
        System.out.println("*****************************************************************");
        System.out.println("      * 1- Acheter la case                                      *");
        System.out.println("      * 0- Passer son tour                                      *");
        System.out.println("*****************************************************************");
        System.out.print("      Votre Choix : "); 
        int choix = sc.nextInt();
        if (choix==1){
            setChanged();
            notifyObservers(TypeCommande.ACHETER_CASE);
            clearChanged();
        }
        if (choix==0){
            setChanged();
            notifyObservers(TypeCommande.JOUEUR_SUIVANT);
            clearChanged();
        }
    }
    

    public void affichSituationJoueur(Joueur j) {
        
        System.out.println("*****************************************************************");
        System.out.println(j.getNomJoueur()+" cash : "+j.getCash());
        System.out.println(j.getPositionCourante().getNomCarreau()+" au num "+j.getPositionCourante().getNumCarreau());
    }
    public void affichePayerLoyer(){
        System.out.println("*****************************************************************");
        System.out.println("**                              payement de loyer          ******");
        setChanged();
        notifyObservers(TypeCommande.PAYER_LOYER);
        clearChanged();
    }
    public void finPartie(Joueur j){
        System.out.println(j.getNomJoueur()+" a gagné.");
    }
    

}
