package interface_graphique;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.* ;

import Interfaces.VertexInterface;
import maze.ABox;
import maze.DBox;
import maze.EBox;
import maze.GBox;
import maze.MBox;
import maze.Maze;
import maze.PBox;
import maze.WBox;

public class MazePanel extends JPanel
{
	private final Color MBoxColor = Color.WHITE; //à voir
	private final Color ABoxColor = Color.RED;
	private final Color EBoxColor = Color.LIGHT_GRAY;
	private final Color DBoxColor = Color.GREEN;
	private final Color WBoxColor = Color.BLACK;
	private final Color PBoxColor = Color.YELLOW;
	private final Color GBoxColor = Color.BLUE;
	
	
	public MazePanel(final MazeApp mazeApp, final Maze maze)
	{
		setLayout(new GridLayout(maze.getHeight(),maze.getWeight())) ; 
		final ArrayList<VertexInterface> allVertices = maze.getAllVertices();
		for (VertexInterface x : allVertices) {
			final Color BoxColor;
			if (x instanceof EBox) {BoxColor = EBoxColor;}
			else if (x instanceof ABox) {BoxColor = ABoxColor;}
			else if (x instanceof DBox) {BoxColor = DBoxColor;}
			else if (x instanceof WBox) {BoxColor = WBoxColor;}
			else if (x instanceof PBox) {BoxColor = PBoxColor;}
			else if (x instanceof GBox) {BoxColor = GBoxColor;}
			else {BoxColor = MBoxColor;}
			
			if(mazeApp.getBuildMode()) {
				EditableMBoxPanel newMBoxPanel = new EditableMBoxPanel (mazeApp,BoxColor);
				add(newMBoxPanel);
				newMBoxPanel.addActionListener(new ActionListener()
				{
					  public void actionPerformed(final ActionEvent e)
					  {   final Maze maze = mazeApp.getMaze();
			  	  	  try {
						  int X = ((MBox) x).getX();
				  	  	  int Y = ((MBox) x).getY();
				  	  	  int dX = maze.getStart().getX();
						  int dY = maze.getStart().getY();
				  	  	  int aX = maze.getEnd().getX();
				  	  	  int aY = maze.getEnd().getY();
				  	  	if (x instanceof EBox && mazeApp.getBuildModeType() == "W") {maze.setBox(X, Y, new WBox(X,Y,maze));}
						else if (x instanceof WBox && mazeApp.getBuildModeType() == "E") {maze.setBox(X, Y, new EBox(X,Y,maze));}
						else if (x instanceof EBox && mazeApp.getBuildModeType() == "D") {
			  	  	  		maze.setBox(X, Y, new DBox(X,Y,maze));
			  	  	  		maze.setBox(dX, dY, new EBox(dX,dY,maze));}
						else if (x instanceof WBox && mazeApp.getBuildModeType() == "D") {
			  	  	  		maze.setBox(X, Y, new DBox(X,Y,maze));
			  	  	  		maze.setBox(dX, dY, new WBox(dX,dY,maze));}
						else if (x instanceof EBox && mazeApp.getBuildModeType() == "A") {
			  	  	  		maze.setBox(X, Y, new ABox(X,Y,maze));
		  	  	  			maze.setBox(aX, aY, new EBox(aX,aY,maze));}
						else if (x instanceof WBox && mazeApp.getBuildModeType() == "A") {
			  	  	  		maze.setBox(X, Y, new ABox(X,Y,maze));
			  	  	  		maze.setBox(aX, aY, new WBox(aX,aY,maze));}
						  mazeApp.setMaze(maze, false);
						  System.out.println(x.getClass().getName().charAt(5) + mazeApp.getBuildModeType());

						} catch (Exception e1) {
							e1.printStackTrace();
							System.out.println(e1);
						}
					  }
					});
			}
			else {
				MBoxPanel newMBoxPanel = new MBoxPanel (mazeApp,BoxColor);
				add(newMBoxPanel);
				
			}
		}
	}
}

