package interface_graphique;

import javax.swing.* ;

import maze.Maze;

public class MazeApp extends JFrame
{
	private final MazeMenuBar mazeMenuBar ;
	private final WindowPanel    windowPanel ;
	
	public MazeApp(Maze maze)
	{
		super("Maze Application") ;
		
		setJMenuBar(mazeMenuBar = new MazeMenuBar(this)) ;
		
		setContentPane(windowPanel = new WindowPanel(this,maze)) ;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; 
		pack() ;
		setVisible(true) ;
	}

}
