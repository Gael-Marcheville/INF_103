package maze;

import Interfaces.VertexInterface;

public class MBox implements VertexInterface {
	private final int x; //attribut position abscisse
	private final int y; //attribut position ordonné
	private final Maze maze;
	
	public MBox(final int xpos, final int ypos,final Maze m)
	{
		x = xpos;
		y = ypos;
		this.maze = m;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public Maze getMaze() {
		return maze;
	}
	public String getLabel() { // on définit un identifiant unique (x,y) à partir des coordonnées x et y
		return "(" + String.valueOf(x) + "," + String.valueOf(y) + ")";
	}
	public boolean isWall() { //dit si une MBox est un mur
		return false;	//de base, une MBox n'est pas un mur
	}
	public String getType() { 
		return "M";	//renvoie le type de la classe en String, M signifiant que la case n'a pas de type définit
	}
}
