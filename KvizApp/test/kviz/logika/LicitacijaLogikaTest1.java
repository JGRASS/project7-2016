package kviz.logika;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LicitacijaLogikaTest1 {
	
/*	private LicitacijaLogika licitacije;

	@Before
	public void setUp() throws Exception {
		licitacije = new LicitacijaLogika();
	}

	@After
	public void tearDown() throws Exception {
		licitacije = null;
	}

	@Test(expected = java.lang.Exception.class)
	public void testUcitajFajlException() throws Exception{
			BufferedReader in = new BufferedReader(new FileReader("licitacije.txt"));
	}
	
	@Test
	public void testUcitajFajl() {
		LinkedList<String> prvi = new LinkedList<String>();
		LinkedList<String> drugi = new LinkedList<String>();
		LinkedList<String> treci = new LinkedList<String>();
		LinkedList<Integer> hS = new LinkedList<Integer>();
		LinkedList<String> hSI = new LinkedList<String>();

		try {
			FileReader f = new FileReader("fajlovi/licitacije.txt");

			BufferedReader in = new BufferedReader(f);

			boolean kraj = false;

			while(in.readLine().equals("1")){
				prvi.add(in.readLine());
				prvi.add(in.readLine());
			}
			do {
				drugi.add(in.readLine());
				drugi.add(in.readLine());
			} while (in.readLine().equals("2"));
			while(!kraj){
				treci.add(in.readLine());
				treci.add(in.readLine());
				if(in.readLine() == null){
					kraj = true;
				}
			}
			in.close();
			licitacije.ucitajFajl();
		} catch (Exception e) {
			e.printStackTrace();
		}


		FileReader f1;
		try {
			f1 = new FileReader("highscore/licitacijeHighScore.txt");

			BufferedReader in1 = new BufferedReader(f1);

			boolean kraj1 = false;
			while(!kraj1){
				Integer i = Integer.valueOf(in1.readLine());
				hS.add(i);
				hSI.add(in1.readLine());
				if(in1.readLine() == null){
					kraj1 = true;
				}
			}
			in1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(prvi, licitacije.getPrviNivo());
		assertEquals(drugi, licitacije.getDrugiNivo());
		assertEquals(treci, licitacije.getTreciNivo());
		assertEquals(hS, licitacije.getHighScore());
		assertEquals(hSI, licitacije.getHighScoreImena());
	}

	@Test
	public void testSetPrviNivo(){
		LinkedList<String> prvi = new LinkedList<String>();
		prvi.add("Pitanje 1");
		prvi.add("Pitanje 2");
		licitacije.setPrviNivo(prvi);
		
		assertEquals(prvi, licitacije.getPrviNivo());
	}
	
	@Test
	public void testSetDrugiNivo(){
		LinkedList<String> drugi = new LinkedList<String>();
		drugi.add("Pitanje 3");
		drugi.add("Pitanje 4");
		licitacije.setDrugiNivo(drugi);
		
		assertEquals(drugi, licitacije.getDrugiNivo());
	}
	
	@Test
	public void testSetTreciNivo(){
		LinkedList<String> treci = new LinkedList<String>();
		treci.add("Pitanje 5");
		treci.add("Pitanje 6");
		licitacije.setTreciNivo(treci);
		
		assertEquals(treci, licitacije.getTreciNivo());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPrviNivoNull(){
		licitacije.setPrviNivo(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetDrugiNivoNull(){
		licitacije.setDrugiNivo(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetTreciNivoNull(){
		licitacije.setTreciNivo(null);
	}
	
	@Test
	public void testIzaberiPitanjaOd10Do14(){
		try {
			licitacije.ucitajFajl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int random;
		while(true){
			random = (int )(Math.random() * licitacije.getPrviNivo().size());
			if(random % 2 == 0)
				break;
		}
		if(random < 0 || random > licitacije.getPrviNivo().size())
			throw new RuntimeException("Izvecuni broj nije u dozvoljenom rangu");
		String pitanje = licitacije.getPrviNivo().get(0);
		String odgovor = licitacije.getPrviNivo().get(1);
		licitacije.getPrviNivo().remove(random);
		licitacije.getPrviNivo().remove(random);
		String[] niz = new String[]{pitanje, odgovor};
		
		String[] niz1 = new String[]{"Prvi srpski ustanak je podignut __________ godine ?", "1804"};
		assertArrayEquals(niz, niz1);
	}
	
	@Test
	public void testIzaberiPitanjaOd5Do9(){
		try {
			licitacije.ucitajFajl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int random;
		while(true){
			random = (int )(Math.random() * licitacije.getDrugiNivo().size());
			if(random % 2 == 0)
				break;
		}
		if(random < 0 || random > licitacije.getDrugiNivo().size())
			throw new RuntimeException("Izvecuni broj nije u dozvoljenom rangu");
		String pitanje = licitacije.getDrugiNivo().get(0);
		String odgovor = licitacije.getDrugiNivo().get(1);
		licitacije.getDrugiNivo().remove(random);
		licitacije.getDrugiNivo().remove(random);
		String[] niz = new String[]{pitanje, odgovor};
		
		String[] niz1 = new String[]{"Kolubarska bitka se odigrala __________ godine ?", "1914"};
		assertArrayEquals(niz, niz1);
	}
	
	@Test
	public void testIzaberiPitanjaOd1Do4(){
		try {
			licitacije.ucitajFajl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int random;
		while(true){
			random = (int )(Math.random() * licitacije.getTreciNivo().size());
			if(random % 2 == 0)
				break;
		}
		if(random < 0 || random > licitacije.getTreciNivo().size())
			throw new RuntimeException("Izvecuni broj nije u dozvoljenom rangu");
		String pitanje = licitacije.getTreciNivo().get(0);
		String odgovor = licitacije.getTreciNivo().get(1);
		licitacije.getTreciNivo().remove(random);
		licitacije.getTreciNivo().remove(random);
		String[] niz = new String[]{pitanje, odgovor};
		
		String[] niz1 = new String[]{"Milan Obrenovic je nasledio kneza Milosa __________ godine ?", "1839"};
		assertArrayEquals(niz, niz1);
	}
	
	@Test
	public void testProveriUpisNaRangListuNaPrvoMesto(){
		try {
			licitacije.ucitajFajl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Integer poeni = licitacije.getHighScore().get(0) + 100;
		int vrednost = licitacije.proveriIUpisiNaRangListu(poeni);
		
		assertEquals(vrednost, 0);
	}
	
	@Test
	public void testProveriUpisNaRangListu(){
		try {
			licitacije.ucitajFajl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Integer razlika = licitacije.getHighScore().get(3) - licitacije.getHighScore().get(4);
		Integer poeni = licitacije.getHighScore().get(4) + 1;
		int vrednost = licitacije.proveriIUpisiNaRangListu(poeni);
		
		assertEquals(vrednost, 4);
	}
	
	@Test
	public void testProveriUpisNaRangListuBezUpisa(){
		try {
			licitacije.ucitajFajl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Integer poeni = licitacije.getHighScore().get(licitacije.getHighScore().size() - 1) - 100;
		int vrednost = licitacije.proveriIUpisiNaRangListu(poeni);
		
		assertEquals(vrednost, -1);
	} */
}
