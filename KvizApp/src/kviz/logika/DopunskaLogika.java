package kviz.logika;

import java.util.LinkedList;

import kviz.dopunska.PitanjaDopunska;
import kviz.dopunska.sistemske_operacije.SOPitanjeNivo;
import kviz.dopunska.sistemske_operacije.SOUbaciURangListu;
import kviz.dopunska.sistemske_operacije.SOUcitajPitanja;
import kviz.dopunska.sistemske_operacije.SOUcitajRangListuDopunska;
/**
 * Klasa koja upravlja logikom kviza na dopunu
 * @author Sava
 *
 */
public class DopunskaLogika {
	PitanjaDopunska pitanja = new PitanjaDopunska();
	
	public PitanjaDopunska getPitanja() {
		return pitanja;
	}

	public void setPitanja(PitanjaDopunska pitanja) {
		if(pitanja == null)
			throw new RuntimeException();
		this.pitanja = pitanja;
	}

	/**
	 * Ucitava sva pitanja iz tekstualne datoteke i
	 * puni liste u zavisnosti od tezine pitanja
	 * @throws Exception ako ne postoji fajl sa pitanjima
	 */
	public void ucitajPitanja() throws Exception{
		SOUcitajPitanja.izvrsi(pitanja.getLaksa(), pitanja.getSrednja(), pitanja.getTeza());
	}
	
	/**
	 * U zavisnosti od trenutnog skora takmicara, pronalazi i vraca pitanje i odgovor iz odredjene grupe tezine pitanja
	 * @param skor - trenutni skor koji je takmicar ostvario
	 * @return dvoclani niz String-ova - prvi clan je pitanje a drugi odgovor
	 */
	public String[] pitanjeNivo(int skor) {
		return SOPitanjeNivo.izvrsi(skor, pitanja);
	}
	/**
	 * Ucitava rang listu iz tekstualne datoteke i vraca je
	 * @return listu rangiranja
	 * @throws Exception
	 */
	public LinkedList<String> ucitajRangListu() throws Exception{
		return SOUcitajRangListuDopunska.izvrsi();
	}
	/**
	 * U zavisnosti od ostvarenog skora upisuje takmicara u rang listu
	 * @param imeTakmicara
	 * @param skor
	 */
	public void ubaciURangListu(String imeTakmicara, String skor) {
		SOUbaciURangListu.izvrsi(imeTakmicara, skor);
	}
}
