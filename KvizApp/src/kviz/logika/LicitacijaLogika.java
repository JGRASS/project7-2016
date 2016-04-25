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

public class LicitacijaLogika {
	private LinkedList<String> prviNivo;
	private LinkedList<String> drugiNivo;
	private LinkedList<String> treciNivo;
	private LinkedList<Integer> highScore;
	private LinkedList<String> highScoreImena;
	private boolean vecUcitano = false;
	
	public LicitacijaLogika(){
		prviNivo = new LinkedList<String>();
		drugiNivo = new LinkedList<String>();
		treciNivo = new LinkedList<String>();
		highScore = new LinkedList<Integer>();
		highScoreImena = new LinkedList<String>();
	}
	
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
			String s;
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
		this.prviNivo = prviNivo;
	}
	public LinkedList<String> getDrugiNivo() {
		return drugiNivo;
	}
	public void setDrugiNivo(LinkedList<String> drugiNivo) {
		this.drugiNivo = drugiNivo;
	}
	public LinkedList<String> getTreciNivo() {
		return treciNivo;
	}
	public void setTreciNivo(LinkedList<String> treciNivo) {
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

	public int proveriIUpisiNaRangListu(int poeni) {
		if(poeni > highScore.get(0)){
//			highScore.addFirst(poeni);
//			highScore.removeLast();
			return 0;
		}
		for (int i = 0; i < highScore.size() - 1; i++) {
			if(highScore.get(i) > poeni && highScore.get(i + 1) < poeni){
//				highScore.add(i + 1, poeni);
//				highScore.remove(10);
				return i + 1;
			}
		}
		return -1;
	}

	public void upisiImeUListu(String ime, int pozicija,int poeni) {
		highScoreImena.add(pozicija, ime);
		highScore.add(pozicija, poeni);
		highScore.removeLast();
		highScoreImena.removeLast();
	}

	public String vratiRangListu() {
		String s = new String();
		for (int i = 0; i < highScore.size(); i++) {
			s += (i+1) +  ". " + highScoreImena.get(i) + "  " + highScore.get(i) + "\n";
		}
		return s;
	}

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
