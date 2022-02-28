package Interfaces;

public interface ASetInterface {
	/**
	 * Retourne Vrai si s est dans ASet, Faux sinon
	 *
	 * @param s Vertex
	 * @return boolean Vrai si s est dans ASet, Faux sinon
	 */
	public boolean contains(VertexInterface s); // dis si s est dans A

	/**
	 * Ajoute s dans ASet
	 *
	 * @param s Vertex
	 */
	public void add(VertexInterface s); // ajoute s � A

	/**
	 * Enl�ve s de ASet
	 *
	 * @param s Vertex
	 */
	public void remove(VertexInterface s); // supprime s de A

	/**
	 * Retourne le nombre d�l�ment de ASet
	 *
	 * @return int nombre d'�l�ment de ASet
	 */
	public int size();

}
