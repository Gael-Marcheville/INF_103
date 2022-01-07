package interface_graphique;

import javax.swing.*;

import maze.GBox;
import maze.MBox;
import maze.Maze;

public class LeaveBuildModeButton extends JButton
{
	private final MazeApp mazeApp ;
	private final Maze maze ;
	
	public LeaveBuildModeButton(final MazeApp mazeApp) 
	{
		super("Leave Build Mode") ; 
		this.maze = mazeApp.getMaze().copy();
		this.mazeApp = mazeApp ;
		
	}
	
}