package hu.u_szeged.inf.esemenyek;

import java.util.Calendar;

public abstract class Esemeny{
	
	private String nev;
	private String tipus;
	private Calendar kezdet;
	private int idotartam;
	
	/*public Esemeny(String nev, Calendar kezdet, int idotartam){
		
		this.nev = nev;
		this.kezdet = kezdet;
		this.idotartam = idotartam;
	}*/

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

	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}
	
	

}
