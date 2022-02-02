package maze;

public class MazeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static String Newline = System.getProperty("line.separator");
	public MazeException(String fileName, int rowNumber, String errorMessage) {
		super(errorMessage + Newline + fileName + " at row " + String.valueOf(rowNumber)); //renvoie une exception donnant le nom du fichier txt et la ligne concernée
	}

}
