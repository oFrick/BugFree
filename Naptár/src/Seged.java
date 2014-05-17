

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
	
	public static Boolean datum(int ev, int ho, int nap){
		if (ho>12 || ho<1)
			return false;
		else{
			switch (ho){
				case 2:
					if (ev%100==0 && ev%400!=0){
						if (nap<1 || nap>28)
							return false;
						else
							return true;
					}
					else{
						if (nap<1 || nap>29)
							return false;
						else
							return true;
					}
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					if (nap<1 || nap>31)
						return false;
					else
						return true;
				case 4:
				case 6:
				case 9:
				case 11:
					if (nap<1 || nap>30)
						return false;
					else
						return true;
				default: return false;
			}
		}
		
		
	}
	
	public static void popupUjMunkahely(MainFrame frame){
		JTextField nev = new JTextField("Név");
		JTextField leiras = new JTextField("leírás",15);
		//JTextField 
	}

}
