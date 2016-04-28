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

public class ZaokruzivanjeLogika {
	public LinkedList<String> pitanja;
	
	public ZaokruzivanjeLogika(){
		pitanja = new LinkedList<String>();
	}
	
	public void ucitajZaokruzivanjeFajl() throws Exception {
		SOUcitajFajlSaPitanjima.izvrsi(pitanja);		
	}
	
	public String[] vratiPitanjaIOdgovore(int brPitanja){
		return SOPitanjaIOdgovori.izvrsi(pitanja, brPitanja);
	}
	public LinkedList<String> ucitajRangListu() throws Exception{
		
//		LinkedList<String> rank = new LinkedList<>();
//		BufferedReader in = new BufferedReader(new FileReader("fajlovi/rang_zaokruzivanje.txt"));
//		while(in.readLine()!=null){
//			rank.add(in.readLine());
//			rank.add(in.readLine());
//		}
//		in.close();
//		return rank;
		return SOUcitajRangListu.izvrsi();
	}
	public void ubaciURangListu(String imeTakmicara, String skor) {
		SOUbaciURangListu.izvrsi(imeTakmicara, skor);
//		LinkedList<String> rank = new LinkedList<>();
//		try {
//			rank = ucitajRangListu();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		if(rank.isEmpty()){
//			rank.add(skor);
//			rank.add(imeTakmicara);
//			osveziRangListu(rank);
//			return;
//		}
//		boolean unet = false;
//		for(int i = 1; i < rank.size(); i=i+2){
//			if(Integer.parseInt(rank.get(i)) < Integer.parseInt(skor)){
//				rank.add(i-1, skor);
//				rank.add(i-1, imeTakmicara);
//				unet = true;
//				osveziRangListu(rank);
//				break;
//			}
//		}
//		if(unet==false){
//			rank.addLast(skor);
//			rank.addLast(imeTakmicara);
//			osveziRangListu(rank);
//			return;
//		}
//		osveziRangListu(rank);
//		
	}
	private void osveziRangListu(LinkedList<String> rank) {
		SOUbaciURangListu.osveziRangListu(rank);
//		try {
//			DataOutputStream out = new DataOutputStream
//					(new BufferedOutputStream(new FileOutputStream("fajlovi/zaokruzivanjerang.out")));
//			for (int i = 0; i < rank.size(); i++) {
//				out.writeUTF(rank.get(i));
//			}
//			out.close();
//		} catch (Exception e) {
//			System.out.println("Greska: "+e.getMessage());
//			e.printStackTrace();
//		}

	}
	public LinkedList<String> getPitanja() {
		return pitanja;
	}

	public void setPitanja(LinkedList<String> pitanja) {
		this.pitanja = pitanja;
	}
}
