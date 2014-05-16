package hu.u_szeged.inf.esemenyek;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
//import java.io.IOException;
import java.util.Scanner;
/**
 * Fájlok kezelésére van
 * Csak 2 STATIKUS metódus van benne fájlok írására illetve olvasására
 * @author Rátkai Sándor
 */
public class EsemenyOlvaso {
	
	/**
	 * Adott év adott hetét tartalmazó fájl olvasása
	 * Tartalmaz hibakezelést
	 * @param ev Hanyadik év
	 * @param het Hanyadik hét
	 * @param username Felhasználó akinek vizsgáljuk a naptárját
	 * @author Rátkai Sándor
	 */
	public static List<Esemeny> Olvass(String username, int ev, int het){
		List<Esemeny> lista = new ArrayList<>();
		String utvonal;
		//Hibakezelés kezdése
		het--;
		ev+=(het/52);
		het%=52;
		het++;
		utvonal="database/"+username.toUpperCase()+"/"+ev+"/"+het+".db";
		Scanner Olvaso;
		try {
			System.out.println("File ovasása: "+utvonal);
			Olvaso = new Scanner(new File(utvonal));
			String tipus;
			while (Olvaso.hasNext()){
				//Fájl olvasása
				tipus = Olvaso.nextLine();
				switch (tipus){
					case "bd":{ //Birthday - Szülinap
						String unnepelt=Olvaso.nextLine();
						GregorianCalendar kezdet = new GregorianCalendar(ev, Olvaso.nextInt(), Olvaso.nextInt(), Olvaso.nextInt(), Olvaso.nextInt());
						int idotartam = Olvaso.nextInt();
						int evesLesz = Olvaso.nextInt();
						Olvaso.nextLine();
						String helyszin = Olvaso.nextLine();
						String ajandek = Olvaso.nextLine();
						lista.add(new SzuliNap(unnepelt, kezdet, idotartam, evesLesz, helyszin, ajandek));
						break;
					}
					case "wp":{ //Workplace - Munkahely
						String nev = Olvaso.nextLine();
						GregorianCalendar kezdet = new GregorianCalendar(ev, Olvaso.nextInt(), Olvaso.nextInt(), Olvaso.nextInt(), Olvaso.nextInt());
						int idotartam = Olvaso.nextInt();
						int hataridoNapok = Olvaso.nextInt();
						Olvaso.nextLine();
						String ugyfelNev = Olvaso.nextLine();
						String cegNev = Olvaso.nextLine();
						lista.add(new Munkahely(nev, kezdet, idotartam, cegNev, ugyfelNev, hataridoNapok));
						break;
					}
				}
				System.out.printf("%3d: %s beolvasva\n", lista.size()-1, lista.get(lista.size()-1).toString());
				
			}
			Olvaso.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fájl nem található, erre a hétre nincs még bejegyzés");
		}
		return lista;
	}
	/**
	 * Adott év adott hetét tartalmazó fájl kiírása
	 * Tartalmaz hibakezelést
	 * @param ev Hanyadik év
	 * @param het Hanyadik hét
	 * @param username Felhasználó akinek vizsgáljuk a naptárját
	 * @author Rátkai Sándor
	 */
	public static void Irj(String username, int ev, int het, List<Esemeny> lista){
		het--;
		ev+=(het/52);
		het%=52;
		het++;
		String utvonal="database/"+username.toUpperCase()+"/"+ev+"/"+het+".db";
		File fajl = new File(utvonal);
		if (lista.isEmpty()){
			System.out.printf("Fájl törlése: %s\n", utvonal);
			fajl.delete();
		}
		else{
			PrintStream Iro;
			try {
				Iro = new PrintStream(utvonal);
				for (int i=0; i<lista.size(); i++){
					switch (lista.get(i).getTipus()){
						case "Szulinap":
							SzuliNap szn = (SzuliNap) lista.get(i);
							Iro.println("bd");
							Iro.println(szn.getUnnepelt());
							Iro.printf("%02d %02d %02d %02d %d\n", szn.getKezdet().get(Calendar.MONTH), szn.getKezdet().get(Calendar.DAY_OF_MONTH), szn.getKezdet().get(Calendar.HOUR), szn.getKezdet().get(Calendar.MINUTE), szn.getIdotartam());
							Iro.println(szn.getEvesLesz());
							Iro.println(szn.getHelyszin());
							Iro.println(szn.getAjandek());
							break;
						case "Munka":
							Munkahely mk = (Munkahely) lista.get(i);
							Iro.println("wp");
							Iro.println(mk.getNev());
							Iro.printf("%02d %02d %02d %02d %d\n", mk.getKezdet().get(Calendar.MONTH), mk.getKezdet().get(Calendar.DAY_OF_MONTH), mk.getKezdet().get(Calendar.HOUR), mk.getKezdet().get(Calendar.MINUTE), mk.getIdotartam());
							Iro.printf("%d\n", mk.getHataridoNapok());
							Iro.println(mk.getUgyfelNev());
							Iro.println(mk.getCegNev());
							break;
					}
				}
				Iro.close();
			} catch (FileNotFoundException e) {
				System.out.println("Fájl írási hiba");
			}
		}
	}
}

