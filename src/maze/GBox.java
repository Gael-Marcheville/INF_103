package maze;

public class GBox extends MBox { //box permettant de marquer la position du joueur
	/**
	 * Renvoie un objet GBox, Game Box
	 *
	 * @param xpos abscisse de la GBox
	 * @param ypos ordonn�e de la GBox
	 * @param m Maze associ� � la GBox
	 */
	public GBox(int xpos, int ypos, Maze m) {
		super(xpos, ypos, m);
	}

}
