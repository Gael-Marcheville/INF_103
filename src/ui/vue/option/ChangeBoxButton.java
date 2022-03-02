package ui.vue.option;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.Color;

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
	private final String type;

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
		this.type = this.getType();
	}

	/**
	 * @return Type de construction du bouton : Wall, Empty, Arrival ou Departure
	 */
	private String getType() {

		switch (this.name) {
		case "Empty Box":
			this.setBackground(Color.LIGHT_GRAY);
			return "Empty";
		case "Move Arrival":
			this.setBackground(Color.RED);
			return "Arrival";
		case "Move Departure":
			this.setBackground(Color.GREEN);
			return "Departure";
		case "Wall Box":
			this.setBackground(Color.ORANGE);
			return "Wall";
		default:
			return "M";
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final MazeAppModel mazeAppModel = this.mazeApp.getMazeAppModel();
		mazeAppModel.setBuildModeType(type);
	}
}