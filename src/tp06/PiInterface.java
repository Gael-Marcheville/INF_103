package tp06;

public interface PiInterface {
	public void init(GraphInterface g) ; //initialise une fonction pi sur les sommets valant tous +inf
	public int value(VertexInterface s) ; //donne la valeur de pi(s)
	public void changeValue(VertexInterface s, int x) ; //change la valeur de pi(s)
}
