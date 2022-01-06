package interface_graphique;

import javax.swing.* ;

public class QuitMenuItem extends JMenuItem
{
   private final MazeApp mazeApp ;

   public QuitMenuItem(final MazeApp mazeApp)
   {
      super("Quit") ; 

      this.mazeApp = mazeApp ;
   }

}