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

	/**
	 * Renvoie un objet Maze initialis� avec une matrice de MBox init
	 *
	 * @param init matrice de MBox
	 */
	public Maze(final MBox[][] init) {
		final int n = init.length;
		final int m = init[0].length; // on suppose que maze[k].length a m�me valeur pour tout k
		maze = new MBox[n][m];
		for (int k = 0; k < n; k++) { // �vite les copies superficielles de init
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
	 * Renvoie la largeur du labyrinthe, on suppose que le labyrinthe est bien form�
	 *
	 * @return int largeur du labyrinthe
	 */
	public int getWeight() { 
		return maze[0].length;
	}
	/**
	 * Renvoie le noeud du graphe d'abscisse x et d'ordonn� y
	 *
	 * @param x abscisse du noeud
	 * @param y ordonn�e du noeud
	 * @return Vertex d'abscisse x et d'ordonn� y
	 */
	public MBox getBox(final int x, final int y) { // donne la valeur d'une case
		return maze[x][y];
	}
	/**
	 * Change le noeud du graphe d'abscisse x et d'ordonn� y
	 *
	 * @param x abscisse du noeud
	 * @param y ordonn�e du noeud 
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
	 * Renvoie le noeud de d�part
	 * 
	 * @return Vertex qui est le d�part.
	 * @throws Exception si le labyrinthe compose une unique case d�part
	 */
	public MBox getStart() throws Exception { // on suppose que le labyrinthe est bien form� (un unique d�part), sinon garde
								// la derni�re case d�part crois�e
		final int columnNumber = maze.length;
		final int rowNumber = maze[0].length;
		MBox depart = null; // cr�ation en 0,0 qui sera modifi� plus tard
		int count = 0; //entier comptant le nombre de case d�part pour g�rer les exceptions
		for (int k = 0; k < columnNumber; k++) {
			for (int i = 0; i < rowNumber; i++) {
				if (maze[k][i].getType() == "D") {
					depart = maze[k][i];
					count += 1;
				}
			}
		}
		if (depart == null) {
			throw new Exception("Il n'y a pas de case d�part");
		}
		if (count > 1) {
			throw new Exception("Il y a plus d'une case d�part");
		}
		return depart;
	}
	/**
	 * Renvoie le noeud d'arriv�e
	 * 
	 * @return Vertex qui est l'arriv�e.
	 * @throws Exception si le labyrinthe compose une unique case d'arriv�e
	 */
	public MBox getEnd() throws Exception { // on suppose que le labyrinthe est bien form� (une unique arriv�), sinon garde
							// la derni�re case d�part crois�e
		final int columnNumber = maze.length;
		final int rowNumber = maze[0].length;
		MBox arrivee = null; // cr�ation en 0,0 qui sera modifi� plus tard
		int count = 0; //entier comptant le nombre de case d�part pour g�rer les exceptions
		for (int k = 0; k < columnNumber; k++) {
			for (int i = 0; i < rowNumber; i++) {
				if (maze[k][i].getType() == "A") {
					arrivee = maze[k][i];
					count += 1;
				}
			}
		}
		if (arrivee == null) {
			throw new Exception("Il n'y a pas de case d�part");
		}
		if (count > 1) {
			throw new Exception("Il y a plus d'une case d�part");
		}
		return arrivee;
	}
	/**
	 * Renvoie la liste des noeuds enfants d'un noeud du graphe
	 *
	 * @param  vertex un noeud du graphe r�pr�sentant le labyrinthe
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
		if ((x - 1) >= 0 && !maze[x - 1][y].isWall()) { // on v�rifie que x-1 est dans le graphe et que maze[x-1][y]
														// n'est
														// pas un mur
			successors.add(maze[x - 1][y]); // ajout de l'�l�ment
		}
		if ((x + 1) < maze.length && !maze[x + 1][y].isWall()) {
			successors.add(maze[x + 1][y]); // ajout de l'�l�ment
		}
		if ((y - 1) >= 0 && !maze[x][y - 1].isWall()) {
			successors.add(maze[x][y - 1]); // ajout de l'�l�ment
		}
		if ((y + 1) < maze[0].length && !maze[x][y + 1].isWall()) { // maze[0].length donne la largeur du tableau
			successors.add(maze[x][y + 1]); // ajout de l'�l�ment
		}
		return successors;
	}
	/**
	 * Renvoie la valeur de l'ar�te entre deux sommets, �ventuellent +inf
	 *
	 * @param  src sommet de d�part
	 * @param dst sommet d'arriv�e
	 * @return double donnant le poids de l'ar�te (src,dst)
	 */
	public Double getWeight(final VertexInterface src, final VertexInterface dst) { // retourne 1 si il existe une
																					// arr�te entre srx et
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
	 * Change le labyrinthe en l'initialisant � partir d'un fichier texte
	 *
	 * @param fileName fichier texte d'initialisation
	 * @throws MazeReadingException Renvoie une erreur en cas de non conformit� du fichier d'initialisation
	 */
	public final void initFromTextFile(final String fileName) throws MazeReadingException { // permet de cr�er un
																							// labyrinthe �
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
	/**
	 * Enregistre le labyrinthe dans un fichier texte
	 *
	 * @param fileName fichier texte de sauvegarde du labyrinthe
	 * @throws FileNotFoundException
	 */
	public final void saveToTextFile(final String fileName) throws FileNotFoundException { // permet de cr�er un fichier texte
																						// � partir d'un labyrinthe
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
