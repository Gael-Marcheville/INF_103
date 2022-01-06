package interface_graphique;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.* ;

import Interfaces.VertexInterface;
import maze.MBox;
import maze.Maze;

public class MazePanel extends JPanel
{
	private final Color MBoxColor = Color.WHITE; //à voir
	private final Color ABoxColor = Color.RED;
	private final Color EBoxColor = Color.LIGHT_GRAY;
	private final Color DBoxColor = Color.GREEN;
	private final Color WBoxColor = Color.BLACK;
	private final Color PBoxColor = Color.YELLOW;
	private final Color GBoxColor = Color.BLUE;
	
	
	public MazePanel(final MazeApp mazeApp, final Maze maze)
	{
		setLayout(new GridLayout(maze.getHeight(),maze.getWeight())) ; 
		final ArrayList<VertexInterface> allVertices = maze.getAllVertices();
		for (VertexInterface x : allVertices) {
			final String type = ((MBox) x).getType();
			switch (type) {
				case "E":
					add(new MBoxPanel (mazeApp,EBoxColor));
					break;
				case "A":
					add(new MBoxPanel (mazeApp,ABoxColor));
					break;
				case "D":
					add(new MBoxPanel (mazeApp,DBoxColor));	
					break;
				case "W":
					add(new MBoxPanel (mazeApp,WBoxColor));	
					break;
				case ".":
					add(new MBoxPanel (mazeApp,PBoxColor));	
					break;
				case "G":
					add(new MBoxPanel (mazeApp,GBoxColor));
				default :
					add(new MBoxPanel (mazeApp,MBoxColor));	
					break;
			}
		}
	}
}

