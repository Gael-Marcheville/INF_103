package Interfaces;

import java.util.ArrayList;

public interface GraphInterface {
	/**
	 * Renvoie la liste des sommets du Graphe
	 *
	 * @return ArrayList liste des sommets du Graphe
	 */
    public ArrayList<VertexInterface> getAllVertices() ; //donne la liste des sommets
	/**
	 * Renvoie la liste des sommets successeurs de vertex dans le Graphe
	 *
	 * @param vertex sommet dont on veut les successeurs
	 * @return ArrayList liste des sommets successeurs de vertex dans le Graphe
	 */
    public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) ; //donne la liste des successeurs de vertex
	/**
	 * Renvoie le poids de l'ar�te (src,dst)
	 *
	 * @param src origine de l'ar�te
	 * @param dst arriv�e de l'ar�te
	 * @return Double poids de l'ar�te (src,dst), �ventuellement Infty
	 */
    public Double getWeight(VertexInterface src, VertexInterface dst) ; //donne la distance entre s1 et s2
    
}
