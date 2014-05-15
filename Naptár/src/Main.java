import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import hu.u_szeged.inf.esemenyek.*;


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
		List<Esemeny> lista = new ArrayList<>();
		lista=EsemenyOlvaso.Olvass("Sanyi", 2014, 21);
		/*if (lista.isEmpty())
			System.out.println("Üres");*/
		EsemenyOlvaso.Irj("Sanyi", 2014, 21, lista);
		System.out.println("--------------------SanyiTeszt vége----------------------------");
	}
	
}
