package ui.vue.option;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ui.model.MazeAppModel;

public class SolveButton extends JButton
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ui.vue.MazeApp mazeApp ;
	
	public SolveButton(final ui.vue.MazeApp mazeApp)
	{
		super("Solve") ; 
		
		this.mazeApp = mazeApp ;
		MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		this.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  if (mazeAppModel.isSolveMode()) {
					  mazeAppModel.setSolveMode(false);
				  }
				  else{
					  mazeAppModel.setSolveMode(true);
					//if (newMaze == null) {
					//	JOptionPane.showMessageDialog(ControlPanel.this, "No Solution");
					//}
				} 
				}
			
			});
	}
	
	public void notifyForUpdate() {
		if (mazeApp.getMazeAppModel().isSolveMode()) {this.setText("Hide Solution");}
		else {this.setText("Solve");}
		
}
	
}