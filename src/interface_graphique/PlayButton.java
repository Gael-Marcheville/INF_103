package interface_graphique;

import javax.swing.*;

import maze.GBox;
import maze.MBox;
import maze.Maze;

public class PlayButton extends JButton
{
	private final MazeApp mazeApp ;
	private final Maze maze ;
	private GBox pos ; //position du joueur
	
	public PlayButton(final MazeApp mazeApp) 
	{
		super("Play") ; 
		this.maze = mazeApp.getMaze().copy();
		this.mazeApp = mazeApp ;
		
	}
	
}