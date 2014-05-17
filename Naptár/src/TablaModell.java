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

	public void setEsemeny(Esemeny esemeny, int row, int column) {
		// TODO Auto-generated method stub
		Esemeny e = ((Esemeny)this.getValueAt(row, column));
		e = esemeny;
		super.setValueAt(esemeny.toString(), row, column);
	}
	
	
	@Override
	public void setValueAt(Object aValue, int row, int column) { //ÜRES, MERT NEM HASZNÁLHATÓ ÁTNEVEZÉSHEZ
		//Esemeny e = (Esemeny)this.getValueAt(row, column);
		//e.setNev((String)aValue);
		//fireTableCellUpdated(row,column);
	}
	
	
	
	
	

	
}
