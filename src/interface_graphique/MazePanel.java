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
	
	
	public MazePanel(MazeApp mazeApp, Maze maze)
	{
		setLayout(new GridLayout(maze.getHeight(),maze.getWeight())) ; 
		ArrayList<VertexInterface> allVertices = maze.getAllVertices();
		for (VertexInterface x : allVertices) {
			String type = ((MBox) x).getType();
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
				default :
					add(new MBoxPanel (mazeApp,MBoxColor));	
					break;
			}
		}
	}
}

