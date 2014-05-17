import java.awt.GridBagConstraints;
import java.awt.LayoutManager;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;


public class UjMunkahelyPanel extends JPanel {
	
	private MainFrame frame;
	private GridBagConstraints c;
	
	private JLabel cimkeNev;
	private JLabel cimkeLeiras;
	private JLabel cimkeDatum;
	private JTextField nev;
	private JTextField leiras;
	private JSpinner ev;
	private JSpinner honap;
	private JSpinner nap;

	public UjMunkahelyPanel(MainFrame frame) {
		this.frame = frame;
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
		this.add(cimkeLeiras, c);
		
		c.gridx=0;
		c.gridy=2;
		cimkeDatum = new JLabel("Esemény kezdete: (év, hónap, nap):");
		this.add(cimkeDatum, c);
		c.gridx=1;
		ev = new JSpinner(new SpinnerNumberModel(most.get(Calendar.YEAR), most.get(Calendar.YEAR), most.get(Calendar.YEAR)+5, 1));
		this.add(ev, c);
		c.gridx=1;
		honap = new JSpinner(new SpinnerNumberModel(most.get(Calendar.MONTH), 1, 12, 1));
		this.add(honap, c);
		c.gridx=2;
		nap = new JSpinner(new SpinnerNumberModel(most.get(Calendar.DAY_OF_WEEK), 1, 31, 1));
		this.add(nap, c);
		
		
		
	}
}
