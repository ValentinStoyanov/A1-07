
public class StateSpace {

	public static void Succesors(Cube state) {

		String[] movements = Movements.Movements_list(state);

		Cube[] cubearray = new Cube[movements.length];

		for (int i = 0; i < movements.length; i++) {
			Cube aux = new Cube(clonearray(state.getBack()), clonearray(state.getDown()), clonearray(state.getFront()),
					clonearray(state.getLeft()), clonearray(state.getRight()), clonearray(state.getUp()));
			cubearray[i] = Movements.do_movement(aux, movements[i]);
			Printer.printcube(cubearray[i]);

		}
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
		Cube cube = importexport.convertjson();
		String a = importexport.getMd5(cube);
		String b = importexport.getMd5(state);
		if (!a.equals(b)) {
			bol = false;
		}
		return bol;
	}

}
