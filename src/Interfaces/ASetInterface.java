package Interfaces;

import java.util.ArrayList;

public interface ASetInterface {
	public boolean contains(VertexInterface s) ; //dis si s est dans A
	public void add(VertexInterface s) ; //ajoute s à A
	public void remove(VertexInterface s) ; //supprime s de A
	public int size() ;
	public Object[] toArray();

}
