/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;
import Controleur.*;
import Model.*;
import java.util.Scanner;
import Utilitaire.*;
import ui.Ihm;
/**
 *
 * @author dodee
 */
public class Monopoly {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fileName = "data.txt";
        Controleur controleur = new Controleur();
        controleur.creerPlateau("C:\\Users\\dodee\\OneDrive\\Documents\\NetBeansProjects\\Monop\\src\\monopoly\\data.txt");
        controleur.jouer();
        
//         
//         
//
//              controleur.affichec();
//         controleur.setPositionDep();
//         controleur.affichej();
//         controleur.jouerTour(controleur.getJoueurs().get(1));
//        
//         controleur.affichej();
//   
//        
//         
//         
//        ihm.affichSituationJoueur(controleur.getJoueurs().get(0));
//        ihm.affichSituationJoueur(controleur.getJoueurs().get(1));
//        
//        controleur.jouerTour(controleur.getJoueurs().get(0));
//        
//        ihm.affichSituationJoueur(controleur.getJoueurs().get(0));
//        ihm.affichSituationJoueur(controleur.getJoueurs().get(1));
//         
         
         
    }
    
    
    
    
    
    
}//
