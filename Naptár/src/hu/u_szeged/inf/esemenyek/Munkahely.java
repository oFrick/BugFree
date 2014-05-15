package hu.u_szeged.inf.esemenyek;

import java.util.Calendar;

public class Munkahely extends Esemeny{
	
	private String cegNev;
	private String ugyfelNev;
	private int hataridoNapok;
	
	public Munkahely(String nev, Calendar kezdet, int idotartam, String cegNev, String ugyfelNev, int hataridoNapok){
		this.setTipus("Munka");
		this.setNev(nev);
		this.setKezdet(kezdet);
		this.setIdotartam(idotartam);
		this.cegNev = cegNev;
		this.ugyfelNev=ugyfelNev;
		this.hataridoNapok = hataridoNapok;
	}
	
	public String toString(){
		String output=getNev();
		if (ugyfelNev!="-")
			output+=" ("+ugyfelNev+")";
		return output;
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
