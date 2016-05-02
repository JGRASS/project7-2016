package kviz.dopunska.sistemske_operacije;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
/**
 * 
 * @author Sava
 *
 */
public class SOUcitajPitanja {
	/**
	 * Ucitava sva pitanja iz tekstualne datoteke i
	 * puni liste u zavisnosti od tezine pitanja
	 * @throws Exception ako ne postoji fajl sa pitanjima
	 * @param laksa, srednja i teza pitanja
	 */
	public static void izvrsi(LinkedList<String> laksa, LinkedList<String> srednja, LinkedList<String> teza) throws Exception{
		BufferedReader in = new BufferedReader(new FileReader("fajlovi/dopunska.txt"));
		
		boolean kraj = false;

		while(in.readLine().equals("1")){
			laksa.add(in.readLine());
			laksa.add(in.readLine());
		}
		do {
			srednja.add(in.readLine());
			srednja.add(in.readLine());
		} while (in.readLine().equals("2"));
		while(!kraj){
			teza.add(in.readLine());
			teza.add(in.readLine());
			if(in.readLine() == null){
				kraj = true;
			}
		}
		
		in.close();
	}
	
}
