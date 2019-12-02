import java.util.ArrayList;

public class StateSpace {

	public static ArrayList<Successor> Succesors(Cube state, int cost) {
		ArrayList<Successor> successors = new ArrayList<>();
		String[] movements = Movements.Movements_list(state);
		Cube[] cubearray = new Cube[movements.length];
		for (int i = 0; i < movements.length; i++) {
			
			Cube aux = new Cube(clonearray(state.getBack()), clonearray(state.getDown()), clonearray(state.getFront()),
					clonearray(state.getLeft()), clonearray(state.getRight()), clonearray(state.getUp()));
			
			cubearray[i] = Movements.do_movement(aux, movements[i]);
			Successor s = new Successor(movements[i], aux, 1);
			successors.add(s);
			// Printer.printcube(cubearray[i]);
		}
		return successors;

	}

	public static int[][] clonearray(int[][] a1) {
		int[][] a2 = new int[a1.length][a1.length];
		for (int i = 0; i < a1.length; i++) {
			for (int j = 0; j < a1.length; j++) {
				a2[i][j] = a1[i][j];
			}
		}
		return a2;
	}

	public static boolean isGoal(Cube state) {
		boolean bol = true;

		if (checklado(state.getBack()) && checklado(state.getDown()) && checklado(state.getFront())
				&& checklado(state.getLeft()) && checklado(state.getRight()) && checklado(state.getUp())) {
			bol = true;
		} else {
			bol = false;
		}
		return bol;
	}

	public static boolean checklado(int[][] a) {
		int num1 = a[0][0];
		int num2;
		boolean equal = true;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (num1 != a[i][j]) {
					equal = false;
				}
			}
		}

		return equal;
	}

}
