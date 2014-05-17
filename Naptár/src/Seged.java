

import java.awt.TextField;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Seged {
	
	private static void oldloginPopup(MainFrame frame){
		TextField felhNev = new TextField("Felhasznalonev");
		JPasswordField jelszo = new JPasswordField();
		Object[] valaszLehetoseg = {"Jelentkezzen be:",felhNev,jelszo}; 
		Object[] valaszGomb = {"Tovabb", "Megsem"};
		
		JOptionPane optionpane = new JOptionPane(valaszLehetoseg, JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION, null, valaszGomb, valaszGomb[0]);
		JDialog dialog = optionpane.createDialog(frame, "Bejelentkezes");
		dialog.setVisible(true);
		Object v = optionpane.getValue();
		if(v instanceof String && v=="Tovabb") { //Ha erre a gombra kattintunk
			//frame.getTartalom().belepes(felhNev.getText(), String.valueOf(jelszo.getPassword())); //meghivjuk a tartalomkezelo objektum belepes metodusat, azaz belep a felhasznalo
		}
		
	}
	
	public static void popupUjMunkahely(MainFrame frame){
		JTextField nev = new JTextField("Név");
		JTextField leiras = new JTextField("leírás",15);
		//JTextField 
	}

}
