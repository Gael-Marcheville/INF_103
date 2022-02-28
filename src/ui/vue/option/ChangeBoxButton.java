package ui.vue.option;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ui.model.MazeAppModel;

public class ChangeBoxButton extends JButton implements ActionListener {

	private static final long serialVersionUID = 1L;
	/**
	 * Vue courante
	 */
	private final ui.vue.MazeApp mazeApp;
	/**
	 * Nom du bouton représentant le mode
	 */
	private final String name;

	/**
	 * Retourne un bouton qui permet d'activer un mode de construction
	 * 
	 * @param mazeApp
	 */
	public ChangeBoxButton(final ui.vue.MazeApp mazeApp, final String name) {
		super(name);
		this.name = name;
		this.mazeApp = mazeApp;
		this.addActionListener(this);
	}

	/**
	 * @return Type de construction du bouton : Wall, Empty, Arrival ou Departure
	 */
	private String getType() {

		switch (this.name) {
		case "Empty Box":
			return "Empty";
		case "Move Arrival":
			return "Arrival";
		case "Move Departure":
			return "Departure";
		case "Wall Box":
			return "Wall";
		default:
			return "M";
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final MazeAppModel mazeAppModel = this.mazeApp.getMazeAppModel();
		final String type = this.getType();
		mazeAppModel.setBuildModeType(type);
	}
}