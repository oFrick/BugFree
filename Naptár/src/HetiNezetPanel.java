import hu.u_szeged.inf.esemenyek.Esemeny;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableRow;


public class HetiNezetPanel extends JPanel {
	
	private JTable tabla;
	private JScrollPane scrollPane;

	public HetiNezetPanel() {
		super();
		
		betolt();
	}
	
	private void betolt(){
		
		Object[][] data = {
				{"0:01-1:00","","","","","","",""},
				{"1:01-2:00","","","","","","",""},
				{"2:01-3:00","","","","","","",""},
				{"3:01-4:00","","","","","","",""},
				{"4:01-5:00","","","","","","",""},
				{"5:01-6:00","","","","","","",""},
				{"6:01-7:00","","","","","","",""},
				{"7:01-8:00","","","","","","",""},
				{"8:01-9:00","","","","","","",""},
				{"10:01-11:00","","","","","","",""},
				{"11:01-12:00","","","","","","",""},
				{"13:01-14:00","","","","","","",""},
				{"15:01-16:00","","","","","","",""},
				{"17:01-18:00","","","","","","",""},
				{"18:01-19:00","","","","","","",""},
				{"19:01-20:00","","","","","","",""},
				{"21:01-22:00","","","","","","",""},
				{"22:01-23:00","","","","","","",""},
				{"23:01-0:00","","","","","","",""},
		};
		
		String[] columnNames = {"##",
                "Hétfő",
                "Kedd",
                "Szerda",
                "Csütörtök",
                "Péntek",
                "Szombat",
                "Vasárnap"
        };
		
		tabla = new JTable(data, columnNames);
		scrollPane = new JScrollPane(tabla);
		tablatBeallit();
		this.add(scrollPane);
		
	}
	
	private void tablatBeallit(){
		scrollPane.setPreferredSize(new Dimension(900, 800));
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		//tabla.setFillsViewportHeight(true);
		tabla.setAlignmentX(RIGHT_ALIGNMENT);
		
		for(int i=0; i<tabla.getColumnModel().getColumnCount(); i++){
			TableColumn oszlop = tabla.getColumnModel().getColumn(i);
			if(i==0) oszlop.setMaxWidth(70);
			tabla.setRowHeight(30);
			
		}
		
		
	}
	
	/**Beállítja a tába adott cellájának tartalmát
	 * @param sor int - a sor száma a táblázatban
	 * @param oszlop int -az oszlop száma a táblázatban
	 * @param adat String - az adat amit be szeretnénk írni
	 * 2014.05.11.
	 */
	private void setMezo(int sor, int oszlop, String adat){
		tabla.setValueAt(adat, sor, oszlop);
	}
	
	public void setMezo(Esemeny esemeny){
		Calendar kezd = esemeny.getKezdet();
		int ev = kezd.get(Calendar.YEAR);
		int honap = kezd.get(Calendar.MONTH);
		int nap = kezd.get(Calendar.DAY_OF_MONTH);
		int ora = kezd.get(Calendar.HOUR_OF_DAY);
		int perc = kezd.get(Calendar.MINUTE);
		
		tabla.setValueAt(esemeny, ora, 1);
	}

}
