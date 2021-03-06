package kviz.logika.zaokruzivanjeSistemskeOperacije;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;
/**
 * 
 * @author Andrija
 *
 */
public class SOUbaciURangListu {
	/**
	 * Metoda koja ubacuje takmicara i njegov ostvareni skor u sortiranu listu i nakon toga
	 * refreshuje data fajl sa rang listom
	 * @param imeTakmicara
	 * @param skor
	 */
	public static void izvrsi(String imeTakmicara, String skor) {
		LinkedList<String> rank = new LinkedList<>();
		try {
			rank = SOUcitajRangListu.izvrsi();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(rank.isEmpty()){
			rank.add(imeTakmicara);
			rank.add(skor);
			osveziRangListu(rank);
			return;
		}
		boolean unet = false;
		for(int i = 1; i < rank.size(); i=i+2){
			if(Integer.parseInt(rank.get(i)) < Integer.parseInt(skor)){
				rank.add(i-1, skor);
				rank.add(i-1, imeTakmicara);
				unet = true;
				osveziRangListu(rank);
				break;
			}
		}
		if(unet==false){
			rank.addLast(imeTakmicara);
			rank.addLast(skor);
			osveziRangListu(rank);
			return;
		}
		osveziRangListu(rank);
		
	}
	/**
	 * Metoda koja refreshuje data fajl koji sadrzi rang listu
	 * @param rang lista
	 */
	public static void osveziRangListu(LinkedList<String> rank) {
		try {
			DataOutputStream out = new DataOutputStream
					(new BufferedOutputStream(new FileOutputStream("fajlovi/zaokruzivanjerang.out")));
			for (int i = 0; i < rank.size(); i++) {
				out.writeUTF(rank.get(i));
			}
			out.close();
		} catch (Exception e) {
			System.out.println("Greska: "+e.getMessage());
			e.printStackTrace();
		}

	}
}
