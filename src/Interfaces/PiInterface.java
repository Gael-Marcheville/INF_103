package Interfaces;

public interface PiInterface {
	/**
	 * Initialise pi, pour tout s pi(s) = +Infty
	 *
	 * @param g graphe sur lequel construire pi
	 */
	public void init(GraphInterface g);

	/**
	 * Retourne la valeur pi(s)
	 *
	 * @param s Vertex
	 * @return Double valeur de pi(s), éventuellement Infty
	 */
	public Double value(VertexInterface s);

	/**
	 * change la valeur pi(s)
	 *
	 * @param s Vertex
	 * @param x nouvelle valeur de pi(s), éventuellement Infty
	 */
	public void changeValue(VertexInterface s, Double x);
}
