package ui.vue;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import ui.vue.option.ControlPanel;

public class WindowPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private final BoxesPanel boxesPanel;
	private final ControlPanel controlPanel;

	/**
	 * Retourne un WindowPanel pour la MazeApp
	 * 
	 * @param mazeApp
	 */
	public WindowPanel(MazeApp mazeApp) {

		setLayout(new BorderLayout());
		add(boxesPanel = new BoxesPanel(mazeApp), BorderLayout.CENTER);
		add(controlPanel = new ControlPanel(mazeApp), BorderLayout.LINE_END);

	}

	public void notifyForUpdate() {
		boxesPanel.notifyForUpdate();
		controlPanel.notifyForUpdate();

	}

}
