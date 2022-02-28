package Interfaces;

public interface PreviousInterface {
	/**
	 * Retourne la valeur previous(s)
	 *
	 * @param x Vertex
	 * @return Vertex valeur de previous(s)
	 */
	public VertexInterface value(VertexInterface x);

	/**
	 * Réalise l'affectation previous(x)=y
	 *
	 * @param x Vertex
	 * @param y Vertex nouvelle valeur de previous(x)
	 */
	public void changeValue(VertexInterface x, VertexInterface y); // réalise l'affectation p(x)=y
}
