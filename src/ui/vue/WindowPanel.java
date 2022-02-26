package ui.vue;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JPanel;

import ui.vue.option.ControlPanel;


public class WindowPanel extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final BoxesPanel boxesPanel ;
	private final ControlPanel controlPanel;
	
	public WindowPanel(MazeApp mazeApp) throws IOException {
	
		setLayout(new BorderLayout());
		add(boxesPanel = new BoxesPanel(mazeApp), BorderLayout.CENTER);
		add(controlPanel = new ControlPanel(mazeApp), BorderLayout.LINE_END);

	}

	public void notifyForUpdate() throws IOException {
		boxesPanel.notifyForUpdate();
		controlPanel.notifyForUpdate();

	}
	
}
