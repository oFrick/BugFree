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
					Vizsga v = new Vizsga(tantargy.getText(), datum, (Integer)idotartam.getValue(), hely.getText(), vizsgaztato.getText());
					frame.ujEsemeny(v);
					
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

	protected boolean checkHelyesseg() {
		// TODO Megvalósítani
		return true;
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
		
		this.kezeloGombHozzaad(c);
		
		
		
	}

}
