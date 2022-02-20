package ui.vue.menu;

import javax.swing.JMenuBar;

import ui.vue.MazeApp;

public class MazeMenuBar extends JMenuBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final FileMenu fileMenu ;
	
	public MazeMenuBar(MazeApp mazeApp) {
		super();
		fileMenu = new FileMenu(mazeApp);
		add(fileMenu);
	}
}
