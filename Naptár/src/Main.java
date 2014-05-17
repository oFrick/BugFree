import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.SwingUtilities;



public class Main {
	
	@SuppressWarnings("unused")
	private static MainFrame frame;

	public static void main(String[] args) throws Exception {
		
		SanyiTeszt();
		DaniTeszt();
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				frame = new MainFrame("BugFree Naptár"); //Frame létrehozása
				
			}
		});
	}

	private static void DaniTeszt() {
		// TODO Auto-generated method stub
		
	}

	private static void SanyiTeszt() throws IOException{
		// TODO Auto-generated method stub
		Calendar az = new GregorianCalendar();
		System.out.printf("Ma: %d %d %d\n", az.get(Calendar.YEAR), az.get(Calendar.MONTH), az.get(Calendar.DAY_OF_MONTH));
		
		System.out.println(Seged.datum(2000, 2, 29));
		System.out.println(Seged.datum(2100, 2, 29));
		System.out.println(Seged.datum(2014, 5, 14)+" 14.");
		System.out.println(Seged.datum(az.get(Calendar.YEAR), az.get(Calendar.MONTH)+1, az.get(Calendar.DAY_OF_MONTH)-1)+" tegnap");
		System.out.println(Seged.datum(az.get(Calendar.YEAR), az.get(Calendar.MONTH)+1, az.get(Calendar.DAY_OF_MONTH))+" ma");
		System.out.println(Seged.datum(az.get(Calendar.YEAR), az.get(Calendar.MONTH)+1, az.get(Calendar.DAY_OF_MONTH)+1)+" holnap");
		System.out.println(Seged.datum(2014, 5, 19)+" 19.");
		System.out.println(Seged.datum(2014, 5, 20)+" 20.");
		System.out.println(Seged.datum(2014, 5, 31)+" 5. hó 31.");
		System.out.println(Seged.datum(2014, 6, 31)+" 6. hó 31.");
		System.out.println(Seged.datum(2400, 2, 29));
		System.out.println("--------------------SanyiTeszt vége----------------------------");
	}
	
}
