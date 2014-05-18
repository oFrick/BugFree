import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JPanel;


public abstract class EsemenyPanel extends JPanel {
	
	protected JButton okGomb;
	protected JButton megseGomb;
	
	protected void kezeloGombHozzaad(GridBagConstraints c){
		okGomb = new JButton("Oké");
		c.gridy+=1;
		c.gridx=0;
		c.gridwidth=1;
		this.add(okGomb, c);
		
		megseGomb = new JButton("Mégsem");
		c.gridx=1;
		this.add(megseGomb, c);
	}

}
