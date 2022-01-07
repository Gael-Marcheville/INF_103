package interface_graphique;

import javax.swing.* ;

import maze.ABox;
import maze.DBox;
import maze.EBox;
import maze.MBox;
import maze.Maze;
import maze.WBox;

public class BuildMazeMenuItem extends JMenuItem
{
   private final MazeApp mazeApp ;

   public BuildMazeMenuItem(final MazeApp mazeApp)
   {
      super("Build a new Maze") ; // Text of menu item

      this.mazeApp = mazeApp ;
   }
   
   public void buildMaze() {
	   this.mazeApp.setBuildMode(true);
	   int n = (int) Double.parseDouble(
	            JOptionPane.showInputDialog(this, "Height:"));
	   int m = (int) Double.parseDouble(
	            JOptionPane.showInputDialog(this, "Width:"));
	   final Maze newMaze = new Maze(new MBox[n][m]);
	   /*
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
	   */
	   for (int k = 0; k < n; k++) {
		   for (int j = 0; j < m; j++) {
			   newMaze.setBox(k, j, new EBox(k,j,newMaze));
		   }
	   }
	   newMaze.setBox(0,0,new DBox(0,0,newMaze));
	   newMaze.setBox(n-1,m-1,new ABox(n-1,m-1,newMaze));
	   this.mazeApp.setMaze(newMaze, true);
	}
   }
