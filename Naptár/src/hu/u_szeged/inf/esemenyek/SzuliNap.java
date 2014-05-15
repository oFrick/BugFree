package hu.u_szeged.inf.esemenyek;

import java.util.GregorianCalendar;

public class SzuliNap extends Esemeny{
	private String unnepelt="";
	private String helyszin="";
	private String ajandek="";
	private int evesLesz=-1; //-1 jelenti hogy nincs megadva. Nem 0, mivel valakinek a 0. szülinapja az a születése napja, lehet hogy valakit már így várnak hogy benne van a naptárban órára pontossan
	
	
	public SzuliNap(){
		this.setTipus("Szülinap");
		this.setNev(getTipus());
	}
	public SzuliNap(String unnepelt, GregorianCalendar kezdet, int idotartam){
		this.setTipus("Szulinap");
		this.setKezdet(kezdet);
		this.setIdotartam(idotartam);
		this.unnepelt = unnepelt;
		this.setNev(toString());
	}
	public SzuliNap(String unnepelt, GregorianCalendar kezdet, int idotartam, int evesLesz, String helyszin, String ajandek){
		this.setTipus("Szulinap");
		this.setKezdet(kezdet);
		this.setIdotartam(idotartam);
		this.unnepelt = unnepelt;
		this.evesLesz=evesLesz;
		this.setNev(toString());
		this.helyszin=helyszin;
		this.ajandek=ajandek;
	}
	
	public String toString(){
		String output=unnepelt;
		if (evesLesz>=0)
			output+=" "+evesLesz+".";
		output+=" születésnapja";
		return output;
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
