package dijkstra;

import java.util.HashSet;

import Interfaces.ASetInterface;
import Interfaces.VertexInterface;

public class ASet implements ASetInterface {
	private final HashSet<VertexInterface> aSet;

	/**
	 * Retourne un objet ASet, HashSet
	 */
	public ASet() {
		aSet = new HashSet<VertexInterface>();
	}

	/**
	 * Retourne Vrai si s est dans ASet, Faux sinon
	 *
	 * @param s Vertex
	 * @return boolean Vrai si s est dans ASet, Faux sinon
	 */
	public boolean contains(VertexInterface s) {
		return aSet.contains(s);
	}

	/**
	 * Ajoute s dans ASet
	 *
	 * @param s Vertex
	 */
	public void add(VertexInterface s) {
		aSet.add(s);
	}

	/**
	 * Enlève s de ASet
	 *
	 * @param s Vertex
	 */
	public void remove(VertexInterface s) { // si s n'est pas dans ASet, cette fonction ne fait rien
		aSet.remove(s);
	}

	/**
	 * Retourne le nombre délément de ASet
	 *
	 * @return int nombre d'élément de ASet
	 */
	public int size() {
		return aSet.size();
	}

}
