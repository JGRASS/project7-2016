package kviz.dopunska.sistemske_operacije;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
/**
 * 
 * @author Sava
 *
 */
public class SOOsveziRangListu {
	/**
	 * Upisuje prosledjenu rang listu u tekstualnu datoteku
	 * @param rang lista
	 */
	public static void izvrsi(LinkedList<String> rank) {
		PrintWriter in;
		try {
			in = new PrintWriter(new BufferedWriter(new FileWriter("fajlovi/rang_dopunska.txt")));
			in.println("RANG LISTA");
			for(int i = 0; i < rank.size(); i=i+2){
				if(i+2 != rank.size()){
					in.println(rank.get(i)); 
					in.println(rank.get(i+1));
					in.println("");
				}else{
					in.println(rank.get(i));
					in.print(rank.get(i+1));
				}
			}
			
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
