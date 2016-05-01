package kviz.licitacije.sistemske_operacije;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;

/**
 * 
 * @author Marko
 *
 */
public class SOSerijalizuj {
	
	/**
	 * Metoda omogucuje serijalizaciju poena sa rang liste.
	 * @param highScore lista sa poenima za serijalizaciju
	 * @throws Exception
	 */
	public static void serijalizujPoeneRangListe(LinkedList<Integer> highScore) throws Exception{
		
		ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("highscore/highScorePoeni.out")));
		
		out.writeObject(highScore);
		
		out.close();
	}

	/**
	 * Metoda omogucuje serijalizaciju imena sa rang liste.
	 * @param highScoreImena lista sa imenima za serijalizaciju
	 * @throws Exception
	 */
	public static void serijalizujImenaRangListe(LinkedList<String> highScoreImena) throws Exception{

		ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("highscore/highScoreImena.out")));
		
		out.writeObject(highScoreImena);
		
		out.close();
	}
}
