package kviz.licitacije.sistemske_operacije;

import java.util.LinkedList;

public class SOUpisiImeUListu {
	
	public static void izvrsi(String ime, int pozicija,int poeni , LinkedList<Integer> highScore, 
								LinkedList<String> highScoreImena) {
		highScoreImena.add(pozicija, ime);
		highScore.add(pozicija, poeni);
		highScore.removeLast();
		highScoreImena.removeLast();
	}
}
