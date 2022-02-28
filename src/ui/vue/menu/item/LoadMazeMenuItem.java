package ui.vue.menu.item;

import java.awt.event.*;
import java.io.FileNotFoundException;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import maze.MazeReadingException;
import ui.model.MazeAppModel;

public class LoadMazeMenuItem extends JMenuItem implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final ui.vue.MazeApp mazeApp;
	String choosedFile;

	/**
	 * Retourne un Item de chargement d'un Maze pour FileMenu
	 * 
	 * @param mazeApp
	 */
	public LoadMazeMenuItem(final ui.vue.MazeApp mazeApp) {
		super("Load a Maze"); // Text of menu item
		this.mazeApp = mazeApp;
		addActionListener(this);

	}

	public void actionPerformed(ActionEvent evt) {
		final JTextField directory = new JTextField(System.getProperty("user.home"), 35);
		final JFileChooser fc = new JFileChooser(directory.getText());
		final FileFilter txtFilter = new FileNameExtensionFilter("txt", "txt");
		fc.setFileFilter(txtFilter);
		final MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		if (!mazeAppModel.isSaved()) {
			mazeAppModel.export_with_warning();
		}
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		final int returnVal = fc.showOpenDialog(LoadMazeMenuItem.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			choosedFile = fc.getSelectedFile().getPath();
			directory.setText(choosedFile);
		}
		try {
			try {
				mazeApp.getMazeAppModel().importFromText(choosedFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} catch (MazeReadingException e1) {
			JOptionPane.showMessageDialog(LoadMazeMenuItem.this, e1);
			e1.printStackTrace();
		}
	}
}