import hu.u_szeged.inf.események.Esemény;

import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.io.File;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame {
	
	private GridBagLayout layout;
	private GridBagConstraints constraint;
	private HetiNézetPanel panel;

	public MainFrame(String név){
		super(név);
		
		this.setSize(1024, 768); //Ablak mérete
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
		
		panel = new HetiNézetPanel();
		setContentPane(panel);
		
		panel.setMező(new Esemény("Gábor szülinap", new GregorianCalendar(2014, 5, 3, 4, 11), 2));
		
	}

	private void loadMenus() {
		// TODO Auto-generated method stub
		
	}

}
