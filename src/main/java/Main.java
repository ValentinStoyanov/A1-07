import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		
		Cube state = importexport.convertjson();
		state = Movements.do_movement(state, "l1");
		//SearchAlgorithm.busqueda(state, "costo", 10000, 1);
		
		Cube state2 = importexport.convertjson();
		state2 = Movements.do_movement(state, "l0");

		
		SortedSet<TreeNode> x = new TreeSet<TreeNode>();
		TreeNode a = new TreeNode();
		a.setF(1);
		a.setState(state);
		a.setCost(3);
		TreeNode b = new TreeNode();
		b.setF(1);
		b.setState(state2);
		b.setCost(3);
			
		x.add(a);
		x.add(b);
		
		
		System.out.println(x.toString());
		
		
	}
}