package kviz.logika;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JOptionPane;

public class LicitacijaLogika {
	private LinkedList<String> prviNivo;
	private LinkedList<String> drugiNivo;
	private LinkedList<String> treciNivo;
	
	public LicitacijaLogika(){
		prviNivo = new LinkedList<String>();
		drugiNivo = new LinkedList<String>();
		treciNivo = new LinkedList<String>();
	}
	
	public void ucitajFajl() throws Exception {
		
			FileReader f = new FileReader("licitacije.txt");
			BufferedReader in = new BufferedReader(f);
			
			boolean kraj = false;

			while(in.readLine().equals("1")){
				prviNivo.add(in.readLine());
				prviNivo.add(in.readLine());
			}
			do {
				drugiNivo.add(in.readLine());
				drugiNivo.add(in.readLine());
			} while (in.readLine().equals("2"));
			while(!kraj){
				treciNivo.add(in.readLine());
				treciNivo.add(in.readLine());
				if(in.readLine() == null){
					kraj = true;
				}
			}
			
			in.close();
	}

	public String[] izaberiPitanje(int brPitanja) {
		
		if(brPitanja >= 10 && brPitanja <= 14){
			int random;
			while(true){
				random = (int )(Math.random() * prviNivo.size());
				if(random % 2 == 0)
					break;
			}
			String pitanje = prviNivo.get(random);
			String odgovor = prviNivo.get(random + 1);
			prviNivo.remove(random);
			prviNivo.remove(random);
			return new String[]{pitanje, odgovor};
			
		}else if(brPitanja >= 5 && brPitanja <= 9){
			int random;
			while(true){
				random = (int )(Math.random() * drugiNivo.size());
				if(random % 2 == 0)
					break;
			}
			String pitanje = drugiNivo.get(random);
			String odgovor = drugiNivo.get(random + 1);
			drugiNivo.remove(random);
			drugiNivo.remove(random);
			return new String[]{pitanje, odgovor};
		}else{
			int random;
			while(true){
				random = (int )(Math.random() * treciNivo.size());
				if(random % 2 == 0)
					break;
			}
			String pitanje = treciNivo.get(random);
			String odgovor = treciNivo.get(random + 1);
			treciNivo.remove(random);
			treciNivo.remove(random);
			return new String[]{pitanje, odgovor};
		}
	}
	
	public LinkedList<String> getPrviNivo() {
		return prviNivo;
	}
	public void setPrviNivo(LinkedList<String> prviNivo) {
		this.prviNivo = prviNivo;
	}
	public LinkedList<String> getDrugiNivo() {
		return drugiNivo;
	}
	public void setDrugiNivo(LinkedList<String> drugiNivo) {
		this.drugiNivo = drugiNivo;
	}
	public LinkedList<String> getTreciNivo() {
		return treciNivo;
	}
	public void setTreciNivo(LinkedList<String> treciNivo) {
		this.treciNivo = treciNivo;
	}
}
