package interface_graphique;

import javax.swing.*;

import maze.Maze;

import java.awt.*;

public class WindowPanel extends JPanel
{
    private final MazePanel mazePanel ;
    private final ControlPanel controlPanel;
    
	public WindowPanel(final MazeApp mazeApp,final Maze maze)
	{
		setLayout(new BorderLayout()) ;
		
		add(mazePanel = new MazePanel (mazeApp, maze), BorderLayout.CENTER) ;
		add(controlPanel = new ControlPanel (mazeApp), BorderLayout.LINE_END) ;
	}
}
	