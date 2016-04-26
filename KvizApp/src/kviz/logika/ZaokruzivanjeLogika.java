package kviz.logika;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class ZaokruzivanjeLogika {
	public LinkedList<String> pitanja;
	
	public ZaokruzivanjeLogika(){
		pitanja = new LinkedList<String>();
	}
	
	public void ucitajZaokruzivanjeFajl() throws Exception {
		FileReader f = new FileReader("fajlovi/pitalice.txt");
		BufferedReader in = new BufferedReader(f);
		boolean kraj = false;
		
		while(!kraj){
			pitanja.add(in.readLine());
			if(in.readLine() == null){
				kraj = true;
			}
			
		}
		in.close();
		
	}
	
	public String[] vratiPitanjaIOdgovore(int brPitanja){
		int brojac=brPitanja*3;
		String pitanje = pitanja.get(brojac);
		String odgovori = pitanja.get(brojac+1);
		String tacanOdgovor = pitanja.get(brojac+2);
		
		return new String[]{pitanje,odgovori,tacanOdgovor};
	}
	public LinkedList<String> ucitajRangListu() throws Exception{
		LinkedList<String> rank = new LinkedList<>();
		BufferedReader in = new BufferedReader(new FileReader("fajlovi/rang_zaokruzivanje.txt"));
		while(in.readLine()!=null){
			rank.add(in.readLine());
			rank.add(in.readLine());
		}
		in.close();
		return rank;
	}
	public void ubaciURangListu(String imeTakmicara, String skor) {
		LinkedList<String> rank = new LinkedList<>();
		try {
			rank = ucitajRangListu();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(rank.isEmpty()){
			rank.add(skor);
			rank.add(imeTakmicara);
			return;
		}
		boolean unet = false;
		for(int i = 1; i < rank.size(); i=i+2){
			if(Integer.parseInt(rank.get(i)) < Integer.parseInt(skor)){
				rank.add(i-1, skor);
				rank.add(i-1, imeTakmicara);
				unet = true;
				break;
			}
		}
		if(unet==false){
			rank.addLast(skor);
			rank.addLast(imeTakmicara);
			return;
		}
		osveziRangListu(rank);
		
	}
	private void osveziRangListu(LinkedList<String> rank) {
		try {
			PrintWriter in = new PrintWriter(new BufferedWriter(new FileWriter("fajlovi/rang_zaokruzivanje.txt")));
			in.println("RANG LISTA");
			for(int i = 0; i < rank.size(); i=i+2){
				if(i+2 != rank.size()){
					in.println(rank.get(i));
					in.println(rank.get(i+1));
					in.println("");
				}else{
					in.println(rank.get(i));
					in.print(rank.get(i+1));
				}
			}
			
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public LinkedList<String> getPitanja() {
		return pitanja;
	}

	public void setPitanja(LinkedList<String> pitanja) {
		this.pitanja = pitanja;
	}
}
