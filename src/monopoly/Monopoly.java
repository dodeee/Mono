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
         controleur.creerPlateau("/users/info/etu-s2/dodee/COO/Monopoly/src/monopoly/data.txt");
         controleur.affiche();
         
         
         
         
         
    }
    
    
    
    
    
    
}//