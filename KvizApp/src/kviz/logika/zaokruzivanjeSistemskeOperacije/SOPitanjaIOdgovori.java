package kviz.logika.zaokruzivanjeSistemskeOperacije;
import java.util.LinkedList;

public class SOPitanjaIOdgovori {
	
	public static String[] izvrsi(LinkedList<String> pitanja, int brPitanja){
		int brojac=brPitanja*3;
		String pitanje = pitanja.get(brojac);
		String odgovori = pitanja.get(brojac+1);
		String tacanOdgovor = pitanja.get(brojac+2);
		
		return new String[]{pitanje,odgovori,tacanOdgovor};
	}
}
