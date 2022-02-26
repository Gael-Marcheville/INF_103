package ui.vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import maze.ABox;
import maze.DBox;
import maze.EBox;
import maze.MBox;
import maze.Maze;
import maze.WBox;
import ui.model.MazeAppModel;

public class EditableMBoxPanel extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ui.vue.MazeApp mazeApp ;
	
	public EditableMBoxPanel(ui.vue.MazeApp mazeApp, Color color, MBox mBox)
	{
			this.mazeApp = mazeApp ;
			setBackground(color);
			setPreferredSize(new Dimension(50,50)) ;
			final MazeAppModel mazeAppModel = this.mazeApp.getMazeAppModel();
			final Maze currentMaze = mazeAppModel.getCurrentMaze();
			this.addActionListener(new ActionListener()
			{
				  public void actionPerformed(final ActionEvent e)
				  {   try {
					  int X = mBox.getX();
			  	  	  int Y = mBox.getY();
			  	  	  int dX = currentMaze.getStart().getX();
					  int dY = currentMaze.getStart().getY();
			  	  	  int aX = currentMaze.getEnd().getX();
			  	  	  int aY = currentMaze.getEnd().getY();
			  	  	if (mBox instanceof EBox && mazeAppModel.getBuildModeType() == "Wall") {mazeAppModel.setBox(X, Y, new WBox(X,Y,currentMaze));}
					else if (mBox instanceof WBox && mazeAppModel.getBuildModeType() == "Empty") {mazeAppModel.setBox(X, Y, new EBox(X,Y,currentMaze));}
					else if (mBox instanceof EBox && mazeAppModel.getBuildModeType() == "Departure") {
		  	  	  		mazeAppModel.setBox(X, Y, new DBox(X,Y,currentMaze));
		  	  	  		mazeAppModel.setBox(dX, dY, new EBox(dX,dY,currentMaze));}
					else if (mBox instanceof WBox && mazeAppModel.getBuildModeType() == "Departure") {
		  	  	  		mazeAppModel.setBox(X, Y, new DBox(X,Y,currentMaze));
		  	  	  		mazeAppModel.setBox(dX, dY, new WBox(dX,dY,currentMaze));}
					else if (mBox instanceof EBox && mazeAppModel.getBuildModeType() == "Arrival") {
		  	  	  		mazeAppModel.setBox(X, Y, new ABox(X,Y,currentMaze));
	  	  	  			mazeAppModel.setBox(aX, aY, new EBox(aX,aY,currentMaze));}
					else if (mBox instanceof WBox && mazeAppModel.getBuildModeType() == "Arrival") {
		  	  	  		mazeAppModel.setBox(X, Y, new ABox(X,Y,currentMaze));
		  	  	  		mazeAppModel.setBox(aX, aY, new WBox(aX,aY,currentMaze));}

					} catch (Exception e1) {
						e1.printStackTrace();
						System.out.println(e1);
					}
				  }
				});
	}

}
