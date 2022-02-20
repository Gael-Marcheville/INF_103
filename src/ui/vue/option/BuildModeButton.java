package ui.vue.option;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ui.model.MazeAppModel;

public class BuildModeButton extends JButton
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ui.vue.MazeApp mazeApp ;
	
	public BuildModeButton(final ui.vue.MazeApp mazeApp) 
	{
		super("Join Build Mode") ; 
		this.mazeApp = mazeApp ;
		MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		
		this.addActionListener(new ActionListener()
		{
			  public void actionPerformed(final ActionEvent e)
			  {  if(mazeAppModel.isBuildMode()){mazeAppModel.setBuildMode(false);}
			     else {mazeAppModel.setBuildMode(true);}
			  }
			});
	}
		
	
	
	public void notifyForUpdate() {
		if (mazeApp.getMazeAppModel().isBuildMode()) {this.setText("Leave Build Mode");}
		else {this.setText("Join Build Mode");}
	}
		
	
}