package maze;

public class PBox extends MBox { //box permettant de marquer le circuit
	/**
	 * Renvoie un objet PBox, Point Box
	 *
	 * @param xpos abscisse de la PBox
	 * @param ypos ordonnée de la PBox
	 * @param m Maze associé à la PBox
	 */
	public PBox(int xpos, int ypos, Maze m) {
		super(xpos, ypos, m);
	}

}
