package tp06;

import java.util.ArrayList;

public class Dijkstra {
	private PreviousInterface dijkstra(GraphInterface g, VertexInterface r, ASetInterface a, PiInterface pi, PreviousInterface previous) {
		a.add(r);
		VertexInterface pivot = r;
		pi.init(g); // initialise pi avec tout les sommets de g à +inf
		pi.changeValue(r, 0); // on initialise la valeur de r à 0
		final int n = g.getAllVertices().size(); // nombre de sommets
		for (int j = 0; j < n; j++) {
			ArrayList<VertexInterface> successors = g.getSuccessors(pivot);
			final int length = successors.size();
			ArrayList<VertexInterface> candidat_pivot = new ArrayList<VertexInterface>(); // on va y lister les sommets qui peuvent devenir pivot																						
			for (int k = 0; k < length; k++) {
				VertexInterface y = successors.get(k);
				if (!a.isIn(y)) {
					if (pi.value(pivot) + g.getWeight(pivot, y) < pi.value(y)) {
						pi.changeValue(y, pi.value(pivot) + g.getWeight(pivot, y));
						previous.changeValue(y, pivot);
						candidat_pivot.add(y);
					}
				}
			}
			VertexInterface y = pivot; // y est la valeur du min
			for (int k = 1; k < candidat_pivot.size(); k++) {
				if (pi.value(y) > pi.value(candidat_pivot.get(k))) {
					y = candidat_pivot.get(k);
				}
			}
			pivot = y;
			a.add(y); // comme a est un ensemble, si y in a, a.add(y) n'ajoute pas une deuxième fois y à a
		}
		return previous;
	}
}
