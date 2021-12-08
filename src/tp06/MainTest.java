package tp06;

import java.io.FileNotFoundException;

import Interfaces.PreviousInterface;
import dijkstra.Dijkstra;
import maze.MBox;
import maze.Maze;
import maze.MazeReadingException;
import maze.PBox;

public class MainTest {

	public static void main(String[] args) throws MazeReadingException, FileNotFoundException {
		MBox[][] init = new MBox[1][1];
		Maze maze = new Maze(init);
		Maze solution = new Maze(init);
		maze.initFromTextFile("data/labyrinthe.txt");
		solution.initFromTextFile("data/labyrinthe.txt");
		MBox d = maze.getStart();
		MBox a = maze.getEnd();
		PreviousInterface previous = Dijkstra.dijkstra(maze, d);
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
