package maze;

public class DBox extends MBox {

	public DBox(final int xpos, final int ypos, final Maze m) {
		super(xpos, ypos, m);
	}
	public String getType() { 
		return "D";	//renvoie le type de la classe en String
	}

}
