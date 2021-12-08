package Interfaces;

public interface PiInterface {
	public void init(final GraphInterface g) ; //initialise une fonction pi sur les sommets valant tous +inf
	public Double value(final VertexInterface s) ; //donne la valeur de pi(s)
	public void changeValue(final VertexInterface s, final Double x) ; //change la valeur de pi(s)
}
