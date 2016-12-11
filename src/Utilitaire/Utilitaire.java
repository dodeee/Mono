package Utilitaire;

import Model.*;
import Controleur.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Utilitaire {
	
	  private final Random RANDOM = new Random();
          private final int[] tab={RANDOM.nextInt(6)+1,RANDOM.nextInt(6)+1};
	   
          public int lancerDes(){
            return tab[0]+tab[1]; 
          }
          public boolean DesEgal(){
              return tab[0]==tab[1];
          }
}//
