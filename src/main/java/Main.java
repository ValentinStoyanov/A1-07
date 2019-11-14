import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Main {
	public static void main(String[] args) throws IOException {
		
		Cube state = importexport.convertjson();
		state = Movements.do_movement(state, "L2");
		state = Movements.do_movement(state, "L1");
		state = Movements.do_movement(state, "B1");
		state = Movements.do_movement(state, "b2");
		SearchAlgorithm.busqueda(state, "anchura", 5, 1);
		
	}
}