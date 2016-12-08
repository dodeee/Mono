/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import Controleur.*;
import Model.Joueur;
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
			System.out.println("      * 2- Lancer la partie                                     *");
			
			
                        System.out.println("*****************************************************************");
			System.out.println("      * 0- Quitter                                              *");
			System.out.println("*****************************************************************");
			System.out.print("      Votre Choix : ");
			
                        choix = sc.nextInt();
                          
                        if (choix==1){
                                    System.out.println("Veuillez entrer un nom de Joueur");
                                    Scanner s = new Scanner(System.in);
            
                                    String nomJ = s.nextLine();
                                    setChanged();
                                    notifyObservers(nomJ);
                                    clearChanged();
                                    
                                    j++;
                        }
                       
                                    
                         
                        }
         
        
    }
    
    
  
}
