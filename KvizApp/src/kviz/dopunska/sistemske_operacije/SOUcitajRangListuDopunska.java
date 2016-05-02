package kviz.dopunska.sistemske_operacije;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
/**
 * 
 * @author Sava
 *
 */
public class SOUcitajRangListuDopunska {
	/**
	 * Ucitava rang listu iz tekstualne datoteke i vraca je
	 * @return listu rangiranja
	 * @throws Exception
	 */
	public static LinkedList<String> izvrsi() throws Exception{
		LinkedList<String> rank = new LinkedList<>();
		BufferedReader in = new BufferedReader(new FileReader("fajlovi/rang_dopunska.txt"));
		while(in.readLine()!=null){
			rank.add(in.readLine());
			rank.add(in.readLine());
		}
		in.close();
		return rank;
	}
	
}
