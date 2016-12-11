package Utilitaire;

import Model.*;
import Controleur.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Utilitaire {
	
	  private static final Random RANDOM = new Random();
          private static final int[] tab={RANDOM.nextInt(6)+1,RANDOM.nextInt(6)+1};
	   
          public static  int lancerDes(){
            return tab[0]+tab[1];
          }
          public static boolean Desegaux(){
              return tab[0]==tab[1];
          }
}
