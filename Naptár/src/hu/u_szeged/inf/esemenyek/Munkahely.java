package hu.u_szeged.inf.esemenyek;

import java.io.PrintStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * Munkahely osztály az üzleti eseményekhez
 * @author Rátkai Sándor
 */
public class Munkahely extends Esemeny{
	
	private String cegNev;
	private String ugyfelNev;
	private int hataridoNapok;
	/**
	 * Munkahely tipusú esemény létrehozása
	 * 
	 * @param nev Esemény neve
	 * @param kezdet Esemény kezdete
	 * @param idotartam Esemény hossza
	 * @param cegNev Cég neve
	 * @param ugyfelNev Ügyfél neve
	 * @param hataridoNapok Hány nap határidő van rá
	 */
	public Munkahely(String nev, Calendar kezdet, int idotartam, String cegNev, String ugyfelNev, int hataridoNapok){
		this.setTipus("Munka");
		this.setNev(nev);
		this.setKezdet(kezdet);
		this.setIdotartam(idotartam);
		this.cegNev = cegNev;
		this.ugyfelNev=ugyfelNev;
		this.hataridoNapok = hataridoNapok;
	}
	/**
	 * Önmagát beolvasó Munkahelyi esemény létrehozása
	 * @param Olvaso Scanner amivel beolvassák magukat
	 * @param ev Év melyben az esemény történik
	 */
	public Munkahely(Scanner Olvaso, int ev){
		this.setNev(Olvaso.nextLine());
		this.setKezdet(new GregorianCalendar(ev, Olvaso.nextInt(), Olvaso.nextInt(), Olvaso.nextInt(), Olvaso.nextInt()));
		this.setIdotartam(Olvaso.nextInt());
		this.hataridoNapok = Olvaso.nextInt();
		Olvaso.nextLine();
		this.ugyfelNev = Olvaso.nextLine();
		this.cegNev = Olvaso.nextLine();
	}
	/**
	 * Önmagát kiírató metódus
	 * @param Iro Printstream amivel tud írni
	 */
	public void Printer(PrintStream Iro){
		Iro.println(getNev());
		Iro.printf("%02d %02d %02d %02d %d\n", getKezdet().get(Calendar.MONTH), getKezdet().get(Calendar.DAY_OF_MONTH), getKezdet().get(Calendar.HOUR), getKezdet().get(Calendar.MINUTE), getIdotartam());
		Iro.printf("%d\n", getHataridoNapok());
		Iro.println(getUgyfelNev());
		Iro.println(getCegNev());
	}
	
	public String toString(){
		String str = "<html><body><b>"+getNev()+"</b>";
		if (ugyfelNev!="-")
			str+="<br> ("+ugyfelNev+")</body></html>";
		return str;
	}
	
	public int getHataridoNapok() {
		return hataridoNapok;
	}

	public void setHataridoNapok(int hataridoNapok) {
		this.hataridoNapok = hataridoNapok;
	}

	public String getUgyfelNev() {
		return ugyfelNev;
	}

	public void setUgyfelNev(String ugyfelNev) {
		this.ugyfelNev = ugyfelNev;
	}

	public String getCegNev() {
		return cegNev;
	}

	public void setCegNev(String cegNev) {
		this.cegNev = cegNev;
	}
}
