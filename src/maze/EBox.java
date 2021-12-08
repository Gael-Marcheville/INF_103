package maze;

public class EBox extends MBox{
	
	public EBox(final int xpos,final int ypos,final Maze m) {
		super(xpos, ypos, m);
	}
	public String getType() { 
		return "E";	//renvoie le type de la classe en String
	}
}
