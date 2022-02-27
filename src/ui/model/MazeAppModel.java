package ui.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
	private final ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>();
	
	public MazeAppModel(String initFileName) {
		modified = false;
		saved = true;
		currentMaze = new Maze();
		try {
			currentMaze.initFromTextFile(initFileName);
		} catch (MazeReadingException e) {
			reset(5,5);
		}
		width = currentMaze.getWeight();
		height = currentMaze.getHeight();
		setBuildMode(false);
		setSolveMode(false);
	}
	
	public void stateChanges() {
		final ChangeEvent evt = new ChangeEvent(this);
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
	public void setCurrentMaze(Maze currentMaze) {
		this.currentMaze = currentMaze;
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
	
	public boolean isSaved() {
		return saved;
	}
	
	
	public void export() {
		if(solveMode) {setSolveMode(false);}
		String fileName = JOptionPane.showInputDialog(null,"Name this maze","Save",JOptionPane.INFORMATION_MESSAGE);
        final JFileChooser saveFile = new JFileChooser();
        saveFile.setSelectedFile(new File(fileName));
        final PrintWriter pwfile;
        final int sf = saveFile.showSaveDialog(null);
        if(sf == JFileChooser.APPROVE_OPTION){
            try {
            	pwfile = new PrintWriter(saveFile.getSelectedFile());
                currentMaze.saveToTextFile(pwfile);
                pwfile.close();
                JOptionPane.showMessageDialog(null, "Maze has been saved","Maze Saved",JOptionPane.INFORMATION_MESSAGE);
        	    saved = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(sf == JFileChooser.CANCEL_OPTION){
            JOptionPane.showMessageDialog(null, "Maze save has been canceled","Maze not save",JOptionPane.INFORMATION_MESSAGE);
        }
	}
	
	public void export_with_warning() {
		final int response = JOptionPane.showOptionDialog(null, "Maze not saved. Export it?", "Maze not save", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
		switch(response) {
		case JOptionPane.CANCEL_OPTION :
			return ;
		case JOptionPane.OK_OPTION :
			try {
				export();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case JOptionPane.NO_OPTION :
			break;
		}
	    saved = true;
	}
	
	
	public void reset(int nwidth,int nheight) {
		if(saved) {
		this.buildModeType = "Wall" ;
		setBuildMode(false);
		setSolveMode(false);
		saved = false;
		final Maze newMaze = new Maze(new MBox[nheight][nwidth]);
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
		if(!saved) {export_with_warning();}
		final Maze m = new Maze();
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