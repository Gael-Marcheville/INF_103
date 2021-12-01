package tp06;

import java.io.FileNotFoundException;

public class MainTest {

	public static void main(String[] args) throws MazeReadingException, FileNotFoundException {
		MBox[][] init = new MBox[1][1];
		Maze maze = new Maze(init);
		maze.initFromTextFile("data/labyrinthe.txt");
		maze.saveToTextFile("data/labyrinthe2.txt");
	}

}
