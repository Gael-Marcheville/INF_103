package ui.vue.option;

import java.awt.*;

import javax.swing.*;

import ui.model.MazeAppModel;
import ui.vue.MazeApp;

public class ControlPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private final MazeApp mazeApp;
	private GridBagLayout layout;
	private final GridBagConstraints gbc;
	private final SolveButton solveButton;
	private final ResetButton resetButton;
	final BuildModeButton buildModeButton;

	/**
	 * Retourne un centre de contrôle pour résoudre le Maze courant, le modifier
	 * (mode construction) ou en créer un nouveau
	 * 
	 * @param mazeApp
	 */
	public ControlPanel(final MazeApp mazeApp) {
		this.mazeApp = mazeApp;
		layout = new GridBagLayout();
		this.setLayout(layout);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 1;
		solveButton = new SolveButton(this.mazeApp);
		buildModeButton = new BuildModeButton(this.mazeApp);
		resetButton = new ResetButton(this.mazeApp);
		fillPanel();

	}

	/**
	 * Permet de remplir le centre de contrôle
	 * 
	 */
	private void fillPanel() {
		final MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		if (mazeAppModel.isBuildMode()) {
			final ChangeBoxButton wallButton = new ChangeBoxButton(this.mazeApp, "Wall Box");
			final ChangeBoxButton emptyButton = new ChangeBoxButton(this.mazeApp, "Empty Box");
			final ChangeBoxButton startButton = new ChangeBoxButton(this.mazeApp, "Move Departure");
			final ChangeBoxButton endButton = new ChangeBoxButton(this.mazeApp, "Move Arrival");
			add(wallButton, gbc);
			add(emptyButton, gbc);
			add(startButton, gbc);
			add(endButton, gbc);
		}

		else {
			add(resetButton, gbc);
			add(solveButton, gbc);
		}
		add(buildModeButton, gbc);

	}

	public void notifyForUpdate() {
		this.removeAll();
		layout = new GridBagLayout();
		fillPanel();
		solveButton.notifyForUpdate();
		buildModeButton.notifyForUpdate();
	}
}