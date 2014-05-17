import java.io.IOException;

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
		System.out.println(Seged.datum(2000, 2, 29));
		System.out.println(Seged.datum(2100, 2, 29));
		System.out.println(Seged.datum(2014, 5, 31));
		System.out.println(Seged.datum(2014, 6, 31));
		System.out.println(Seged.datum(2400, 2, 29));
		System.out.println("--------------------SanyiTeszt vége----------------------------");
	}
	
}
