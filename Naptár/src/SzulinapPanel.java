import hu.u_szeged.inf.esemenyek.SzuliNap;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;


public class SzulinapPanel extends EsemenyPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 154517317541078163L;
	private MainFrame frame;
	private GridBagConstraints c;
	private boolean isModosit=false;
	private SzuliNap esemeny;
	
	private JLabel cimkeDatum;
	private JLabel cimkeIdotartam;
	private JLabel cimkeUnnepelt;
	private JLabel cimkeHelyszin;
	private JLabel cimkeAjandek;
	private JLabel cimkeEvesLesz;
	private JSpinner ev;
	private JSpinner honap;
	private JSpinner nap;
	private JSpinner ora;
	private JSpinner idotartam;
	private JSpinner evesLesz;
	private JTextField unnepelt;
	private JTextField helyszin;
	private JTextField ajandek;

	public SzulinapPanel(MainFrame frame) {
		this(frame, null);
	}
	
	public SzulinapPanel(MainFrame frame, SzuliNap esemeny){
		if(esemeny != null) isModosit = true;
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

	private void EsemenyKezelok() {
		okGomb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(checkHelyesseg()){
					GregorianCalendar datum = new GregorianCalendar((Integer)ev.getValue(), (Integer)honap.getValue()-1, (Integer)nap.getValue(), (Integer)ora.getValue(), 0);
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh-mm");
					System.out.println("datum: "+df.format(datum.getTime()));
					
					SzuliNap szn = new SzuliNap(unnepelt.getText(), datum, (Integer)idotartam.getValue(), (Integer)evesLesz.getValue(), helyszin.getText(), ajandek.getText(), "");
					//frame.ujEsemeny(szn);
					if(!isModosit) frame.ujEsemeny(szn);
					else frame.modositEsemeny(szn, esemeny);
					
					frame.setDefaultPane();
				}else Seged.popup("Bevitt adatok nem megfelelőek!", "Sikertelen esemény létrehozás", frame);
				
			}
		});
		
		megseGomb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setDefaultPane();
				
			}
		});
		
	}

	private void panelFeltolt() {
		Calendar most = new GregorianCalendar();
		
		c.gridx=0;
		c.gridy=0;
		cimkeEvesLesz = new JLabel("Hány éves lesz:");
		this.add(cimkeEvesLesz, c);
		c.gridx=1;
		evesLesz = new JSpinner(new SpinnerNumberModel(0, 0, 150, 1));
		this.add(evesLesz, c);
		
		c.gridx=0;
		c.gridy=1;
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
		
		c.gridy=2;
		c.gridx=0;
		cimkeIdotartam = new JLabel("Időtartam:");
		this.add(cimkeIdotartam, c);
		c.gridx=1;
		idotartam = new JSpinner(new SpinnerNumberModel(1, 1, 24, 1));
		this.add(idotartam, c);
		
		c.gridy=3;
		c.gridx=0;
		cimkeUnnepelt = new JLabel("Ünnepelt neve:");
		this.add(cimkeUnnepelt, c);
		c.gridx=1;
		unnepelt = new JTextField(15);
		this.add(unnepelt, c);
		
		c.gridy=4;
		c.gridx=0;
		cimkeHelyszin = new JLabel("Helyszín");
		this.add(cimkeHelyszin, c);
		c.gridx=1;
		helyszin = new JTextField(25);
		this.add(helyszin, c);
		
		c.gridy=5;
		c.gridx=0;
		cimkeAjandek = new JLabel("Ajándék");
		this.add(cimkeAjandek, c);
		c.gridx=1;
		ajandek = new JTextField(15);
		this.add(ajandek, c);
		
		this.kezeloGombHozzaad(c);
		
		if(isModosit){
			Calendar cal = esemeny.getKezdet();
			
			ev.setValue(cal.get(Calendar.YEAR));
			honap.setValue(cal.get(Calendar.MONTH));
			nap.setValue(cal.get(Calendar.DAY_OF_MONTH));
			ora.setValue(cal.get(Calendar.HOUR_OF_DAY));
			idotartam.setValue(esemeny.getIdotartam());
			evesLesz.setValue(esemeny.getEvesLesz());
			unnepelt.setText(esemeny.getUnnepelt());
			ajandek.setText(esemeny.getAjandek());
		}
		
	}
	
	/**
	 * 
	 * @return true, ha nem tortent hiba
	 */
	protected boolean checkHelyesseg() {
		if (!Seged.datum(((Integer) this.ev.getValue()), (Integer) this.honap.getValue(), (Integer) this.nap.getValue()) == true) {
			return false;
		}
		if ((Integer) this.ora.getValue() < 0 || (Integer) this.ora.getValue() > 23) {
			return false;
		}
		if ((Integer) this.evesLesz.getValue() < 1 || (Integer) this.evesLesz.getValue() > 110) {
			return false;
		}
		if ((this.unnepelt.getText()).length() < 4) {
			return false;
		}
		if ((this.helyszin.getText()).length() < 4) {
			return false;
		}
		if ((this.ajandek.getText()).length() < 4) {
			return false;
		}
		return true; //Ha minden ertek megfelelo, nem adunk vissza hibauzenetet
	}

}
