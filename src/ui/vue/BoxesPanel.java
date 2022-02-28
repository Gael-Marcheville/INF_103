package ui.vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import Interfaces.VertexInterface;
import maze.*;
import ui.model.MazeAppModel;

public class BoxesPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private MazeApp mazeApp;
	private GridLayout gridLayout;
	private final Color MBoxColor = Color.WHITE;
	private final Color ABoxColor = Color.RED;
	private final Color EBoxColor = Color.LIGHT_GRAY;
	private final Color DBoxColor = Color.GREEN;
	private final Color WBoxColor = Color.BLACK;
	private final Color PBoxColor = Color.YELLOW;

	/**
	 * Retourne un objet BoxesPanel, objet graphique représentant un Maze
	 * 
	 * @param mazeApp
	 */
	public BoxesPanel(MazeApp mazeApp) {
		setLayout(gridLayout);
		this.mazeApp = mazeApp;
		fillGrid();

	}

	/**
	 * Remplie la grille du Maze
	 */
	private void fillGrid() {
		this.removeAll();
		final MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		final int width = mazeAppModel.getWidth();
		final int height = mazeAppModel.getHeight();
		this.gridLayout = new GridLayout(height, width);
		setLayout(gridLayout);
		final Maze currentMaze = mazeAppModel.getCurrentMaze();
		final ArrayList<VertexInterface> allVertices = currentMaze.getAllVertices();
		for (VertexInterface x : allVertices) {
			final Color BoxColor;
			if (x instanceof EBox) {
				BoxColor = EBoxColor;
			} else if (x instanceof ABox) {
				BoxColor = ABoxColor;
			} else if (x instanceof DBox) {
				BoxColor = DBoxColor;
			} else if (x instanceof WBox) {
				BoxColor = WBoxColor;
			} else if (x instanceof PBox) {
				BoxColor = PBoxColor;
			} else {
				BoxColor = MBoxColor;
			}

			if (mazeAppModel.isBuildMode()) {
				add(new EditableMBoxPanel(mazeApp, BoxColor, (MBox) x));
			} else {
				add(new MBoxPanel(BoxColor));

			}
		}
		revalidate();
		repaint();
	}

	public void notifyForUpdate() {
		final MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		if (mazeAppModel.isModified()) {
			fillGrid();
		}
	}
}
