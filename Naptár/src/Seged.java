

import java.awt.TextField;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Seged {
	
	public static Boolean datum(int ev, int ho, int nap){
		Boolean eredmeny;
		if (ho>12 || ho<1)
			return false;
		else{
			switch (ho){
				case 2:
					if (ev%100==0 && ev%400!=0){
						if (nap<1 || nap>28)
							eredmeny = false;
						else
							eredmeny = true;
					}
					else{
						if (nap<1 || nap>29)
							eredmeny = false;
						else
							eredmeny = true;
					}
					break;
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					if (nap<1 || nap>31)
						eredmeny = false;
					else
						eredmeny = true;
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					if (nap<1 || nap>30)
						eredmeny = false;
					else
						eredmeny = true;
					break;
				default:
					eredmeny = false;
					break;
			}
		}
		if (eredmeny){
			Calendar m = new GregorianCalendar();
			Calendar most = new GregorianCalendar(m.get(Calendar.YEAR), m.get(Calendar.MONTH), m.get(Calendar.DAY_OF_MONTH));
			Calendar az = new GregorianCalendar(ev, ho-1, nap);
			eredmeny = most.compareTo(az)<=0;
		}
		return eredmeny;
	}
	
	public static void popup(String uzenet, String cim, MainFrame frame){
		JOptionPane optionpane = new JOptionPane(uzenet, JOptionPane.INFORMATION_MESSAGE);
		JDialog dialog = optionpane.createDialog(frame, cim);
		dialog.setVisible(true);
	}

}
