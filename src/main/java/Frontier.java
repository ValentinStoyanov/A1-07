import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Frontier {

	public static void main(String[] args) {
		double linktime = 0;
		linktime += testlinkedlist();
		linktime += testlinkedlist();
		linktime += testlinkedlist();
		linktime += testlinkedlist(); 
		linktime += testlinkedlist(); 
		linktime += testlinkedlist(); 
		
		System.out.println("El tiempo medio de la linked list para la insercion de nodos es:  "+(linktime/6)/1000000000);
		
		
		double queuetime = 0;
		queuetime += testpriorityqueue();
		queuetime += testpriorityqueue();
		queuetime += testpriorityqueue();
		queuetime += testpriorityqueue();
		queuetime += testpriorityqueue();
		queuetime += testpriorityqueue();
		
		System.out.println("El tiempo medio de la queue para la insercion de nodos es:  "+(queuetime/6)/1000000000);
	}


	public static long testlinkedlist() {

		Cube cube = importexport.convertjson();
		LinkedList<TreeNode> x = new LinkedList<TreeNode>();
		String[] moves = Movements.Movements_list(cube);

		long startTime = System.nanoTime();

		for (int i = 0; i < 10000000; i++) {

			int indicemov = (int) (Math.random() * cube.getBack().length*6);
			TreeNode a = new TreeNode(cube,"");
			a.setState(Movements.do_movement(cube,moves[indicemov]));
			a.setF((int)Math.random()*10000);
			x.add(a);

		}

		long endTime = System.nanoTime();
		endTime = endTime - startTime;

		System.out.println("Elapsed time in miliseconds: " + endTime);

		return endTime;
	}

	public static long testpriorityqueue() {

		Cube cube = importexport.convertjson();
		PriorityQueue<TreeNode> x =  new PriorityQueue<TreeNode>(); 
		String[] moves = Movements.Movements_list(cube);

		long startTime = System.nanoTime();

		for (int i = 0; i < 10000000; i++) {

			int indicemov = (int) (Math.random() * cube.getBack().length*6);
			TreeNode a = new TreeNode(cube,"");
			a.setState(Movements.do_movement(cube,moves[indicemov]));
			a.setF((int)Math.random()*10000);
			x.add(a);

		}

		long endTime = System.nanoTime();
		endTime = endTime - startTime;

		System.out.println("Elapsed time in miliseconds: " + endTime);

		return endTime;
	}

}
