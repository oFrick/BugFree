package hu.u_szeged.inf.esemenyek;

import java.util.Calendar;

public class Esemeny {
	
	private Calendar kezdet;
	private int idotartam;
	private String nev;
	
	public Esemeny(String nev, Calendar kezdet, int idotartam){
		
		this.nev = nev;
		this.kezdet = kezdet;
		this.idotartam = idotartam;
	}

	public Calendar getKezdet() {
		return kezdet;
	}

	public int getIdotartam() {
		return idotartam;
	}

	public String getNev() {
		return nev;
	}

	public void setKezdet(Calendar kezdet) {
		this.kezdet = kezdet;
	}

	public void setIdotartam(int idotartam) {
		this.idotartam = idotartam;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}
	
	public String toString(){
		return getNev();
	}
	
	

}
