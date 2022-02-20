package ui.vue.menu.item;

import java.awt.event.*;

import javax.swing.*;

import ui.model.MazeAppModel;
import ui.vue.MazeApp;

public class QuitMenuItem extends JMenuItem implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final MazeApp mazeApp;
	
	public QuitMenuItem(MazeApp mazeApp) {
		super("Quit") ;
		this.mazeApp = mazeApp ;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt) {
		MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		
		int response = JOptionPane.showInternalOptionDialog(this, "Maze not saved. Export it?", "Quit Application", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
		switch(response) {
		case JOptionPane.CANCEL_OPTION :
			return ;
		case JOptionPane.OK_OPTION :
			try {
				mazeAppModel.export();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case JOptionPane.NO_OPTION :
			break;
		}
		System.exit(0);
	
	}
}