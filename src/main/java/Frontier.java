import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Frontier {

	public static void main(String[] args) {
		stresstest7();
	}

	public static void stresstest7() {

		Cube cube = importexport.convertjson();
		SortedSet<Cube> set = new TreeSet<Cube>();
		String[] moves = Movements.Movements_list(cube);
		Cube vacio = new Cube();
		int i = 0;

		while (true) {
			int indicemov = (int) (Math.random() * 60);
			set.add(Movements.do_movement(cube, moves[indicemov]));
			i++;
			System.out.println(i);
		}

	}

	public static void stresstest1() {

		Cube cube = importexport.convertjson();
		ArrayList<Cube> list = new ArrayList();
		String[] moves = Movements.Movements_list(cube);
		Cube vacio = new Cube();
		int i = 0;

		while (true) {
			int indicemov = (int) (Math.random() * 60);
			list.add(Movements.do_movement(cube, moves[indicemov]));
			i++;
			System.out.println(i);
		}

	}

	public static void datatest() {
		long time1;
		long time2;

		time1 = testset();
		time2 = testarraylist();

		if (time1 > time2) {
			System.out.println("ArrayList is the best");
		} else {
			System.out.println("SortedSet is the best");
		}

	}

	public static long testarraylist() {

		Cube cube = importexport.convertjson();
		ArrayList<Cube> list = new ArrayList();
		String[] moves = Movements.Movements_list(cube);
		Cube vacio = new Cube();

		long startTime = System.nanoTime();

		for (int i = 0; i < 100000; i++) {

			int indicemov = (int) (Math.random() * 60);
			list.add(Movements.do_movement(cube, moves[indicemov]));

		}

		long endTime = System.nanoTime();
		endTime = endTime - startTime;

		// System.out.println("Elapsed time in miliseconds: " + endTime);

		return endTime;
	}

	public static long testset() {

		Cube cube = importexport.convertjson();
		SortedSet<Cube> set = new TreeSet<Cube>();
		String[] moves = Movements.Movements_list(cube);
		Cube vacio = new Cube();

		long startTime = System.nanoTime();

		for (int i = 0; i < 100000; i++) {

			int indicemov = (int) (Math.random() * 60);
			set.add(Movements.do_movement(cube, moves[indicemov]));

		}

		long endTime = System.nanoTime();
		endTime = endTime - startTime;

		// System.out.println("Elapsed time in miliseconds: " + endTime);

		return endTime;
	}

}
