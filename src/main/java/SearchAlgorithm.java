import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.PriorityQueue;

public class SearchAlgorithm {

	public static boolean busqueda_acotada(Cube Prob, String estrategia, int Prof_max, boolean optimized,
			boolean print_stdout, boolean print_file) throws IOException, InterruptedException {

		PriorityQueue<TreeNode> front = new PriorityQueue<TreeNode>();
		Hashtable<String, Double> visited = new Hashtable<>();
		TreeNode n_inicial = new TreeNode(Prob, estrategia);
		front.add(n_inicial);
		boolean solucion = false;
		TreeNode n_actual = null;
		int node = 0;

		while (!solucion && !front.isEmpty()) {
			n_actual = front.remove();
			String md5 = n_actual.get_md5();

			if (visited.containsKey(md5) && visited.get(md5) < n_actual.getF()) {

			} else {
				
				visited.put(md5, n_actual.getF());

				if (StateSpace.isGoal(n_actual.getState())) {
					solucion = true;
				} else {
					ArrayList<Successor> LS = StateSpace.Succesors(n_actual.getState(), n_actual.getCost());
					ArrayList<TreeNode> LN = CrearListaNodosArbol(LS, n_actual, Prof_max, estrategia);
					
					if(n_actual.getDepth()<Prof_max) {
							for (TreeNode nc : LN) {
								node++;
								nc.setID(node);
								front.add(nc);

							}
					}
					
					


					// Prunning 2 not working in some cases
					/*
					 * if (optimized) {
					 * 
					 * if (LN != null) { if (!LN.isEmpty()) { for (TreeNode ni : LN) { String md5 =
					 * ni.get_md5(); double f_value = ni.getF(); if (!visited.containsKey(md5)) {
					 * visited.put(md5, Math.abs(f_value)); front.add(ni); node_id++; } else {
					 * double f_visited = visited.get(md5); if (f_visited > f_value) {
					 * front.add(ni); visited.put(md5, Math.abs(f_value)); node_id++; } } } } } }
					 * else { if (LN != null) { if (!LN.isEmpty()) { for (TreeNode nc : LN) {
					 * front.add(nc); } } } }
					 */
				}
			}
		}

		if (solucion) {

			print_camino(n_actual);

		} else {

			solucion = false;
			System.out.println("No hay solucion");
		}
		return solucion;
	}

	public static void print_camino(TreeNode n) {

		ArrayList<TreeNode> sol = new ArrayList<TreeNode>();
		
		while (n != null) {
			sol.add(n);
			n = n.getParent();
		}
		
		for (int i = 0;  i < sol.size(); i++) {
			System.out.println(sol.get(sol.size()-i-1).toString());
		}
		
	}

	public static boolean busqueda(Cube Prob, String estrategia, int Prof_Max, int Inc_Prof, boolean Optimized,
			boolean print_stdout, boolean print_file) throws IOException, InterruptedException {
		int Prof_Actual = Inc_Prof;
		boolean solucion = false;
		while (!solucion && Prof_Actual <= Prof_Max) {
			solucion = busqueda_acotada(Prob, estrategia, Prof_Actual, Optimized, print_stdout, print_file);
			Prof_Actual = Prof_Actual + Inc_Prof;
		}
		return solucion;
	}

	public static ArrayList<TreeNode> CrearListaNodosArbol(ArrayList<Successor> lS, TreeNode n_actual, int prof_max,
			String estrategia) {

		ArrayList<TreeNode> LN = new ArrayList<TreeNode>();

			for (int i = 0; i < lS.size(); i++) {
				LN.add(new TreeNode(n_actual, lS.get(i).getState(), lS.get(i).getAccion(), estrategia));
			}
		return LN;
	}

}
