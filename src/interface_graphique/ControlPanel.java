package interface_graphique;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.* ;

import maze.Maze;

public class ControlPanel extends JPanel
{	
	private final SolveButton solveButton;
	private final MazeApp mazeApp;
	
	
	public ControlPanel(final MazeApp mazeApp)
	{	
		this.mazeApp = mazeApp;
		this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 1;
		solveButton = new SolveButton (this.mazeApp);
		add(solveButton,gbc);
		if(mazeApp.getSolveMode()) {solveButton.setText("Hide Solution");}
		solveButton.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  if (mazeApp.getSolveMode()) {
					  mazeApp.setSolveMode(false);
					  final Maze newMaze = mazeApp.getMaze();
					  mazeApp.setMaze(newMaze,false);
				  }
				  else{
					  mazeApp.setSolveMode(true);
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
			  }
			});
		
		if (this.mazeApp.getBuildMode()) {
			ChangeBoxButton wallButton = new ChangeBoxButton(this.mazeApp,"Wall Box");
			ChangeBoxButton emptyButton = new ChangeBoxButton(this.mazeApp,"Empty Box");
			ChangeBoxButton startButton = new ChangeBoxButton(this.mazeApp,"Move Departure");
			ChangeBoxButton endButton = new ChangeBoxButton(this.mazeApp,"Move Arrival");
			LeaveBuildModeButton leaveButton = new LeaveBuildModeButton(this.mazeApp);
			add(wallButton,gbc);	
			add(emptyButton,gbc);	
			add(startButton,gbc);	
			add(endButton,gbc);
			add(leaveButton,gbc);
			leaveButton.addActionListener(new ActionListener()
			{
				  public void actionPerformed(final ActionEvent e)
				  {  
					  mazeApp.setBuildMode(false);
					  final Maze newMaze = mazeApp.getMaze();
					  mazeApp.setMaze(newMaze,false);
				  }
				});
		}
		else {
			JoinBuildModeButton joinButton = new JoinBuildModeButton(this.mazeApp);
			add(joinButton,gbc                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               );
			joinButton.addActionListener(new ActionListener()
			{
				  public void actionPerformed(final ActionEvent e)
				  {  
					  mazeApp.setBuildMode(true);
					  final Maze newMaze = mazeApp.getMaze();
					  mazeApp.setMaze(newMaze,false);
				  }
				});
		}
			
		
	}
}

