package kviz.licitacije;

import java.util.LinkedList;

public class HighScoreLicitacije {
	/**
	 * Lista sa poenima na rang listi kviza.
	 */
	private LinkedList<Integer> highScore = new LinkedList<Integer>();
	/**
	 * Lista sa imenima na rang listi kviza.
	 */
	private LinkedList<String> highScoreImena = new LinkedList<String>();
	/**
	 * Indikator da li su pitanja i rang lista ucitani.
	 */
	
	public LinkedList<Integer> getHighScore() {
		return highScore;
	}
	
	public void setHighScore(LinkedList<Integer> highScore) {
		this.highScore = highScore;
	}

	public LinkedList<String> getHighScoreImena() {
		return highScoreImena;
	}

	public void setHighScoreImena(LinkedList<String> highScoreImena) {
		this.highScoreImena = highScoreImena;
	}
}
