import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;


public class UjMunkahelyPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1733438848681116239L;
	private MainFrame frame;
	private GridBagConstraints c;
	
	private JLabel cimkeNev;
	private JLabel cimkeLeiras;
	private JLabel cimkeDatum;
	private JLabel cimkeIdotartam;
	private JLabel cimkeCegNev;
	private JLabel cimkeUgyfelNev;
	private JTextField nev;
	private JTextField leiras;
	private JSpinner ev;
	private JSpinner honap;
	private JSpinner nap;
	private JSpinner idotartam;
	private JTextField cegNev;
	private JTextField ugyfelNev;

	public UjMunkahelyPanel(MainFrame frame) {
		this.frame = frame;
		this.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.gridx=0;
		c.gridy=0;
		c.gridwidth=1;
		
		panelFeltolt();
	}

	private void panelFeltolt() {
		
		Calendar most = new GregorianCalendar();
		
		cimkeNev = new JLabel("Esemény neve:");
		this.add(cimkeNev, c);
		c.gridx=1;
		nev = new JTextField(10);
		this.add(nev, c);
		
		c.gridy=1;
		c.gridx=0;
		cimkeLeiras = new JLabel("Leírás");
		this.add(cimkeLeiras, c);
		c.gridx=1;
		leiras = new JTextField(50);
		this.add(leiras, c);
		
		c.gridx=0;
		c.gridy=2;
		cimkeDatum = new JLabel("Esemény kezdete: (év, hónap, nap):");
		this.add(cimkeDatum, c);
		c.gridx=1;
		ev = new JSpinner(new SpinnerNumberModel(most.get(Calendar.YEAR), most.get(Calendar.YEAR), most.get(Calendar.YEAR)+5, 1));
		this.add(ev, c);
		c.gridx=2;
		honap = new JSpinner(new SpinnerNumberModel(most.get(Calendar.MONTH), 1, 12, 1));
		this.add(honap, c);
		c.gridx=3;
		nap = new JSpinner(new SpinnerNumberModel(most.get(Calendar.DAY_OF_WEEK), 1, 31, 1));
		this.add(nap, c);
		
		c.gridy=3;
		c.gridx=0;
		cimkeIdotartam = new JLabel("Időtartam:");
		this.add(cimkeIdotartam, c);
		c.gridx=1;
		idotartam = new JSpinner(new SpinnerNumberModel(1, 1, 24, 1));
		this.add(idotartam, c);
		
		c.gridy=4;
		c.gridx=0;
		
		
		
		
	}
	
	/**
	 * Leellenőrzi, hogy a bevitt adatok helyesek-e
	 * 2014.05.18.
	 */
	private void checkHelyessek(){
		
	}
}
