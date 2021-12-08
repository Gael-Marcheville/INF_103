package dijkstra;

import java.util.Hashtable;

import Interfaces.PreviousInterface;
import Interfaces.VertexInterface;

public class Previous implements PreviousInterface {
	private final Hashtable<VertexInterface,VertexInterface> previous; 
	
	public Previous(){
		previous = new Hashtable<VertexInterface, VertexInterface>();
	}
	public VertexInterface value(final VertexInterface x) {
		return previous.get(x);
	}

	public void changeValue(final VertexInterface x, final VertexInterface y) {
		previous.put(x, y);
	}

}
