package ui.vue.menu.item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import ui.model.MazeAppModel;
import ui.vue.MazeApp;

public class ExportMenuItem extends JMenuItem implements ActionListener  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final MazeApp mazeApp;
	
	public ExportMenuItem(MazeApp mazeApp) {
		super("Export") ;
		this.mazeApp = mazeApp ;		
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evt) {
		final MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		mazeAppModel.export();
}
}
