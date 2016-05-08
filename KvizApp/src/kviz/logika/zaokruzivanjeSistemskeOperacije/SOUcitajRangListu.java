package kviz.logika.zaokruzivanjeSistemskeOperacije;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
/**
 * 
 * @author Andrija
 *
 */
public class SOUcitajRangListu {
	
	public static LinkedList<String> izvrsi(){
		
	
	LinkedList<String> rank = new LinkedList<>();
	
	try{
	DataInputStream in = new DataInputStream
			(new BufferedInputStream(new FileInputStream("fajlovi/zaokruzivanjerang.out")));
	while(in.available()!=0){
		rank.add(in.readUTF());
		rank.add(in.readUTF());
	}
	in.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	return rank;
	}
}

