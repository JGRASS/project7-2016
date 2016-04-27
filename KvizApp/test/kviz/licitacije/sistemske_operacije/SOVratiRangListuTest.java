package kviz.licitacije.sistemske_operacije;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kviz.logika.LicitacijaLogika;

public class SOVratiRangListuTest {

	private LicitacijaLogika licitacije;
	
	@Before
	public void setUp() throws Exception {
		licitacije = new LicitacijaLogika();
	}

	@After
	public void tearDown() throws Exception {
		licitacije = null;
	}

	@Test
	public void testVratiRangListuString() {
		licitacije.getHighScoreLicitacije().getHighScore().add(100);
		licitacije.getHighScoreLicitacije().getHighScoreImena().add("Marko");
		licitacije.getHighScoreLicitacije().getHighScore().add(90);
		licitacije.getHighScoreLicitacije().getHighScoreImena().add("Nikola");

		String rangLista = licitacije.vratiRangListu();
		String s = "1. Marko  100" + "\n" + "2. Nikola  90" + "\n";
		
		assertEquals(rangLista, s);
	}

}
