package maze;

public class WBox extends MBox {
	/**
	 * Retourne un objet WBox, Wall Box
	 *
	 * @param xpos abscisse de la WBox
	 * @param ypos ordonn�e de la WBox
	 * @param m    Maze associ� � la WBox
	 */
	public WBox(int xpos, int ypos, Maze m) {
		super(xpos, ypos, m);
	}

	/**
	 * Retourne Vrai si la Box est un mur, Faux sinon
	 *
	 * @return bool�en valant Vrai si la Box est un mur, Faux sinon
	 */
	public boolean isWall() {
		return true;
	}
}
