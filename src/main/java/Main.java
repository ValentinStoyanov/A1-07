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
		
		double startTime = System.nanoTime();

		Cube state = importexport.convertjson();
		
		
		SearchAlgorithm.busqueda(state, "cost", 6, 1, false);
		
		double endTime = System.nanoTime();
		endTime = endTime - startTime;

		System.out.println("Elapsed time in seconds: " + endTime/1000000000);
		
	}
}