import javax.swing.SwingUtilities;


public class Main {
	
	private static MainFrame frame;

	public static void main(String[] args) {
		
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

	private static void SanyiTeszt() {
		// TODO Auto-generated method stub
		
		System.out.println("--------------------SanyiTeszt vége----------------------------");
	}
	
}
