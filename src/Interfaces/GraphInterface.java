package Interfaces;

import java.util.ArrayList;

public interface GraphInterface {
	
	//Première proposition d'interface (tp06)
	 /*
	public boolean isArc(VertexInterface s1, VertexInterface s2); //True si il existe un arc entre s1 et s2
	public void addArc(VertexInterface s1, VertexInterface s2); //ajoute un arc entre s1 et s2
	public void supprArc(VertexInterface s1, VertexInterface s2); //supprime l'arc entre s1 et s2
	*/
	
	//Interface retenue
    public ArrayList<VertexInterface> getAllVertices() ; //donne la liste des sommets
    public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) ; //donne la liste des successeurs de vertex
    public int getWeight(VertexInterface src,VertexInterface dst) ; //donne la distance entre s1 et s2
    
}
