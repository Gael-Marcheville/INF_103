package interface_graphique;

import javax.swing.* ;
import java.awt.event.*;

public class FileMenu extends JMenu implements ActionListener
{
   private final QuitMenuItem quitMenuItem ;
   private final LoadMazeMenuItem loadMazeMenuItem ;

   public FileMenu(MazeApp mazeApp)
   {
      super("File") ; // Text of the menu

      // Create and add menu items
      add(quitMenuItem = new QuitMenuItem(mazeApp)) ;
      add(loadMazeMenuItem = new LoadMazeMenuItem(mazeApp)) ;
      quitMenuItem.addActionListener(this);
   }

@Override
public void actionPerformed(ActionEvent e) {
	String choice = e.getActionCommand();
	switch (choice) {
	case "Quit" :
		System.exit(0);
		break;
	case "loadMazeMenuItem" :
		break;
	default :
		break;
	}
	
}

}