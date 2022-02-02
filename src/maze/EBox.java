package maze;

public class EBox extends MBox{
	/**
	 * Renvoie un objet EBox, Empty Box
	 *
	 * @param xpos abscisse de la EBox
	 * @param ypos ordonnée de la EBox
	 * @param m Maze associé à la EBox
	 */
	public EBox(int xpos, int ypos, Maze m) {
		super(xpos, ypos, m);
	}
}
