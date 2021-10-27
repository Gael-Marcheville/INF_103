package tp06;

public class WBox extends MBox{

	public WBox(int xpos, int ypos, Maze m) {
		super(xpos, ypos, m);
	}
	public boolean isWall() { 
		return true;	//les objets de cette classe sont des murs
	}
}
