package hu.u_szeged.inf.események;

import java.util.Calendar;

public class Esemény {
	
	private Calendar kezdet;
	private int időtartam;
	private String név;
	
	public Esemény(String név, Calendar kezdet, int időtartam){
		
		this.név = név;
		this.kezdet = kezdet;
		this.időtartam = időtartam;
	}

	public Calendar getKezdet() {
		return kezdet;
	}

	public int getIdőtartam() {
		return időtartam;
	}

	public String getNév() {
		return név;
	}

	public void setKezdet(Calendar kezdet) {
		this.kezdet = kezdet;
		System.out.println("változott");
	}

	public void setIdőtartam(int időtartam) {
		this.időtartam = időtartam;
	}

	public void setNév(String név) {
		this.név = név;
	}
	
	public String toString(){
		return getNév();
	}
	
	public String kiírCím(){
		return getNév();
	}
	
	

}
