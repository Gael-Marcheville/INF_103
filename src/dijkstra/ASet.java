package dijkstra;

import java.util.HashSet;

import Interfaces.ASetInterface;
import Interfaces.VertexInterface;

public class ASet implements ASetInterface {
	private final HashSet<VertexInterface> aSet;
	/**
	 * Renvoie un objet ASet, HashSet
	 */
	public ASet()
	{   aSet = new HashSet<VertexInterface>();
	}

	/**
	 * Renvoie Vrai si s est dans ASet, Faux sinon
	 *
	 * @param s Vertex 
	 * @return boolean Vrai si s est dans ASet, Faux sinon
	 */
	public boolean contains(final VertexInterface s) {
		return aSet.contains(s);
	}
	/**
	 * Ajoute s dans ASet
	 *
	 * @param s Vertex 
	 */
	public void add(final VertexInterface s) {
		aSet.add(s);
	}
	/**
	 * enl�ve s de ASet
	 *
	 * @param s Vertex 
	 */
	public void remove(final VertexInterface s) { //si s n'est pas dans ASet, cette fonction ne fait rien
		aSet.remove(s);
	}
	/**
	 * Renvoie le nombre d�l�ment de ASet
	 *
	 * @return int nombre d'�l�ment de ASet
	 */
	public int size() {
		return aSet.size();
	}
	

}
