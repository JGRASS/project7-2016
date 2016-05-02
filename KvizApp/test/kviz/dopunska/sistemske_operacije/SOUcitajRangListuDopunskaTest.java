package kviz.dopunska.sistemske_operacije;

import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import org.junit.Test;

public class SOUcitajRangListuDopunskaTest {

	@Test
	public void testIzvrsi() {
		LinkedList<String> rank = new LinkedList<>();
		LinkedList<String> r = new LinkedList<>();
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader("fajlovi/rang_dopunska.txt"));
			while(in.readLine()!=null){
				rank.add(in.readLine());
				rank.add(in.readLine());
			}
			in.close();
			r = SOUcitajRangListuDopunska.izvrsi();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(r, rank);
	}
}
