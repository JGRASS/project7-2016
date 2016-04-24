package kviz.logika;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

public class TableModelDopunskaRang extends AbstractTableModel{

	private final String[] kolone = new String[] { "Rang", "Ime", "Skor"};
	LinkedList<String> rank;
	
	public TableModelDopunskaRang(LinkedList<String> rank) {
		if(rank == null){
			this.rank = new LinkedList<>();
		}else{
			this.rank = rank;
		}
	}
	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		return rank.size()/2;
	}

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
	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}
}
