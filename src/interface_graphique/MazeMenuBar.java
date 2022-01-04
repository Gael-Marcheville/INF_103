package interface_graphique;

import javax.swing.* ;

public class MazeMenuBar extends JMenuBar
{

	private final FileMenu fileMenu ;
	
	public MazeMenuBar(MazeApp mazeApp)
	{
		super() ;
		
		// Create and add menus
		add(fileMenu = new FileMenu(mazeApp)) ;
	}
}