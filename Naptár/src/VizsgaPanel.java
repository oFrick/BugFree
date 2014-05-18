import hu.u_szeged.inf.esemenyek.Vizsga;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;


public class VizsgaPanel extends EsemenyPanel {
	
	private static final long serialVersionUID = 6545497628797746484L;
	private MainFrame frame;
	private GridBagConstraints c;
	private boolean isModosit=false;
	private Vizsga esemeny;
	
	private JLabel cimkeNev;
	private JLabel cimkeLeiras;
	private JLabel cimkeDatum;
	private JLabel cimkeIdotartam;
	private JLabel cimkeTantargy;
	private JLabel cimkeHely;
	private JLabel cimkeVizsgaztato;
	private JTextField nev;
	private JTextField leiras;
	private JSpinner ev;
	private JSpinner honap;
	private JSpinner nap;
	private JSpinner ora;
	private JSpinner idotartam;
	private JTextField tantargy;
	private JTextField hely;
	private JTextField vizsgaztato;

	public VizsgaPanel(MainFrame frame) {
		this(frame, null);
	}
	
	public VizsgaPanel(MainFrame frame, Vizsga esemeny){
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

	private void EsemenyKezelok() {
		okGomb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkHelyesseg()){
					GregorianCalendar datum = new GregorianCalendar((Integer)ev.getValue(), (Integer)honap.getValue()-1, (Integer)nap.getValue(), (Integer)ora.getValue(), 0);
					Vizsga v = new Vizsga(tantargy.getText(), datum, (Integer)idotartam.getValue(), hely.getText(), vizsgaztato.getText(), leiras.getText());
					if(!isModosit) frame.ujEsemeny(v);
					else frame.modositEsemeny(v, esemeny);
					
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
	 * Ellenorzi, hogy az esemeny tulajdonsagai megfeleloek-e
	 * @return true, ha minden ertek elfogadhato
	 */
	protected boolean checkHelyesseg() {
		if ((this.nev.getText()).length() < 4) {
			return false;
		}
		if ((this.leiras.getText()).length() < 10) {
			return false;
		}
		if ((this.tantargy.getText()).length() < 4) {
			return false;
		}
		if ((this.vizsgaztato.getText()).length() < 10) {
			return false;
		}
		if ((this.hely.getText()).length() < 4) {
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
		honap = new JSpinner(new SpinnerNumberModel(most.get(Calendar.MONTH)+1, 1, 12, 1));
		this.add(honap, c);
		c.gridx=3;
		nap = new JSpinner(new SpinnerNumberModel(most.get(Calendar.DAY_OF_MONTH), 1, 31, 1));
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
		cimkeTantargy = new JLabel("Tantárgy:");
		this.add(cimkeTantargy, c);
		c.gridx=1;
		tantargy = new JTextField(15);
		this.add(tantargy, c);
		
		c.gridy=5;
		c.gridx=0;
		cimkeHely = new JLabel("Helyszín:");
		this.add(cimkeHely, c);
		c.gridx=1;
		hely = new JTextField(25);
		this.add(hely, c);
		
		c.gridy=6;
		c.gridx=0;
		cimkeVizsgaztato = new JLabel("Vizsgaelnök:");
		this.add(cimkeVizsgaztato, c);
		c.gridx=1;
		vizsgaztato = new JTextField(15);
		this.add(vizsgaztato, c);
		
		if(isModosit){
			nev.setText(esemeny.getNev());
			leiras.setText(esemeny.getLeiras());
			Calendar cal = esemeny.getKezdet();
			
			ev.setValue(cal.get(Calendar.YEAR));
			honap.setValue(cal.get(Calendar.MONTH));
			nap.setValue(cal.get(Calendar.DAY_OF_MONTH));
			ora.setValue(cal.get(Calendar.HOUR_OF_DAY));
			idotartam.setValue(esemeny.getIdotartam());
			tantargy.setText(esemeny.getTantargy());
			hely.setText(esemeny.getHely());
			vizsgaztato.setText(esemeny.getVizsgaztato());
		}
		
		this.kezeloGombHozzaad(c);
		
		
		
	}

}
