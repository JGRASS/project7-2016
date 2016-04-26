package kviz.logika;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JOptionPane;

import kviz.licitacije.HighScoreLicitacije;
import kviz.licitacije.PitanjaLicitacije;
import kviz.licitacije.sistemske_operacije.SOIzaberiPitanje;
import kviz.licitacije.sistemske_operacije.SOProveriUpisNaRangListu;
import kviz.licitacije.sistemske_operacije.SOSerijalizuj;
import kviz.licitacije.sistemske_operacije.SOUcitajFajl;
import kviz.licitacije.sistemske_operacije.SOUpisiImeUListu;
import kviz.licitacije.sistemske_operacije.SOVratiRangListu;
/**
 * Klasa koja predstavlja logiku kviza licitacije.
 * @author Marko
 *
 */
public class LicitacijaLogika {
	
	private PitanjaLicitacije pitanjaLicitacije = new PitanjaLicitacije();
	private HighScoreLicitacije highScoreLicitacije = new HighScoreLicitacije();
	
	
	/**
	 * Metoda za ucitavanje pitanja i rang liste u odgovarajuce atribute.
	 * @throws Exception
	 */
	public void ucitajFajl() throws Exception {
/*			SOUcitajFajl.izvrsi(pitanjaLicitacije.getPrviNivo(), pitanjaLicitacije.getDrugiNivo(), pitanjaLicitacije.getTreciNivo(),
									highScoreLicitacije.getHighScore(), highScoreLicitacije.getHighScoreImena()); */
			SOUcitajFajl.ucitajTxtFajl(pitanjaLicitacije.getPrviNivo(), pitanjaLicitacije.getDrugiNivo(), pitanjaLicitacije.getTreciNivo());
			SOUcitajFajl.deserijalizujRangListuPoena(highScoreLicitacije.getHighScore());
			SOUcitajFajl.deserijalizujRangListuImena(highScoreLicitacije.getHighScoreImena());
	}

	/**
	 * Metoda koja vrsi izbor pitanja i vraca niz sa pitanjem i tacnim odgovorom.
	 * @param brPitanja broj trenutnog pitanja u kvizu
	 * @return niz sa pitanjem i tacnim odgovorom
	 */
	public String[] izaberiPitanje(int brPitanja) {
		return SOIzaberiPitanje.izvrsi(brPitanja, pitanjaLicitacije.getPrviNivo(), pitanjaLicitacije.getDrugiNivo(), 
							pitanjaLicitacije.getTreciNivo());
	}

	/**
	 * Meotda koja provera da li treba izvrsiti upis na rang listu kviza.
	 * @param poeni koje su osvojeni u kvizu
	 * @return -1 u slucaju da ne treba upisati, a u slucaju da treba odogovarajucu poziciju pocevsi od 0
	 */
	public int proveriIUpisiNaRangListu(int poeni) {
		return SOProveriUpisNaRangListu.izvrsi(poeni, highScoreLicitacije.getHighScore());
	}

	/**
	 * Metoda vrsi upis broja poena i imena takmicara u odgovarajuce liste.
	 * @param ime koje ce biti upisano
	 * @param pozicija na koju ce takmicar biti upisan
	 * @param poeni broj poena za upis
	 */
	public void upisiImeUListu(String ime, int pozicija,int poeni) {
		SOUpisiImeUListu.izvrsi(ime, pozicija, poeni, highScoreLicitacije.getHighScore()
								,highScoreLicitacije.getHighScoreImena());
	}

	/**
	 * Metoda vraca string koji sadrzi rang listu.
	 * @return string sa rang listom
	 */
	public String vratiRangListu() {
		return SOVratiRangListu.izvrsi(highScoreLicitacije.getHighScore(), highScoreLicitacije.getHighScoreImena());
	}
	
	/**
	 * Metoda omogucije serijalizaciju rang liste.
	 * @throws Exception
	 */
	public void serijalizuj() throws Exception {
//		SOSerijalizuj.izvrsi(highScoreLicitacije.getHighScore(), highScoreLicitacije.getHighScoreImena());
		SOSerijalizuj.serijalizujPoeneRangListe(highScoreLicitacije.getHighScore());
		SOSerijalizuj.serijalizujImenaRangListe( highScoreLicitacije.getHighScoreImena());
	}

	public PitanjaLicitacije getPitanjaLicitacije() {
		return pitanjaLicitacije;
	}

	public void setPitanjaLicitacije(PitanjaLicitacije pitanjaLicitacije) {
		if(pitanjaLicitacije == null)
			throw new RuntimeException("Greska prilikom inicijalizacije.");
		this.pitanjaLicitacije = pitanjaLicitacije;
	}

	public HighScoreLicitacije getHighScoreLicitacije() {
		return highScoreLicitacije;
	}

	public void setHighScoreLicitacije(HighScoreLicitacije highScoreLicitacije) {
		if(highScoreLicitacije == null)
			throw new RuntimeException("Greska prilikom inicijalizacije.");
		this.highScoreLicitacije = highScoreLicitacije;
	}
	
	
}
