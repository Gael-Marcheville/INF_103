package maze;

public class WBox extends MBox{
	/**
	 * Renvoie un objet WBox, Wall Box
	 *
	 * @param xpos abscisse de la WBox
	 * @param ypos ordonnée de la WBox
	 * @param m Maze associé à la WBox
	 */
	public WBox(final int xpos, final int ypos, final Maze m) {
		super(xpos, ypos, m);
	}
	/**
	 * Renvoie Vrai si la Box est un mur, Faux sinon
	 *
	 * @return booléen valant Vrai si la Box est un mur, Faux sinon
	 */
	public boolean isWall() { 
		return true;	//les objets de cette classe sont des murs
	}
	/**
	 * Renvoie le type de la Box, "W"
	 *
	 * @return String valant "W", le type de la Box
	 */
	public String getType() { 
		return "W";	//renvoie le type de la classe en String
	}
}
