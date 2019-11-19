import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;

public class SearchAlgorithm {

	public static boolean busqueda_acotada(Cube Prob, String estrategia, int Prof_max, boolean optimized)
			throws IOException {

		PriorityQueue<TreeNode> front = new PriorityQueue<TreeNode>();
		ArrayList<String> v_list = new ArrayList<String>();
		TreeNode n_inicial = new TreeNode(Prob, estrategia);
		front.add(n_inicial);
		System.out.println(n_inicial.toString());
		boolean solucion = false;
		TreeNode n_actual = null;
		int node = 0;

		while (!solucion && !front.isEmpty()) {
			
			n_actual = front.remove();
			node++;
			
			while(v_list.contains(importexport.getMd5(n_actual.getState())) && !front.isEmpty() && optimized) {	
				n_actual = front.remove();
				node++;
			}
			
			System.out.println("NODE: "+node);
			System.out.println(n_actual.toString());
			v_list.add(importexport.getMd5(n_actual.getState()));
			
			//System.out.println(n_actual.toString());
			if (StateSpace.isGoal(n_actual.getState())) {
				solucion = true;
			} else {
				ArrayList<Successor> LS = StateSpace.Succesors(n_actual.getState(), n_actual.getCost());
				ArrayList<TreeNode> LN = CrearListaNodosArbol(LS, n_actual, Prof_max, estrategia);
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
