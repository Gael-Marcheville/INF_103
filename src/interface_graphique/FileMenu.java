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
   private final SaveMazeMenuItem saveMazeMenuItem;
   private final MazeApp mazeApp;
   
   public FileMenu(MazeApp mazeApp)
   {
      super("File") ; // Text of the menu
      this.mazeApp = mazeApp;
      // Create and add menu items
      add(loadMazeMenuItem = new LoadMazeMenuItem(this.mazeApp)) ;
      add(saveMazeMenuItem = new SaveMazeMenuItem(this.mazeApp));
      add(buildMazeMenuItem = new BuildMazeMenuItem(this.mazeApp)) ;
      add(quitMenuItem = new QuitMenuItem(this.mazeApp)) ;
      loadMazeMenuItem.addActionListener(this);
      saveMazeMenuItem.addActionListener(this);
      buildMazeMenuItem.addActionListener(this);
      quitMenuItem.addActionListener(this);
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
	case "Save" :
		saveMazeMenuItem.saveMaze();
		break;
	default :
		break;
	}
	
}

}