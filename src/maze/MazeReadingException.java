package maze;

public class MazeReadingException extends Exception {

	/**
	 * Classe d'Exception déclenchée lors d'une erreur de lecture d'un fichier texte
	 * représentant un Maze
	 * 
	 * @return Error : "Message d'erreur", "nom_du_fichier" at row
	 *         "numéro_de_la_ligne"
	 */
	private static final long serialVersionUID = 1L;
	private final static String Newline = System.getProperty("line.separator");

	public MazeReadingException(String fileName, int rowNumber, String errorMessage) {
		super(errorMessage + Newline + fileName + " at row " + String.valueOf(rowNumber));
	}

}
