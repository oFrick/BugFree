import hu.u_szeged.inf.esemenyek.*;

import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.io.File;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings({ "unused", "serial" })
public class MainFrame extends JFrame {
	
	private GridBagLayout layout;
	private GridBagConstraints constraint;
	private HetiNezetPanel panel;

	public MainFrame(String nev){
		super(nev);
		
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
		
		panel = new HetiNezetPanel();
		setContentPane(panel);
		
		Esemeny test1 = new SzuliNap("Gábor", new GregorianCalendar(2014, 5, 3, 4, 11), 2);
		Esemeny test2 = new Munkahely("Találkozó", new GregorianCalendar(2014, 5, 6, 6, 11), 2, "Microsoft", "Bill Gates", 5);
		panel.setMezo(test1);
		panel.setMezo(test2);
		
	}

	private void loadMenus() {
		// TODO Auto-generated method stub
		
	}

}
