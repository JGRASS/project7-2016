package kviz.dopunska.sistemske_operacije;

import java.util.LinkedList;

import javax.swing.JOptionPane;
/**
 * 
 * @author Sava
 *
 */
public class SOUbaciURangListu {
	/**
	 * U zavisnosti od ostvarenog skora upisuje takmicara u rang listu
	 * @param imeTakmicara
	 * @param skor
	 */
	public static void izvrsi(String imeTakmicara, String skor) {
		LinkedList<String> rank = new LinkedList<>();
		try {
			rank = SOUcitajRangListuDopunska.izvrsi();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(rank.isEmpty()){
			rank.add(skor);
			rank.add(imeTakmicara);
			return;
		}
		boolean unet = false;
		for(int i = 1; i < rank.size(); i=i+2){
			if(Integer.parseInt(rank.get(i)) < Integer.parseInt(skor)){
				rank.add(i-1, skor);
				rank.add(i-1, imeTakmicara);
				JOptionPane.showMessageDialog(null, "Upisani ste u rang listu!", "Cestitamo", JOptionPane.INFORMATION_MESSAGE);
				unet = true;
				break;
			}
		}
		while(rank.size()>30){
			rank.removeLast();
		}
		if(unet == false && rank.size() < 30){
			rank.addLast(imeTakmicara);
			rank.addLast(skor);
			JOptionPane.showMessageDialog(null, "Upisani ste u rang listu!", "Cestitamo", JOptionPane.INFORMATION_MESSAGE);
			SOOsveziRangListu.izvrsi(rank);
		}
		SOOsveziRangListu.izvrsi(rank);
	}
	
}
