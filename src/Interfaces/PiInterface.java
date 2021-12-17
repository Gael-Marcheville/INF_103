package Interfaces;

public interface PiInterface {
	/**
	 * Initialise pi, pour tout s pi(s) = +Infty
	 *
	 * @param g graphe sur lequel construire pi
	 */
	public void init(final GraphInterface g) ; //initialise une fonction pi sur les sommets valant tous +inf
	/**
	 * Renvoie la valeur pi(s)
	 *
	 * @param s Vertex
	 * @return Double valeur de pi(s), éventuellement Infty
	 */
	public Double value(final VertexInterface s) ; //donne la valeur de pi(s)
	/**
	 * change la valeur pi(s)
	 *
	 * @param s Vertex
	 * @param x nouvelle valeur de pi(s), éventuellement Infty
	 */
	public void changeValue(final VertexInterface s, final Double x) ; //change la valeur de pi(s)
}
