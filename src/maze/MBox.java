package maze;

import Interfaces.VertexInterface;

public class MBox implements VertexInterface {
	private final int x;
	private final int y;
	private final Maze maze;

	/**
	 * Retourne un objet MBox
	 *
	 * @param xpos abscisse de la MBox
	 * @param ypos ordonnée de la MBox
	 * @param m    Maze associé à la MBox
	 */
	public MBox(final int xpos, final int ypos, final Maze m) {
		x = xpos;
		y = ypos;
		this.maze = m;
	}

	/**
	 * Retourne l'abscisse de la MBox
	 *
	 * @return int valant l'abscisse de la MBox
	 */
	public int getX() {
		return x;
	}

	/**
	 * Retourne l'ordonnée de la MBox
	 *
	 * @return int valant l'ordonnée de la MBox
	 */
	public int getY() {
		return y;
	}

	/**
	 * Retourne le Maze associé à la MBox
	 *
	 * @return Maze associé à la MBox
	 */
	public Maze getMaze() {
		return maze;
	}

	/**
	 * Retourne le label de la MBox
	 *
	 * @return String "(x,y)" fournissant une identification unique de la MBox
	 */
	public String getLabel() { // on définit un identifiant unique (x,y) à partir des coordonnées x et y
		return "(" + String.valueOf(x) + "," + String.valueOf(y) + ")";
	}

	/**
	 * Retourne Vrai si la Box est un mur, Faux sinon
	 *
	 * @return boolean valant Vrai si la Box est un mur, Faux sinon
	 */
	public boolean isWall() {
		return false; // de base, une MBox n'est pas un mur
	}
}
