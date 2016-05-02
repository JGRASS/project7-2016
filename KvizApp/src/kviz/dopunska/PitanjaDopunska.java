package kviz.dopunska;

import java.util.LinkedList;

public class PitanjaDopunska {
	/**
	 * Lista laksih pitanja
	 */
	private LinkedList<String> laksa;
	/**
	 * Lista pitanja srednje tezina
	 */
	private LinkedList<String> srednja;
	/**
	 * Lista teskih pitanja
	 */
	private LinkedList<String> teza;
	
	public PitanjaDopunska() {
		laksa = new LinkedList<>();
		srednja = new LinkedList<>();
		teza = new LinkedList<>();
	}
	
	/**
	 * Vraca listu laksih pitanja
	 * @return listu laksih pitanja
	 */
	public LinkedList<String> getLaksa() {
		return laksa;
	}

	public void setLaksa(LinkedList<String> laksa) {
		if(laksa == null){
			throw new RuntimeException("Greska! Lista nije dobro prosledjena");
		}
		this.laksa = laksa;
	}
	/**
	 * Vraca listu srednjih pitanja
	 * @return listu srednjih pitanja
	 */
	public LinkedList<String> getSrednja() {
		return srednja;
	}

	public void setSrednja(LinkedList<String> srednja) {
		if(srednja == null){
			throw new RuntimeException("Greska! Lista nije dobro prosledjena");
		}
		this.srednja = srednja;
	}
	/**
	 * Vraca listu tezih pitanja
	 * @return listu tezih pitanja
	 */
	public LinkedList<String> getTeza() {
		return teza;
	}

	public void setTeza(LinkedList<String> teza) {
		if(teza == null){
			throw new RuntimeException("Greska! Lista nije dobro prosledjena");
		}
		this.teza = teza;
	}
}
