package kviz.licitacije.sistemske_operacije;

import java.util.LinkedList;

public class SOProveriUpisNaRangListu {
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
