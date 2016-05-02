package kviz.dopunska.sistemske_operacije;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kviz.logika.DopunskaLogika;

public class SOPitanjeNivoTest {
	
	private static DopunskaLogika logika;
	
	@Before
	public void setUp() throws Exception {
		logika = new DopunskaLogika();
	}

	@After
	public void tearDown() throws Exception {
		logika = null;
	}

	@Test
	public void testIzvrsi() {
		String[] laksa;
		String[] srednja;
		String[] teza;
		try {
			logika.ucitajPitanja();
		} catch (Exception e) {
			e.printStackTrace();
		}
		LinkedList<String> l = logika.getPitanja().getLaksa();
		LinkedList<String> s = logika.getPitanja().getSrednja();
		LinkedList<String> t = logika.getPitanja().getTeza();
		laksa = logika.pitanjeNivo(3);
		srednja = logika.pitanjeNivo(7);
		teza = logika.pitanjeNivo(12);
		assertEquals(false, l.contains(laksa[0]));
		assertEquals(false, l.contains(laksa[1]));
		assertEquals(false, s.contains(srednja[0]));
		assertEquals(false, s.contains(srednja[1]));
		assertEquals(false, t.contains(teza[0]));
		assertEquals(false, t.contains(teza[1]));
		try {
			logika.ucitajPitanja();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(true, l.contains(laksa[0]));
		assertEquals(true, l.contains(laksa[1]));
		assertEquals(true, s.contains(srednja[0]));
		assertEquals(true, s.contains(srednja[1]));
		assertEquals(true, t.contains(teza[0]));
		assertEquals(true, t.contains(teza[1]));
	}

}
