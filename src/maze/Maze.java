package maze;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import Interfaces.GraphInterface;
import Interfaces.PreviousInterface;
import Interfaces.VertexInterface;
import dijkstra.Dijkstra;

public class Maze implements GraphInterface {

	private MBox[][] maze; // on implémente le labyrinthe comme une matrice de dim 2, n'est pas final car
							// besoin modifier le tableau dans le init et dans le initFromTextFile
	/**
	 * Renvoie un objet Maze initialisé avec une matrice de MBox[0][0]
	 *
	 */
	public Maze() {
		maze = new MBox[0][0];
	}

	/**
	 * Renvoie un objet Maze initialisé avec une matrice de MBox init
	 *
	 * @param init matrice de MBox
	 */
	public Maze(MBox[][] init) {
		final int n = init.length;
		final int m = init[0].length; // on suppose que maze[k].length a même valeur pour tout k
		maze = new MBox[n][m];
		for (int k = 0; k < n; k++) { // évite les copies superficielles de init
			maze[k] = Arrays.copyOf(init[k], init[k].length);
		}
	}
	/**
	 * Renvoie une copie non superficielle du labyrinthe
	 *
	 * @return copie non superficielle du labyrinthe
	 */
	public Maze copy() {
		final int n = this.getHeight();
		final int m = this.getWeight(); 
		Maze copy = new Maze(new MBox[n][m]);
		for (int k = 0; k < n; k++) { 
			for (int j = 0; j < m; j++) {
				copy.setBox(k, j, this.getBox(k, j));
			}
		}
		return copy;
	}
	/**
	 * Renvoie la hauteur du labyrinthe
	 *
	 * @return int hauteur du labyrinthe
	 */
	public int getHeight() {
		return maze.length;
	}
	/**
	 * Renvoie la largeur du labyrinthe, on suppose que le labyrinthe est bien formé
	 *
	 * @return int largeur du labyrinthe
	 */
	public int getWeight() { 
		return maze[0].length;
	}
	/**
	 * Renvoie le noeud du graphe d'abscisse x et d'ordonné y
	 *
	 * @param x abscisse du noeud
	 * @param y ordonnée du noeud
	 * @return Vertex d'abscisse x et d'ordonné y
	 */
	public MBox getBox(int x, int y) { // donne la valeur d'une case
		return maze[x][y];
	}
	/**
	 * Change le noeud du graphe d'abscisse x et d'ordonné y
	 *
	 * @param x abscisse du noeud
	 * @param y ordonnée du noeud 
	 * @param boxValue nouvelle valeur du noeud
	 */
	public void setBox(int x, int y, VertexInterface boxValue) { // change la valeur d'une case
		maze[x][y] = (MBox) boxValue;
	}
	/**
	 * Renvoie la liste des noeuds graphe
	 *
	 * @return ArrayList contenant les noeuds du graphe
	 */
	public ArrayList<VertexInterface> getAllVertices() {
		final ArrayList<VertexInterface> allVertices = new ArrayList<VertexInterface>();
		for (MBox[] L : maze) { // parcours suivant x
			for (MBox m : L) { // parcours suivant y
				allVertices.add(m);
			}
		}
		return allVertices;
	}
	/**
	 * Renvoie le noeud de départ
	 * 
	 * @return Vertex qui est le départ.
	 * @throws Exception si le labyrinthe compose une unique case départ
	 */
	public MBox getStart() throws Exception { // on suppose que le labyrinthe est bien formé (un unique départ), sinon garde
								// la dernière case départ croisée
		final int columnNumber = maze.length;
		final int rowNumber = maze[0].length;
		MBox depart = null; // création en 0,0 qui sera modifié plus tard
		int count = 0; //entier comptant le nombre de case départ pour gérer les exceptions
		for (int k = 0; k < columnNumber; k++) {
			for (int i = 0; i < rowNumber; i++) {
				if (maze[k][i] instanceof DBox) {
					depart = maze[k][i];
					count += 1;
				}
			}
		}
		if (depart == null) {
			throw new Exception("Il n'y a pas de case départ");
		}
		if (count > 1) {
			throw new Exception("Il y a plus d'une case départ");
		}
		return depart;
	}
	/**
	 * Renvoie le noeud d'arrivée
	 * 
	 * @return Vertex qui est l'arrivée.
	 * @throws Exception si le labyrinthe compose une unique case d'arrivée
	 */
	public MBox getEnd() throws Exception { // on suppose que le labyrinthe est bien formé (une unique arrivé), sinon garde
							// la dernière case départ croisée
		final int columnNumber = maze.length;
		final int rowNumber = maze[0].length;
		MBox arrivee = null; // création en 0,0 qui sera modifié plus tard
		int count = 0; //entier comptant le nombre de case départ pour gérer les exceptions
		for (int k = 0; k < columnNumber; k++) {
			for (int i = 0; i < rowNumber; i++) {
				if (maze[k][i] instanceof ABox) {
					arrivee = maze[k][i];
					count += 1;
				}
			}
		}
		if (arrivee == null) {
			throw new Exception("Il n'y a pas de case départ");
		}
		if (count > 1) {
			throw new Exception("Il y a plus d'une case départ");
		}
		return arrivee;
	}
	
	/**
	 * Renvoie la liste des noeuds enfants d'un noeud du graphe
	 *
	 * @param  vertex un noeud du graphe réprésentant le labyrinthe
	 * @return ArrayList contenant les successeurs de vertex
	 */
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {
		final MBox m = (MBox) vertex;
		final int x = m.getX();
		final int y = m.getY();
		final ArrayList<VertexInterface> successors = new ArrayList<VertexInterface>();
		if (m.isWall()) {
			return successors;
		}
		if ((x - 1) >= 0 && !maze[x - 1][y].isWall()) { // on vérifie que x-1 est dans le graphe et que maze[x-1][y]
														// n'est
														// pas un mur
			successors.add(maze[x - 1][y]); // ajout de l'élément
		}
		if ((x + 1) < maze.length && !maze[x + 1][y].isWall()) {
			successors.add(maze[x + 1][y]); // ajout de l'élément
		}
		if ((y - 1) >= 0 && !maze[x][y - 1].isWall()) {
			successors.add(maze[x][y - 1]); // ajout de l'élément
		}
		if ((y + 1) < maze[0].length && !maze[x][y + 1].isWall()) { // maze[0].length donne la largeur du tableau
			successors.add(maze[x][y + 1]); // ajout de l'élément
		}
		return successors;
	}
	/**
	 * Renvoie la valeur de l'arête entre deux sommets, éventuellent +inf
	 *
	 * @param  src sommet de départ
	 * @param dst sommet d'arrivée
	 * @return double donnant le poids de l'arête (src,dst)
	 */
	public Double getWeight(VertexInterface src, VertexInterface dst) { // retourne 1 si il existe une
																					// arrête entre srx et
		// dst, 0 sinon
		final ArrayList<VertexInterface> srcsuccessors = getSuccessors(src);
		if (srcsuccessors.contains(dst)) {
			return (double) 1;
		}
		if (src == dst) {
			return (double) 0;
		} else {
			return Double.POSITIVE_INFINITY;
		}
	}
	/**
	 * Renvoie le labyrinthe résolu sans modifier l'original
	 *
	 * @return labyrinthe résolu
	 */
	public final Maze solveMaze() throws Exception {
		Maze solution = this.copy();
		final MBox d = this.getStart();
		final MBox a = this.getEnd();
		final PreviousInterface previous = Dijkstra.dijkstra(this, d);
		MBox t = (MBox) previous.value(a); 
		while (t != d && t != null) {
			final int x = t.getX();
			final int y = t.getY();
			solution.setBox(x, y, new PBox(x, y, solution));
			t = (MBox) previous.value(t);
		}
		if (t == null) {
			return null;
		}
		return solution;
		
	}
	/**
	 * Renvoie le labyrinthe original, non résolu
	 *
	 * @return labyrinthe original
	 */
	public final Maze unsolveMaze() throws Exception {
		Maze solution = this.copy();
		final int columnNumber = maze.length;
		final int rowNumber = maze[0].length;
		for (int k = 0; k < columnNumber; k++) {
			for (int i = 0; i < rowNumber; i++) {
				if (maze[k][i] instanceof PBox) {solution.setBox(k, i, new EBox(k,i,solution));}
			}
		}
		return solution;
		
	}
	
	/**
	 * Change le labyrinthe en l'initialisant à partir d'un fichier texte
	 *
	 * @param fileName fichier texte d'initialisation
	 * @throws MazeReadingException Renvoie une erreur en cas de non conformité du fichier d'initialisation
	 */
	public final void initFromTextFile(String fileName) throws MazeReadingException { // permet de créer un
																							// labyrinthe à
		// partir d'un fichier texte
		BufferedReader bufferedreader = null;
		FileReader filereader = null;
		// on va réaliser deux "tours" du fichier:
		// - un permier pour vérifier que la taille convient et connaître les valeurs
		// pour initialiser la matrice du labyrinthe
		// - un second pour la remplir
		try {
			// 1er tour
			filereader = new FileReader(fileName);
			bufferedreader = new BufferedReader(filereader);
			String strCurrentLine;
			strCurrentLine = bufferedreader.readLine();
			int i = 0; // compte le numéro de la ligne
			final int columnNumber = strCurrentLine.length(); // nombre de colonne
			while ((strCurrentLine = bufferedreader.readLine()) != null) {
				if (strCurrentLine.length() != columnNumber) { // provoque une erreur si le labyrinthe n'est pas
																// rectangulaire
					throw new MazeReadingException(fileName, i, "the Maze is not a rectangle");
				}
				i += 1;
			}
			final int rowNumber = i + 1; // nombre de lignes
			// 2nd tour
			filereader = new FileReader(fileName);
			bufferedreader = new BufferedReader(filereader);
			maze = new MBox[rowNumber][columnNumber]; // création du labyrinthe
			i = 0; // on réinitialise le numéro de ligne
			boolean d = false; // on vérifie qu'on a qu'un seul départ et qu'une seule arrivée
			boolean a = false;
			while ((strCurrentLine = bufferedreader.readLine()) != null) {
				for (int k = 0; k < columnNumber; k++) {
					char sBox = strCurrentLine.charAt(k); // on récupère le type de boite
					switch (sBox) {
					case 'E' : // si la lettre est E, on ajoute une EBox
						maze[i][k] = new EBox(i, k, this);
						break;
					case 'P' : // si la lettre est P, on ajoute une PBox
						maze[i][k] = new PBox(i, k, this);
						break;
					case 'W' : // si la lettre est W, on ajoute une WBox
						maze[i][k] = new WBox(i, k, this);
						break;
					
					case 'A' :
						if (a) { // provoque une erreur si le fichier texte contient deux A
							throw new MazeReadingException(fileName, i, "There are two arrivals or more in the file. Only one is required.");
						}
						else { // si la lettre est A, on ajoute une ABox
							maze[i][k] = new ABox(i, k, this);
							a = true;
						}
						break;
					case 'D' :
						if (d) { // provoque une erreur si le fichier texte contient deux D
							throw new MazeReadingException(fileName, i, "There are two departures or more in the file. Only one is required.");
						}
						else { // si la lettre est D, on ajoute une DBox
							maze[i][k] = new DBox(i, k, this);
							d = true;
						}
						break;
					default :
						throw new MazeReadingException(fileName, i, sBox + " letter is in the file and is not recognized. The recognized letters are A,E,W and D");
					} // provoque une erreur si le fichier texte contient autre chose que A,E,W ou D
				}
				i += 1;
			}
			if (!a) {
				throw new MazeReadingException(fileName, i, "There is no arrival in the file. One is required.");
			} // provoque une erreur si le fichier texte ne contient pas de A
			if (!d) {
				throw new MazeReadingException(fileName, i, "There is no departure in the file. One is required.");
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
	/**
	 * Enregistre le labyrinthe dans un fichier texte
	 *
	 * @param fileName nom du fichier texte de sauvegarde du labyrinthe
	 * @throws FileNotFoundException
	 */
	public final void saveToTextFile(String fileName) throws FileNotFoundException { // permet de créer un fichier texte
																						// à partir d'un labyrinthe
		final PrintWriter printWriter = new PrintWriter(fileName);
		saveToTextFile(printWriter);
		printWriter.close();

	}
	
	/**
	 * Enregistre le labyrinthe dans un fichier texte
	 *
	 * @param file fichier texte de sauvegarde du labyrinthe
	 * @throws FileNotFoundException
	 */
	public final void saveToTextFile(PrintWriter pwfile) throws FileNotFoundException { // permet de créer un fichier texte
																						// à partir d'un labyrinthe
		final int columnNumber = maze.length;
		final int rowNumber = maze[0].length;
		for (int k = 0; k < columnNumber; k++) {
			String ligne = "";
			for (int i = 0; i < rowNumber; i++) {
				final MBox SBox = maze[k][i];
				ligne += SBox.getClass().getSimpleName().charAt(0);
			}
			pwfile.printf(ligne);
			pwfile.println();
		}

	}
}
