package kviz.licitacije.sistemske_operacije;

import java.util.LinkedList;

public class SOUpisiImeUListu {
	
	/**
	 * Metoda omogucava upis imena i poena takmicara na odgovarajucu poziciju u rang listi.
	 * @param ime takmicara za upis
	 * @param pozicija na koju se upisuje takmicar
	 * @param poeni broj osvojenih poena
	 * @param highScore lista koja sadrzi poene rang liste
	 * @param highScoreImena lista koja sadrzi imena rang liste
	 */
	public static void izvrsi(String ime, int pozicija,int poeni , LinkedList<Integer> highScore, 
								LinkedList<String> highScoreImena) {
		highScoreImena.add(pozicija, ime);
		highScore.add(pozicija, poeni);
		if(highScore.size() > 10 && highScoreImena.size() > 10){
			highScore.removeLast();
			highScoreImena.removeLast();
		}
	}
}
