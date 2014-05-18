package hu.u_szeged.inf.esemenyek;

import java.io.PrintStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
/**
 * Születésnap osztály az születésnapi eseményeknek
 * @author Rátkai Sándor
 */
public class SzuliNap extends Esemeny{
	private String unnepelt="";
	private String helyszin="";
	private String ajandek="";
	private int evesLesz=-1; //-1 jelenti hogy nincs megadva. Nem 0, mivel valakinek a 0. szülinapja az a születése napja, lehet hogy valakit már így várnak hogy benne van a naptárban órára pontossan
	
	/**
	 * Születésnap tipusú esemény létrehozása
	 * 
	 * @param unnepelt Ünnepelt neve
	 * @param kezdet Buli időpontja
	 * @param idotartam Buli hossza
	 */
	public SzuliNap(String unnepelt, GregorianCalendar kezdet, int idotartam, int evesLesz, String helyszin, String ajandek, String leiras){
		this.setTipus("Szulinap");
		this.setKezdet(kezdet);
		this.setIdotartam(idotartam);
		this.unnepelt = unnepelt;
		this.evesLesz=evesLesz;
		this.setNev(toString());
		this.helyszin=helyszin;
		this.ajandek=ajandek;
		this.setLeiras(leiras);
	}
	/**
	 * Önmagát beolvasó Születésnap esemény létrehozása
	 * @param Olvaso Scanner amivel beolvassák magukat
	 * @param ev Év melyben az esemény történik
	 */
	public SzuliNap(Scanner Olvaso, int ev){
		this.setTipus("Szulinap");
		this.unnepelt = Olvaso.nextLine();
		this.setKezdet(new GregorianCalendar(ev, Olvaso.nextInt(), Olvaso.nextInt(), Olvaso.nextInt(), Olvaso.nextInt()));
		this.setIdotartam(Olvaso.nextInt());
		this.evesLesz = Olvaso.nextInt();
		Olvaso.nextLine();
		this.helyszin = Olvaso.nextLine();
		this.ajandek = Olvaso.nextLine();
		this.setLeiras(Olvaso.nextLine());
	}
	/**
	 * Önmagát kiírató metódus
	 * @param Iro Printstream amivel tud írni
	 */
	public void Printer(PrintStream Iro){
		Iro.println(getUnnepelt());
		Iro.printf("%02d %02d %02d %02d %d\n", getKezdet().get(Calendar.MONTH), getKezdet().get(Calendar.DAY_OF_MONTH), getKezdet().get(Calendar.HOUR), getKezdet().get(Calendar.MINUTE), getIdotartam());
		Iro.println(getEvesLesz());
		Iro.println(getHelyszin());
		Iro.println(getAjandek());
		Iro.println(getLeiras());
	}
	
	public String toString(){
		String str="<html><body><b>"+unnepelt+"</b>";
		if (evesLesz>=0)
			str+="<br>"+evesLesz+".";
		str+=" születésnapja";
		str+="</body></html>";
		return str;
	}
	public String getUnnepelt() {
		return unnepelt;
	}
	public void setUnnepelt(String unnepelt) {
		this.unnepelt = unnepelt;
	}
	public String getHelyszin() {
		return helyszin;
	}
	public void setHelyszin(String helyszin) {
		this.helyszin = helyszin;
	}
	public String getAjandek() {
		return ajandek;
	}
	public void setAjandek(String ajandek) {
		this.ajandek = ajandek;
	}
	public int getEvesLesz() {
		return evesLesz;
	}
	public void setEvesLesz(int evesLesz) {
		this.evesLesz = evesLesz;
	}
}
