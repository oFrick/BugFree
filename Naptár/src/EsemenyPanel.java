import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JPanel;


public abstract class EsemenyPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7835285641611179326L;
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
