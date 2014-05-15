package hu.u_szeged.inf.idotartamok;

import hu.u_szeged.inf.esemenyek.Esemeny;

import java.util.List;

/**
 * Absztrakt ősosztály, amely a naptár egy adott időintervallumát határozza meg. Ez lehet egy hónap, hét, vagy akár nap.<br>
 * <b>Az órának ez nem ősosztálya!</b>
 * 
 * @author Kiss Dániel
 * 2014.04.25.
 */
public abstract class Idotartam {
	
	private List<Esemeny> esemenyek;

	/**
	 * Getter metódus.
	 * 
	 * @return the események
	 * 2014.04.25.
	 */
	public List<Esemeny> getEsemenyek() {
		return esemenyek;
	}

	/**
	 * Setter metódus.
	 * 
	 * @param események the események to set
	 * 2014.04.25.
	 */
	public void setEsemenyek(List<Esemeny> esemenyek) {
		this.esemenyek = esemenyek;
	}	
	
}
