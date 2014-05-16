import hu.u_szeged.inf.esemenyek.*;

import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings({ "unused", "serial" })
public class MainFrame extends JFrame {
	private GregorianCalendar mutat;
	private GridBagLayout layout;
	private GridBagConstraints constraint;
	private HetiNezetPanel panel;
	
	public MainFrame(String nev){
		super(nev);
		mutat = new GregorianCalendar();
		this.setSize(1024, 756); //Ablak mérete
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ablakbezárás esemény kezelése
				
		loadMenus();
		loadContent();
		this.setVisible(true);
	}

	private void loadContent() {
		// TODO Auto-generated method stub
		layout = new GridBagLayout();
		constraint = new GridBagConstraints();
		constraint.fill = GridBagConstraints.HORIZONTAL; // Maximális szélesség, szükséges magasság
		
		panel = new HetiNezetPanel(mutat.get(Calendar.WEEK_OF_YEAR));
		setContentPane(panel);
		
		List<Esemeny> esemenyek = new ArrayList<>();
		esemenyek=hu.u_szeged.inf.esemenyek.EsemenyOlvaso.Olvass("Sanyi", mutat.get(Calendar.YEAR), mutat.get(Calendar.WEEK_OF_YEAR));
		for (int i=0; i<esemenyek.size(); i++){
			panel.setMezo(esemenyek.get(i));
		}
		
	}

	private void loadMenus() {
		// TODO Auto-generated method stub
		
	}

}
