package kviz.licitacije.sistemske_operacije;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.LinkedList;

/**
 * 
 * @author Marko
 *
 */
public class SOUcitajFajl {

	private static boolean vecUcitano = false;

	public void  setVecUcitano(boolean vrednost){
		vecUcitano = vrednost;
	}
	
	/**
	 * Metoda ucitava pitanja sa odgovorima iz txt fajla.
	 * @param prviNivo lista pitanja za prvi nivo
	 * @param drugiNivo lista pitanja za drugi nivo
	 * @param treciNivo lista pitanja za treci nivo
	 * @throws Exception
	 */
	public static void ucitajTxtFajl(LinkedList<String> prviNivo, LinkedList<String> drugiNivo, 
			LinkedList<String> treciNivo ) throws Exception{
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
	}

	/**
	 * Metoda deserijalizuje poene koji ce biti prikazani u rang listi.
	 * @param highScore lista u koju ce biti upisani poeni
	 * @throws Exception
	 */
	public static void deserijalizujRangListuPoena(LinkedList<Integer> highScore) throws Exception{

		ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("highscore/highScorePoeni.out")));

		highScore.clear();

		try{
			while(true){
				highScore.addAll( (Collection<? extends Integer>) in.readObject());
			}
		}catch(EOFException e){}

		in.close();

	}
	
	/**
	 *  Metoda deserijalizuje imena koji ce biti prikazani u rang listi.
	 * @param highScoreImena lista u koju ce biti upisana imena
	 * @throws Exception
	 */
	public static void deserijalizujRangListuImena(LinkedList<String> highScoreImena) throws Exception{

		ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("highscore/highScoreImena.out")));

		highScoreImena.clear();

		try{
			while(true){
				highScoreImena.addAll((Collection<? extends String>) in.readObject());
			}
		}catch(EOFException e){}

		in.close();

	}
}
