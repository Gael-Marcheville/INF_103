package interface_graphique;

import java.awt.*;
import javax.swing.*;

public class MBoxPanel extends JPanel {
	private final MazeApp mazeApp ;
	
	public MBoxPanel(MazeApp mazeApp, Color color)
	{
			this.mazeApp = mazeApp ;
			setBackground(color);
			setPreferredSize(new Dimension(50,50)) ;
	}

}
