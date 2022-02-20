package ui.vue.option;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ui.model.MazeAppModel;

public class ChangeBoxButton extends JButton
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
		final MazeAppModel mazeAppModel = this.mazeApp.getMazeAppModel();
		final String type = this.getType();
		this.addActionListener(new ActionListener()
		{
			  public void actionPerformed(final ActionEvent e)
			  {  
				  mazeAppModel.setBuildModeType(type);
			  }
			});
	}
	
	private String getType() {

		switch (this.name) {
			case "Empty Box":
				return "E";
		case "Move Arrival":
				return "A";
			case "Move Departure":
				return "D";
			case "Wall Box":
				return "W";
			default :
				return "M";
	}
	
}
}