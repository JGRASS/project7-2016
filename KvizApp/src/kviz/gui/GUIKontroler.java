package kviz.gui;

import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import kviz.logika.DopunskaLogika;
import kviz.logika.LicitacijaLogika;
import kviz.logika.ZaokruzivanjeLogika;
/**
 * Klasa koja predstavlja vezu izmedju logike i izgleda aplikacije
 * @author Marko, Sava, Andrija
 * @version 1.0
 */
public class GUIKontroler {
	/**
	 * Glavni prozor prikazan na pocetku igre
	 */
	private static GlavniProzor glavniProzor;
	
	/**
	 * Prozor kviza pitalice na zaokruzivanje
	 */
	private static PitanjaNaZaokruzivanje zaokruzivanjeProzor;
	/**
	 * Logika kviza pitalice na zaokruzivanje
	 */
	private static ZaokruzivanjeLogika zaokruzivanjeLogika;
	/**
	 * Redni broj postavljenog pitanja
	 */
	private static int redniBrPitanja = 0;
	/**
	 * Niz stringova postavljenog pitanja i ponudjenih odgovora
	 */
	private static String[] pitanjaIOdg;

	
	private static LicitacijeProzor licitacijeProzor;
	private static LicitacijaLogika licitacijeLogika;
	private static String[] nizSaOdgovorom;
	
	/**
	 * Prozor kviza pitalice na dopunu
	 */
	private static DopunskaProzor dopunskaProzor;
	/**
	 * Logika kviza pitalice na dopunu
	 */
	private static DopunskaLogika dopunskaLogika;
	private static DopunskaHighscore dopunskaProzorRang;
	/**
	 * Niz stringova u koji ce se upisivati trenutno pitanje i odgovor
	 */
	private static String[] pitanjeOdgovor;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					glavniProzor = new GlavniProzor();
					glavniProzor.setVisible(true);
					licitacijeLogika = new LicitacijaLogika();
					dopunskaLogika = new DopunskaLogika();
					dopunskaProzor = new DopunskaProzor();
					dopunskaProzorRang = new DopunskaHighscore();
					zaokruzivanjeLogika = new ZaokruzivanjeLogika();
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
	public static void pokreniProzorZaokruzivanje(){
		zaokruzivanjeProzor = new PitanjaNaZaokruzivanje();
		zaokruzivanjeProzor.setVisible(true);
		zaokruzivanjeProzor.setLocationRelativeTo(null);
		
		try{
			zaokruzivanjeLogika.ucitajZaokruzivanjeFajl();
		}catch(Exception e){
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Greska prilikom ucitavanja fajla pitalice.txt", "Greska", JOptionPane.WARNING_MESSAGE);
		}
		redniBrPitanja = 0;
//		resetujPitanja();
		
	}
	public static void resetujPitanja(){

		pitanjaIOdg = zaokruzivanjeLogika.vratiPitanjaIOdgovore(redniBrPitanja);
		String[] odgovori = pitanjaIOdg[1].split("&");
		zaokruzivanjeProzor.getJtaPitanje().setText(pitanjaIOdg[0]);
		zaokruzivanjeProzor.getJtaA().setText(odgovori[0]);
		zaokruzivanjeProzor.getJtaB().setText(odgovori[1]);
		zaokruzivanjeProzor.getJtaC().setText(odgovori[2]);
		zaokruzivanjeProzor.getJtaD().setText(odgovori[3]);
		
		zaokruzivanjeProzor.getBtnA().setVisible(true);
		zaokruzivanjeProzor.getBtnB().setVisible(true);
		zaokruzivanjeProzor.getBtnC().setVisible(true);
		zaokruzivanjeProzor.getBtnD().setVisible(true);
//		zaokruzivanjeProzor.getBtnZamena().setVisible(true);
		
		zaokruzivanjeProzor.getJtaPitanje().setVisible(true);
		zaokruzivanjeProzor.getJtaA().setVisible(true);
		zaokruzivanjeProzor.getJtaB().setVisible(true);
		zaokruzivanjeProzor.getJtaC().setVisible(true);
		zaokruzivanjeProzor.getJtaD().setVisible(true);
		
		zaokruzivanjeProzor.getLblBrPitanja().setVisible(true);
		zaokruzivanjeProzor.getLblBrPoena().setVisible(true);
		
		zaokruzivanjeProzor.getLblBrPitanja().setText("Pitanje broj:" +(redniBrPitanja+1));
		redniBrPitanja++;
		
	}
	public static void refreshPoslePotvrde(){
		resetujPitanja();
		zaokruzivanjeProzor.getLblUnesiteIme().setVisible(false);
		zaokruzivanjeProzor.getJtfUnesiteIme().setVisible(false);
		zaokruzivanjeProzor.getBtnPotvrdiUnos().setVisible(false);
		zaokruzivanjeProzor.getBtnZamena().setVisible(true);
		zaokruzivanjeProzor.getBtn5050().setVisible(true);
	}
	public static void izbaciPitanja(){
		int brojPromenjenih = 0;
		if(!zaokruzivanjeProzor.getJtaA().getText().equals(vratiTacan())){
			zaokruzivanjeProzor.getJtaA().setVisible(false);
			zaokruzivanjeProzor.getBtnA().setVisible(false);
			brojPromenjenih++;
		}
		if(!zaokruzivanjeProzor.getJtaB().getText().equals(vratiTacan())){
			zaokruzivanjeProzor.getJtaB().setVisible(false);
			zaokruzivanjeProzor.getBtnB().setVisible(false);
			brojPromenjenih++;
		}
		if(!zaokruzivanjeProzor.getJtaC().getText().equals(vratiTacan()) && brojPromenjenih!=2){
			zaokruzivanjeProzor.getJtaC().setVisible(false);
			zaokruzivanjeProzor.getBtnC().setVisible(false);
			brojPromenjenih++;
		}
		zaokruzivanjeProzor.getBtn5050().setVisible(false);
	}
	public static void zameniPitanje(){
		pitanjaIOdg = zaokruzivanjeLogika.vratiPitanjaIOdgovore(15);
		String[] odgovori = pitanjaIOdg[1].split("&");
		zaokruzivanjeProzor.getJtaPitanje().setText(pitanjaIOdg[0]);
		zaokruzivanjeProzor.getJtaA().setText(odgovori[0]);
		zaokruzivanjeProzor.getJtaA().setVisible(true);
		zaokruzivanjeProzor.getBtnA().setVisible(true);
		zaokruzivanjeProzor.getJtaB().setText(odgovori[1]);
		zaokruzivanjeProzor.getJtaB().setVisible(true);
		zaokruzivanjeProzor.getBtnB().setVisible(true);
		zaokruzivanjeProzor.getJtaC().setText(odgovori[2]);
		zaokruzivanjeProzor.getJtaC().setVisible(true);
		zaokruzivanjeProzor.getBtnC().setVisible(true);
		zaokruzivanjeProzor.getJtaD().setText(odgovori[3]);
	
	}
	public static String vratiTacan(){
		return pitanjaIOdg[2];
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
	/**
	 * Otvara prozor za kviz sa dopunskim pitalicama i zapocinje igru postavljanjem prvog pitanja
	 */
	public static void pokreniProzorDopunska() {
		
		dopunskaProzor = new DopunskaProzor();
		dopunskaProzor.setVisible(true);
		dopunskaProzor.setLocationRelativeTo(null);
		
		try {
			dopunskaLogika.ucitajPitanja();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Greska prilikom ucitavanja pitanja", "Greska", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			dopunskaProzor.dispose();
		}
		postaviPitanje(Integer.parseInt(dopunskaProzor.getTxtSkor().getText()));
		
	}
	/**
	 * Postavlja pitanje u zavisnosti od trenutnog skora takmicara
	 * @param skor - Trenutni skor takmicara
	 */
	public static void postaviPitanje(int skor) {
		if(skor>=15){
			JOptionPane.showMessageDialog(null, "Pobedili ste!", "Cestitamo!", JOptionPane.YES_NO_OPTION);
			rangLista();
			dopunskaProzor.dispose();
		}
		pitanjeOdgovor = dopunskaLogika.pitanjeNivo(skor);
		dopunskaProzor.getLblPitanje().setText(pitanjeOdgovor[0]);
		
	}
	/**
	 * Proverava dat odgovor takmicara
	 * @param odgovor
	 * @return true - ako je dat odgovor tacan, false - ako je dat odgovor pogresan
	 */
	public static boolean proveriOdgovor(String odgovor) {
		if(odgovor.equals(pitanjeOdgovor[1])){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * Zatvara ceo prozor kviza pitalice na dopunu
	 */
	public static void zatvoriProzorDopunska() {
		dopunskaProzor.dispose();
	}
	public static void zatvoriZaokruzivanjeProzor(){
		zaokruzivanjeProzor.dispose(); 
		
	}
	public static void rangLista() {
		dopunskaLogika.ubaciURangListu(dopunskaProzor.getTxtImeTakmicara().getText(),dopunskaProzor.getTxtSkor().getText());
	}
	public static void zaokruzivanjeRangLista(){
		zaokruzivanjeLogika.ubaciURangListu(zaokruzivanjeProzor.getJtfUnesiteIme().getText(),
				zaokruzivanjeProzor.getBrTacnih());
	}
	public static void pokreniProzorDopunskaHighscore() {
		dopunskaProzorRang = new DopunskaHighscore();
		dopunskaProzorRang.setVisible(true);
		dopunskaProzorRang.enable();
		dopunskaProzorRang.setLocationRelativeTo(null);
	}
	public static LinkedList<String> vratiRangListu(){
		try {
			return dopunskaLogika.ucitajRangListu();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
