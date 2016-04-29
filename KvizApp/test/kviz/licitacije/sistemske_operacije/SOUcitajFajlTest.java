package kviz.licitacije.sistemske_operacije;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kviz.logika.LicitacijaLogika;

public class SOUcitajFajlTest {

	private LicitacijaLogika licitacije;
	
	@Before
	public void setUp() throws Exception {
		licitacije = new LicitacijaLogika();
	}

	@After
	public void tearDown() throws Exception {
		licitacije = null;
	}

	@Test(expected = java.lang.Exception.class)
	public void testUcitajTxtFajlNaziv() throws Exception {
		BufferedReader bf = new BufferedReader(new FileReader(""));
	}
	
	@Test
	public void testUcitajTxtFajl(){
		try {
			licitacije.ucitajFajl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(licitacije.getPitanjaLicitacije().getPrviNivo() == null ||
				licitacije.getPitanjaLicitacije().getDrugiNivo() == null ||
				licitacije.getPitanjaLicitacije().getTreciNivo() == null)
			fail("Greska pri ucitavanju pitanja");
	}
	
	@Test
	public void testDeserijalizujListuRangPoenaiImena(){
		try {
			licitacije.ucitajFajl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(licitacije.getHighScoreLicitacije().getHighScore() == null ||
				licitacije.getHighScoreLicitacije().getHighScoreImena() == null)
			fail("Greska pri ucitavanju rang liste");
	}
	
	@Test(expected = java.lang.Exception.class)
	public void testDeserijalizujNaziv() throws Exception{
		ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("")));
	}

}
