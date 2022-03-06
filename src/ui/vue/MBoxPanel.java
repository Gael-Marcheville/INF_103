package ui.vue;

import java.awt.*;
import javax.swing.*;

public class MBoxPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Color color;

	/**
	 * Retourne un objet MBoxPanel, Box d'un Maze lorsque le mode construction est
	 * desactivé
	 * 
	 * @param color
	 */
	public MBoxPanel(final Color color) {
		this.color = color;
		setBackground(color);
		setPreferredSize(new Dimension(40, 40));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int h = this.getHeight();
		int w = this.getWidth();
		if (color == Color.ORANGE) {
			g.drawLine(0, 0, w, 0);
			g.drawLine(0, h / 4, w, h / 4);
			g.drawLine(0, h / 2, w, h / 2);
			g.drawLine(0, h * 3 / 4, w, h * 3 / 4);
			g.drawLine(0, 0, 0, h / 4);
			g.drawLine(w / 2, 0, w / 2, h / 4);
			g.drawLine(w / 4, h / 4, w / 4, h / 2);
			g.drawLine(w * 3 / 4, h / 4, w * 3 / 4, h / 2);
			g.drawLine(0, h / 2, 0, h * 3 / 4);
			g.drawLine(w / 2, h / 2, w / 2, h * 3 / 4);
			g.drawLine(w / 4, h * 3 / 4, w / 4, h);
			g.drawLine(w * 3 / 4, h * 3 / 4, w * 3 / 4, h);
		}

		g.drawLine(w, 0, w, h);
		g.drawLine(0, 0, w, 0);
		g.drawLine(0, h, w, h);
		g.drawLine(0, 0, 0, h);

	}

}
