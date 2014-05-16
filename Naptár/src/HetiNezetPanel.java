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
	private int het;
	public HetiNezetPanel(int het) {
		super();
		this.het=het;
		betolt();
	}
	
	private void betolt(){
		
		Object[][] data = {
				{"0:00-0:59","","","","","","",""},
				{"1:00-1:59","","","","","","",""},
				{"2:00-2:59","","","","","","",""},
				{"3:00-3:59","","","","","","",""},
				{"4:00-4:59","","","","","","",""},
				{"5:00-5:59","","","","","","",""},
				{"6:00-6:59","","","","","","",""},
				{"7:00-7:59","","","","","","",""},
				{"8:00-8:59","","","","","","",""},
				{"9:00-9:59","","","","","","",""},
				{"10:00-10:59","","","","","","",""},
				{"11:00-11:59","","","","","","",""},
				{"12:00-12:59","","","","","","",""},
				{"13:00-13:59","","","","","","",""},
				{"14:00-14:59","","","","","","",""},
				{"15:00-15:59","","","","","","",""},
				{"16:00-16:59","","","","","","",""},
				{"17:00-17:59","","","","","","",""},
				{"18:00-18:59","","","","","","",""},
				{"19:00-19:59","","","","","","",""},
				{"20:00-20:59","","","","","","",""},
				{"21:00-21:59","","","","","","",""},
				{"22:00-22:59","","","","","","",""},
				{"23:00-23:59","","","","","","",""},
		};
		
		String[] columnNames = {Integer.toString(het)+". hét",
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
			if(i==0)
			{
				oszlop.setMaxWidth(90);
				oszlop.setMinWidth(80);
			}
			tabla.setRowHeight(28);
			
		}
		
		
	}
	
	/**Beállítja a tábla adott cellájának tartalmát
	 * @param sor int - a sor száma a táblázatban
	 * @param oszlop int -az oszlop száma a táblázatban
	 * @param adat String - az adat amit be szeretnénk írni
	 * 2014.05.11.
	 */
	public void setMezo(int sor, int oszlop, String adat){
		tabla.setValueAt(adat, sor, oszlop);
	}
	
	public void setMezo(Esemeny esemeny){
		Calendar kezd = esemeny.getKezdet();
		int ev = kezd.get(Calendar.YEAR);
		int honap = kezd.get(Calendar.MONTH);
		int nap = kezd.get(Calendar.DAY_OF_WEEK);
		int ora = kezd.get(Calendar.HOUR_OF_DAY);
		int perc = kezd.get(Calendar.MINUTE);
		
		tabla.setValueAt(esemeny.toString(), ora, (nap+3)%7);
	}

}
