package dijkstra;

import java.util.ArrayList;
import java.util.Hashtable;

import Interfaces.GraphInterface;
import Interfaces.PiInterface;
import Interfaces.VertexInterface;

public class Pi implements PiInterface {
	private final Hashtable<VertexInterface, Double> pi; 
	private final Double infty = Double.POSITIVE_INFINITY; //valeur de l'infini pour notre implémentation
	
	public Pi(){
		pi = new Hashtable<VertexInterface, Double>();
	}
	
	@Override
	public void init(GraphInterface g) { //initialisation de pi pour l'algo dijkstra
		final ArrayList<VertexInterface> allVertices = g.getAllVertices();
		for(VertexInterface v: allVertices) {
			pi.put(v,infty);
		}
	}

	public Double value(VertexInterface s) {
		return pi.get(s);
	}
	
	public void changeValue(VertexInterface s, Double x) {
		pi.put(s, x);
		
	}

}
