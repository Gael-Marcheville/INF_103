package interface_graphique;

import javax.swing.* ;
import java.awt.*;

import maze.Maze;

public class MazeApp extends JFrame
{
	private final MazeMenuBar mazeMenuBar ;
	private Maze maze;
	private boolean buildMode;
	private String buildModeType;
	
	public MazeApp(final Maze maze)
	{
		super("Maze Application") ;
		this.maze = maze;
		this.buildMode = false;
		setJMenuBar(mazeMenuBar = new MazeMenuBar(this)) ;
		this.setMaze(this.maze, true);
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
	
	public void setBuildMode(final boolean buildMode) {
		this.buildMode = buildMode;
		this.buildModeType = "W";
	}
	
	public boolean getBuildMode() {
		return this.buildMode; 
	}
	
	public void setBuildModeType(final String buildModeType) {
		this.buildModeType = buildModeType;
	}
	
	public String getBuildModeType() {
		return this.buildModeType; 
	}

}
