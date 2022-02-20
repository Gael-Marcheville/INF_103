package ui.vue.menu.item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import ui.vue.MazeApp;

public class SolveMenuItem extends JMenuItem implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final MazeApp mazeApp;
	
	public SolveMenuItem(MazeApp mazeApp) {
		super("Solve") ;
		this.mazeApp = mazeApp ;
		addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent evt) {
		try {
			mazeApp.getMazeAppModel().setSolveMode(!mazeApp.getMazeAppModel().isSolveMode());
		} catch (Exception  e) {
			e.printStackTrace();
		}
		
	}
}
