package tp06;

import java.io.IOException;

import ui.vue.MazeApp;

public class MainUi {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MazeApp res = new MazeApp("data/petitlab.txt");
		try {
			res.getMazeAppModel().export();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}