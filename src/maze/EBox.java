package maze;

public class EBox extends MBox{
	/**
	 * Renvoie un objet EBox, Empty Box
	 *
	 * @param xpos abscisse de la EBox
	 * @param ypos ordonn�e de la EBox
	 * @param m Maze associ� � la EBox
	 */
	public EBox(final int xpos,final int ypos,final Maze m) {
		super(xpos, ypos, m);
	}
	/**
	 * Renvoie le type de la Box, "E"
	 *
	 * @return String valant "E", le type de la Box
	 */
	public String getType() { 
		return "E";	//renvoie le type de la classe en String
	}
}
