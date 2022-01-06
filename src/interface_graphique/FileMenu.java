package interface_graphique;

import javax.swing.* ;

import maze.MBox;
import maze.Maze;
import maze.MazeReadingException;

import java.awt.Component;
import java.awt.event.*;

public class FileMenu extends JMenu implements ActionListener
{
   private final QuitMenuItem quitMenuItem ;
   private final LoadMazeMenuItem loadMazeMenuItem ;
   private final BuildMazeMenuItem buildMazeMenuItem;
   private final MazeApp mazeApp;
   
   public FileMenu(MazeApp mazeApp)
   {
      super("File") ; // Text of the menu
      this.mazeApp = mazeApp;
      // Create and add menu items
      add(quitMenuItem = new QuitMenuItem(this.mazeApp)) ;
      add(loadMazeMenuItem = new LoadMazeMenuItem(this.mazeApp)) ;
      add(buildMazeMenuItem = new BuildMazeMenuItem(this.mazeApp)) ;
      quitMenuItem.addActionListener(this);
      loadMazeMenuItem.addActionListener(this);
      buildMazeMenuItem.addActionListener(this);
   }

@Override
public void actionPerformed(ActionEvent e) {
	final String choice = e.getActionCommand();
	switch (choice) {
	case "Quit" :
		System.exit(0);
		break;
	case "Load a Maze" :
		loadMazeMenuItem.loadMaze();
		break;
	case "Build a Maze" :
		buildMazeMenuItem.buildMaze();
		break;
	default :
		break;
	}
	
}

}