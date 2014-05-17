import hu.u_szeged.inf.események.Esemény;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableRow;


public class HetiNézetPanel extends JPanel {
	
	private JTable tábla;
	private JScrollPane scrollPane;
	private TáblaModell modell;

	public HetiNézetPanel() {
		super();
		
		betölt();
	}
	
	private void betölt(){
		
		Object[][] data = {
				{"0:00-0:59",null,null,null,null,null,null,null},
				{"1:00-1:59",null,null,null,null,null,null,null},
				{"2:00-2:59",null,null,null,null,null,null,null},
				{"3:00-3:59",null,null,null,null,null,null,null},
				{"4:00-4:59",null,null,null,null,null,null,null},
				{"5:00-5:59",null,null,null,null,null,null,null},
				{"6:00-6:59",null,null,null,null,null,null,null},
				{"7:00-7:59",null,null,null,null,null,null,null},
				{"8:00-8:59",null,null,null,null,null,null,null},
				{"9:00-9:59",null,null,null,null,null,null,null},
				{"10:00-10:59",null,null,null,null,null,null,null},
				{"11:00-11:59",null,null,null,null,null,null,null},
				{"12:00-12:59",null,null,null,null,null,null,null},
				{"13:00-13:59",null,null,null,null,null,null,null},
				{"14:00-14:59",null,null,null,null,null,null,null},
				{"15:00-15:59",null,null,null,null,null,null,null},
				{"16:00-16:59",null,null,null,null,null,null,null},
				{"17:00-17:59",null,null,null,null,null,null,null},
				{"18:00-18:59",null,null,null,null,null,null,null},
				{"19:00-19:59",null,null,null,null,null,null,null},
				{"20:00-20:59",null,null,null,null,null,null,null},
				{"21:00-21:59",null,null,null,null,null,null,null},
				{"22:00-22:59",null,null,null,null,null,null,null},
				{"23:00-23:59",null,null,null,null,null,null,null},		
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
		
		tábla = new JTable();
		modell = new TáblaModell(data, columnNames);
		tábla.setModel(modell);
		
		scrollPane = new JScrollPane(tábla);
		táblátBeállít();
		this.add(scrollPane);
		
	}
	
	private void táblátBeállít(){
		
		scrollPane.setPreferredSize(new Dimension(900, 500));
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		//tábla.setFillsViewportHeight(true);
		tábla.setAlignmentX(RIGHT_ALIGNMENT);
		
		for(int i=0; i<tábla.getColumnModel().getColumnCount(); i++){
			TableColumn oszlop = tábla.getColumnModel().getColumn(i);
			if(i==0) oszlop.setMaxWidth(70);
			tábla.setRowHeight(60);
			
		}
		
		
	}
	
	/**Beállítja a tába adott cellájának tartalmát
	 * @param sor int - a sor száma a táblázatban
	 * @param oszlop int -az oszlop száma a táblázatban
	 * @param adat String - az adat amit be szeretnénk írni
	 * 2014.05.11.
	 */
	private void setMező(int sor, int oszlop, String adat){
		tábla.setValueAt(adat, sor, oszlop);
	}
	
	public void setMező(Esemény esemény){
		Calendar kezd = esemény.getKezdet();
		int év = kezd.get(Calendar.YEAR);
		int hónap = kezd.get(Calendar.MONTH);
		int nap = kezd.get(Calendar.DAY_OF_WEEK);
		int óra = kezd.get(Calendar.HOUR_OF_DAY);
		int perc = kezd.get(Calendar.MINUTE);
		
		modell.setEsemény(esemény, óra, nap-1);
		
	}

}
