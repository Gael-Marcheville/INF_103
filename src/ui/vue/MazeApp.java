package ui.vue;

import java.io.IOException;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import maze.MazeReadingException;
import ui.model.MazeAppModel;
import ui.vue.menu.MazeMenuBar;


public class MazeApp extends JFrame implements ChangeListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Dimension screenSize;
	private final WindowPanel windowPanel;
	private final MazeMenuBar mazeMenuBar ;
	private String fileName;
	private MazeAppModel mazeAppModel;

	
	public MazeApp(String fileName) throws IOException, MazeReadingException {
		super("Create your maze ! ");
		this.fileName = fileName;
		mazeAppModel = new MazeAppModel(fileName);
		mazeMenuBar = new MazeMenuBar(this);
		setJMenuBar(mazeMenuBar);
		setContentPane(windowPanel = new WindowPanel(this));
		mazeAppModel.addObserver(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width,screenSize.height);
		setVisible(true);
	}

	public String getFileName() {return this.fileName;}
	
	public MazeAppModel getMazeAppModel() {
		return mazeAppModel;
	}
	public void setMazeAppModel(MazeAppModel mazeAppModel) {
		this.mazeAppModel = mazeAppModel;
	}


	public void stateChanged(ChangeEvent evt) {
		try {
			windowPanel.notifyForUpdate();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
