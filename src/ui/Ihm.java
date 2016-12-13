package ui;
import Controleur.*;
import Model.AutreCarreau;
import Model.Carreaux;
import Model.Joueur;
import Model.Propriete;
import Utilitaire.TypeCommande;
import Utilitaire.Utilitaire;
import java.util.ArrayList;
import java.util.HashMap;
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
           //     POUR TOUS LES TEST, enlever le "if" et juste faire le else
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
    
    public void affichetourdejeu(String nomjoueur,int prix){
        Scanner sc = new Scanner(System.in);   	
        System.out.println("\n***************************************************************");
        System.out.println("                 *  Monopoly               *");
        System.out.println("           Joueur :"+nomjoueur);
        System.out.println("*****************************************************************");
        System.out.println("      * 1- Acheter la case   ("+prix+")                         *");
        System.out.println("      * 0- Passer son tour                                      *");
        System.out.println("*****************************************************************");
        System.out.print("        * Votre Choix : "); 
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
    public void afficheAvLanceDes(Joueur j){
        Scanner s = new Scanner(System.in);
        System.out.println("Appuyer sur entrer pour lancer les dès :");
        s.nextLine();
    }
    public void afficheAutreCarreau(AutreCarreau c){
        System.out.println("Vous êtes tombé sur : "+c.getNomCarreau()+" qui n'est pas une propriété.");
    }
    public void afficheJoueurAPerdu(Joueur j){
        System.out.println("   Le joueur "+j.getNomJoueur()+" a perdu.");
    }
    public void afficheDouble(){
        System.out.println("   C'est un double ! Tu auras un tour supplementaire. ;) ");
    }

    public void affichSituationJoueur(Joueur j) {
        
        System.out.println("*****************************************************************");
        System.out.println("       "+j.getNomJoueur());
        System.out.println("       cash : "+j.getCash());
        System.out.println("       "+j.getPositionCourante().getNomCarreau());
        System.out.println("       au numero : "+j.getPositionCourante().getNumCarreau());
        System.out.println("*****************************************************************");
        
    }
    public void afficheAuTourDuJoueur(Joueur j) {
        
        System.out.println("*****************************************************************");
        System.out.println("       Au tour de "+j.getNomJoueur()+"   cash : "+j.getCash());
        System.out.println("       "+j.getPositionCourante().getNomCarreau());
        System.out.println("       au numero : "+j.getPositionCourante().getNumCarreau());
        System.out.println("*****************************************************************");
        
    }
    public void affichec(HashMap<Integer,Carreaux> carreaux){
        for (Integer i: carreaux.keySet()){
            System.out.println(carreaux.get(i).getNumCarreau()+" "+carreaux.get(i).getNomCarreau());
        }
    }
    public void afficheFinTourDesJoueurs(ArrayList<Joueur> joueurs){
        for (Joueur j: joueurs){
            System.out.println("     Joueur : "+j.getNomJoueur()+"    Case numéro : "+j.getPositionCourante().getNumCarreau());
            System.out.println("     Ses Propriétés : ");
            for(Propriete p : j.getProprietes()){
                System.out.println("                         "+p.getNumCarreau()+". "+p.getNomCarreau());
            }
            System.out.println("");
        }
    }
    public void affichePasDeSous(){
        System.out.println("***  Pas assez de sous pour acheter la propriété.");
    }
    public void afficheCaseCouranteJoueur(Joueur jCourant){
        System.out.println("case : "+jCourant.getPositionCourante().getNumCarreau()+"       "+jCourant.getPositionCourante().getNomCarreau());
    }
    public void afficheAuJoueurSuivant(){
        System.out.println("");
        System.out.println("*****************************************************************");
        System.out.println("               Fin du tour. Au joueur Suivant !");
        System.out.println("");
        System.out.println("*****************************************************************");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
    public void affichePayerLoyer(){
        System.out.println("*****************************************************************");
        System.out.println("***********             payement de loyer          **************");
        System.out.println("*****************************************************************");
        setChanged();
        notifyObservers(TypeCommande.PAYER_LOYER);
        clearChanged();
    }
    public void finPartie(Joueur j){
        System.out.println(j.getNomJoueur()+" a gagné.");
    }
    

}
