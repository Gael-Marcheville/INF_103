package tp06;

public class MBox implements VertexInterface {
	private final int x; //attribut position abscisse
	private final int y; //attribut position ordonn�
	private Maze maze;
	
	public MBox(int xpos, int ypos, Maze m)
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
	public String getLabel() { // on d�finit un identifiant unique (x,y) � partir des coordonn�es x et y
		return "(" + String.valueOf(x) + "," + String.valueOf(y) + ")";
	}
	public boolean isWall() { //dit si une MBox est un mur
		return false;	//de base, une MBox n'est pas un mur
	}
}