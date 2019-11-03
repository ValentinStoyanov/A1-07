import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class SearchAlgorithm {

	

	public static boolean Busqueda_acotada (Cube prob, String estrategia, int profundidad) {
		//Proceso de inicialización
		SortedSet<TreeNode> frontier = new TreeSet<TreeNode>();
		TreeNode nodo_inicial = new TreeNode(null,prob,0,"",0,0);
		frontier.add(nodo_inicial);
		boolean solucion = false; 
		 TreeNode n_actual= null;
		  
		  
		  while(!solucion && !frontier.isEmpty()) {
			  
		    n_actual = frontier.last();
		    if(StateSpace.isGoal(n_actual.getState())) {
		    	solucion = true;
		    }else {
		    	ArrayList<Successor> LS = StateSpace.Succesors(n_actual.getState());
		    	ArrayList<TreeNode> LN = CreaListaNodosArbol(LS,n_actual.getState(),0,"");
		    }
		  }
		  
		  //#Resultado 
		  if(solucion) {
			  Printer.printcube(n_actual.getState());
		  }else {
			  System.out.println("NO HAY SOLUCION");
		  }
		  return solucion;
	}
	
	public static boolean Busqueda (Cube prob,String estrategia,int prof_Max,int inc_Prof) {
		int prof_Actual = inc_Prof;
		
		boolean solucion = false;
		
		while(!solucion && prof_Actual >= prof_Max) {
			solucion = Busqueda_acotada(prob,estrategia,prof_Actual);
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
