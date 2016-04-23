package kviz.logika;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

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
	public LinkedList<String> getPitanja() {
		return pitanja;
	}

	public void setPitanja(LinkedList<String> pitanja) {
		this.pitanja = pitanja;
	}
}
