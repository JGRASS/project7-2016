package kviz.licitacije.sistemske_operacije;

import java.util.LinkedList;

/**
 * 
 * @author Marko
 *
 */
public class SOProveriUpisNaRangListu {
	
	/**
	 * Metoda provera da li treba izvrsiti upis na rang listu.
	 * @param poeni broj takmicarevih osvojenih poena
	 * @param highScore lista sa poenima na trenutnoj rang listi
	 * @return -1 u slucaju da ne treba izvrsiti upis, u suprotnom poziciju upisa
	 */
	public static int izvrsi(int poeni, LinkedList<Integer> highScore) {
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
}
