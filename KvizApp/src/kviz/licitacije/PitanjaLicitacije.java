package kviz.licitacije;

import java.util.LinkedList;

public class PitanjaLicitacije {
	/**
	 * Lista pitanja prvog nivoa.
	 */
	private LinkedList<String> prviNivo = new LinkedList<String>();
	/**
	 * Lista pitanja drugog nivoa.
	 */
	private LinkedList<String> drugiNivo = new LinkedList<String>();
	/**
	 * Lista pitanja treceg nivoa.
	 */
	private LinkedList<String> treciNivo = new LinkedList<String>();
	
	public LinkedList<String> getPrviNivo() {
		return prviNivo;
	}
	
	public void setPrviNivo(LinkedList<String> prviNivo) {
		if(prviNivo == null)
			throw new RuntimeException("Greska prilikom inicijalizacije liste");
		this.prviNivo = prviNivo;
	}
	
	public LinkedList<String> getDrugiNivo() {
		return drugiNivo;
	}
	
	public void setDrugiNivo(LinkedList<String> drugiNivo) {
		if(drugiNivo == null)
			throw new RuntimeException("Greska prilikom inicijalizacije liste");
		this.drugiNivo = drugiNivo;
	}
	
	public LinkedList<String> getTreciNivo() {
		return treciNivo;
	}
	
	public void setTreciNivo(LinkedList<String> treciNivo) {
		if(treciNivo == null)
			throw new RuntimeException("Greska prilikom inicijalizacije liste");
		this.treciNivo = treciNivo;
	}
}
