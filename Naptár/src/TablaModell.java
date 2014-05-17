import hu.u_szeged.inf.esemenyek.Esemeny;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;


public class TablaModell extends DefaultTableModel {

	/**
	 * 2014.05.11.
	 * @param data
	 * @param columnNames
	 */
	public TablaModell(Object[][] data, Object[] columnNames) {
		super(data, columnNames);
		// TODO Auto-generated constructor stub
	}

	public void setEsemeny(Esemeny esemény, int row, int column) {
		// TODO Auto-generated method stub
		Esemeny e = ((Esemeny)this.getValueAt(row, column));
		e = esemény;
		super.setValueAt(esemény.toString(), row, column);
	}
	
	
	@Override
	public void setValueAt(Object aValue, int row, int column) { //ÜRES, MERT NEM HASZNÁLHATÓ ÁTNEVEZÉSHEZ
		//Esemény e = (Esemény)this.getValueAt(row, column);
		//e.setNév((String)aValue);
		//fireTableCellUpdated(row,column);
	}
	
	
	
	
	

	
}
