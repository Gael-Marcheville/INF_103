package maze;

public class PBox extends MBox {
	/**
	 * Retourne un objet PBox, Point Box, qui permet de marquer le circuit pour le
	 * r�soudre.
	 *
	 * @param xpos abscisse de la PBox
	 * @param ypos ordonn�e de la PBox
	 * @param m    Maze associ� � la PBox
	 */
	public PBox(int xpos, int ypos, Maze m) {
		super(xpos, ypos, m);
	}

}
