package kviz.licitacije.sistemske_operacije;

import java.util.LinkedList;

public class SOVratiRangListu {
	
	/**
	 * Metoda koja vraca sadrzaj rang liste u vidu stringa.
	 * @param highScore lista koja sadrzi poene rang liste
	 * @param highScoreImena lista koja sadrzi imena rang liste
	 * @return
	 */
	public static String izvrsi(LinkedList<Integer> highScore, LinkedList<String> highScoreImena) {
		String s = new String();
		for (int i = 0; i < highScore.size(); i++) {
			s += (i+1) +  ". " + highScoreImena.get(i) + "  " + highScore.get(i) + "\n";
		}
		return s;
	}
}
