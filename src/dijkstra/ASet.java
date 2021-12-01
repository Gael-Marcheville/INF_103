package dijkstra;

import java.util.ArrayList;
import java.util.HashSet;

import Interfaces.ASetInterface;
import Interfaces.VertexInterface;

public class ASet implements ASetInterface {
	private final HashSet<VertexInterface> aSet;
	
	public ASet()
	{   aSet = new HashSet<VertexInterface>();
	}

	public boolean isIn(VertexInterface s) {
		return aSet.contains(s);
	}

	public void add(VertexInterface s) {
		aSet.add(s);
	}

	public void suppr(VertexInterface s) { //si s n'est pas dans ASet, cette fonction ne fait rien
		aSet.remove(s);
	}

	public int length() {
		return aSet.size();
	}
	

}
