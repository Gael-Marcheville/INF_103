package interface_graphique;

import javax.swing.* ;

import maze.EBox;
import maze.MBox;
import maze.Maze;
import maze.WBox;

public class BuildMazeMenuItem extends JMenuItem
{
   private final MazeApp mazeApp ;

   public BuildMazeMenuItem(final MazeApp mazeApp)
   {
      super("Build a Maze") ; // Text of menu item

      this.mazeApp = mazeApp ;
   }
   
   public void buildMaze() {
	   int n = (int) Double.parseDouble(
	            JOptionPane.showInputDialog(this, "Height:"));
	   int m = (int) Double.parseDouble(
	            JOptionPane.showInputDialog(this, "Width:"));
	   final Boolean e;
	   Object[] options = {"Wall Background please",
               "Empty Background please"};
	   int option = JOptionPane.showOptionDialog(this, "What do you prefer", "Start Build", JOptionPane.YES_NO_CANCEL_OPTION, 2, null, options, "Cancel");
	   if (option == 1) {
		   e = true;
	   }
	   else {
		   e = false;
	   }
	    
	   //boolean e = Boolean.parseBoolean(
	   //         JOptionPane.showInputDialog(this, "Yes for Empty background, No for Wall Background"));
	   final Maze newMaze = new Maze(new MBox[n][m]);
	   if (e) {
	   for (int k = 0; k < n; k++) {
		   for (int j = 0; j < m; j++) {
			   newMaze.setBox(k, j, new EBox(k,j,newMaze));
		   }
	   }
	   }
	   else {
		   for (int k = 0; k < n; k++) {
			   for (int j = 0; j < m; j++) {
				   newMaze.setBox(k, j, new WBox(k,j,newMaze));
			   }
		   }
		   }
	   
	   this.mazeApp.setMaze(newMaze, true);
	}
   }
