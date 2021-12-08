package maze;

public class WBox extends MBox{

	public WBox(final int xpos, final int ypos, final Maze m) {
		super(xpos, ypos, m);
	}
	public boolean isWall() { 
		return true;	//les objets de cette classe sont des murs
	}
	public String getType() { 
		return "W";	//renvoie le type de la classe en String
	}
}
