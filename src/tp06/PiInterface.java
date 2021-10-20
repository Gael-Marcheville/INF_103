package tp06;

public interface PiInterface {
	public PiInterface init(int n) ; //initialise une fonction pi sur n sommet valant tous +inf
	public int value(VertexInterface s) ; //donne la valeur de pi(s)
	public void changeValue(VertexInterface s, int x) ; //change la valeur de pi(s)
}
