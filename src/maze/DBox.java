package maze;

public class DBox extends MBox {
	/**
	 * Renvoie un objet DBox, Departure Box
	 *
	 * @param xpos abscisse de la DBox
	 * @param ypos ordonnée de la DBox
	 * @param m Maze associé à la DBox
	 */
	public DBox(final int xpos, final int ypos, final Maze m) {
		super(xpos, ypos, m);
	}
	/**
	 * Renvoie le type de la Box, "D"
	 *
	 * @return String valant "D", le type de la Box
	 */
	public String getType() { 
		return "D";	//renvoie le type de la classe en String
	}

}
