package tp06;

public class MainTest {

	public static void main(String[] args) throws MazeReadingException {
		MBox[][] init = new MBox[1][1];
		Maze maze = new Maze(init);
		maze.initFromTextFile("data/labyrinthe.txt");
	}

}
