package ui.vue.option;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ui.model.MazeAppModel;

public class BuildModeButton extends JButton implements ActionListener {

	private static final long serialVersionUID = 1L;
	/**
	 * Vue courante
	 */
	private final ui.vue.MazeApp mazeApp;

	/**
	 * Retourne un bouton pour activer ou désactiver le mode construction
	 * 
	 * @param mazeApp
	 */
	public BuildModeButton(final ui.vue.MazeApp mazeApp) {
		super("Join Build Mode");
		this.mazeApp = mazeApp;
		this.addActionListener(this);
	}

	public void notifyForUpdate() {
		if (mazeApp.getMazeAppModel().isBuildMode()) {
			this.setText("Leave Build Mode");
		} else {
			this.setText("Join Build Mode");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		if (mazeAppModel.isBuildMode()) {
			mazeAppModel.setBuildMode(false);
		} else {
			mazeAppModel.setBuildMode(true);
		}
	}

}