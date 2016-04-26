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

public class SOSerijalizuj {
	
	public static void izvrsi(LinkedList<Integer> highScore, LinkedList<String> highScoreImena) throws Exception {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("highscore/licitacijeHighScore.txt")));
		
		for (int i = 0; i < highScore.size(); i++) {
			out.println(highScore.get(i));
			out.println(highScoreImena.get(i));
			if(i != highScore.size() - 1)
				out.println();
		}
		out.close();		
	}
	
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
