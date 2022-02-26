package tp06;

import java.io.IOException;

import maze.MazeReadingException;
import ui.vue.MazeApp;

public class MainUi {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
			MazeApp res = new MazeApp("data/petitlab.txt");
		} catch (IOException | MazeReadingException e) {
			// le fichier n'existe pas
			e.printStackTrace();
		}
	}

}