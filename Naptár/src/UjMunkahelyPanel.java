import java.awt.GridBagConstraints;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class UjMunkahelyPanel extends JPanel {
	
	private MainFrame frame;
	private GridBagConstraints c;
	
	private JLabel cimkeNev;
	private JLabel cimkeLeiras;
	private JLabel cimkeTipus;

	public UjMunkahelyPanel(MainFrame frame) {
		this.frame = frame;
		c = new GridBagConstraints();
		c.gridx=0;
		c.gridy=0;
		c.gridwidth=1;
	}
}
