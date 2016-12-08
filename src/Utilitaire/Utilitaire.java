package Utilitaire;

import Model.*;
import Controleur.*;
import java.util.Scanner;


public class Utilitaire {
	
	    private static final Random RANDOM = new Random();

	    public static int desA() {
        return RANDOM.nextInt(6)+1;
    }

          public static int desB() {
        return RANDOM.nextInt(6)+1;
    }

          public static int lancerDes(){
             return desA()+desB();
             
              
          }


	

}//
