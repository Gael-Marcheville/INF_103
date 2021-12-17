package maze;

public class PBox extends MBox { //box permettant de marquer le circuit
	/**
	 * Renvoie un objet PBox, Point Box
	 *
	 * @param xpos abscisse de la PBox
	 * @param ypos ordonnée de la PBox
	 * @param m Maze associé à la PBox
	 */
	public PBox(final int xpos, final int ypos, final Maze m) {
		super(xpos, ypos, m);
	}
	/**
	 * Renvoie le type de la Box, "P"
	 *
	 * @return String valant "P", le type de la Box
	 */
	public String getType() { 
		return ".";	//renvoie le type de la classe en String
	}

}
