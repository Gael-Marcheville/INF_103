package dijkstra;

import java.util.Hashtable;

import Interfaces.PreviousInterface;
import Interfaces.VertexInterface;

public class Previous implements PreviousInterface {
	private final Hashtable<VertexInterface,VertexInterface> previous; 
	
	public Previous(){
		previous = new Hashtable<VertexInterface, VertexInterface>();
	}
	public VertexInterface value(VertexInterface x) {
		return previous.get(x);
	}

	public void changeValue(VertexInterface x, VertexInterface y) {
		previous.put(x, y);
	}

}
