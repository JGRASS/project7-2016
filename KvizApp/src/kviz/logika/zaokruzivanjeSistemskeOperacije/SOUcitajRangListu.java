package kviz.logika.zaokruzivanjeSistemskeOperacije;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;

public class SOUcitajRangListu {
	
	public static LinkedList<String> izvrsi(){
	LinkedList<String> rank = new LinkedList<>();
	BufferedReader in;
	try {
		in = new BufferedReader(new FileReader("fajlovi/rang_zaokruzivanje.txt"));
		while(in.readLine()!=null){
			rank.add(in.readLine());
			rank.add(in.readLine());
		}
		in.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return rank;
	}
}