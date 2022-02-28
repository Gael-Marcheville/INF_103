package ui.vue;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ui.model.MazeAppModel;
import ui.vue.menu.MazeMenuBar;

public class MazeApp extends JFrame implements ChangeListener {

	private static final long serialVersionUID = 1L;
	private final Dimension screenSize;
	private final WindowPanel windowPanel;
	private final MazeMenuBar mazeMenuBar;
	private MazeAppModel mazeAppModel;

	/**
	 * Retourne une nouvelle MazeApp en l'initialisant avec le fichier fileName. 5*5
	 * 
	 * @param fileName fichier de démarage correspondant à un Maze. Si le fichier
	 *                 lève une MazeReadingException, un WallMaze 5*5 est créé
	 */
	public MazeApp(String fileName) {
		super("Create your maze ! ");
		mazeAppModel = new MazeAppModel(fileName);
		mazeMenuBar = new MazeMenuBar(this);
		setJMenuBar(mazeMenuBar);
		setContentPane(windowPanel = new WindowPanel(this));
		mazeAppModel.addObserver(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width, screenSize.height);
		setVisible(true);
	}

	/**
	 * Retourne le model associé à MazeApp
	 * 
	 * @return mazeAppModel
	 */
	public MazeAppModel getMazeAppModel() {
		return mazeAppModel;
	}

	/**
	 * Change le Model associé à MazeApp
	 * 
	 * @param mazeAppModel
	 */
	public void setMazeAppModel(MazeAppModel mazeAppModel) {
		this.mazeAppModel = mazeAppModel;
	}

	public void stateChanged(ChangeEvent evt) {
		windowPanel.notifyForUpdate();
	}

}
