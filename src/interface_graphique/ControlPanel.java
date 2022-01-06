package interface_graphique;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.* ;

import maze.Maze;

public class ControlPanel extends JPanel
{	
	private final PlayButton playButton;
	private final SolveButton solveButton;
	private final MazeApp mazeApp;
	
	
	public ControlPanel(final MazeApp mazeApp)
	{	this.mazeApp = mazeApp;
		playButton = new PlayButton (this.mazeApp);
		solveButton = new SolveButton (this.mazeApp);
		add(playButton);	
		add(solveButton);	
		
		playButton.addActionListener(new ActionListener()
		{
			  public void actionPerformed(final ActionEvent e)
			  {  
				  final Maze newMaze = mazeApp.getMaze();
				  mazeApp.setMaze(newMaze,false);
			  }
			});
		solveButton.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  try {
					final Maze newMaze = mazeApp.getMaze().solveMaze();
					if (newMaze == null) {
						JOptionPane.showMessageDialog(ControlPanel.this, "No Solution");
					}
					else {
					mazeApp.setMaze(newMaze,false);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			  }
			});
	}
}

