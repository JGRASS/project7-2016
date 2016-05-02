package kviz.dopunska.sistemske_operacije;

import java.util.LinkedList;

import kviz.dopunska.PitanjaDopunska;
/**
 * 
 * @author Sava
 *
 */
public class SOPitanjeNivo {
	/**
	 * U zavisnosti od trenutnog skora takmicara, pronalazi i vraca pitanje i odgovor iz odredjene grupe tezine pitanja
	 * @param skor, laksa, srednja i teza pitanja
	 * @return dvoclani niz String-ova - prvi clan je pitanje a drugi odgovor
	 */
	public static String[] izvrsi(int skor, PitanjaDopunska pitanja) {
		LinkedList<String> laksa = pitanja.getLaksa();
		LinkedList<String> srednja = pitanja.getSrednja();
		LinkedList<String> teza = pitanja.getTeza();
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
			pitanja.setLaksa(laksa);
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
				pitanja.setSrednja(srednja);
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
				pitanja.setTeza(teza);
				return new String[]{pitanje, odgovor};
			}
		}
	}
	
}
