import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {

		Scanner reader = new Scanner(System.in);
		boolean exists = false;
		System.out.println("Type the name or path of the json file containing the cube");
		String file = reader.next();
		File tmpDir = new File(file);
		exists = tmpDir.exists();
		
		while (!exists) {
			System.out.println("The file or path you introduce is wrong please try again");
			file = reader.next();
			tmpDir = new File(file);
			exists = tmpDir.exists();
		}

		Cube state = importexport.convertjson(file);

		boolean cont = true;
		String strategy = "";
		int depth = 0;
		boolean prunning = true;
		while (cont) {
			System.out.println("Write the number in the left of the type of strategy: ");

			System.out.println("1) Greedy");
			System.out.println("2) A*");
			System.out.println("3) Uniform Cost");
			System.out.println("4) BFS");
			System.out.println("5) Depth");
			int option = reader.nextInt();
			switch (option) {
			case 1:
				strategy = "greedy";
				break;
			case 2:
				strategy = "A";
				break;
			case 3:
				strategy = "cost";
				break;
			case 4:
				strategy = "anchura";
				break;
			case 5:
				strategy = "profundidad";
				break;
			}
			System.out.println("Write the maximun depth: ");
			depth = reader.nextInt();
			System.out.println("Write 'true' if you want prunning implemented on the search or 'false' if not");
			prunning = reader.nextBoolean();
			cont = false;
			System.out.println("The chosen options are: ");
			System.out.println("Strategy: " + strategy);
			System.out.println("Depth: " + depth);
			System.out.println("Prunning: " + prunning);

		}
		reader.close();
		SearchAlgorithm.busqueda_acotada(state, strategy, depth, prunning);

	}
}