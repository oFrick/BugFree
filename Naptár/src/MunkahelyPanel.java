import hu.u_szeged.inf.esemenyek.Munkahely;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;


public class MunkahelyPanel extends EsemenyPanel {
	
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
	private JLabel cimkeHatarido;
	private JTextField nev;
	private JTextField leiras;
	private JSpinner ev;
	private JSpinner honap;
	private JSpinner nap;
	private JSpinner ora;
	private JSpinner idotartam;
	private JTextField cegNev;
	private JTextField ugyfelNev;
	private JSpinner hatarido;

	public MunkahelyPanel(MainFrame frame) {
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
		c.gridx=4;
		ora = new JSpinner(new SpinnerNumberModel(most.get(Calendar.HOUR_OF_DAY), 0, 23, 1));
		
		c.gridy=3;
		c.gridx=0;
		cimkeIdotartam = new JLabel("Időtartam:");
		this.add(cimkeIdotartam, c);
		c.gridx=1;
		idotartam = new JSpinner(new SpinnerNumberModel(1, 1, 24, 1));
		this.add(idotartam, c);
		
		c.gridy=4;
		c.gridx=0;
		cimkeCegNev = new JLabel("Cég neve:");
		this.add(cimkeCegNev, c);
		c.gridx=1;
		cegNev = new JTextField(15);
		this.add(cegNev, c);
		
		c.gridy=5;
		c.gridx=0;
		cimkeUgyfelNev = new JLabel("Ügyfél neve:");
		this.add(cimkeUgyfelNev, c);
		c.gridx=1;
		ugyfelNev = new JTextField(15);
		this.add(ugyfelNev, c);
		
		
		this.kezeloGombHozzaad(c);
		
	}
	
	private void EsemenyKezelok(){
		okGomb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(checkHelyessek()){
					//alendar datum = new Gregori
					//frame.ujEsemeny(e);
				}
			}
		});
	}
	
	/**
	 * Leellenőrzi, hogy a bevitt adatok helyesek-e
	 * 2014.05.18.
	 */

	private boolean checkHelyessek(){
		/*
		if (getTextField(this.nev).length < 4) {
			return true;
		}
		if (getTextField(this.leiras).length < 20) {
			return true;
		}
		if (getTextField(this.cegNev).length < 4) {
			return true;
		}
		if (getTextField(this.ugyfelNev).length < 10) {
			return true;
		}
		if (Seged.datum(((int)getValue(this.ev)), (int)getValue(this.honap), (int)getValue(this.nap)) == true) {
			return true;
		}
		if (((int)getValue(this.idotartam)) < 1) {
			return true;
		}
		*/
		return false; //Ha minden ertek megfelelo, nem adunk vissza hibajelzest
	}
}
