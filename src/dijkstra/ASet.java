package dijkstra;

import java.util.HashSet;

import Interfaces.ASetInterface;
import Interfaces.VertexInterface;

public class ASet implements ASetInterface {
	private final HashSet<VertexInterface> aSet;
	
	public ASet()
	{   aSet = new HashSet<VertexInterface>();
	}

	public boolean contains(final VertexInterface s) {
		return aSet.contains(s);
	}

	public void add(final VertexInterface s) {
		aSet.add(s);
	}

	public void remove(final VertexInterface s) { //si s n'est pas dans ASet, cette fonction ne fait rien
		aSet.remove(s);
	}

	public int size() {
		return aSet.size();
	}
	

}
