package hu.u_szeged.inf.esemenyek;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
/**
 * Fájlok kezelésére van
 * Csak 2 STATIKUS metódus van benne fájlok írására illetve olvasására
 * @author Rátkai Sándor
 */
public class EsemenyOlvaso {
	
	/**
	 * Adott év adott hetét tartalmazó fájl olvasása
	 * Nyomokban paraméter hibakezelést tartalmaz
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
			System.out.printf("File ovasása: %s elkezdve\n", utvonal);
			Olvaso = new Scanner(new File(utvonal));
			String tipus;
			while (Olvaso.hasNext()){
				//Fájl olvasása
				tipus = Olvaso.nextLine();
				switch (tipus){
					case "bd":{ //Birthday - Szülinap
						lista.add(new SzuliNap(Olvaso, ev));
						break;
					}
					case "wp":{ //Workplace - Munkahely
						lista.add(new Munkahely(Olvaso, ev));
						break;
					}
					case "xm":{ //Exam - vizsga
						lista.add(new Vizsga(Olvaso, ev));
						break;
					}
				}
				System.out.printf("%3d: %s beolvasva\n", lista.size()-1, lista.get(lista.size()-1).toString());
				
			}
			System.out.printf("File ovasása: %s befejezve\n", utvonal);
			Olvaso.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fájl nem található, erre a hétre nincs még bejegyzés");
		}
		return lista;
	}
	/**
	 * Adott év adott hetét tartalmazó fájl kiírása
	 * Nyomokban paraméter hibakezelést tartalmaz
	 * Amennyiben üres listát kap, megpróbálja kitörölni az adott hét adatbázisát
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
			System.out.printf("File írása: %s elkezdve\n", utvonal);
			PrintStream Iro;
			try {
				Iro = new PrintStream(utvonal);
				for (int i=0; i<lista.size(); i++){
					switch (lista.get(i).getTipus()){
						case "Szulinap":
							SzuliNap szn = (SzuliNap) lista.get(i);
							Iro.println("bd");
							szn.Printer(Iro);
							break;
						case "Munka":
							Munkahely mk = (Munkahely) lista.get(i);
							Iro.println("wp");
							mk.Printer(Iro);
							break;
						case "Vizsga":
							Vizsga v = (Vizsga) lista.get(i);
							Iro.println("xm");
							v.Printer(Iro);
							break;
					}
				}
				System.out.printf("File írása: %s befejezve\n", utvonal);
				Iro.close();
			} catch (FileNotFoundException e) {
				System.out.println("Fájl írási hiba");
			}
		}
	}
}

