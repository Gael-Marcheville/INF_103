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

	private MBox[][] maze; // on implémente le labyrinthe comme une matrice de dim 2, n'est pas private car
							// besoin modifier le tableau dans le init et dans le initFromTextFile

	/**
	 * Renvoie un objet Maze initialisé avec une matrice de MBox init
	 *
	 * @param init matrice de MBox
	 */
	public Maze(final MBox[][] init) {
		final int n = init.length;
		final int m = init[0].length; // on suppose que maze[k].length a même valeur pour tout k
		maze = new MBox[n][m];
		for (int k = 0; k < n; k++) { // évite les copies superficielles de init
			maze[k] = Arrays.copyOf(init[k], init[k].length);
		}
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
	public MBox getBox(final int x, final int y) { // donne la valeur d'une case
		return maze[x][y];
	}
	/**
	 * Change le noeud du graphe d'abscisse x et d'ordonné y
	 *
	 * @param x abscisse du noeud
	 * @param y ordonnée du noeud 
	 * @param boxValue nouvelle valeur du noeud
	 */
	public void setBox(final int x, final int y, final VertexInterface boxValue) { // change la valeur d'une case
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
				if (maze[k][i].getType() == "D") {
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
				if (maze[k][i].getType() == "A") {
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
	public ArrayList<VertexInterface> getSuccessors(final VertexInterface vertex) {
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
	public Double getWeight(final VertexInterface src, final VertexInterface dst) { // retourne 1 si il existe une
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
	 * Change le labyrinthe en l'initialisant à partir d'un fichier texte
	 *
	 * @param fileName fichier texte d'initialisation
	 * @throws MazeReadingException Renvoie une erreur en cas de non conformité du fichier d'initialisation
	 */
	public final void initFromTextFile(final String fileName) throws MazeReadingException { // permet de créer un
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
					throw new MazeReadingException(fileName, i, "le labyrinthe n'est pas rectangulaire");
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
						throw new MazeReadingException(fileName, i, "Il y a deux caractères A, il en faut un unique");
					} // provoque une erreur si le fichier texte contient deux A
					else if (sBox == 'D' && d) {
						throw new MazeReadingException(fileName, i, "Il y a deux caractères D, il en faut un unique");
					} // provoque une erreur si le fichier texte contient deux D
					else {
						throw new MazeReadingException(fileName, i, "Il y a un caractère différent de A,E,W ou D");
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
	/**
	 * Enregistre le labyrinthe dans un fichier texte
	 *
	 * @param fileName fichier texte de sauvegarde du labyrinthe
	 * @throws FileNotFoundException
	 */
	public final void saveToTextFile(final String fileName) throws FileNotFoundException { // permet de créer un fichier texte
																						// à partir d'un labyrinthe
		final PrintWriter printWriter = new PrintWriter(fileName);

		final int columnNumber = maze.length;
		final int rowNumber = maze[0].length;
		for (int k = 0; k < columnNumber; k++) {
			String ligne = "";
			for (int i = 0; i < rowNumber; i++) {
				final MBox SBox = maze[k][i];
				ligne += SBox.getType();
			}
			printWriter.printf(ligne);
			printWriter.println();
		}
		printWriter.close();

	}
}
