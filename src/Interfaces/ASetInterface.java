package Interfaces;

public interface ASetInterface {
	public boolean contains(final VertexInterface s) ; //dis si s est dans A
	public void add(final VertexInterface s) ; //ajoute s à A
	public void remove(final VertexInterface s) ; //supprime s de A
	public int size() ;

}
