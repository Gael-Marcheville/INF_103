package ui.vue.option;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ui.model.MazeAppModel;

public class SolveButton extends JButton implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final ui.vue.MazeApp mazeApp;

	/**
	 * Retourne un bouton pour activer ou désactiver le mode solution
	 * 
	 * @param mazeApp
	 */
	public SolveButton(final ui.vue.MazeApp mazeApp) {
		super("Solve");

		this.mazeApp = mazeApp;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		if (mazeAppModel.isSolveMode()) {
			mazeAppModel.setSolveMode(false);
		} else {
			mazeAppModel.setSolveMode(true);
		}
	}

	public void notifyForUpdate() {
		if (mazeApp.getMazeAppModel().isSolveMode()) {
			this.setText("Hide Solution");
		} else {
			this.setText("Solve");
		}

	}

}
