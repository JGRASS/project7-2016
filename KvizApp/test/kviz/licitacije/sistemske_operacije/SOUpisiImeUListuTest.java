package kviz.licitacije.sistemske_operacije;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kviz.logika.LicitacijaLogika;

public class SOUpisiImeUListuTest {

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
	public void testUpisiImeUListu(){
		
		licitacije.upisiImeUListu("Marko", 0, 100);
		licitacije.upisiImeUListu("Nikola", 1, 90);
		
		assertEquals(Integer.parseInt(licitacije.getHighScoreLicitacije().getHighScore().get(0).toString()), 100);
		assertEquals(licitacije.getHighScoreLicitacije().getHighScoreImena().get(0), "Marko");
		assertEquals(Integer.parseInt(licitacije.getHighScoreLicitacije().getHighScore().get(1).toString()), 90);
		assertEquals(licitacije.getHighScoreLicitacije().getHighScoreImena().get(1), "Nikola");
	}

}
