package kviz.licitacije.sistemske_operacije;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kviz.logika.LicitacijaLogika;

public class SOProveriUpisNaListuTest {

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
	public void testProveriUpisNaRangListuNaPrvoMesto(){
		try {
			licitacije.ucitajFajl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Integer poeni = licitacije.getHighScoreLicitacije().getHighScore().get(0) + 100;
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
		Integer razlika = licitacije.getHighScoreLicitacije().getHighScore().get(3) - licitacije.getHighScoreLicitacije().getHighScore().get(4);
		Integer poeni = licitacije.getHighScoreLicitacije().getHighScore().get(4) + 1;
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
		Integer poeni = licitacije.getHighScoreLicitacije().getHighScore().get(licitacije.getHighScoreLicitacije().getHighScore().size() - 1) - 100;
		int vrednost = licitacije.proveriIUpisiNaRangListu(poeni);

		assertEquals(vrednost, -1);
	} 

}
