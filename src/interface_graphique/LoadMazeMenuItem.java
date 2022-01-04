package interface_graphique;

import javax.swing.* ;

public class LoadMazeMenuItem extends JMenuItem
{
   private final MazeApp mazeApp ;

   public LoadMazeMenuItem(MazeApp mazeApp)
   {
      super("Load a Maze") ; // Text of menu item

      this.mazeApp = mazeApp ;
   }

}