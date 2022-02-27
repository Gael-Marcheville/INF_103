package ui.vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

import Interfaces.VertexInterface;
import maze.ABox;
import maze.DBox;
import maze.EBox;
import maze.GBox;
import maze.MBox;
import maze.Maze;
import maze.PBox;
import maze.WBox;
import ui.model.MazeAppModel;

public class BoxesPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*private int width ;
	private int height ;*/
	private MazeApp mazeApp; 
	private GridLayout gridLayout;
	private final Color MBoxColor = Color.WHITE; //à voir
	private final Color ABoxColor = Color.RED;
	private final Color EBoxColor = Color.LIGHT_GRAY;
	private final Color DBoxColor = Color.GREEN;
	private final Color WBoxColor = Color.BLACK;
	private final Color PBoxColor = Color.YELLOW;
	private final Color GBoxColor = Color.BLUE;
	
	public BoxesPanel(MazeApp mazeApp) throws IOException {
		setLayout(gridLayout);
		this.mazeApp = mazeApp ;
		//addMouseListener(boxesPanelMouseListener);
		fillGrid();
		
	}
	
    private void fillGrid() throws IOException {
        this.removeAll();
		final MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		final int width = mazeAppModel.getWidth();
		final int height = mazeAppModel.getHeight();	
		this.gridLayout = new GridLayout(height,width);
		setLayout(gridLayout); 
		final Maze currentMaze = mazeAppModel.getCurrentMaze();
		final ArrayList<VertexInterface> allVertices = currentMaze.getAllVertices();
		for (VertexInterface x : allVertices) {
			final Color BoxColor;
			if (x instanceof EBox) {BoxColor = EBoxColor;}
			else if (x instanceof ABox) {BoxColor = ABoxColor;}
			else if (x instanceof DBox) {BoxColor = DBoxColor;}
			else if (x instanceof WBox) {BoxColor = WBoxColor;}
			else if (x instanceof PBox) {BoxColor = PBoxColor;}
			else if (x instanceof GBox) {BoxColor = GBoxColor;}
			else {BoxColor = MBoxColor;}
			
			if(mazeAppModel.isBuildMode()) {
				add(new EditableMBoxPanel (mazeApp,BoxColor, (MBox) x));
			}
			else {
				add(new MBoxPanel (mazeApp,BoxColor));
				
			}
		}
        revalidate();
        repaint();
    }

	public void notifyForUpdate() throws IOException {
		final MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		if(mazeAppModel.isModified()) {
			fillGrid();
		}
	}
}
