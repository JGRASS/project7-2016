package kviz.licitacije.sistemske_operacije;

import java.util.LinkedList;

public class SOVratiRangListu {
	
	public static String izvrsi(LinkedList<Integer> highScore, LinkedList<String> highScoreImena) {
		String s = new String();
		for (int i = 0; i < highScore.size(); i++) {
			s += (i+1) +  ". " + highScoreImena.get(i) + "  " + highScore.get(i) + "\n";
		}
		return s;
	}
}
