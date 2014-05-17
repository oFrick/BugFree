package hu.u_szeged.inf.időtartamok;

import hu.u_szeged.inf.események.Esemény;

import java.util.Calendar;
import java.util.List;

/**
 * Absztrakt ősosztály, amely a naptár egy adott időintervallumát határozza meg. Ez lehet egy hónap, hét, vagy akár nap.<br>
 * <b>Az órának ez nem ősosztálya!</b>
 * 
 * @author Kiss Dániel
 * 2014.04.25.
 */
public abstract class Időtartam {
	
	/**
	 * Az adott időtartam alatt végbemenő események.
	 */
	private List<Esemény> események;

	/**
	 * Getter metódus.
	 * 
	 * @return the események
	 * 2014.04.25.
	 */
	public List<Esemény> getEsemények() {
		return események;
	}

	/**
	 * Setter metódus.
	 * 
	 * @param események the események to set
	 * 2014.04.25.
	 */
	public void setEsemények(List<Esemény> események) {
		this.események = események;
	}	
	
}
