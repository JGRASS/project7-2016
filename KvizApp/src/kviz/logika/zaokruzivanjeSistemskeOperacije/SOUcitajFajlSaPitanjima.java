package kviz.logika.zaokruzivanjeSistemskeOperacije;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
/**
 * 
 * @author Andrija
 *
 */
public class SOUcitajFajlSaPitanjima {
	/**
	 * Ucitava pitanja i odgovore iz fajla i puni listu
	 * @param lista pitanja
	 * @throws Exception
	 */
	public static void izvrsi(LinkedList<String> pitanja) throws Exception {
		FileReader f = new FileReader("fajlovi/pitalice.txt");
		BufferedReader in = new BufferedReader(f);
		boolean kraj = false;
		
		while(!kraj){
			pitanja.add(in.readLine());
			if(in.readLine() == null){
				kraj = true;
			}
			
		}
		in.close();
		
	}
}
