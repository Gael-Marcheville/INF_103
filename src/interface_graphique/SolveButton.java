package interface_graphique;

import javax.swing.*;

public class SolveButton extends JButton
{
	private final MazeApp mazeApp ;
	
	public SolveButton(final MazeApp mazeApp)
	{
		super("Solve") ; 
		
		this.mazeApp = mazeApp ;
	}
}