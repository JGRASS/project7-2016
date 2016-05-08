package kviz.logika;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import kviz.logika.zaokruzivanjeSistemskeOperacije.SOPitanjaIOdgovori;
import kviz.logika.zaokruzivanjeSistemskeOperacije.SOUbaciURangListu;
import kviz.logika.zaokruzivanjeSistemskeOperacije.SOUcitajFajlSaPitanjima;
import kviz.logika.zaokruzivanjeSistemskeOperacije.SOUcitajRangListu;
/**
 * Klasa koja upravlja logikom kviza sa ponudjenim odgovorima
 * @author Andrija
 *
 */
public class ZaokruzivanjeLogika {
	public LinkedList<String> pitanja;
	
	public ZaokruzivanjeLogika(){
		pitanja = new LinkedList<String>();
	}
	/**
	 * Ucitava sva pitanja i odgovore iz odredjenog fajla i puni listu sa njima
	 * @throws Exception
	 */
	public void ucitajZaokruzivanjeFajl() throws Exception {
		SOUcitajFajlSaPitanjima.izvrsi(pitanja);		
	}
	/**
	 * Vraca string niz od 3 elemenata u kome je prvi element pitanje,
	 * drugi element svi odgovori a treci element tacan odgovor
	 * @param redni broj pitanja
	 * @return
	 */
	public String[] vratiPitanjaIOdgovore(int brPitanja){
		return SOPitanjaIOdgovori.izvrsi(pitanja, brPitanja);
	}
	/**
	 * Metoda koja ucitava data fajl i iz njega puni rang listu
	 * @return Rang lista
	 * @throws Exception
	 */
	public LinkedList<String> ucitajRangListu() throws Exception{
		
		return SOUcitajRangListu.izvrsi();
	}
	/**
	 * Metoda koja ubacuje takmicara i njegov ostvareni skor u sortiranu listu i nakon toga
	 * refreshuje data fajl sa rang listom
	 * @param imeTakmicara
	 * @param skor
	 */
	public void ubaciURangListu(String imeTakmicara, String skor) {
		SOUbaciURangListu.izvrsi(imeTakmicara, skor);
	}
	/**
	 * Metoda koja refreshuje data fajl koji sadrzi rang listu
	 * @param rang lista
	 */
	private void osveziRangListu(LinkedList<String> rank) {
		SOUbaciURangListu.osveziRangListu(rank);

	}
	/**
	 * Metoda koja vraca listu pitanja
	 * @return pitanja
	 */
	public LinkedList<String> getPitanja() {
		return pitanja;
	}

	public void setPitanja(LinkedList<String> pitanja) {
		this.pitanja = pitanja;
	}
}
