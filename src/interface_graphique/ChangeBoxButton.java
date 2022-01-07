package interface_graphique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import maze.GBox;
import maze.MBox;
import maze.Maze;

public class ChangeBoxButton extends JButton
{
	private final MazeApp mazeApp ;
	private final Maze maze ;
	private final String name;
	private GBox pos ; //position du joueur
	
	public ChangeBoxButton(final MazeApp mazeApp, final String name) 
	{   super(name);
		this.name = name;
		this.maze = mazeApp.getMaze().copy();
		this.mazeApp = mazeApp ;
		final String type = this.getType();
		
		this.addActionListener(new ActionListener()
		{
			  public void actionPerformed(final ActionEvent e)
			  {  
				  mazeApp.setBuildModeType(type);
			  }
			});
	}
	
	private String getType() {

		switch (this.name) {
			case "Empty Box":
				return "E";
		case "Move Arrival":
				return "A";
			case "Move Departure":
				return "D";
			case "Wall Box":
				return "W";
			default :
				return "M";
	}
	
}
}