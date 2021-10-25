package tp06;

public class MBox {
	private final int x; //attribut position abscisse
	private final int y; //attribut position ordonné
	private Maze maze;
	
	public MBox(int xpos, int ypos)
	{
		x = xpos;
		y = ypos;
		this.maze = Main.getMaze();
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
}
