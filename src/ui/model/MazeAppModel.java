package ui.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import maze.MBox;
import maze.Maze;
import maze.MazeReadingException;
import maze.WBox;


public class MazeAppModel {
	private int width = 5 ;
	private int height = 5;
	private Maze currentMaze ;
	private boolean modified = false ;
	private boolean buildMode;
	private boolean solveMode;
	private String buildModeType = "Wall";
	private ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>();
	
	public MazeAppModel() {
		setBuildMode(false);
		setSolveMode(false);
		final MBox[][] init = new MBox[1][1];
		final Maze maze = new Maze(init);
		try {
			maze.initFromTextFile("data/labyrinthe.txt");
			currentMaze = maze;
			width = currentMaze.getWeight();
			height = currentMaze.getHeight();
		} catch (MazeReadingException e) {
			this.reset(width, height);
		}
	}
	
	public void stateChanges() {
		ChangeEvent evt = new ChangeEvent(this);
		for(ChangeListener listener : listeners) {
			listener.stateChanged(evt);
		}
	}
			
		
	
	public void addObserver(ChangeListener listener) {
		listeners.add(listener);
	}
	public int getWidth() {return width;}
	public void setWidth(int width) {
		if(this.width != width) {
			this.width = width ;
			modified = true ; 
			stateChanges();
		}
	}
	public int getHeight() {return height;}
	public void setHeight(int height) {
		if (this.height != height) {
			this.height = height ;
			modified = true ; 
			stateChanges();
		}
	}
	public Maze getCurrentMaze() {return currentMaze;}
	public void setCurrentMaze(Maze m) {
		this.currentMaze = m;
		height = currentMaze.getHeight();
		width = currentMaze.getWeight();
		modified = true ; 
		stateChanges();
	}

	public void setBox(int i, int j, MBox newBox) {
		this.currentMaze.setBox(i, j, newBox);
		modified = true ;
		stateChanges();
	}
	
	public boolean isModified() {
		return modified;
	}
	
	
	public void export() throws Exception {
		if(solveMode) {setSolveMode(false);}
		currentMaze.saveToTextFile("data/export.txt");
	}

	public void reset(int nwidth,int nheight) {
		this.width = nwidth ;
		this.height = nheight ; 
		this.buildModeType = "W" ;
		setBuildMode(false);
		setSolveMode(false);
		Maze wallMaze = new Maze(new MBox[nheight][nwidth]);
		for(int i = 0 ; i<nheight ; i++) {
			for(int j = 0 ; j< nwidth ; j++) {
				wallMaze.setBox(i,j,new WBox(i , j, wallMaze));
			}
		}
		this.setCurrentMaze(wallMaze);
	}
	
	public void importFromText(String fileName) throws FileNotFoundException, MazeReadingException {
		Maze m = new Maze();
		m.initFromTextFile(fileName);
		this.setCurrentMaze(m);
	}

	public String getBuildModeType() {
		return buildModeType;
	}

	public void setBuildModeType(String buildModeType) {
		if(this.buildModeType != buildModeType) {
			this.buildModeType = buildModeType;
			modified = true ;
			stateChanges();
		}
	}

	public boolean isBuildMode() {
		return buildMode;
	}

	public void setBuildMode(boolean buildMode) {
		this.buildMode = buildMode;
		if (buildMode) {setSolveMode(false);}
		modified = true ;
		stateChanges();
	}

	public boolean isSolveMode() {
		return solveMode;
	}

	public void setSolveMode(boolean solveMode) {
		this.solveMode = solveMode;
		try {
		if (solveMode) {
			currentMaze.saveToTextFile("data/labyrinthe.txt");
			Maze m = currentMaze.solveMaze();
			m.saveToTextFile("data/solution.txt");
			this.importFromText("data/solution.txt");
		}
		else {
			this.importFromText("data/labyrinthe.txt");
		}
		modified = true ; 
		stateChanges();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}