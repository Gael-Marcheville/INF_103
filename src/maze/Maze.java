package maze;

import java.io.BufferedReader; 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import Interfaces.GraphInterface;
import Interfaces.VertexInterface;

public class Maze implements GraphInterface {

	private MBox[][] maze; // on impl�mente le labyrinthe comme une matrice de dim 2, n'est pas private car
							// besoin modifier le tableau dans le init et dans le initFromTextFile

	public Maze(MBox[][] init) {
		final int n = init.length;
		final int m = init[0].length; // on suppose que maze[k].length a m�me valeur pour tout k
		maze = new MBox[n][m];
		for (int k = 0; k < n; k++) { // �vite les copies superficielles de init
			maze[k] = Arrays.copyOf(init[k], init[k].length);
		}
	}

	public MBox getBox(int x, int y) { // donne la valeur d'une case
		return maze[x][y];
	}

	public void setBox(int x, int y, MBox boxValue) { // change la valeur d'une case
		maze[x][y] = boxValue;
	}

	public ArrayList<VertexInterface> getAllVertices() {
		final ArrayList<VertexInterface> allVertices = new ArrayList<VertexInterface>();
		for (int i = 0; i < maze.length; i++) { // parcours suivant x
			for (int j = 0; j < maze[0].length; j++) { // parcours suivant y
				allVertices.add(maze[i][j]);
			}
		}
		return allVertices;
	}

	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {
		MBox m = (MBox) vertex;
		final int x = m.getX();
		final int y = m.getY();
		final ArrayList<VertexInterface> successors = new ArrayList<VertexInterface>();
		if (m.isWall()) {
			return successors;
		}
		if (x - 1 >= 0 && !maze[x - 1][y].isWall()) { // on v�rifie que x-1 est dans le graphe et que maze[x-1][y] n'est
														// pas un mur
			successors.add(maze[x - 1][y]); // ajout de l'�l�ment
		}
		if (x + 1 < maze.length && !maze[x + 1][y].isWall()) {
			successors.add(maze[x + 1][y]); // ajout de l'�l�ment
		}
		if (y - 1 >= 0 && !maze[x][y - 1].isWall()) {
			successors.add(maze[y - 1][y]); // ajout de l'�l�ment
		}
		if (y + 1 < maze[0].length && !maze[x][y + 1].isWall()) { // maze[0].length donne la largeur du tableau
			successors.add(maze[x][y + 1]); // ajout de l'�l�ment
		}
		return successors;
	}

	public int getWeight(VertexInterface src, VertexInterface dst) { // retourne 1 si il existe une arr�te entre srx et
																		// dst, 0 sinon
		final ArrayList<VertexInterface> srcsuccessors = getSuccessors(src);
		if (srcsuccessors.contains(dst)) {
			return 1;
		} else {
			return 0;
		}
	}

	public final void initFromTextFile(String fileName) throws MazeReadingException { // permet de cr�er un labyrinthe �
																						// partir d'un fichier texte
		BufferedReader bufferedreader = null;
		FileReader filereader = null;
		// on va r�aliser deux "tours" du fichier:
		// - un permier pour v�rifier que la taille convient et conna�tre les valeurs
		// pour initialiser la matrice du labyrinthe
		// - un second pour la remplir
		try {
			// 1er tour
			filereader = new FileReader(fileName);
			bufferedreader = new BufferedReader(filereader);
			String strCurrentLine;
			strCurrentLine = bufferedreader.readLine();
			int i = 0; // compte le num�ro de la ligne
			int columnNumber = strCurrentLine.length(); // nombre de colonne
			while ((strCurrentLine = bufferedreader.readLine()) != null) {
				if (strCurrentLine.length() != columnNumber) { // provoque une erreur si le labyrinthe n'est pas
																// rectangulaire
					throw new MazeReadingException(fileName, i, "le labyrinthe n'est pas rectangulaire");
				}
				i += 1;
			}
			int rowNumber = i + 1; // nombre de lignes
			// 2nd tour
			filereader = new FileReader(fileName);
			bufferedreader = new BufferedReader(filereader);
			maze = new MBox[rowNumber][columnNumber]; // cr�ation du labyrinthe
			i = 0; // on r�initialise le num�ro de ligne
			boolean d = false; // on v�rifie qu'on a qu'un seul d�part et qu'une seule arriv�e
			boolean a = false;
			while ((strCurrentLine = bufferedreader.readLine()) != null) {
				for (int k = 0; k < columnNumber; k++) {
					char sBox = strCurrentLine.charAt(k); // on r�cup�re le type de boite
					if (sBox == 'E') {
						maze[i][k] = new EBox(i, k, this);
					} // si la boite est de type EBox, on ajoute une EBox
					else if (sBox == 'W') {
						maze[i][k] = new WBox(i, k, this);
					} // si la boite est de type WBox, on ajoute une WBox
					else if (sBox == 'A' && !a) {
						maze[i][k] = new ABox(i, k, this);
						a = true;
					} // si la boite est de type ABox, on ajoute une ABox
					else if (sBox == 'D' && !d) {
						maze[i][k] = new DBox(i, k, this);
						d = true;
					} // si la boite est de type DBox, on ajoute une DBox
					else if (sBox == 'A' && a) {
						throw new MazeReadingException(fileName, i, "Il y a deux caract�res A, il en faut un unique");
					} // provoque une erreur si le fichier texte contient deux A
					else if (sBox == 'D' && d) {
						throw new MazeReadingException(fileName, i, "Il y a deux caract�res D, il en faut un unique");
					} // provoque une erreur si le fichier texte contient deux D
					else {
						throw new MazeReadingException(fileName, i, "Il y a un caract�re diff�rent de A,E,W ou D");
					} // provoque une erreur si le fichier texte contient autre chose que A,E,W ou D
				}
				i += 1;
			}
			if (!a) {
				throw new MazeReadingException(fileName, i, "Il n'y a pas de A, il en faut un unique");
			} // provoque une erreur si le fichier texte ne contient pas de A
			if (!d) {
				throw new MazeReadingException(fileName, i, "Il n'y a pas de D, il en faut un unique");
			} // provoque une erreur si le fichier texte ne contient pas de D
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedreader != null)
					bufferedreader.close();
				if (filereader != null)
					filereader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public final void saveToTextFile(String fileName) throws FileNotFoundException { //permet de cr�er un fichier texte � partir d'un labyrinthe
		PrintWriter printWriter = new PrintWriter(fileName);

			int columnNumber = maze.length;
			int rowNumber = maze[0].length;
			for (int k = 0; k < columnNumber; k++) {
				String ligne = "";
				for (int i = 0; i < rowNumber; i++) {
					MBox SBox = maze[k][i];
					ligne += SBox.getType();
				}
				printWriter.printf(ligne);
				printWriter.println();
			}
			printWriter.close();
		
	}
}
