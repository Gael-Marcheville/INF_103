package ui.vue.menu.item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

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
		MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		
		int response = JOptionPane.showInternalOptionDialog(this, " Export the maze?", "Export ?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
		switch(response) {
		case JOptionPane.CANCEL_OPTION :
			return ;
		case JOptionPane.OK_OPTION :
			try {
				mazeAppModel.export();
				System.out.println("Maze exported as 'export.txt'");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case JOptionPane.NO_OPTION :
			break;
		}	
	}	
}
