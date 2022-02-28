package maze;

public class PBox extends MBox {
	/**
	 * Retourne un objet PBox, Point Box, qui permet de marquer le circuit pour le
	 * résoudre.
	 *
	 * @param xpos abscisse de la PBox
	 * @param ypos ordonnée de la PBox
	 * @param m    Maze associé à la PBox
	 */
	public PBox(int xpos, int ypos, Maze m) {
		super(xpos, ypos, m);
	}

}
