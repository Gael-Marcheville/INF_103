package dijkstra;

import java.util.Hashtable;

import Interfaces.PreviousInterface;
import Interfaces.VertexInterface;

public class Previous implements PreviousInterface {
	private final Hashtable<VertexInterface,VertexInterface> previous; 
	/**
	 * Renvoie un objet previous, Hashtable
	 *
	 */
	public Previous(){
		previous = new Hashtable<VertexInterface, VertexInterface>();
	}
	/**
	 * Renvoie la valeur previous(s)
	 *
	 * @param x Vertex
	 * @return Vertex valeur de previous(s)
	 */
	public VertexInterface value(final VertexInterface x) {
		return previous.get(x);
	}
	/**
	 * Réalise l'affectation previous(x)=y
	 *
	 * @param x Vertex
	 * @param y Vertex nouvelle valeur de previous(x)
	 */
	public void changeValue(final VertexInterface x, final VertexInterface y) {
		previous.put(x, y);
	}

}
