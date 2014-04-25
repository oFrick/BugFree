package hu.u_szeged.inf.időtartamok;

/**
 * A Naptár egy hetét reprezentálja. Tárolja a hozzá tartozó napokat, illetve a héten lévő összes eseményt.<br>
 * Egyenlőre ez a legnagyobb időtartam.<br><br>
 * A hét meghatározható az alapján, hogy melyik év hányadik hetéről van szó.
 *
 * @author Kiss Dániel
 * 2014.04.25.
 */
public class Hét extends Időtartam {
	
	/**
	 * Megadja, hogy hányadik naptári hétről van szó az adott évben
	 */
	private int hétSzám;
	/**
	 * Megadja, hogy melyik évhez tartozik a hét
	 */
	private int év;
	/**
	 * Ezen héthez tartozó  7 nap
	 */
	private Nap[] napok;
	
	/**
	 * A hét osztály konstruktora.<br>
	 * Létrehozza a hozzá tartozó napokat, átadja az egyes napokhoz tartozó
	 * eseményeket.
	 * 
	 * @param év int - a héthez tartozó naptári év
	 * @param hétSzám int - a naptári évben a hét sorszáma
	 * 2014.04.25.
	 */
	public Hét(int év, int hétSzám) {
		this.év = év;
		this.hétSzám = hétSzám;
		
		napok = new Nap[7];
		
		//Napok példányosítása
		for(int i=0; i<7; i++){
			Nap nap = new Nap();
			napok[i] = nap;
		}
	}
}
