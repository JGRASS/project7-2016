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
/**
 * Klasa koja predstavlja logiku kviza licitacije.
 * @author Marko
 *
 */
public class LicitacijaLogika {
	/**
	 * Lista pitanja prvog nivoa.
	 */
	private LinkedList<String> prviNivo;
	/**
	 * Lista pitanja drugog nivoa.
	 */
	private LinkedList<String> drugiNivo;
	/**
	 * Lista pitanja treceg nivoa.
	 */
	private LinkedList<String> treciNivo;
	/**
	 * Lista sa poenima na rang listi kviza.
	 */
	private LinkedList<Integer> highScore;
	/**
	 * Lista sa imenima na rang listi kviza.
	 */
	private LinkedList<String> highScoreImena;
	/**
	 * Indikator da li su pitanja i rang lista ucitani.
	 */
	private boolean vecUcitano = false;
	
	/**
	 * Konstruktor koji inicijalizuje liste ove klase.
	 */
	public LicitacijaLogika(){
		prviNivo = new LinkedList<String>();
		drugiNivo = new LinkedList<String>();
		treciNivo = new LinkedList<String>();
		highScore = new LinkedList<Integer>();
		highScoreImena = new LinkedList<String>();
	}
	
	/**
	 * Metoda za ucitavanje pitanja i rang liste u odgovarajuce atribute.
	 * @throws Exception
	 */
	public void ucitajFajl() throws Exception {
			if(!(prviNivo.isEmpty()))
				prviNivo.remove();
			if(!(drugiNivo.isEmpty()))
				drugiNivo.remove();
			if(!(treciNivo.isEmpty()))
				treciNivo.remove();
			FileReader f = new FileReader("fajlovi/licitacije.txt");
			BufferedReader in = new BufferedReader(f);

			boolean kraj = false;

			while(in.readLine().equals("1")){
				prviNivo.add(in.readLine());
				prviNivo.add(in.readLine());
			}
			do {
				drugiNivo.add(in.readLine());
				drugiNivo.add(in.readLine());
			} while (in.readLine().equals("2"));
			while(!kraj){
				treciNivo.add(in.readLine());
				treciNivo.add(in.readLine());
				if(in.readLine() == null){
					kraj = true;
				}
			}

			in.close();
		

			FileReader f1 = new FileReader("highscore/licitacijeHighScore.txt");
			BufferedReader in1 = new BufferedReader(f1);
			
			int r = 0;
			if(!vecUcitano){
				boolean kraj1 = false;
				while(!kraj1){
					Integer i = Integer.valueOf(in1.readLine());
					highScore.add(i);
					highScoreImena.add(in1.readLine());
					r++;
					if(in1.readLine() == null){
						kraj1 = true;
					}
				}
				vecUcitano = true;
			} else{
				boolean kraj1 = false;
				while(!kraj1){
					Integer i = Integer.valueOf(in1.readLine());
					highScore.set(r, i);
					highScoreImena.set(r, in1.readLine());
					r++;
					if(in1.readLine() == null){
						kraj1 = true;
					}
				}
			}
			
			in1.close();
	}

	/**
	 * Metoda koja vrsi izbor pitanja i vraca niz sa pitanjem i tacnim odgovorom.
	 * @param brPitanja broj trenutnog pitanja u kvizu
	 * @return niz sa pitanjem i tacnim odgovorom
	 */
	public String[] izaberiPitanje(int brPitanja) {
		
		if(brPitanja >= 10 && brPitanja <= 14){
			int random;
			while(true){
				random = (int )(Math.random() * prviNivo.size());
				if(random % 2 == 0)
					break;
			}
			String pitanje = prviNivo.get(random);
			String odgovor = prviNivo.get(random + 1);
			prviNivo.remove(random);
			prviNivo.remove(random);
			return new String[]{pitanje, odgovor};
			
		}else if(brPitanja >= 5 && brPitanja <= 9){
			int random;
			while(true){
				random = (int )(Math.random() * drugiNivo.size());
				if(random % 2 == 0)
					break;
			}
			String pitanje = drugiNivo.get(random);
			String odgovor = drugiNivo.get(random + 1);
			drugiNivo.remove(random);
			drugiNivo.remove(random);
			return new String[]{pitanje, odgovor};
		}else{
			int random;
			while(true){
				random = (int )(Math.random() * treciNivo.size());
				if(random % 2 == 0)
					break;
			}
			String pitanje = treciNivo.get(random);
			String odgovor = treciNivo.get(random + 1);
			treciNivo.remove(random);
			treciNivo.remove(random);
			return new String[]{pitanje, odgovor};
		}
	}
	
	public LinkedList<String> getPrviNivo() {
		return prviNivo;
	}
	public void setPrviNivo(LinkedList<String> prviNivo) {
		if(prviNivo == null)
			throw new RuntimeException("Greska prilikom inicijalizacije liste");
		this.prviNivo = prviNivo;
	}
	public LinkedList<String> getDrugiNivo() {
		return drugiNivo;
	}
	public void setDrugiNivo(LinkedList<String> drugiNivo) {
		if(drugiNivo == null)
			throw new RuntimeException("Greska prilikom inicijalizacije liste");
		this.drugiNivo = drugiNivo;
	}
	public LinkedList<String> getTreciNivo() {
		return treciNivo;
	}
	public void setTreciNivo(LinkedList<String> treciNivo) {
		if(treciNivo == null)
			throw new RuntimeException("Greska prilikom inicijalizacije liste");
		this.treciNivo = treciNivo;
	}
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

	/**
	 * Meotda koja provera da li treba izvrsiti upis na rang listu kviza.
	 * @param poeni koje su osvojeni u kvizu
	 * @return -1 u slucaju da ne treba upisati, a u slucaju da treba odogovarajucu poziciju pocevsi od 0
	 */
	public int proveriIUpisiNaRangListu(int poeni) {
		if(poeni > highScore.get(0)){
			return 0;
		}
		for (int i = 0; i < highScore.size() - 1; i++) {
			if(highScore.get(i) > poeni && highScore.get(i + 1) < poeni){
				return i + 1;
			}
		}
		return -1;
	}

	/**
	 * Metoda vrsi upis broja poena i imena takmicara u odgovarajuce liste.
	 * @param ime koje ce biti upisano
	 * @param pozicija na koju ce takmicar biti upisan
	 * @param poeni broj poena za upis
	 */
	public void upisiImeUListu(String ime, int pozicija,int poeni) {
		highScoreImena.add(pozicija, ime);
		highScore.add(pozicija, poeni);
		highScore.removeLast();
		highScoreImena.removeLast();
	}

	/**
	 * Metoda vraca string koji sadrzi rang listu.
	 * @return string sa rang listom
	 */
	public String vratiRangListu() {
		String s = new String();
		for (int i = 0; i < highScore.size(); i++) {
			s += (i+1) +  ". " + highScoreImena.get(i) + "  " + highScore.get(i) + "\n";
		}
		return s;
	}
	/**
	 * Metoda omogucije serijalizaciju rang liste.
	 * @throws Exception
	 */
	public void serijalizuj() throws Exception {
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
