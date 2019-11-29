import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class SearchAlgorithm {

	public static boolean busqueda_acotada(Cube Prob, String estrategia, int Prof_max, boolean optimized)
			throws IOException {

		PriorityQueue<TreeNode> front = new PriorityQueue<TreeNode>();
		HashMap<String, Double> visited = new HashMap<>();

		TreeNode n_inicial = new TreeNode(Prob, estrategia);
		front.add(n_inicial);
		boolean solucion = false;
		TreeNode n_actual = null;

		while (!solucion && !front.isEmpty()) {

			n_actual = front.remove();
			visited.put(importexport.getMd5(n_actual.getState()), Math.abs(n_actual.getF()));
			System.out.println(visited);

			if (StateSpace.isGoal(n_actual.getState())) {
				solucion = true;
			} else {
				ArrayList<Successor> LS = StateSpace.Succesors(n_actual.getState(), n_actual.getCost());
				ArrayList<TreeNode> LN = CrearListaNodosArbol(LS, n_actual, Prof_max, estrategia);
				if (!LN.isEmpty()) {
					for (TreeNode ni : LN) {
						if (!visited.containsKey(ni)) {
							visited.put(importexport.getMd5(ni.getState()), Math.abs(n_actual.getF()));
							front.add(ni);
						} else {
							if ((double) visited.get(importexport.getMd5(ni.getState())) > Math.abs(ni.getF())) {
								visited.replace(importexport.getMd5(ni.getState()), Math.abs(n_actual.getF()));
								front.add(ni);
							}
						}
					}
				}

				front = addnodestofrontier(front, LN);
			}
		}

		if (solucion) {
			Printer.printcube(n_actual.getState());
			System.out.println(n_actual.toString());
		} else {

			solucion = false;
			System.out.println("No hay solucion");
		}
		return solucion;
	}

	public static boolean busqueda(Cube Prob, String estrategia, int Prof_Max, int Inc_Prof, boolean Optimized)
			throws IOException {
		int Prof_Actual = Inc_Prof;
		boolean solucion = false;
		while (!solucion && Prof_Actual <= Prof_Max) {
			solucion = busqueda_acotada(Prob, estrategia, Prof_Actual, Optimized);
			Prof_Actual = Prof_Actual + Inc_Prof;
		}
		return solucion;
	}

	public static ArrayList<TreeNode> CrearListaNodosArbol(ArrayList<Successor> lS, TreeNode n_actual, int prof_max,
			String estrategia) {

		ArrayList<TreeNode> LN = new ArrayList<TreeNode>();

		if (n_actual.getDepth() < prof_max) {
			for (int i = 0; i < lS.size(); i++) {

				LN.add(new TreeNode(n_actual, lS.get(i).getState(), lS.get(i).getAccion(), estrategia));
			}
		} else {
			LN = null;
		}
		return LN;
	}

	public static PriorityQueue<TreeNode> addnodestofrontier(PriorityQueue<TreeNode> front, ArrayList<TreeNode> LN) {

		if (!(LN == null)) {
			for (int i = 0; i < LN.size(); i++) {
				front.add(LN.get(i));
			}
		}

		return front;
	}

}
