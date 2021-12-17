package Interfaces;

public interface ASetInterface {
	/**
	 * Renvoie Vrai si s est dans ASet, Faux sinon
	 *
	 * @param s Vertex 
	 * @return boolean Vrai si s est dans ASet, Faux sinon
	 */
	public boolean contains(final VertexInterface s) ; //dis si s est dans A
	/**
	 * Ajoute s dans ASet
	 *
	 * @param s Vertex 
	 */
	public void add(final VertexInterface s) ; //ajoute s à A
	/**
	 * enlève s de ASet
	 *
	 * @param s Vertex 
	 */
	public void remove(final VertexInterface s) ; //supprime s de A
	/**
	 * Renvoie le nombre délément de ASet
	 *
	 * @return int nombre d'élément de ASet
	 */
	public int size() ;

}
