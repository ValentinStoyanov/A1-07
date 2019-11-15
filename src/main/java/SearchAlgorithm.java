import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;

public class SearchAlgorithm {

	// implement visited list with md5 arraylist and f value
	// the key(teoria) is the md5
	// we have to consider when checking if the node is not visited or if the node
	// is visited with greater f
	// Change the value of f and the visited node in the visited list when the node
	// is visited and the f is greater of the expanded node
	// condition to revisit f.current < f.visited_list
	// we have to remove all the elements of the visited list in
	// IteratvieDeepeningSearch
	// We have to make an special action with depth and iterative in the negative
	// cost
	// Use absolute value for the values of the cost
	// We need to have 2 version: prunning or optimized code and non prunning code
	// Global value optimization true or false

	public static boolean busqueda_acotada(Cube Prob, String estrategia, int Prof_max, boolean optimized) throws IOException {
		ArrayList<VisitedNode> visited = new ArrayList<VisitedNode>();
		PriorityQueue<TreeNode> front = new PriorityQueue<TreeNode>();
		TreeNode n_inicial = new TreeNode(0, null, Prob, 0, "", 0, 0);
		front.add(n_inicial);
		// System.out.println(n_inicial.toString());
		visited.add(new VisitedNode(n_inicial.getF(), importexport.getMd5(n_inicial.getState())));
		boolean solucion = false;
		TreeNode n_actual = null;
		int nodes = 0;

		while (!solucion && !front.isEmpty()) {
			n_actual = front.remove();

			nodes++;

			importexport.write(n_actual.toString()+"\n");

			visited.add(new VisitedNode(n_actual.getF(), importexport.getMd5(n_actual.getState())));

			if (StateSpace.isGoal(n_actual.getState())) {
				solucion = true;
			} else {
				ArrayList<Successor> LS = StateSpace.Succesors(n_actual.getState(), n_actual.getCost());
				ArrayList<TreeNode> LN = CrearListaNodosArbol(LS, n_actual, Prof_max, estrategia);
				if (optimized) {
					front = addnodestofrontierOPT(front, LN, visited);
				} else {
					front = addnodestofrontier(front, LN);
				}
			}
		}
		System.out.println("Numero de nodos: " + nodes);

		if (solucion) {
			Printer.printcube(n_actual.getState());
			System.out.println(n_actual.toString());
		} else {
			solucion = false;
		}
		return solucion;
	}

	public static boolean busqueda(Cube Prob, String estrategia, int Prof_Max, int Inc_Prof, boolean Optimized) throws IOException {
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
		int cost = n_actual.getCost() + 1;
		int depth = n_actual.getDepth() + 1;
		int f = 0;
		if (estrategia.equals("anchura")) {
			f = depth;
		}
		if (estrategia.equals("profundidad")) {
			f = -depth;
		}
		if (estrategia.equals("costo")) {
			f = cost;
		}

		for (int i = 0; i < lS.size() && depth <= prof_max; i++) {
			LN.add(new TreeNode(n_actual.getID(), n_actual, lS.get(i).getState(), cost, lS.get(i).getAccion(), depth,
					f));
		}
		return LN;
	}

	public static PriorityQueue<TreeNode> addnodestofrontier(PriorityQueue<TreeNode> front, ArrayList<TreeNode> LN) {

		for (int i = 0; i < LN.size(); i++) {
			front.add(LN.get(i));
		}

		return front;

	}

	public static PriorityQueue<TreeNode> addnodestofrontierOPT(PriorityQueue<TreeNode> front, ArrayList<TreeNode> LN,
			ArrayList<VisitedNode> visited) {

		for (int ln = 0; ln < LN.size(); ln++) {
			if (nodoisvisited(LN.get(ln), visited)) {

			} else {
				front.add(LN.get(ln));
			}
		}

		return front;
	}

	public static boolean nodoisvisited(TreeNode node, ArrayList<VisitedNode> visited) {
		boolean bol = false;
		String n1, n2;
		n1 = importexport.getMd5(node.getState());
		for (int i = 0; i < visited.size(); i++) {
			n2 = visited.get(i).getMd5();

			if ((node.getF() < visited.get(i).getF()) && (n1.equals(n2))) {
				bol = true;
			}

		}
		return bol;
	}

}
