package Interfaces;

public interface PiInterface {
	public void init(GraphInterface g) ; //initialise une fonction pi sur les sommets valant tous +inf
	public Double value(VertexInterface s) ; //donne la valeur de pi(s)
	public void changeValue(VertexInterface s, Double x) ; //change la valeur de pi(s)
}
