package kviz.gui;

import java.awt.EventQueue;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import kviz.gui.dijalog.LicitacijeScoreDijalog;
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

	/**
	 * Prozor kviza licitacije 
	 */
	private static LicitacijeProzor licitacijeProzor;
	/**
	 * Logika kviza licitacije
	 */
	private static LicitacijaLogika licitacijeLogika;
	/**
	 * Niz koji sadrzi pitanje i tacan odgovor kviza licitacije
	 */
	private static String[] nizSaOdgovorom;
	/**
	 * Dijalog koji prodstavlja rang listu kviza licitacije
	 */
	private static LicitacijeScoreDijalog licitacijeScoreDijalog;
	/**
	 * Pozicija na koju treba dodati igraca u rang listu
	 */
	private static int pozicija;
	
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
	/**
	 * Metoda za pokretanje prozora kviza licitacije i ucitavanje pitanja i rang liste.
	 */
	public static void pokreniProzorLicitacije() {
		licitacijeProzor = new LicitacijeProzor();
		licitacijeProzor.setVisible(true);
		licitacijeProzor.setLocationRelativeTo(null);
		try {
			licitacijeLogika.ucitajFajl();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Greska prilikom ucitavanja fajla", "Greska", 
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
		zaokruzivanjeProzor.getBtnA().setText(odgovori[0]);
		zaokruzivanjeProzor.getBtnB().setText(odgovori[1]);
		zaokruzivanjeProzor.getBtnC().setText(odgovori[2]);
		zaokruzivanjeProzor.getBtnD().setText(odgovori[3]);
		
		zaokruzivanjeProzor.getBtnA().setVisible(true);
		zaokruzivanjeProzor.getBtnB().setVisible(true);
		zaokruzivanjeProzor.getBtnC().setVisible(true);
		zaokruzivanjeProzor.getBtnD().setVisible(true);
//		zaokruzivanjeProzor.getBtnZamena().setVisible(true);
		
		zaokruzivanjeProzor.getJtaPitanje().setVisible(true);
		zaokruzivanjeProzor.getBtnA().setVisible(true);
		zaokruzivanjeProzor.getBtnB().setVisible(true);
		zaokruzivanjeProzor.getBtnC().setVisible(true);
		zaokruzivanjeProzor.getBtnD().setVisible(true);
		
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
		if(!zaokruzivanjeProzor.getBtnA().getText().equals(vratiTacan())){
			zaokruzivanjeProzor.getBtnA().setVisible(false);
			brojPromenjenih++;
		}
		if(!zaokruzivanjeProzor.getBtnB().getText().equals(vratiTacan())){
			zaokruzivanjeProzor.getBtnB().setVisible(false);
			brojPromenjenih++;
		}
		if(!zaokruzivanjeProzor.getBtnC().getText().equals(vratiTacan()) && brojPromenjenih!=2){
			zaokruzivanjeProzor.getBtnC().setVisible(false);
			brojPromenjenih++;
		}
		zaokruzivanjeProzor.getBtn5050().setVisible(false);
	}
	public static void zameniPitanje(){
		pitanjaIOdg = zaokruzivanjeLogika.vratiPitanjaIOdgovore(15);
		String[] odgovori = pitanjaIOdg[1].split("&");
		zaokruzivanjeProzor.getJtaPitanje().setText(pitanjaIOdg[0]);
		zaokruzivanjeProzor.getBtnA().setText(odgovori[0]);
		zaokruzivanjeProzor.getBtnA().setVisible(true);
		zaokruzivanjeProzor.getBtnB().setText(odgovori[1]);
		zaokruzivanjeProzor.getBtnB().setVisible(true);
		zaokruzivanjeProzor.getBtnC().setText(odgovori[2]);
		zaokruzivanjeProzor.getBtnC().setVisible(true);
		zaokruzivanjeProzor.getBtnD().setVisible(true);
		zaokruzivanjeProzor.getBtnD().setText(odgovori[3]);
	
	}
	public static String vratiTacan(){
		return pitanjaIOdg[2];
	}
	/**
	 * Metoda koja pronalazi pitanje i postavlja ga u prozoru kviza licitacije.
	 */
	public static void pronadjiOdgovorLicitacije(){
		nizSaOdgovorom = licitacijeLogika.izaberiPitanje(licitacijeProzor.vratiSelektovaniIndeks());
		licitacijeProzor.getLblPitanje().setText(nizSaOdgovorom[0]);
	}
	/**
	 * Meotda koja vraca broj osvojenih poena na osnovu odgovora(kviza licitacije) koji je prosledjen.
	 * @param odgovor koji je korisnik uneo
	 * @return broj osvojenih poena
	 */
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
			else if(odg - odgovor >= - 50 && odg - odgovor <= 50)
				return 5;
			else if(odg - odgovor >= - 200 && odg - odgovor <= 200)
				return 3;
			else 
				return 0;
		}
	}
	
	/**
	 * Metoda vraca tacan odgovor trenutnog pitanje kviza licitacije
	 * @return odgovor koji ce biti vracen
	 */
	public static int vratiOdgovorLicitacije(){
		return Integer.parseInt(nizSaOdgovorom[1]);
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
	/**
	 * Metoda za pokretanje dijaloga za rang listu kviza licitacije.
	 * @param button true za prikaz dijaloga za upis na rang listu, false samo za prikaz rang liste kviza licitacije
	 * @param poeni koji ce biti prikazani
	 */
	public static void pokreniLicitacijeScoreDijalog(boolean button, int poeni) {
		licitacijeScoreDijalog = new LicitacijeScoreDijalog(button, poeni);
		licitacijeScoreDijalog.setVisible(true);
	}
	/**
	 * Metoda vrsi proveru da li igraca treba upisati na rang listu kviza licitacija.
	 * @param poeni na osnovu kojih se provera da li treba izvrsiti upis
	 * @return true/false u zavisnosti da li treba izvrsiti upis na rang listu
	 */
	public static boolean daLiUpisatiNaRangListuLicitacija(int poeni) {
		pozicija = licitacijeLogika.proveriIUpisiNaRangListu(poeni);
		if(pozicija == -1)
			return false;
		else
			return true;
	}
	
	/**
	 * Upis igraca u rang listu kviza licitacije.
	 * @param ime koje ce biti upisano
	 * @param poeni broj poena za upis
	 */
	public static void upisiImeNaLicitacije(String ime, int poeni) {
		licitacijeLogika.upisiImeUListu(ime, pozicija, poeni);
		
	}
	/**
	 * Metoda vraca rang listu kviza licitacije.
	 * @return String koji sadrzi rang listu za prikaz
	 */
	public static String rangListaLicitacije() {
		return licitacijeLogika.vratiRangListu();
	}
	/**
	 * Metoda koja omogucuje serijalizaciju rang liste kviza licitacije.
	 * @throws Exception 
	 */
	public static void serijalizujLicitacije() throws Exception {
		licitacijeLogika.serijalizuj();
	}
}
