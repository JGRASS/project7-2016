package kviz.licitacije.sistemske_operacije;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class SOUcitajFajl {

	private static boolean vecUcitano = false;

	public static void izvrsi(LinkedList<String> prviNivo, LinkedList<String> drugiNivo, LinkedList<String> treciNivo, 
			LinkedList<Integer> highScore, LinkedList<String> highScoreImena) throws Exception {
		if(!(prviNivo.isEmpty()))
			prviNivo.remove();
		if(!(drugiNivo.isEmpty()))
			drugiNivo.remove();
		if(!(treciNivo.isEmpty()))
			treciNivo.remove();
		FileReader f = new FileReader("fajlovi/licitacije.txt");
		BufferedReader in = new BufferedReader(f);

		boolean kraj = false;

		while(in.readLine().equals("1")){
			prviNivo.add(in.readLine());
			prviNivo.add(in.readLine());
		}
		do {
			drugiNivo.add(in.readLine());
			drugiNivo.add(in.readLine());
		} while (in.readLine().equals("2"));
		while(!kraj){
			treciNivo.add(in.readLine());
			treciNivo.add(in.readLine());
			if(in.readLine() == null){
				kraj = true;
			}
		}

		in.close();


		FileReader f1 = new FileReader("highscore/licitacijeHighScore.txt");
		BufferedReader in1 = new BufferedReader(f1);

		int r = 0;
		if(!vecUcitano){
			boolean kraj1 = false;
			while(!kraj1){
				Integer i = Integer.valueOf(in1.readLine());
				highScore.add(i);
				highScoreImena.add(in1.readLine());
				r++;
				if(in1.readLine() == null){
					kraj1 = true;
				}
			}
			vecUcitano = true;
		} else{
			boolean kraj1 = false;
			while(!kraj1){
				Integer i = Integer.valueOf(in1.readLine());
				highScore.set(r, i);
				highScoreImena.set(r, in1.readLine());
				r++;
				if(in1.readLine() == null){
					kraj1 = true;
				}
			}
		}

		in1.close();
	}

	public void  setVecUcitano(boolean vrednost){
		vecUcitano = vrednost;
	}
}
