package kviz.logika;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;
/**
 * Klasa koja predstavlja model tabele za prikazivanje rang liste
 * dopunskih pitalica
 * @author Sava
 *
 */
public class TableModelDopunskaRang extends AbstractTableModel{
	/**
	 * Niz naziva kolona
	 */
	private final String[] kolone = new String[] { "Rang", "Ime", "Skor"};
	/**
	 * Rang lista
	 */
	LinkedList<String> rank;
	/**
	 * Konstruktor modela koji inicijalizuje rang listu
	 * @param rang lista
	 */
	public TableModelDopunskaRang(LinkedList<String> rank) {
		if(rank == null){
			this.rank = new LinkedList<>();
		}else{
			this.rank = rank;
		}
	}
	/**
	 * Vraca broj kolona
	 */
	@Override
	public int getColumnCount() {
		return kolone.length;
	}
	/**
	 * Vraca broj redova
	 */
	@Override
	public int getRowCount() {
		return rank.size()/2;
	}
	/**
	 * Vraca vrednost zadatog polja
	 * @param indeks reda
	 * @param indeks kolone
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex==0){
			return rowIndex+1;
		}
		if(columnIndex == 1){
			return rank.get(rowIndex*2);
		}
		if(columnIndex == 2)
			return rank.get(rowIndex*2+1);
		return null;
	}
	/**
	 * Vraca naziv zadate kolone
	 * @param indeks kolone
	 */
	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}
}
