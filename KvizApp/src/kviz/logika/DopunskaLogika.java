package kviz.logika;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.swing.JOptionPane;
/**
 * Klasa koja upravlja logikom kviza na dopunu
 * @author Sava
 *
 */
public class DopunskaLogika {
	/**
	 * Lista laksih pitanja
	 */
	private LinkedList<String> laksa;
	/**
	 * Lista pitanja srednje tezina
	 */
	private LinkedList<String> srednja;
	/**
	 * Lista teskih pitanja
	 */
	private LinkedList<String> teza;
	/**
	 * Konstruktor Dopunske logike koji inicijalizuje liste
	 * <ul> 
 	 * 		<li>laksih</li>
 	 * 		<li>srednjih</li>
 	 * 		<li>tezih</li>
 	 * </ul>
 	 * pitanja
	 */
	public DopunskaLogika(){
		laksa = new LinkedList<String>();
		srednja = new LinkedList<String>();
		teza = new LinkedList<String>();
	}
	/**
	 * Ucitava sva pitanja iz tekstualne datoteke i
	 * puni liste u zavisnosti od tezine pitanja
	 * @throws Exception ako ne postoji fajl sa pitanjima
	 */
	public void ucitajPitanja() throws Exception{
		
		BufferedReader in = new BufferedReader(new FileReader("fajlovi/dopunska.txt"));
		
		boolean kraj = false;

		while(in.readLine().equals("1")){
			laksa.add(in.readLine());
			laksa.add(in.readLine());
		}
		do {
			srednja.add(in.readLine());
			srednja.add(in.readLine());
		} while (in.readLine().equals("2"));
		while(!kraj){
			teza.add(in.readLine());
			teza.add(in.readLine());
			if(in.readLine() == null){
				kraj = true;
			}
		}
		
		in.close();
	}
	/**
	 * Vraca listu laksih pitanja
	 * @return listu laksih pitanja
	 */
	public LinkedList<String> getLaksa() {
		return laksa;
	}

	public void setLaksa(LinkedList<String> laksa) {
		if(laksa == null){
			throw new RuntimeException("Greska! Lista nije dobro prosledjena");
		}
		this.laksa = laksa;
	}
	/**
	 * Vraca listu srednjih pitanja
	 * @return listu srednjih pitanja
	 */
	public LinkedList<String> getSrednja() {
		return srednja;
	}

	public void setSrednja(LinkedList<String> srednja) {
		if(srednja == null){
			throw new RuntimeException("Greska! Lista nije dobro prosledjena");
		}
		this.srednja = srednja;
	}
	/**
	 * Vraca listu tezih pitanja
	 * @return listu tezih pitanja
	 */
	public LinkedList<String> getTeza() {
		return teza;
	}

	public void setTeza(LinkedList<String> teza) {
		if(teza == null){
			throw new RuntimeException("Greska! Lista nije dobro prosledjena");
		}
		this.teza = teza;
	}
	/**
	 * U zavisnosti od trenutnog skora takmicara, pronalazi i vraca pitanje i odgovor iz odredjene grupe tezine pitanja
	 * @param skor - trenutni skor koji je takmicar ostvario
	 * @return dvoclani niz String-ova - prvi clan je pitanje a drugi odgovor
	 */
	public String[] pitanjeNivo(int skor) {
		if(skor<5){
			int a;
			while(true){
				a = (int)(Math.random() * laksa.size());
				if(a % 2 == 0)
					break;
			}
			String pitanje = laksa.get(a);
			String odgovor = laksa.get(a+1);
			laksa.remove(a);
			laksa.remove(a);
			return new String[]{pitanje, odgovor};
		}else{
			if(skor<10){
				int a;
				while(true){
					a = (int)(Math.random() * srednja.size());
					if(a % 2 == 0)
						break;
				}
				String pitanje = srednja.get(a);
				String odgovor = srednja.get(a+1);
				srednja.remove(a);
				srednja.remove(a);
				return new String[]{pitanje, odgovor};
			}else{
				int a;
				while(true){
					a = (int)(Math.random() * teza.size());
					if(a % 2 == 0)
						break;
				}
				String pitanje = teza.get(a);
				String odgovor = teza.get(a+1);
				teza.remove(a);
				teza.remove(a);
				return new String[]{pitanje, odgovor};
			}
		}
	}
	/**
	 * Ucitava rang listu iz tekstualne datoteke i vraca je
	 * @return listu rangiranja
	 * @throws Exception
	 */
	public LinkedList<String> ucitajRangListu() throws Exception{
		LinkedList<String> rank = new LinkedList<>();
		BufferedReader in = new BufferedReader(new FileReader("fajlovi/rang_dopunska.txt"));
		while(in.readLine()!=null){
			rank.add(in.readLine());
			rank.add(in.readLine());
		}
		in.close();
		return rank;
	}
	/**
	 * U zavisnosti od ostvarenog skora upisuje takmicara u rang listu
	 * @param imeTakmicara
	 * @param skor
	 */
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
				JOptionPane.showMessageDialog(null, "Upisani ste u rang listu!", "Cestitamo", JOptionPane.INFORMATION_MESSAGE);
				unet = true;
				break;
			}
		}
		while(rank.size()>30){
			rank.removeLast();
		}
		if(unet == false && rank.size() < 30){
			rank.addLast(imeTakmicara);
			rank.addLast(skor);
			JOptionPane.showMessageDialog(null, "Upisani ste u rang listu!", "Cestitamo", JOptionPane.INFORMATION_MESSAGE);
			osveziRangListu(rank);
		}
		osveziRangListu(rank);
	}
	/**
	 * Upisuje prosledjenu rang listu u tekstualnu datoteku
	 * @param rang lista
	 */
	private void osveziRangListu(LinkedList<String> rank) {
		PrintWriter in;
		try {
			in = new PrintWriter(new BufferedWriter(new FileWriter("fajlovi/rang_dopunska.txt")));
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
	

}
