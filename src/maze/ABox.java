package maze;

public class ABox extends MBox{

	public ABox(final int xpos, final int ypos, final Maze m) {
		super(xpos, ypos, m);
	}
	public String getType() { 
		return "A";	//renvoie le type de la classe en String
	}

	
}
