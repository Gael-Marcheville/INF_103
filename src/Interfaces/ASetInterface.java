package Interfaces;

public interface ASetInterface {
	public boolean isIn(VertexInterface s) ; //dis si s est dans A
	public void add(VertexInterface s) ; //ajoute s à A
	public void suppr(VertexInterface s) ; //supprime s de A
	public int length() ;

}
