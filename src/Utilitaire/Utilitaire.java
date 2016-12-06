package Utilitaire;

import Model.*;
import Controleur.*;
import java.util.Scanner;


public class Utilitaire {

	public static void lancerDés() {
		// TODO - implement Utilitaire.lancerDés
		throw new UnsupportedOperationException();
	}
        public static Joueur demanderJoueur(){
            System.out.println("Veuillez entrer un nom de Joueur");
            Scanner sc = new Scanner(System.in);
            
            String nomJ = sc.nextLine();
            Joueur j = new Joueur(nomJ);
            return j;
        }

}//