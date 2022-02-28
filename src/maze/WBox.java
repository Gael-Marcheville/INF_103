package maze;

public class WBox extends MBox {
	/**
	 * Retourne un objet WBox, Wall Box
	 *
	 * @param xpos abscisse de la WBox
	 * @param ypos ordonnée de la WBox
	 * @param m    Maze associé à la WBox
	 */
	public WBox(int xpos, int ypos, Maze m) {
		super(xpos, ypos, m);
	}

	/**
	 * Retourne Vrai si la Box est un mur, Faux sinon
	 *
	 * @return booléen valant Vrai si la Box est un mur, Faux sinon
	 */
	public boolean isWall() {
		return true;
	}
}
