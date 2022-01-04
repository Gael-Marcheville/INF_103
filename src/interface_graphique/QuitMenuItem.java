package interface_graphique;

import javax.swing.* ;

public class QuitMenuItem extends JMenuItem
{
   private final MazeApp mazeApp ;

   public QuitMenuItem(MazeApp mazeApp)
   {
      super("Quit") ; // Text of menu item

      this.mazeApp = mazeApp ;
   }

}