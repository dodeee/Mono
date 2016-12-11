package Utilitaire;

import Model.*;
import Controleur.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Utilitaire {
    private static final Random RAMDOM=new Random();
    public static int lancesDes(){
        return RAMDOM.nextInt(6)+1;
    }
    public static boolean desEgaux(int a,int b){
        return a==b;
    }
}
