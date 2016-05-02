package kviz.logika;

import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import kviz.dopunska.PitanjaDopunska;

public class DopunskaLogikaTest {
	
	private DopunskaLogika logika;

	@Before
	public void setUp() throws Exception {
		logika = new DopunskaLogika();
	}

	@After
	public void tearDown() throws Exception {
		logika = null;
	}


	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPitanjaNull() {
		logika.setPitanja(null);
	}
	
	@Test
	public void testSetPitanjaOk() {
		PitanjaDopunska pitanja = new PitanjaDopunska();
		LinkedList<String> l = new LinkedList<>();
		l.add("Proba");
		l.add("Test");
		pitanja.setLaksa(l);
		assertEquals(pitanja.getLaksa(), l);
	}
}
