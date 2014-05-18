import hu.u_szeged.inf.esemenyek.Munkahely;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
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
	private boolean isModosit=false;
	private Munkahely esemeny;
	
	
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
		this(frame, null);
	}
	
	public MunkahelyPanel(MainFrame frame, Munkahely esemeny){
		if(esemeny != null) this.isModosit = true;
		this.esemeny = esemeny;
		
		this.frame = frame;
		this.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.gridx=0;
		c.gridy=0;
		c.gridwidth=1;
		
		panelFeltolt();
		EsemenyKezelok();
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
		cimkeDatum = new JLabel("Esemény kezdete: (év, hónap, nap, óra):");
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
		this.add(ora, c);
		
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
		
		if(isModosit){
			nev.setText(esemeny.getNev());
			
		}
		
	}
	
	private void EsemenyKezelok(){
		okGomb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(checkHelyessek()){
					Calendar datum = new GregorianCalendar((Integer)ev.getValue(), (Integer)honap.getValue()-1, (Integer)nap.getValue(), (Integer)ora.getValue(), 0);
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh-mm");
					System.out.println("datum: "+df.format(datum.getTime()));
					
					Munkahely mh = new Munkahely(nev.getText(), datum, (Integer)idotartam.getValue(), cegNev.getText(), ugyfelNev.getText(), 3, leiras.getText());
					frame.ujEsemeny(mh);
					
					frame.setDefaultPane();
				} else Seged.popup("Bevitt adatok nem megfelelőek!", "Sikertelen esemény létrehozás", frame);
			}
		});
		
		megseGomb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setDefaultPane();
				
			}
		});
	}
	
	/**
	 * Leellenőrzi, hogy a bevitt adatok helyesek-e
	 * 2014.05.18.
	 * @return true, ha nem tortent hiba
	 */
	private boolean checkHelyessek(){

		if ((this.nev.getText()).length() < 4) {
			return false;
		}
		if ((this.leiras.getText()).length() < 20) {
			return false;
		}
		if ((this.cegNev.getText()).length() < 4) {
			return false;
		}
		if ((this.ugyfelNev.getText()).length() < 10) {
			return false;
		}
		if (!Seged.datum(((Integer) this.ev.getValue()), (Integer) this.honap.getValue(), (Integer) this.nap.getValue()) == true) {
			return false;
		}
		if ((Integer) this.idotartam.getValue() < 1) {
			return false;
		}
		return true; //Ha minden ertek megfelelo, nem adunk vissza hibajelzest
	}
}
