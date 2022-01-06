package interface_graphique;

import javax.swing.* ;
import java.awt.*;

import maze.Maze;

public class MazeApp extends JFrame
{
	private final MazeMenuBar mazeMenuBar ;
	private Maze maze;
	
	public MazeApp(final Maze maze)
	{
		super("Maze Application") ;
		this.maze = maze;
		
		setJMenuBar(mazeMenuBar = new MazeMenuBar(this)) ;
		
		setContentPane(new WindowPanel(this,this.maze)) ; //on ne définie pas la variable windowPanel car elle doit pouvoir changer si on charge un nouveau maze
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; 
		final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width,screenSize.height);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true) ;
	}
	
	public void setMaze(final Maze newMaze, final Boolean changeThisMaze)
	{	
		setContentPane(new WindowPanel(this,newMaze)) ;
		if (changeThisMaze) {
		this.maze = newMaze;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; 
		final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width,screenSize.height);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
		setVisible(true) ;
	}
	
	public Maze getMaze() {
		return this.maze;
	}

}
