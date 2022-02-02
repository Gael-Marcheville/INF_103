package dijkstra;

import java.util.ArrayList;
import java.util.Hashtable;

import Interfaces.GraphInterface;
import Interfaces.PiInterface;
import Interfaces.VertexInterface;

public class Pi implements PiInterface {
	private final Hashtable<VertexInterface, Double> pi; 
	private final Double infty = Double.POSITIVE_INFINITY; //valeur de l'infini pour notre implémentation
	/**
	 * Renvoie un objet pi, Hashtable
	 *
	 */
	public Pi(){
		pi = new Hashtable<VertexInterface, Double>();
	}
	/**
	 * Initialise pi, pour tout s pi(s) = +Infty
	 *
	 * @param g graphe sur lequel construire pi
	 */
	public void init(GraphInterface g) { //initialisation de pi pour l'algo dijkstra
		final ArrayList<VertexInterface> allVertices = g.getAllVertices();
		for(VertexInterface v: allVertices) {
			pi.put(v,infty);
		}
	}
	/**
	 * Renvoie la valeur pi(s)
	 *
	 * @param s Vertex
	 * @return Double valeur de pi(s), éventuellement Infty
	 */
	public Double value(VertexInterface s) {
		return pi.get(s);
	}
	/**
	 * change la valeur pi(s)
	 *
	 * @param s Vertex
	 * @param x nouvelle valeur de pi(s), éventuellement Infty
	 */
	public void changeValue(VertexInterface s, Double x) {
		pi.put(s, x);
		
	}

}
