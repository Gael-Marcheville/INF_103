package maze;

import Interfaces.VertexInterface;

public class MBox implements VertexInterface {
	private final int x; //attribut position abscisse
	private final int y; //attribut position ordonné
	private final Maze maze;
	/**
	 * Renvoie un objet MBox
	 *
	 * @param xpos abscisse de la MBox
	 * @param ypos ordonnée de la MBox
	 * @param m Maze associé à la MBox
	 */
	public MBox(final int xpos, final int ypos,final Maze m)
	{
		x = xpos;
		y = ypos;
		this.maze = m;
	}
	/**
	 * Renvoie l'abscisse de la MBox
	 *
	 * @return int valant l'abscisse de la MBox
	 */
	public int getX() {
		return x;
	}
	/**
	 * Renvoie l'ordonnée de la MBox
	 *
	 * @return int valant l'ordonnée de la MBox
	 */
	public int getY() {
		return y;
	}
	/**
	 * Renvoie le Maze associé à la MBox
	 *
	 * @return Maze associé à la MBox
	 */
	public Maze getMaze() {
		return maze;
	}
	/**
	 * Renvoie le label de la MBox
	 *
	 * @return String "(x,y)" fournissant une identification unique de la MBox 
	 */
	public String getLabel() { // on définit un identifiant unique (x,y) à partir des coordonnées x et y
		return "(" + String.valueOf(x) + "," + String.valueOf(y) + ")";
	}
	/**
	 * Renvoie Vrai si la Box est un mur, Faux sinon
	 *
	 * @return boolean valant Vrai si la Box est un mur, Faux sinon
	 */
	public boolean isWall() { //dit si une MBox est un mur
		return false;	//de base, une MBox n'est pas un mur
	}
	/**
	 * Renvoie le type de la Box, par défaut "M"
	 *
	 * @return String valant le type de la Box, par défaut "M"
	 */
	public String getType() { 
		return "M";	//renvoie le type de la classe en String, M signifiant que la case n'a pas de type définit
	}
}
