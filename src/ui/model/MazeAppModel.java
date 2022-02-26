package ui.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import maze.ABox;
import maze.DBox;
import maze.MBox;
import maze.Maze;
import maze.MazeReadingException;
import maze.WBox;


public class MazeAppModel {
	private int width = 5 ;
	private int height = 5;
	private Maze currentMaze ;
	private boolean modified ;
	private boolean saved;
	private boolean buildMode;
	private boolean solveMode;
	private String buildModeType = "Wall";
	private ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>();
	
	public MazeAppModel(String initFileName) {
		modified = false;
		saved = true;
		currentMaze = new Maze();
		try {
			currentMaze.initFromTextFile(initFileName);
		} catch (MazeReadingException e) {
			// ceci n'est pas un maze
		}
		width = currentMaze.getWeight();
		height = currentMaze.getHeight();
		setBuildMode(false);
		setSolveMode(false);
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
	public int getHeight() {return height;}
	public Maze getCurrentMaze() {return currentMaze;}
	public void setCurrentMaze(Maze m) {
		this.currentMaze = m;
		height = currentMaze.getHeight();
		width = currentMaze.getWeight();
		modified = true;
		stateChanges();
	}

	public void setBox(int i, int j, MBox newBox) {
		this.currentMaze.setBox(i, j, newBox);
		modified = true ;
		saved = false;
		stateChanges();
	}
	
	public boolean isModified() {
		return modified;
	}
	
	
	public boolean export() {
		if(solveMode) {setSolveMode(false);}
		String filename = JOptionPane.showInputDialog("Name this file");
        JFileChooser savefile = new JFileChooser();
        savefile.setSelectedFile(new File(filename));
        int sf = savefile.showSaveDialog(null);
        if(sf == JFileChooser.APPROVE_OPTION){
            try {
        		currentMaze.saveToTextFile(filename);
                JOptionPane.showMessageDialog(null, "File has been saved","File Saved",JOptionPane.INFORMATION_MESSAGE);
        	    return true;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(sf == JFileChooser.CANCEL_OPTION){
            JOptionPane.showMessageDialog(null, "File save has been canceled");
        }
        return false;
	}

	public void reset(int nwidth,int nheight) {
		if(saved || export()) {
		this.width = nwidth ;
		this.height = nheight ; 
		this.buildModeType = "Wall" ;
		setBuildMode(false);
		setSolveMode(false);
		Maze newMaze = new Maze(new MBox[nheight][nwidth]);
		for(int i = 0 ; i<nheight ; i++) {
			for(int j = 0 ; j< nwidth ; j++) {
				newMaze.setBox(i,j,new WBox(i , j, newMaze));
			}
		}
		newMaze.setBox(0, 0, new DBox(0,0,newMaze));
		newMaze.setBox(nheight-1,nwidth-1, new ABox(nheight-1,nwidth-1,newMaze));
		this.setCurrentMaze(newMaze);;
		setBuildMode(true);
	}
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
			stateChanges();
		}
	}

	public boolean isBuildMode() {
		return buildMode;
	}

	public void setBuildMode(boolean buildMode) {
		this.buildMode = buildMode;
		if (buildMode) {setSolveMode(false);}
		stateChanges();
	}

	public boolean isSolveMode() {
		return solveMode;
	}

	public void setSolveMode(boolean solveMode) {
		this.solveMode = solveMode;
		try {
		if (solveMode) {setCurrentMaze(currentMaze.solveMaze());}
		else {setCurrentMaze(currentMaze.unsolveMaze());}
		} catch (Exception e) {
			e.printStackTrace();
		}
		stateChanges();
	}
}