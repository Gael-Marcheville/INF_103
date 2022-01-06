package interface_graphique;

import javax.swing.* ;

import maze.Maze;
import maze.MazeReadingException;

public class LoadMazeMenuItem extends JMenuItem
{
   private final MazeApp mazeApp ;
   private JFileChooser fc;
   private JTextField  directory = new JTextField(System.getProperty("user.home"), 35);
   private String choosedFile;

   public LoadMazeMenuItem(final MazeApp mazeApp)
   {
      super("Load a Maze") ; // Text of menu item

      this.mazeApp = mazeApp ;
      
      
   }
   
   public void loadMaze() {
	    fc = new JFileChooser(directory.getText());
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int returnVal = fc.showOpenDialog(LoadMazeMenuItem.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) 
		{
			choosedFile = fc.getSelectedFile().getPath();
			directory.setText(choosedFile);
		} 
		final Maze maze = new Maze();
		try {
			maze.initFromTextFile(choosedFile);
			mazeApp.setMaze(maze,true);
		} catch (MazeReadingException e1) {
			JOptionPane.showMessageDialog(LoadMazeMenuItem.this, e1);
			e1.printStackTrace();
		}
   }
}