package tp06;

import java.io.FileNotFoundException;

import Interfaces.PreviousInterface;
import dijkstra.Dijkstra;
import maze.MBox;
import maze.Maze;
import maze.MazeReadingException;
import maze.PBox;

public class MainTest {

	public static void main(final String[] args) throws MazeReadingException, FileNotFoundException {
		final MBox[][] init = new MBox[1][1];
		final Maze maze = new Maze(init);
		final Maze solution = new Maze(init);
		maze.initFromTextFile("data/labyrinthe.txt");
		solution.initFromTextFile("data/labyrinthe.txt");
		final MBox d = maze.getStart();
		final MBox a = maze.getEnd();
		final PreviousInterface previous = Dijkstra.dijkstra(maze, d);
		MBox t = (MBox) previous.value(a); //On ne remplace pas A
		while (t != d && t != null) {
			final int x = t.getX();
			final int y = t.getY();
			solution.setBox(x, y, new PBox(x, y, solution));
			t = (MBox) previous.value(t);
		}
		if (t == null) {
			System.out.println("pas de solution");
		}
		solution.saveToTextFile("data/labyrinthe2.txt");
	}

}
