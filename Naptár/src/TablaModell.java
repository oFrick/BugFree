import hu.u_szeged.inf.esemenyek.Esemeny;
import hu.u_szeged.inf.esemenyek.Munkahely;

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
	}

	public void setEsemeny(Esemeny esemeny, int row, int column, MainFrame frame) {
		//Esemeny e = ((Esemeny)this.getValueAt(row, column));
		//e = esemeny;
		String str = (String)this.getValueAt(row, column);
		
		Esemeny torlendo = null;
		
		for(Esemeny es : frame.getEsemenyek()){
			System.out.println(str+" ||| "+es.toString());
			if(es.toString().equals(str)){
				es = esemeny;
				break;
			}
		}
		
		super.setValueAt(esemeny.toString(), row, column);
	}
	
	public void setCella(Object aValue, int row, int column){
		super.setValueAt(aValue, row, column);
		fireTableCellUpdated(row,column);
	}
	
	
	@Override
	public void setValueAt(Object aValue, int row, int column) { //ÜRES, MERT NEM HASZNÁLHATÓ ÁTNEVEZÉSHEZ
		//Esemény e = (Esemény)this.getValueAt(row, column);
		//e.setNév((String)aValue);
		//fireTableCellUpdated(row,column);
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	
	
	
	

	
}
