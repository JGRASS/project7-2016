package kviz.logika;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class DopunskaLogika {
	
	private LinkedList<String> laksa;
	private LinkedList<String> srednja;
	private LinkedList<String> teza;
	
	public DopunskaLogika(){
		laksa = new LinkedList<String>();
		srednja = new LinkedList<String>();
		teza = new LinkedList<String>();
	}
	
	public void ucitajPitanja() throws Exception{
		
		BufferedReader in = new BufferedReader(new FileReader("fajlovi/dopunska.txt"));
		
		boolean kraj = false;

		while(in.readLine().equals("1")){
			laksa.add(in.readLine());
			laksa.add(in.readLine());
		}
		do {
			srednja.add(in.readLine());
			srednja.add(in.readLine());
		} while (in.readLine().equals("2"));
		while(!kraj){
			teza.add(in.readLine());
			teza.add(in.readLine());
			if(in.readLine() == null){
				kraj = true;
			}
		}
		
		in.close();
	}

	public LinkedList<String> getLaksa() {
		return laksa;
	}

	public void setLaksa(LinkedList<String> laksa) {
		this.laksa = laksa;
	}

	public LinkedList<String> getSrednja() {
		return srednja;
	}

	public void setSrednja(LinkedList<String> srednja) {
		this.srednja = srednja;
	}

	public LinkedList<String> getTeza() {
		return teza;
	}

	public void setTeza(LinkedList<String> teza) {
		this.teza = teza;
	}

	public String[] pitanjeNivo(int skor) {
		if(skor<5){
			int a;
			while(true){
				a = (int)(Math.random() * laksa.size());
				if(a % 2 == 0)
					break;
			}
			String pitanje = laksa.get(a);
			String odgovor = laksa.get(a+1);
			laksa.remove(a);
			laksa.remove(a);
			return new String[]{pitanje, odgovor};
		}else{
			if(skor<10){
				int a;
				while(true){
					a = (int)(Math.random() * srednja.size());
					if(a % 2 == 0)
						break;
				}
				String pitanje = srednja.get(a);
				String odgovor = srednja.get(a+1);
				srednja.remove(a);
				srednja.remove(a);
				return new String[]{pitanje, odgovor};
			}else{
				int a;
				while(true){
					a = (int)(Math.random() * teza.size());
					if(a % 2 == 0)
						break;
				}
				String pitanje = teza.get(a);
				String odgovor = teza.get(a+1);
				teza.remove(a);
				teza.remove(a);
				return new String[]{pitanje, odgovor};
			}
		}
		
	}
	

}
