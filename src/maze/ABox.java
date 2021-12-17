package maze;

public class ABox extends MBox{
	/**
	 * Renvoie un objet ABox, Arrival Box
	 *
	 * @param xpos abscisse de la ABox
	 * @param ypos ordonnée de la ABox
	 * @param m Maze associé à la ABox
	 */
	public ABox(final int xpos, final int ypos, final Maze m) {
		super(xpos, ypos, m);
	}
	/**
	 * Renvoie le type de la Box, "A"
	 *
	 * @return String valant "A", le type de la Box
	 */
	public String getType() { 
		return "A";	//renvoie le type de la classe en String
	}

	
}
