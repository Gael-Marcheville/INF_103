package maze;

public class PBox extends MBox { //box permettant de marquer le circuit

	public PBox(final int xpos, final int ypos, final Maze m) {
		super(xpos, ypos, m);
	}
	public String getType() { 
		return ".";	//renvoie le type de la classe en String
	}

}
