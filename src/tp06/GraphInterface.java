package tp06;

public interface GraphInterface {
	public boolean isArc(VertexInterface s1, VertexInterface s2); //True si il existe un arc entre s1 et s2
	public void addArc(VertexInterface s1, VertexInterface s2); //ajoute un arc entre s1 et s2
	public void supprArc(VertexInterface s1, VertexInterface s2); //supprime l'arc entre s1 et s2
}
