import hu.u_szeged.inf.esemenyek.*;

import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


@SuppressWarnings({ "unused", "serial" })
public class MainFrame extends JFrame {
	private Calendar datum;
	private GridBagLayout layout;
	private GridBagConstraints constraint;
	private HetiNezetPanel panel;
	private JMenuBar menubar;
	private JMenu fajlMenu;
	private JMenuItem kilepes;
	private JMenu esemenyMenu;
	private JMenu ujEsemenyMenu;
	private JMenuItem ujMunkahely;
	private JMenuItem ujSzulinap;
	private JMenuItem ujVizsga;
	
	/**A program grafikus main osztályának konstruktora. Paraméterül meg kell adni
	 * a létrehozandó grafikus felület (ablak) címét.
	 * 2014.05.17.
	 * @param nev
	 */
	public MainFrame(String nev){
		super(nev);
		this.setSize(1024, 756); //Ablak mérete
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ablakbezárás esemény kezelése
				
		loadMenus();
		loadContent();
		this.setVisible(true);
	}

	/**
	 * Betölti a grafikus felület tartalmát. Alapbeállításokat végez, pl ablak mérete.<br>
	 * Feltölti a táblát az indításkor alapértelmezett értékekkel. Ez nem más, mint a rendszeridő szerinti
	 * aktális dátumnak megfelelő héten lévő események heti-nézetben
	 * 2014.05.17.
	 */
	private void loadContent() {
		layout = new GridBagLayout();
		constraint = new GridBagConstraints();
		constraint.fill = GridBagConstraints.HORIZONTAL; // Maximális szélesség, szükséges magasság
		
		
		datum = new GregorianCalendar();
		panel = new HetiNezetPanel(datum.get(Calendar.WEEK_OF_YEAR), this);
		setContentPane(panel);
		
		betoltHet(0);
		
		
		
		//Teszt munkahelyi esemény
		Munkahely es = new Munkahely("állásinterjú", new GregorianCalendar(2014, 4, 18, 12, 3), 4, "Dani kft", "Nagy Béla", 3); //Azaz ez 2014 5 15.-e !!!!!! (hónap+1 az aktuális dátum)
		panel.setMezo(es);
		
	}

	/**
	 * Példányosítja és betölti a grafikus felületen a menüket
	 * 2014.05.17.
	 */
	private void loadMenus() {
		menubar = new JMenuBar();
		this.setJMenuBar(menubar);
		fajlMenu = new JMenu("Fájl");
		menubar.add(fajlMenu);
		kilepes = new JMenuItem("Kilépés");
		fajlMenu.add(kilepes);
		
		esemenyMenu = new JMenu("Esemény");
		menubar.add(esemenyMenu);
		ujEsemenyMenu = new JMenu("Új esemény");
		esemenyMenu.add(ujEsemenyMenu);
		ujMunkahely = new JMenuItem("Új munkahely");
		ujEsemenyMenu.add(ujMunkahely);
		ujSzulinap = new JMenuItem("Új születésnap");
		ujEsemenyMenu.add(ujSzulinap);
		ujVizsga = new JMenuItem("Új vizsga");
		ujEsemenyMenu.add(ujVizsga);
	}
	
	/**Betölti a megfelelő hetet a táblázatba. A fájlból először beolvassa az aktuális hetet
	 * @param differencia int - <b>NAGYON FONTOS!</b>Az előzőleg aktuális héthezképest eltelt hetek száma. Tehát ha egy hetet ugrunk előre, akkor +1.
	 * @return
	 * 2014.05.17.
	 */
	public List<Esemeny> betoltHet(int differencia){
		datum.set(Calendar.WEEK_OF_YEAR, datum.get(Calendar.WEEK_OF_YEAR)+differencia);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println("Hét váltása erre: "+df.format(datum.getTime()));
		List<Esemeny> esemenyek = new ArrayList<>();
		esemenyek = EsemenyOlvaso.Olvass("Sanyi", this.datum.get(Calendar.YEAR), this.datum.get(Calendar.WEEK_OF_YEAR));
		for (int i=0; i<esemenyek.size(); i++){
			panel.setMezo(esemenyek.get(i));
		}
		
		return esemenyek;
	}

}
