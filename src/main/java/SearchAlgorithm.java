import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class SearchAlgorithm {
	//implement visited list with md5 arraylist and f value
	//the key(teoria) is the md5 
	//we have to consider when checking if the node is not visited  or if the node is visited with greater f
	//Change the value of f and the visited node in the visited list when the node is visited and the f is greater of the expanded node
	//condition to revisit f.current < f.visited_list
	//we have to remove all the elements of the visited list in IteratvieDeepeningSearch
	//We have to make an special action with depth and iterative in the negative cost
	//Use absolute value for the values of the cost 
	//We need to have 2 version: prunning or optimized code and non prunning code
	//Global value optimization true or false  
	

	public static boolean Busqueda_acotada(Cube prob, String estrategia, int profundidad) {
		// Proceso de inicialización
		SortedSet<TreeNode> frontier = new TreeSet<TreeNode>();
		TreeNode nodo_inicial = new TreeNode(null, prob, 0, "", 0, 0);
		frontier.add(nodo_inicial);
		boolean solucion = false;
		TreeNode n_actual = null;

		while (!solucion && !frontier.isEmpty()) {

			n_actual = frontier.last();
			if (StateSpace.isGoal(n_actual.getState())) {
				solucion = true;
			} else {
				ArrayList<Successor> LS = StateSpace.Succesors(n_actual.getState());
				ArrayList<TreeNode> LN = CreaListaNodosArbol(LS, n_actual.getState(), 0, "");
			}
		}

		// #Resultado
		if (solucion) {
			Printer.printcube(n_actual.getState());
		} else {
			System.out.println("NO HAY SOLUCION");
		}
		return solucion;
	}

	public static boolean Busqueda(Cube prob, String estrategia, int prof_Max, int inc_Prof) {
		int prof_Actual = inc_Prof;

		boolean solucion = false;

		while (!solucion && prof_Actual >= prof_Max) {
			Printer.printcube(prob);

			solucion = Busqueda_acotada(prob, estrategia, prof_Actual);
			prof_Actual = prof_Actual + inc_Prof;
		}
		return solucion;

	}

	public static ArrayList<TreeNode> CreaListaNodosArbol(ArrayList<Successor> LS, Cube nodo_actual, int Prof_Max,
			String estrategia) {
		ArrayList<TreeNode> LN = new ArrayList<TreeNode>();

		for (int i = 0; i < LS.size(); i++) {
			TreeNode nodo = new TreeNode();
			nodo.setState(LS.get(i).getState());
			LN.add(nodo);
		}

		return LN;

	}

}
