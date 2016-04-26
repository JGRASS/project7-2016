package kviz.licitacije.sistemske_operacije;

import java.io.BufferedWriter;
import java.io.FileWriter;
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
}
