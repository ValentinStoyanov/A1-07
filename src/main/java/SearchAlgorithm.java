import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SearchAlgorithm {

	public static boolean busqueda_acotada(Cube Prob, String estrategia, int Prof_max, boolean optimized,
			boolean print_stdout, boolean print_file) throws IOException {

		PriorityQueue<TreeNode> front = new PriorityQueue<TreeNode>();
		HashMap<String, Double> visited = new HashMap<>();

		TreeNode n_inicial = new TreeNode(Prob, estrategia);
		front.add(n_inicial);
		boolean solucion = false;
		TreeNode n_actual = null;
		int node_id = 0;
		while (!solucion && !front.isEmpty()) {
			
			n_actual = front.remove();
			node_id++;
			n_actual.setID(node_id);
			if (print_stdout) {
				System.out.println(n_actual.toString());
			}

			if (print_file) {
				importexport.write(n_actual.toString() + "\n");
			}
			if (StateSpace.isGoal(n_actual.getState())) {
				solucion = true;
			} else {
				ArrayList<Successor> LS = StateSpace.Succesors(n_actual.getState(), n_actual.getCost());
				ArrayList<TreeNode> LN = CrearListaNodosArbol(LS, n_actual, Prof_max, estrategia);

				if (optimized) {

					if (LN != null) {
						if (!LN.isEmpty()) {
							for (TreeNode ni : LN) {
								String md5 = ni.get_md5();
								double f_value = ni.getF();
								if (!visited.containsKey(md5)) {
									visited.put(md5, Math.abs(f_value));
									front.add(ni);
									node_id++;
								} else {
									double f_visited = visited.get(md5);
									if (f_visited > f_value) {
										front.add(ni);
										visited.put(md5, Math.abs(f_value));
										node_id++;
									}
								}
							}
						}
					}
				} else {
					if (LN != null) {
						if (!LN.isEmpty()) {
							for (TreeNode nc : LN) {
								front.add(nc);
							}
						}
					}
				}

			}
		}

		if (solucion) {
			System.out.println("The solution of the problem is: ");
			Printer.printcube(n_actual.getState());
			System.out.println(n_actual.toString());
		} else {

			solucion = false;
			System.out.println("No hay solucion");
		}
		return solucion;
	}

	public static boolean busqueda(Cube Prob, String estrategia, int Prof_Max, int Inc_Prof, boolean Optimized,
			boolean print_stdout, boolean print_file) throws IOException {
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

		if (n_actual.getDepth() < prof_max) {
			for (int i = 0; i < lS.size(); i++) {

				LN.add(new TreeNode(n_actual, lS.get(i).getState(), lS.get(i).getAccion(), estrategia));
			}
		} else {
			LN = null;
		}
		return LN;
	}

}
