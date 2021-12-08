package maze;

public class PBox extends MBox { //box permettant de marquer le circuit

	public PBox(int xpos, int ypos, Maze m) {
		super(xpos, ypos, m);
	}
	public String getType() { 
		return ".";	//renvoie le type de la classe en String
	}

}
