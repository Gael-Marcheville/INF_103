package interface_graphique;

import javax.swing.*;

import maze.GBox;
import maze.MBox;
import maze.Maze;

public class JoinBuildModeButton extends JButton
{
	private final MazeApp mazeApp ;
	private final Maze maze ;
	
	public JoinBuildModeButton(final MazeApp mazeApp) 
	{
		super("Join Build Mode") ; 
		this.maze = mazeApp.getMaze().copy();
		this.mazeApp = mazeApp ;
		
	}
	
}