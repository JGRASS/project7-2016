package kviz.logika;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

	@Test
	public void testUcitajPitanja() {
		LinkedList<String> l = new LinkedList<>();
		LinkedList<String> s = new LinkedList<>();
		LinkedList<String> t = new LinkedList<>();
		
		

		try {
			BufferedReader in = new BufferedReader(new FileReader("fajlovi/dopunska.txt"));
			
			boolean kraj = false;
			
			while(in.readLine().equals("1")){
				l.add(in.readLine());
				l.add(in.readLine());
			}
			do {
				s.add(in.readLine());
				s.add(in.readLine());
			} while (in.readLine().equals("2"));
			while(!kraj){
				t.add(in.readLine());
				t.add(in.readLine());
				if(in.readLine() == null){
					kraj = true;
				}
			}
			in.close();
			logika.ucitajPitanja();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(l, logika.getLaksa());
		assertEquals(s, logika.getSrednja());
		assertEquals(t, logika.getTeza());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetLaksaNull() {
		logika.setLaksa(null);
	}
	
	@Test
	public void testSetLaksaOk() {
		LinkedList<String> l = new LinkedList<>();
		l.add("Proba");
		l.add("Test");
		logika.setLaksa(l);
		assertEquals(logika.getLaksa(), l);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSrednjaNull() {
		logika.setSrednja(null);
	}
	
	@Test
	public void testSetSrednjaOk() {
		LinkedList<String> s = new LinkedList<>();
		s.add("Proba");
		s.add("Test");
		logika.setSrednja(s);
		assertEquals(logika.getSrednja(), s);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetTezaNull() {
		logika.setTeza(null);
	}
	
	@Test
	public void testSetTezaOk() {
		LinkedList<String> t = new LinkedList<>();
		t.add("Proba");
		t.add("Test");
		logika.setTeza(t);
		assertEquals(logika.getTeza(), t);
	}

	@Test
	public void testPitanjeNivo() {
		String[] laksa;
		String[] srednja;
		String[] teza;
		try {
			logika.ucitajPitanja();
		} catch (Exception e) {
			e.printStackTrace();
		}
		LinkedList<String> l = logika.getLaksa();
		LinkedList<String> s = logika.getSrednja();
		LinkedList<String> t = logika.getTeza();
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
