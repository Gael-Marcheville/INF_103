package interface_graphique;

import javax.swing.*;

import maze.Maze;

import java.awt.*;

public class WindowPanel extends JPanel
{
    private final MazePanel mazePanel ;
    
	public WindowPanel(MazeApp mazeApp, Maze maze)
	{
		setLayout(new BorderLayout()) ;
		
		add(mazePanel = new MazePanel (mazeApp, maze), BorderLayout.CENTER) ;
		}
}
	