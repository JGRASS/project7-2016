package kviz.licitacije.sistemske_operacije;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kviz.licitacije.HighScoreLicitacije;
import kviz.licitacije.PitanjaLicitacije;
import kviz.logika.LicitacijaLogika;

public class SOIzaberiPitanjeTest {

	private LicitacijaLogika licitacije;
	private SOUcitajFajl soUcitajFajl;
	
	@Before
	public void setUp() throws Exception {
		licitacije = new LicitacijaLogika();
		soUcitajFajl = new SOUcitajFajl();
		soUcitajFajl.setVecUcitano(false);
	}

	@After
	public void tearDown() throws Exception {
		licitacije = null;
		soUcitajFajl = null;
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
			random = (int )(Math.random() * licitacije.getPitanjaLicitacije().getPrviNivo().size());
			if(random % 2 == 0)
				break;
		}
		if(random < 0 || random > licitacije.getPitanjaLicitacije().getPrviNivo().size())
			fail("Izvecuni broj nije u dozvoljenom rangu");
		String pitanje = licitacije.getPitanjaLicitacije().getPrviNivo().get(0);
		String odgovor = licitacije.getPitanjaLicitacije().getPrviNivo().get(1);
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
			random = (int )(Math.random() * licitacije.getPitanjaLicitacije().getDrugiNivo().size());
			if(random % 2 == 0)
				break;
		}
		if(random < 0 || random > licitacije.getPitanjaLicitacije().getDrugiNivo().size())
			fail("Izvecuni broj nije u dozvoljenom rangu");
		String pitanje = licitacije.getPitanjaLicitacije().getDrugiNivo().get(0);
		String odgovor = licitacije.getPitanjaLicitacije().getDrugiNivo().get(1);
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
			random = (int )(Math.random() * licitacije.getPitanjaLicitacije().getTreciNivo().size());
			if(random % 2 == 0)
				break;
		}
		if(random < 0 || random > licitacije.getPitanjaLicitacije().getTreciNivo().size())
			fail("Izvecuni broj nije u dozvoljenom rangu");
		String pitanje = licitacije.getPitanjaLicitacije().getTreciNivo().get(0);
		String odgovor = licitacije.getPitanjaLicitacije().getTreciNivo().get(1);
		String[] niz = new String[]{pitanje, odgovor};
		
		String[] niz1 = new String[]{"Milan Obrenovic je nasledio kneza Milosa __________ godine ?", "1839"};
		assertArrayEquals(niz, niz1);
	}
}
