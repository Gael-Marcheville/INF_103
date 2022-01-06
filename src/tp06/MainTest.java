package tp06;

import java.io.FileNotFoundException;

import Interfaces.PreviousInterface;
import dijkstra.Dijkstra;
import interface_graphique.MazeApp;
import maze.MBox;
import maze.Maze;
import maze.MazeReadingException;
import maze.PBox;

public class MainTest {

	public static void main(final String[] args) throws Exception {
		final MBox[][] init = new MBox[1][1];
		final Maze maze = new Maze(init);
		maze.initFromTextFile("data/labyrinthe.txt");
		new MazeApp(maze);
	}

}
