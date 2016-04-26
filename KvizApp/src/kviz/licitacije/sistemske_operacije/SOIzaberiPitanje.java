package kviz.licitacije.sistemske_operacije;

import java.util.LinkedList;

public class SOIzaberiPitanje {
	
	/**
	 * Metoda u zavisnosti od broja pitanja(koje je trenutno u kvizu) bira pitanje iz odgovarajuce liste.
	 * @param brPitanja
	 * @param prviNivo lista pitanja prvog nivoa
	 * @param drugiNivo lista pitanja drugog nivoa
	 * @param treciNivo lista pitanja treceg nivoa
	 * @return niz sa pitanjem i odgovorom
	 */
	public static String[] izvrsi(int brPitanja, LinkedList<String> prviNivo, LinkedList<String> drugiNivo,
								LinkedList<String> treciNivo) {

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
}
