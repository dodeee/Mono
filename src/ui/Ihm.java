/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import Controleur.*;
import Model.Joueur;
import Utilitaire.Utilitaire;
import java.util.Scanner;
/**
 *
 * @author dodee
 */
public class Ihm {
    
    
    public Ihm(){
        
         Scanner sc = new Scanner(System.in);
	        	
	    	
	    	
			String choix ="0";
			do {
			System.out.println("\n***************************************************************");
			System.out.println("                 *  Mes films préférés       *");
			System.out.println("*****************************************************************");
			System.out.println("      * 1- Ajouter un joueur                          *");
			System.out.println("      * 2- Ajouter un film                            *");
			System.out.println("      * 3- Ajouter un acteur à un film                *");
			System.out.println("      * 4- Afficher les films                         *");
			System.out.println("      * 5- Afficher les acteurs                       *");
			
                        System.out.println("*****************************************************************");
			System.out.println("      * 0- Quitter                                              *");
			System.out.println("*****************************************************************");
			System.out.print("      Votre Choix : ");
			
                        choix = sc.nextLine();
                        switch (choix) {
				case "1": {
                                      Joueur j= Utilitaire.demanderJoueur();
                                        controleur.getJoueurs().add(j);
                                        controleur.affichej();
                                    
                                    
                                        break; }
				case "2": {
                                      
                                        break;}
				
                                case "0":
                                        return;
				default:
                                       System.out.println("Choix non valide");
                                       break;
				} // switch
                        } while (choix != "0");
        
    }
}
