import hu.u_szeged.inf.események.Esemény;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;


public class TáblaModell extends DefaultTableModel {

	/**
	 * 2014.05.11.
	 * @param data
	 * @param columnNames
	 */
	public TáblaModell(Object[][] data, Object[] columnNames) {
		super(data, columnNames);
		// TODO Auto-generated constructor stub
	}

	public void setEsemény(Esemény esemény, int row, int column) {
		// TODO Auto-generated method stub
		Esemény e = ((Esemény)this.getValueAt(row, column));
		e = esemény;
		super.setValueAt(esemény.getNév(), row, column);
	}
	
	
	@Override
	public void setValueAt(Object aValue, int row, int column) { //ÜRES, MERT NEM HASZNÁLHATÓ ÁTNEVEZÉSHEZ
		//Esemény e = (Esemény)this.getValueAt(row, column);
		//e.setNév((String)aValue);
		//fireTableCellUpdated(row,column);
	}
	
	
	
	
	

	
}
