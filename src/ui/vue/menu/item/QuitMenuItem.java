package ui.vue.menu.item;

import java.awt.event.*;

import javax.swing.*;

import ui.model.MazeAppModel;
import ui.vue.MazeApp;

public class QuitMenuItem extends JMenuItem implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final MazeApp mazeApp;

	/**
	 * Retourne un Item destiné à quitter l'application MazeApp, pour FileMenu
	 * 
	 * @param mazeApp
	 */
	public QuitMenuItem(MazeApp mazeApp) {
		super("Quit");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt) {
		final MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		mazeAppModel.export_with_warning();
		System.exit(0);

	}
}