package ui.vue.menu;

import javax.swing.JMenu;

import ui.vue.MazeApp;
import ui.vue.menu.item.*;

public class FileMenu extends JMenu {

	private static final long serialVersionUID = 1L;
	private final QuitMenuItem quitMenuItem;
	private final LoadMazeMenuItem loadMazeMenuItem;
	private final ExportMenuItem exportMenuItem;

	/**
	 * Retourne un Item File pour la barre de Menu de la MazeApp
	 * 
	 * @param mazeApp
	 */
	public FileMenu(MazeApp mazeApp) {
		super("File");
		quitMenuItem = new QuitMenuItem(mazeApp);
		loadMazeMenuItem = new LoadMazeMenuItem(mazeApp);
		exportMenuItem = new ExportMenuItem(mazeApp);
		add(quitMenuItem);
		add(loadMazeMenuItem);
		add(exportMenuItem);

	}

}
