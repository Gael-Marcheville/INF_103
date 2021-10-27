package tp06;

import java.util.ArrayList;
import java.util.Arrays;

public class Maze implements GraphInterface {
	
		private final MBox[][] maze; //on implémente le labyrinthe comme une matrice de dim 2
		public Maze(MBox[][] init){
			int n = init.length;
			int m = init[0].length; //on suppose que maze[k].length a même valeur pour tout k
			maze = new MBox[n][m] ; 
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
		public ArrayList<VertexInterface> getAllVertices(){
			ArrayList<VertexInterface> allVertices = new ArrayList<VertexInterface>() ;
			for (int i = 0; i < maze.length; i++) { //parcours suivant x
				for (int j = 0; j < maze[0].length; j++) {  //parcours suivant y
					allVertices.add(maze[i][j]);
				}
			}
			return allVertices;
		}
		public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex){
			MBox m = (MBox)vertex;
			int x = m.getX();
			int y =	m.getY();
			ArrayList<VertexInterface> successors = new ArrayList<VertexInterface>() ;
			if (m.isWall()) {
				return successors;
			}
			if (x-1 >= 0 && !maze[x-1][y].isWall()) { //on vérifie que x-1 est dans le graphe et que maze[x-1][y] n'est pas un mur
				successors.add(maze[x-1][y]); //ajout de l'élément
			}
			if (x+1 < maze.length && !maze[x+1][y].isWall()) { 
				successors.add(maze[x+1][y]); //ajout de l'élément
			}
			if (y-1 >= 0 && !maze[x][y-1].isWall()) { 
				successors.add(maze[y-1][y]); //ajout de l'élément
			}
			if (y+1 < maze[0].length && !maze[x][y+1].isWall()) { //maze[0].length donne la largeur du tableau 
				successors.add(maze[x][y+1]); //ajout de l'élément
			}
			return successors;
		}
		public int getWeight(VertexInterface src,VertexInterface dst) { 
			return 0; //on reviendra dessus plus tard
		}
}
