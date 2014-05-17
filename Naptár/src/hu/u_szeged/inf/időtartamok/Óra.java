package hu.u_szeged.inf.időtartamok;

public class Óra extends Időtartam {
	
	private int óraSzám;
	private Nap konténer;
	
	/** 
	 * @param óraSzám
	 * @param konténer
	 * 2014.04.25.
	 */
	public Óra(int óraSzám, Nap konténer) {
		this.óraSzám = óraSzám;
		this.konténer = konténer;
	}
	
	

}
