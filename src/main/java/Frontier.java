import java.util.ArrayList;

public class Frontier {

	public static void main(String[] args) {
		
		datatest();
		datatest();
		datatest();
		datatest();
		datatest();
		datatest();
		datatest();
		
		

	}
	
	public static void datatest () {
		long time1;
		long time2;
		
		time1 = testarray();
		time2 = testarraylist();
		
		if(time1>time2) {
			System.out.println("ArrayList is the best");
		}else {
			System.out.println("Array is the best");
		}
		
	}
	
	
	public static long testarraylist() {
		
		Cube cube = importexport.convertjson();
		ArrayList<Cube> list = new ArrayList();
		String[] moves = Movements.Movements_list(cube);
		Cube vacio = new Cube();
		
		for(int x = 0; x < 100000;x++) {
			list.add(x, vacio);
		}

		long startTime = System.nanoTime();

		for (int i = 0; i < 100000; i++) {

			int indice = (int) (Math.random() * 100000);
			int indicemov = (int) (Math.random() * 60);
			list.add(indice,Movements.do_movement(cube, moves[indicemov]));

		}

		long endTime = System.nanoTime();
		endTime = endTime - startTime;

		System.out.println("Elapsed time in miliseconds: " + endTime);
		
		return endTime;
	}

	public static long testarray() {
		Cube cube = importexport.convertjson();
		Cube[] array = new Cube[100000];
		String[] moves = Movements.Movements_list(cube);

		long startTime = System.nanoTime();

		for (int i = 0; i < 100000; i++) {

			int indice = (int) (Math.random() * 100000);
			int indicemov = (int) (Math.random() * 60);
			array[indice] = Movements.do_movement(cube, moves[indicemov]);

		}

		long endTime = System.nanoTime();
		endTime = endTime - startTime;

		System.out.println("Elapsed time in miliseconds: " + endTime);
		
		return endTime;
	}

}
