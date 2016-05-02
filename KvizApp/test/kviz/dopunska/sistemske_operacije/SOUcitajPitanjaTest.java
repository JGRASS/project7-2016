package kviz.dopunska.sistemske_operacije;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kviz.logika.DopunskaLogika;

public class SOUcitajPitanjaTest {
	
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
	public void testIzvrsi() {
		
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
		assertEquals(l, logika.getPitanja().getLaksa());
		assertEquals(s, logika.getPitanja().getSrednja());
		assertEquals(t, logika.getPitanja().getTeza());
	}

}
