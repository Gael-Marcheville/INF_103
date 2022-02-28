package dijkstra;

import java.util.ArrayList;

import Interfaces.ASetInterface;
import Interfaces.GraphInterface;
import Interfaces.PiInterface;
import Interfaces.PreviousInterface;
import Interfaces.VertexInterface;

public class Dijkstra {
	/**
	 * Retourne un objet Previous permettant de remonter au plus court chemin à
	 * partir de r
	 * 
	 * @param g        graphe
	 * @param r        Vertex racine de l'exécution de l'algorithme
	 * @param a        ASet ensemble permettant de garder les Vertex déjà traités
	 * @param pi       Hashtable permettant de garder le poids des chemins
	 * @param previous Hashable permettant de garder les chemins
	 *
	 * @return previous Hashable, previous(s) donnant le père de s dans le plus
	 *         court chemin (r,s)
	 */
	private static PreviousInterface dijkstra(GraphInterface g, VertexInterface r, ASetInterface a, PiInterface pi,
			PreviousInterface previous) {
		final ArrayList<VertexInterface> allVertices = g.getAllVertices();
		a.add(r);
		VertexInterface pivot = r;
		pi.init(g); // initialise pi avec tout les sommets de g à +inf
		pi.changeValue(r, (double) 0); // on initialise la valeur de r à 0
		final int n = allVertices.size(); // nombre de sommets
		for (int j = 0; j < n; j++) {
			final ArrayList<VertexInterface> successors = g.getSuccessors(pivot);
			for (VertexInterface y : successors) {
				if (!a.contains(y)) {
					if (pi.value(pivot) + g.getWeight(pivot, y) < pi.value(y))
						;
					pi.changeValue(y, pi.value(pivot) + g.getWeight(pivot, y));
					previous.changeValue(y, pivot);
				}
			}
			VertexInterface y = allVertices.get(0);
			int k = 1;
			while (a.contains(y) && (k < n)) {
				y = allVertices.get(k);
				k += 1;
			}
			for (VertexInterface x : allVertices) {
				if ((!a.contains(x)) && (pi.value(y) > pi.value(x))) {
					y = x;

				}
			}
			pivot = y;
			a.add(y); // comme a est un ensemble, si y in a, a.add(y) n'ajoute pas une deuxième fois y
						// à a
		}

		return previous;
	}

	/**
	 * Retourne un objet Previous permettant de remonter au plus court chemin à
	 * partir de r
	 * 
	 * @param g graphe
	 * @param r Vertex racine de l'exécution de l'algorithme
	 *
	 * @return previous Hashable, previous(s) donnant le père de s dans le plus
	 *         court chemin (r,s)
	 */
	public static PreviousInterface dijkstra(GraphInterface g, VertexInterface r) {
		final ASet aSet = new ASet();
		final Pi pi = new Pi();
		final Previous previous = new Previous();
		return dijkstra(g, r, aSet, pi, previous);
	}
}
