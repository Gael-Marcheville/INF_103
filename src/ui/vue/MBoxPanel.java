package ui.vue;

import java.awt.*;
import javax.swing.*;

public class MBoxPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Retourne un objet MBoxPanel, Box d'un Maze lorsque le mode construction est
	 * desactivé
	 * 
	 * @param color
	 */
	public MBoxPanel(final Color color) {
		setBackground(color);
		setPreferredSize(new Dimension(50, 50));
	}

}
