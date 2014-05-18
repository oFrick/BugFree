package hu.u_szeged.inf.esemenyek;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * Vizsga osztály a vizsgáknak
 * Elvégre egyetemisták vagyunk, erre nagy szükségünk van
 * @author Rátkai Sándor
 */
public class Vizsga extends Esemeny{
	private String tantargy;
	private String hely;
	private String vizsgaztato;
	/**
	 * Vizsga tipusú esemény létrehozása adatokkal
	 * @param tantargy Tantárgy neve
	 * @param kezdet Vizsga kezdete
	 * @param idotartam Vizsga időtartama
	 * @param hely Vizsga helye
	 * @param vizsgaztato Vizsgáztató tanár/professzor neve
	 */
	public Vizsga(String tantargy, GregorianCalendar kezdet, int idotartam, String hely, String vizsgaztato){
		this.setTipus("Vizsga");
		this.setTantargy(tantargy);
		this.setKezdet(kezdet);
		this.setIdotartam(idotartam);
		this.setHely(hely);
		this.setVizsgaztato(vizsgaztato);
	}
	/**
	 * Önmagát beolvasó Vizsga esemény létrehozása
	 * @param Olvaso Scanner amivel beolvassák magukat
	 * @param ev Év melyben az esemény történik
	 */
	public Vizsga(Scanner Olvaso, int ev){
		this.tantargy = Olvaso.nextLine();
		this.setKezdet(new GregorianCalendar(ev, Olvaso.nextInt(), Olvaso.nextInt(), Olvaso.nextInt(), Olvaso.nextInt()));
		this.setIdotartam(Olvaso.nextInt());
		Olvaso.nextLine();
		this.hely = Olvaso.nextLine();
		this.vizsgaztato = Olvaso.nextLine();
	}
	/**
	 * Önmagát kiírató metódus
	 * @param Iro Printstream amivel tud írni
	 */
	public void Printer(PrintStream Iro){
		Iro.println(getTantargy());
		Iro.printf("%02d %02d %02d %02d %d\n", getKezdet().get(Calendar.MONTH), getKezdet().get(Calendar.DAY_OF_MONTH), getKezdet().get(Calendar.HOUR), getKezdet().get(Calendar.MINUTE), getIdotartam());
		Iro.println(getHely());
		Iro.println(getVizsgaztato());
	}
	
	public String getTantargy() {
		return tantargy;
	}

	public void setTantargy(String tantargy) {
		this.tantargy = tantargy;
	}
	
	public String getHely() {
		return hely;
	}

	public void setHely(String hely) {
		this.hely = hely;
	}

	public String getVizsgaztato() {
		return vizsgaztato;
	}

	public void setVizsgaztato(String vizsgaztato) {
		this.vizsgaztato = vizsgaztato;
	}
	
	public String toString(){
		String str="<html><body>";
		str+=tantargy;
		str+="<br>vizsga</body></html>";
		return str;
	}
}
