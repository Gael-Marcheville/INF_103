package ui.vue.option;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ui.model.MazeAppModel;

public class ResetButton extends JButton implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final ui.vue.MazeApp mazeApp;

	/**
	 * Retourne un bouton pour lancer la création d'un nouveau Maze
	 * 
	 * @param mazeApp
	 */
	public ResetButton(final ui.vue.MazeApp mazeApp) {
		super("Create a new Maze");
		this.mazeApp = mazeApp;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		if (!mazeAppModel.isSaved()) {
			mazeAppModel.export_with_warning();
		}
		int width = 2;
		int height = 2;
		boolean parseIntSuccess = false;
		boolean cancelled = false;
		while (!parseIntSuccess && !cancelled) {
			try {
				final String inputWidth = JOptionPane.showInputDialog(null, "Width : ", "Customize your Maze",
						JOptionPane.INFORMATION_MESSAGE);
				if (inputWidth == null) {
					cancelled = true;
				} else {
					width = Integer.parseInt(inputWidth);
					if (width > 1) {
						parseIntSuccess = true;
					} else {
						JOptionPane.showMessageDialog(mazeApp, "Width must be > 1 !");
					}
				}
			} catch (NumberFormatException numberFormatException) {
				JOptionPane.showMessageDialog(mazeApp, "Width must be an int");
			}
		}
		parseIntSuccess = false;
		while (!parseIntSuccess && !cancelled) {
			try {
				final String inputHeight = JOptionPane.showInputDialog(null, "Height : ", "Customize your Maze",
						JOptionPane.INFORMATION_MESSAGE);
				if (inputHeight == null) {
					cancelled = true;
				} else {
					height = Integer.parseInt(inputHeight);
					if (height > 1) {
						parseIntSuccess = true;
					} else {
						JOptionPane.showMessageDialog(mazeApp, "Height must be > 1 !");
					}
				}
			} catch (NumberFormatException numberFormatException) {
				JOptionPane.showMessageDialog(mazeApp, "Height must be an int");
			}
		}
		if (!cancelled) {
			mazeAppModel.reset(width, height);
		}
	}
}