package dijkstra;

import java.util.ArrayList;
import java.util.Hashtable;

import Interfaces.GraphInterface;
import Interfaces.PiInterface;
import Interfaces.VertexInterface;

public class Pi implements PiInterface {
	private final Hashtable<VertexInterface,Integer> pi; 
	private final Integer infty = Integer.MAX_VALUE; //valeur de l'infini pour notre implémentation
	
	public Pi(){
		pi = new Hashtable<VertexInterface, Integer>();
	}
	
	@Override
	public void init(GraphInterface g) { //initialisation de pi pour l'algo dijkstra
		final ArrayList<VertexInterface> allVertices = g.getAllVertices();
		for(VertexInterface v: allVertices) {
			pi.put(v,infty);
		}
	}

	public int value(VertexInterface s) {
		return pi.get(s);
	}
	
	public void changeValue(VertexInterface s, int x) {
		pi.put(s, x);
		
	}

}
