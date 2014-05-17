package hu.u_szeged.inf.időtartamok;

import hu.u_szeged.inf.idotartamok.Napok;

import java.util.Calendar;

/**
 * A naptár hetének egy napja. Tárolja az aznapi összes eseményt (amely 0:00 perctől 23:59 percig tart), illetve a
 * hozzá tartozó órákat.
 * 
 * @author Kiss Dániel
 * 2014.04.25.
 */
public class Nap extends Időtartam {
	
	/**
	 * A nap enumerációs neve
	 */
	private Napok napNév;
	private Calendar dátum;
	/**
	 * Az a hét, amely ezt a napot tartalmazza
	 */
	private Hét konténer;

	/**
	 * A hét napjának konstruktora. Példányosítja a hozzá tartozó órákat, átadja a
	 * hozzájuk tartozó eseményeket.
	 * @param napNév
	 * 2014.04.25.
	 */
	public Nap(Napok napNév, Hét konténer) {
		this.napNév = napNév;
		this.konténer = konténer;
		
	}
	
	
}
