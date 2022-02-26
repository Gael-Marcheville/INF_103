package ui.vue.option;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ui.model.MazeAppModel;

public class ChangeBoxButton extends JButton implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ui.vue.MazeApp mazeApp ;
	private final String name;
	
	public ChangeBoxButton(final ui.vue.MazeApp mazeApp, final String name) 
	{   super(name);
		this.name = name;
		this.mazeApp = mazeApp;
		this.addActionListener(this);
	}
	
	private String getType() {

		switch (this.name) {
			case "Empty Box":
				return "Empty";
		case "Move Arrival":
				return "Arrival";
			case "Move Departure":
				return "Departure";
			case "Wall Box":
				return "Wall";
			default :
				return "M";
	}
	
}

	@Override
	public void actionPerformed(ActionEvent e) {
		final MazeAppModel mazeAppModel = this.mazeApp.getMazeAppModel();
		final String type = this.getType();
		mazeAppModel.setBuildModeType(type);
	}
}