package ui.vue;

import java.awt.*;
import javax.swing.*;

public class MBoxPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private final MazeApp mazeApp ;
	
	public MBoxPanel(final MazeApp mazeApp, final Color color)
	{
			this.mazeApp = mazeApp ;
			setBackground(color);
			setPreferredSize(new Dimension(50,50)) ;
	}

}
