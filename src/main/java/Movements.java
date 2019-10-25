
public class Movements {
	
	public static String[] Movements_list (Cube cube) {
		String [] a = new String[cube.getBack().length*6];
		String character = "L";
		int number = 0;
		
		for(int j = 0; j<cube.getBack().length;j++) {
			a[j] = "L"+j;
			a[j+cube.getBack().length] = "l"+j;
			a[j+cube.getBack().length*2] = "D"+j;
			a[j+cube.getBack().length*3] = "d"+j;
			a[j+cube.getBack().length*4] = "B"+j;
			a[j+cube.getBack().length*5] = "b"+j;
		}
		return a;
	}
	

	public static Cube do_movement(Cube cube, String move) {
		
		//System.out.println("Doing movement: "+move);
		String movement_tipe = move.substring(0, 1);
		int number = Integer.parseInt(move.substring(1));

		switch (movement_tipe) {
		case "L":
		case "l":
			cube = Calculate_mov_position_L(cube, movement_tipe, number);
			//System.out.println("Estas en el movimiento: " + movement_tipe);
			break;
		case "D":
		case "d":
			cube = Calculate_mov_position_D(cube, movement_tipe, number);
			//System.out.println("Estas en el movimiento: " + movement_tipe);
			break;
		case "B":
		case "b":
			cube = Calculate_mov_position_B(cube, movement_tipe, number);
			//System.out.println("Estas en el movimiento: " + movement_tipe);
			break;
		default:
			//System.out.println("MOVIMIENTO NO VALIDO");
		}

		return cube;

	}

	public static Cube Calculate_mov_position_L(Cube cube, String move, int number) {
		int col_back_down_front;
		int col_up;

		col_back_down_front = number;
		col_up = cube.getUp().length - 1 - number;

		if (move.equals("L")) {
			cube = L(cube, col_back_down_front, col_up);
		} else {
			cube = l(cube, col_back_down_front, col_up);
		}
		return cube;
	}

	public static Cube Calculate_mov_position_D(Cube cube, String move, int number) {
		int left_col;
		int rigth_col;
		int front_row;
		int back_row;

		left_col = cube.getLeft().length - 1 - number;
		rigth_col = number;
		front_row = number;
		back_row = cube.getDown().length - 1 - number;

		if (move.equals("D")) {
			cube = D(cube, left_col, rigth_col, front_row, back_row);
		} else {
			cube = d(cube, left_col, rigth_col, front_row, back_row);
		}

		return cube;
	}

	public static Cube Calculate_mov_position_B(Cube cube, String move, int number) {
		int row = number;

		if (move.equals("B")) {
			cube = B(cube, row);
		} else {
			cube = b(cube, row);
		}
		return cube;
	}

	public static Cube L(Cube cube, int col_back_down_front, int col_up) {

		if (col_back_down_front == 0) {
			int[][] left = cube.getLeft();
			left = rotate90(left, left.length);
			cube.setLeft(left);
		}

		if (col_back_down_front == cube.getBack().length - 1) {
			int[][] right = cube.getRight();
			right = rotate90(right, right.length);
			cube.setRight(right);
		}

		cube = mov_traslacionL(cube, col_back_down_front, col_up);

		return cube;
	}

	public static Cube mov_traslacionL(Cube cube, int col_back_down_front, int col_up) {
		int len = cube.getBack().length;
		Cube aux = copy_cube(cube);
		int[] backrow = copy_content_of_array_col(cube.getBack(), len, col_back_down_front);
		backrow = invertrow(backrow);
		int[] uprow = copy_content_of_array_col(cube.getUp(), len, col_up);
		uprow = invertrow(uprow);

		for (int i = 0; i < len; i++) {

			aux.getBack()[i][col_back_down_front] = cube.getDown()[i][col_back_down_front];
			aux.getDown()[i][col_back_down_front] = cube.getFront()[i][col_back_down_front];
			aux.getFront()[i][col_back_down_front] = uprow[i];
			aux.getUp()[i][col_up] = backrow[i];

		}

		return aux;
	}

	public static Cube D(Cube cube, int left_col, int rigth_col, int front_row, int back_row) {

		if (rigth_col == 0) {
			int[][] down = cube.getDown();
			down = rotate90(down, down.length);
			cube.setDown(down);
		}
		if (rigth_col == cube.getBack().length - 1) {
			int[][] up = cube.getUp();
			up = rotate90(up, up.length);
			cube.setUp(up);
		}

		cube = mov_traslacionD(cube, left_col, rigth_col, front_row, back_row);

		return cube;

	}

	public static Cube mov_traslacionD(Cube cube, int left_col, int rigth_col, int front_row, int back_row) {
		int len = cube.getBack().length;
		Cube aux = copy_cube(cube);
		int[] backrow = copy_content_of_array_row(cube.getBack(), len, back_row);

		for (int i = 0; i < len; i++) {
			aux.getBack()[back_row][i] = cube.getLeft()[len - 1 - i][left_col];
		}
		for (int i = 0; i < len; i++) {
			aux.getLeft()[i][left_col] = cube.getFront()[front_row][i];
		}
		for (int i = 0; i < len; i++) {
			aux.getFront()[front_row][i] = cube.getRight()[len - 1 - i][rigth_col];
		}
		for (int j = 0; j < len; j++) {
			aux.getRight()[j][rigth_col] = backrow[j];
		}

		return aux;
	}

	public static Cube B(Cube cube, int row) {

		if (row == 0) {
			int[][] back = cube.getBack();
			back = rotate90(back, back.length);
			cube.setBack(back);
		}
		if (row == cube.getLeft().length - 1) {
			int[][] front = cube.getFront();
			front = rotate90(front, front.length);
			cube.setFront(front);
		}

		cube = mov_traslacionB(cube, row);
		return cube;
	}

	public static Cube mov_traslacionB(Cube cube, int row) {
		int len = cube.getLeft().length;
		Cube aux = copy_cube(cube);
		int[] uprow = copy_content_of_array_row(cube.getUp(), len, row);

		for (int i = 0; i < len; i++) {
			aux.getUp()[row][i] = cube.getRight()[row][i];
			aux.getRight()[row][i] = cube.getDown()[row][i];
			aux.getDown()[row][i] = cube.getLeft()[row][i];
			aux.getLeft()[row][i] = uprow[i];
		}

		return aux;
	}

	public static Cube b(Cube cube, int row) {

		if (row == 0) {
			int[][] back = cube.getBack();
			back = rotateminus90(back);
			cube.setBack(back);
		}

		if (row == cube.getBack().length - 1) {
			int[][] front = cube.getFront();
			front = rotateminus90(front);
			cube.setFront(front);
		}

		cube = mov_traslacionb(cube, row);
		return cube;
	}

	public static Cube mov_traslacionb(Cube cube, int row) {
		int len = cube.getLeft().length;
		Cube aux = copy_cube(cube);
		int[] left = copy_content_of_array_row(cube.getLeft(), len, row);

		for (int i = 0; i < len; i++) {
			aux.getLeft()[row][i] = cube.getDown()[row][i];
			aux.getDown()[row][i] = cube.getRight()[row][i];
			aux.getRight()[row][i] = cube.getUp()[row][i];
			aux.getUp()[row][i] = left[i];
		}

		return aux;
	}

	public static Cube d(Cube cube, int left_col, int rigth_col, int front_row, int back_row) {

		if (rigth_col == 0) {
			int[][] down = cube.getDown();
			down = rotateminus90(down);
			cube.setDown(down);
		}
		if (back_row == 0) {
			int[][] up = cube.getUp();
			up = rotateminus90(up);
			cube.setUp(up);
		}

		cube = mov_traslaciond(cube, left_col, rigth_col, front_row, back_row);
		return cube;
	}

	public static Cube mov_traslaciond(Cube cube, int left_col, int rigth_col, int front_row, int back_row) {
		int len = cube.getBack().length;
		Cube aux = copy_cube(cube);
		int[] right = copy_content_of_array_col(cube.getRight(), len, rigth_col);

		for (int i = 0; i < len; i++) {
			aux.getRight()[i][rigth_col] = cube.getFront()[front_row][len - 1 - i];
		}
		for (int i = 0; i < len; i++) {
			aux.getFront()[front_row][i] = cube.getLeft()[i][left_col];
		}

		for (int i = 0; i < len; i++) {
			aux.getLeft()[i][left_col] = cube.getBack()[back_row][len - 1 - i];
		}

		for (int j = 0; j < len; j++) {
			aux.getBack()[back_row][j] = right[j];
		}

		return aux;
	}

	public static Cube l(Cube cube, int col_back_down_front, int col_up) {

		if (col_back_down_front == 0) {
			int[][] left = cube.getLeft();
			left = rotateminus90(left);
			cube.setLeft(left);
		}

		if (col_back_down_front == cube.getBack().length - 1) {
			int[][] right = cube.getRight();
			right = rotateminus90(right);
			cube.setRight(right);
		}

		cube = mov_traslacionl(cube, col_back_down_front, col_up);
		return cube;
	}

	public static Cube mov_traslacionl(Cube cube, int col_back_down_front, int col_up) {
		int len = cube.getBack().length;
		Cube aux = copy_cube(cube);
		int[] up = copy_content_of_array_col(cube.getUp(), len, col_up);

		for (int i = 0; i < len; i++) {
			aux.getUp()[len - 1 - i][col_up] = cube.getFront()[i][col_back_down_front];
			aux.getFront()[i][col_back_down_front] = cube.getDown()[i][col_back_down_front];
			aux.getDown()[i][col_back_down_front] = cube.getBack()[i][col_back_down_front];
			aux.getBack()[i][col_back_down_front] = up[len - 1 - i];

		}
		return aux;
	}

	public static Cube copy_cube(Cube cube) {
		Cube aux = new Cube();
		aux.setBack(cube.getBack());
		aux.setDown(cube.getDown());
		aux.setFront(cube.getFront());
		aux.setLeft(cube.getLeft());
		aux.setRight(cube.getRight());
		aux.setUp(cube.getUp());

		return aux;
	}

	public static int[] copy_content_of_array_row(int[][] array, int len, int row) {
		int[] aux = new int[len];
		for (int i = 0; i < len; i++) {
			aux[i] = array[row][i];
		}

		return aux;
	}
	// Unir metodos

	public static int[] copy_content_of_array_col(int[][] array, int len, int col) {
		int[] aux = new int[len];
		for (int i = 0; i < len; i++) {
			aux[i] = array[i][col];
		}

		return aux;
	}

	public static int[][] invertcara(int[][] cara) {

		int[][] aux = new int[cara.length][cara.length];
		for (int j = 0; j < cara.length; j++) {
			for (int i = 0; i < cara.length; i++) {
				aux[i][j] = cara[cara.length - i - 1][cara.length - j - 1];
			}
		}

		return aux;
	}

	public static int[] invertrow(int[] array) {

		for (int i = 0; i < array.length / 2; i++) {
			int temp = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = temp;
		}
		return array;
	}

	public static int[][] rotate90(int[][] a, int N) {

		for (int i = 0; i < N / 2; i++) {
			for (int j = i; j < N - i - 1; j++) {

				// Swap elements of each cycle
				// in clockwise direction
				int temp = a[i][j];
				a[i][j] = a[N - 1 - j][i];
				a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j];
				a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i];
				a[j][N - 1 - i] = temp;
			}
		}
		return a;
	}

	public static int[][] rotateminus90(int[][] a) {
		for (int i = 0; i < 3; i++) {
			a = rotate90(a, a.length);
		}

		return a;
	}

}
