package interface_graphique;

import javax.swing.* ;

import maze.Maze;
import maze.MazeReadingException;

public class SaveMazeMenuItem extends JMenuItem
{
   private final MazeApp mazeApp ;
   private JFileChooser fc;
   private JTextField  directory = new JTextField(System.getProperty("user.home"), 35);
   private String choosedFile;

   public SaveMazeMenuItem(final MazeApp mazeApp)
   {
      super("Save") ; // Text of menu item

      this.mazeApp = mazeApp ;
      
      
   }
   
   public void saveMaze() {
	    /*fc = new JFileChooser(directory.getText());
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int returnVal = fc.showOpenDialog(SaveMazeMenuItem.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) 
		{
			choosedFile = fc.getSelectedFile().getPath();
			directory.setText(choosedFile);
		} 
		mazeApp.getMaze().saveToTextFile(choosedFile);*/
	   System.out.println("save");
   }
}