package ui.vue;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ui.model.MazeAppModel;
import ui.vue.menu.MazeMenuBar;


public class MazeApp extends JFrame implements ChangeListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private final WindowPanel windowPanel;
	private final MazeMenuBar mazeMenuBar ;
	private String fileName;
	private MazeAppModel mazeAppModel = new MazeAppModel();

	
	public MazeApp(String fileName) throws IOException {
		super("Create your maze ! ");
		this.fileName = fileName;
		mazeMenuBar = new MazeMenuBar(this);
		setJMenuBar(mazeMenuBar);
		setContentPane(windowPanel = new WindowPanel(this));
		mazeAppModel.addObserver(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
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
