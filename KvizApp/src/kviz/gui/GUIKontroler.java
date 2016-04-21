package kviz.gui;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import kviz.logika.LicitacijaLogika;

public class GUIKontroler {

	private static LicitacijeProzor licitacijeProzor;
	private static GlavniProzor glavniProzor;
	private static LicitacijaLogika licitacijeLogika;
	private static String[] nizSaOdgovorom;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					glavniProzor = new GlavniProzor();
					glavniProzor.setVisible(true);
					licitacijeLogika = new LicitacijaLogika();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void pokreniProzorLicitacije() {
		licitacijeProzor = new LicitacijeProzor();
		licitacijeProzor.setVisible(true);
		licitacijeProzor.setLocationRelativeTo(null);
		try {
			licitacijeLogika.ucitajFajl();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Greska prilikom ucitavanja fajla licitacije.txt", "Greska", 
											JOptionPane.ERROR_MESSAGE);	
			licitacijeProzor.dispose();
		}
		pronadjiOdgovorLicitacije();
	}
	
	public static void pronadjiOdgovorLicitacije(){
		nizSaOdgovorom = licitacijeLogika.izaberiPitanje(licitacijeProzor.vratiSelektovaniIndeks());
		licitacijeProzor.getLblPitanje().setText(nizSaOdgovorom[0]);
	}
	
	public static int proveraOdgovora(int odgovor){
		int odg = Integer.parseInt(nizSaOdgovorom[1]);
		if(odg <= 21){
			if(odg == odgovor)
				return 10;
			else if(odg - odgovor >= - 2 && odg - odgovor <= 2)
				return 5;
			else if(odg - odgovor >= - 4 && odg - odgovor <= 4)
				return 3;
			else 
				return 0;
		}else{
			if(odg == odgovor) 
				return 10;
			else if(odg - odgovor >= - 200 && odg - odgovor <= 200)
				return 5;
			else if(odg - odgovor >= - 400 && odg - odgovor <= 400)
				return 3;
			else 
				return 0;
		}
	}
	public static void zatvoriProzor() {
		licitacijeProzor.dispose();
	}

}
