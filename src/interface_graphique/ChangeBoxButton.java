package interface_graphique;

import javax.swing.*;

import maze.GBox;
import maze.MBox;
import maze.Maze;

public class ChangeBoxButton extends JButton
{
	private final MazeApp mazeApp ;
	private final Maze maze ;
	private GBox pos ; //position du joueur
	
	public ChangeBoxButton(final MazeApp mazeApp, final String type) 
	{
		super(type) ; 
		this.maze = mazeApp.getMaze().copy();
		this.mazeApp = mazeApp ;
		
	}
	
}