import hu.u_szeged.inf.esemenyek.Esemeny;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.TableView.TableRow;


public class HetiNezetPanel extends JPanel {
	
	private JTable tabla;
	private JScrollPane scrollPane;
	private TablaModell modell;
	private JButton balra;
	private JButton jobbra;
	private JButton megnyit;
	private GridBagConstraints c;
	private MainFrame frame;
	
	private int het;

	public HetiNezetPanel(int het, MainFrame frame) {
		super();
		
		this.frame = frame;
		this.het = het;		
		betolt();
	}
	
	private void betolt(){
		
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
		
		String[] columnNames = {Integer.toString(het)+". hét",
                "Hétfő",
                "Kedd",
                "Szerda",
                "Csütörtök",
                "Péntek",
                "Szombat",
                "Vasárnap"
        };
		
		tabla = new JTable();
		modell = new TablaModell(data, columnNames);
		tabla.setModel(modell);
		tabla.setEnabled(false);
		
		scrollPane = new JScrollPane(tabla);
		tablatBeallit();
		
		c = new GridBagConstraints();
		gombokEsMenukHozzaad();		
		c.gridwidth=2;
		c.gridy=1;
		c.gridx=0;
		this.add(scrollPane, c);
		
		esemenyKezelokHozzaad();
		
	}
	
	private void tablatBeallit(){
		
		scrollPane.setPreferredSize(new Dimension(900, 500));
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		//tábla.setFillsViewportHeight(true);
		tabla.setAlignmentX(RIGHT_ALIGNMENT);
		
		for(int i=0; i<tabla.getColumnModel().getColumnCount(); i++){
			TableColumn oszlop = tabla.getColumnModel().getColumn(i);
			if(i==0) oszlop.setMaxWidth(70);
			tabla.setRowHeight(60);
			
		}
		
		
	}
	
	/**Beállítja a tába adott cellájának tartalmát
	 * @param sor int - a sor száma a táblázatban
	 * @param oszlop int -az oszlop száma a táblázatban
	 * @param adat String - az adat amit be szeretnénk írni
	 * 2014.05.11.
	 */
	private void setMezo(int sor, int oszlop, String adat){
		modell.setCella(adat, sor, oszlop);
	}
	
	/**Beállítja a táblában az eseményt.<br><br>
	 * Ha az esemény nem az aktuális héten található, akkor <b>NEM</b> lesz megjelenítve!!!
	 * @param esemeny {@link Esemeny} - az esemény, amelyet be szeretnénk szúrni/módosítani szeretnénk
	 * 2014.05.17.
	 */
	public void setMezo(Esemeny esemeny){
		Calendar kezd = esemeny.getKezdet();
		if(het == kezd.get(Calendar.WEEK_OF_YEAR)){
			int ev = kezd.get(Calendar.YEAR);
			int honap = kezd.get(Calendar.MONTH);
			int nap = kezd.get(Calendar.DAY_OF_WEEK);
			int ora = kezd.get(Calendar.HOUR_OF_DAY);
			int perc = kezd.get(Calendar.MINUTE);
			
			if(nap == 1) nap=7;
			else nap = nap -1;
			modell.setEsemeny(esemeny, ora, nap);
			for(int i=1; i<esemeny.getIdotartam(); i++){
				modell.setEsemeny(esemeny, ora+i, nap);
			}
		}else {
			//TODO ezt a debug jellegű figyelmeztető üzenetet kivenni
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println("A(z)"+esemeny.getNev()+" nevű esemény nem ezen a héten van! ("+dt.format(esemeny.getKezdet().getTime())+")!!!");
		}
		
		
	}
	
	private void gombokEsMenukHozzaad(){
		c.gridy=0;
		c.gridwidth=1;
		balra = new JButton("<<");
		this.add(balra, c);
		jobbra = new JButton(">>");
		this.add(jobbra, c);
	}
	
	/**
	 * Frissíti a táblában megjelenő adatokat (pl a hét száma), hogy az aktuális
	 * legyen megjelenítve.
	 * 2014.05.17.
	 */
	private void updateTable(){
		tabla.getTableHeader().getColumnModel().getColumn(0).setHeaderValue(het+". hét");
		
		
		
		JTableHeader col = tabla.getTableHeader();
		col.repaint();
	}
	
	private void esemenyKezelokHozzaad(){
		balra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				het--;
				cleartable();
				frame.betoltHet(-1);
				updateTable();
				
			}
		});
		
		jobbra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				het++;
				cleartable();
				frame.betoltHet(1);
				updateTable();
				
			}
		});
	}
	
	private void cleartable(){
		for(int i=0; i<24; i++){
			for(int j=1; j<=7; j++){
				modell.setCella(null, i, j);
			}
		}
		
	}

}
