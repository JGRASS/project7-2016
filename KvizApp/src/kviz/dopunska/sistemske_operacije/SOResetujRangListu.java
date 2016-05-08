package kviz.dopunska.sistemske_operacije;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
/**
 * 
 * @author Sava
 *
 */
public class SOResetujRangListu {
	/**
	 * Postavlja sva imena u rang listi na "EMPTY" i svaki skor na 0
	 */
	public static void izvrsi() {
		PrintWriter in;
		try {
			in = new PrintWriter(new BufferedWriter(new FileWriter("fajlovi/rang_dopunska.txt")));
			in.println("RANG LISTA");
			for(int i = 0; i < 15; i++){
				if(i==14){
					in.println("EMPTY"); 
					in.println("0");
				}else{
					in.println("EMPTY"); 
					in.println("0");
					in.println("");
				}
			}
			
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
