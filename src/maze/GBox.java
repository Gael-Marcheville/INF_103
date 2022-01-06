package maze;

public class GBox extends MBox { //box permettant de marquer la position du joueur
	/**
	 * Renvoie un objet GBox, Game Box
	 *
	 * @param xpos abscisse de la GBox
	 * @param ypos ordonnée de la GBox
	 * @param m Maze associé à la GBox
	 */
	public GBox(final int xpos, final int ypos, final Maze m) {
		super(xpos, ypos, m);
	}
	/**
	 * Renvoie le type de la Box, "G"
	 *
	 * @return String valant "G", le type de la Box
	 */
	public String getType() { 
		return "G";	//renvoie le type de la classe en String
	}

}
