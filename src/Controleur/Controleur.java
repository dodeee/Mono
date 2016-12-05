package Controleur;

import Model.*;
import java.util.*;
import Utilitaire.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Controleur {
      
     
	private Carreaux carreaux;
	private ArrayList<Joueur> joueurs;

    public Controleur() {
    }
        
        
    public void creerPlateau(String dataFilename){
		buildGamePlateau(dataFilename);
	}
	
	private void buildGamePlateau(String dataFilename)
	{
		try{
			ArrayList<String[]> data = readDataFile(dataFilename, ",");
			
			//TODO: create cases instead of displaying
			for(int i=0; i<data.size(); ++i){
				String caseType = data.get(i)[0];
				if(caseType.compareTo("P") == 0){
					System.out.println("Propriété :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        Carreaux c = new ProprieteAConstruire();
				}
				else if(caseType.compareTo("G") == 0){
					System.out.println("Gare :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
				}
				else if(caseType.compareTo("C") == 0){
					System.out.println("Compagnie :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
				}
				else if(caseType.compareTo("AU") == 0){
					System.out.println("Case Autre :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
				}
				else
					System.err.println("[buildGamePleateau()] : Invalid Data type");
			}
			
		} 
		catch(FileNotFoundException e){
			System.err.println("[buildGamePlateau()] : File is not found!");
		}
		catch(IOException e){
			System.err.println("[buildGamePlateau()] : Error while reading file!");
		}
	}
	
	private ArrayList<String[]> readDataFile(String filename, String token) throws FileNotFoundException, IOException
	{
		ArrayList<String[]> data = new ArrayList<String[]>();
		
		BufferedReader reader  = new BufferedReader(new FileReader(filename));
		String line = null;
		while((line = reader.readLine()) != null){
			data.add(line.split(token));
		}
		reader.close();
		
		return data;
	}

	

	/**
	 * 
	 * @param j
	 * @param nb
	 */
	private Carreaux avancer(Joueur j, int nb) {
		// TODO - implement Controleur.avancer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param type
	 */
	public void miseAJour(TypeCommande type) {
		// TODO - implement Controleur.miseAJour
		throw new UnsupportedOperationException();
	}

	public Joueur getJoueurCourant() {
		// TODO - implement Controleur.getJoueurCourant
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param num
	 * @param nb
	 */
	public int CalculNouvPos(int num, int nb) {
		// TODO - implement Controleur.CalculNouvPos
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param b
	 */
	public Carreaux getCarreau(int b) {
		// TODO - implement Controleur.getCarreau
		throw new UnsupportedOperationException();
	}

}