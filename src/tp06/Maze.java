package tp06;

import java.util.Arrays;

public class Maze {
	
		private final MBox[][] maze; //on implémente le labyrinthe comme une matrice de dim 2
		
		public Maze(MBox[][] init){
			int n = init.length;
			maze = new MBox[n][n] ; 
			for (int k = 0; k < n ; k++) { //évite les copies superficielles de init
				maze[k] = Arrays.copyOf(init[k], init[k].length) ;
			}
		}
		
		public MBox getBox(int x, int y) { //donne la valeur d'une case
			return maze[x][y];
		}
		
		public void setBox(int x, int y,MBox boxValue) { //change la valeur d'une case
			maze[x][y] = boxValue;
		}

}
