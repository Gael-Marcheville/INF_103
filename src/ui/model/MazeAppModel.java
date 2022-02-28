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
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import maze.ABox;
import maze.DBox;
import maze.MBox;
import maze.Maze;
import maze.MazeReadingException;
import maze.WBox;

public class MazeAppModel {
	private int width = 5;
	private int height = 5;
	private Maze currentMaze;
	private boolean modified;
	private boolean saved;
	private boolean buildMode;
	private boolean solveMode;
	private String buildModeType = "Wall";
	private final ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>();

	/**
	 * Retourne un Model pour MazeApp
	 * 
	 * @param initFileName fichier de démarage correspondant à un Maze. Si le
	 *                     fichier lève une MazeReadingException, un WallMaze 5*5
	 *                     est créé
	 */
	public MazeAppModel(String initFileName) {
		modified = false;
		saved = true;
		currentMaze = new Maze();
		try {
			currentMaze.initFromTextFile(initFileName);
		} catch (MazeReadingException e) {
			reset(5, 5);
		}
		width = currentMaze.getWeight();
		height = currentMaze.getHeight();
		setBuildMode(false);
		setSolveMode(false);
	}

	public void stateChanges() {
		final ChangeEvent evt = new ChangeEvent(this);
		for (ChangeListener listener : listeners) {
			listener.stateChanged(evt);
		}
	}

	public void addObserver(ChangeListener listener) {
		listeners.add(listener);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	/**
	 * Retourne le Maze du model
	 * 
	 * @return currentMaze
	 */
	public Maze getCurrentMaze() {
		return currentMaze;
	}

	/**
	 * Change le Maze du model
	 * 
	 * @param currentMaze
	 */
	public void setCurrentMaze(Maze currentMaze) {
		this.currentMaze = currentMaze;
		height = currentMaze.getHeight();
		width = currentMaze.getWeight();
		modified = true;
		stateChanges();
	}

	/**
	 * Change la Box de coordonnéées i,j du model par newBox
	 * 
	 * @param i
	 * @param j
	 * @param newBox
	 */
	public void setBox(int i, int j, MBox newBox) {
		this.currentMaze.setBox(i, j, newBox);
		modified = true;
		saved = false;
		stateChanges();
	}

	/**
	 * Retourne la valeur de modified, qui note les changements pour l'affichage
	 * 
	 * @return modified
	 */
	public boolean isModified() {
		return modified;
	}

	/**
	 * Retourne la valeur de Saved, qui vaut true si le Maze actuel est sauvegardé
	 * dans un fichier texte
	 * 
	 * @return saved
	 */
	public boolean isSaved() {
		return saved;
	}

	/**
	 * Exporte le Maze Actuel dans un fichier texte
	 * 
	 */
	public void export() {
		if (solveMode) {
			setSolveMode(false);
		}
		String fileName = JOptionPane.showInputDialog(null, "Name this maze", "Save", JOptionPane.INFORMATION_MESSAGE);
		final JFileChooser saveFile = new JFileChooser();
		int i = fileName.lastIndexOf('.'); //on supprime l'extension si elle existe déjà
		if (i > 0) {
		    fileName = fileName.substring(0,i);
		}
		fileName += ".txt"; //on ajoute .txt 
		final FileFilter txtFilter = new FileNameExtensionFilter("txt", "txt");
		saveFile.setFileFilter(txtFilter);
		saveFile.setSelectedFile(new File(fileName));
		final PrintWriter pwfile;
		final int sf = saveFile.showSaveDialog(null);
		if (sf == JFileChooser.APPROVE_OPTION) {
			try {
				pwfile = new PrintWriter(saveFile.getSelectedFile());
				currentMaze.saveToTextFile(pwfile);
				pwfile.close();
				JOptionPane.showMessageDialog(null, "Maze has been saved", "Maze Saved",
						JOptionPane.INFORMATION_MESSAGE);
				saved = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (sf == JFileChooser.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(null, "Maze save has been canceled", "Maze not save",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Exporte le Maze Actuel dans un fichier texte, en commançant par un Warning
	 * 
	 */
	public void export_with_warning() {
		final int response = JOptionPane.showOptionDialog(null, "Maze not saved. Export it?", "Maze not save",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
		switch (response) {
		case JOptionPane.CANCEL_OPTION:
			return;
		case JOptionPane.OK_OPTION:
			try {
				export();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case JOptionPane.NO_OPTION:
			break;
		}
		saved = true;
	}

	/**
	 * Crée un nouveau Maze composé uniquement de murs
	 * 
	 * @param nwidth  largeur du Maze
	 * @param nheight hauteur du Maze
	 */
	public void reset(int nwidth, int nheight) {
		if (saved) {
			this.buildModeType = "Wall";
			setBuildMode(false);
			setSolveMode(false);
			saved = false;
			final Maze newMaze = new Maze(new MBox[nheight][nwidth]);
			for (int i = 0; i < nheight; i++) {
				for (int j = 0; j < nwidth; j++) {
					newMaze.setBox(i, j, new WBox(i, j, newMaze));
				}
			}
			newMaze.setBox(0, 0, new DBox(0, 0, newMaze));
			newMaze.setBox(nheight - 1, nwidth - 1, new ABox(nheight - 1, nwidth - 1, newMaze));
			this.setCurrentMaze(newMaze);
			setBuildMode(true);
		}
	}

	/**
	 * Permet d'importer un Maze à partir du nom du fichier
	 * 
	 * @param fileName nom du fichier
	 * @throws FileNotFoundException
	 * @throws MazeReadingException
	 */
	public void importFromText(String fileName) throws FileNotFoundException, MazeReadingException {
		if (!saved) {
			export_with_warning();
		}
		final Maze m = new Maze();
		m.initFromTextFile(fileName);
		this.setCurrentMaze(m);
	}

	/**
	 * Retourne le mode de construction actuel : Wall, Empty, Arrival, Departure
	 * 
	 * @return STring buildModeType
	 */
	public String getBuildModeType() {
		return buildModeType;
	}

	/**
	 * Change le mode de construction actuel : W pour Wall, E pour Empty, A pour
	 * Arrival, D pour Departure
	 * 
	 * @param buildModeType
	 */
	public void setBuildModeType(String buildModeType) {
		if (this.buildModeType != buildModeType) {
			if ((buildModeType == "Wall") || (buildModeType == "Empty") || (buildModeType == "Arrival") || (buildModeType == "Departure")) {
				this.buildModeType = buildModeType;
				stateChanges();
			}
		}
	}

	/**
	 * Retourne la valeur de buildMode, qui vaut true si le mode construction est
	 * activé
	 * 
	 * @return buildMode
	 */
	public boolean isBuildMode() {
		return buildMode;
	}

	/**
	 * Change la valeur de buildMode, qui vaut true si le mode construction est
	 * activé
	 * 
	 * @param buildMode
	 */
	public void setBuildMode(boolean buildMode) {
		this.buildMode = buildMode;
		if (buildMode) {
			setSolveMode(false);
		}
		stateChanges();
	}

	/**
	 * Retourne la valeur de solveMode, qui vaut true si le mode solution est activé
	 * 
	 * @return solveMode
	 */
	public boolean isSolveMode() {
		return solveMode;
	}

	/**
	 * Change la valeur de solveMode, qui vaut true si le mode solution est activé
	 * 
	 * @param solveMode
	 */
	public void setSolveMode(boolean solveMode) {
		this.solveMode = solveMode;
		try {
			if (solveMode) {
				Maze newMaze = currentMaze.solveMaze();
				if (newMaze == null) {
					JOptionPane.showMessageDialog(null, "There is no solution", "Maze not solve",
							JOptionPane.INFORMATION_MESSAGE);
					this.solveMode = false;
				} else {
					setCurrentMaze(newMaze);
				}
			} else {
				setCurrentMaze(currentMaze.unsolveMaze());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		stateChanges();
	}
}