import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {

		/*Scanner reader = new Scanner(System.in);
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
		boolean opt_print = false;
		boolean opt_file = false;
		String strategy = "";
		int depth = 0;
		boolean prunning = false;
		boolean sw = false;

		System.out.println("Choose the strategy you want (Type the number) ");

		System.out.println(
				"1) Greedy" + "\n" + "2) A*" + "\n" + "3) Uniform Cost" + "\n" + "4) BFS" + "\n" + "5) Depth" + "\n");

		do {

			String option = reader.next();
			switch (option) {
			case "1":
				strategy = "greedy";
				sw = false;
				break;
			case "2":
				strategy = "A";
				sw = false;
				break;
			case "3":
				strategy = "cost";
				sw = false;
				break;
			case "4":
				strategy = "anchura";
				sw = false;
				break;
			case "5":
				strategy = "profundidad";
				sw = false;
				break;
			default:
				System.out.println("Wrong option try again");
				sw = true;
				;
			}

		} while (sw);

		System.out.println("Write the maximun depth: ");
		depth = reader.nextInt();

		System.out.println("Type y (YES) if you want prunning implemented on the search or n (NO) if not");

		String pr = reader.next();

		while (!pr.equals("y") && !pr.equals("n")) {
			System.out.println("Please type again y or n");
			pr = reader.next();
		}

		if (pr.equals("y")) {
			prunning = true;
		}

		System.out.println("The chosen options are: " + "\n" + "Strategy: " + strategy + "\n" + "Depth: " + depth + "\n"
				+ "Prunning: " + prunning + "\n");

		System.out.println(
				"Do you want to print the nodes added to the frontier to a file (WARNING SEVERAL PERFORMANCE LOSS)"
						+ "\n" + "Type y (YES) or n (NO)");

		String tofile = reader.next();

		while (!tofile.equals("y") && !tofile.equals("n")) {
			System.out.println("Please type again y or n");
			tofile = reader.next();
		}

		if (tofile.equals("y")) {
			opt_file = true;
		}

		System.out.println(
				"Do you want to print the nodes added to the frontier to STDOUT (WARNING SEVERAL PERFORMANCE LOSS)"
						+ "\n" + "Type y (YES) or n (NO)");

		String tostdoout = reader.next();

		while (!tostdoout.equals("y") && !tostdoout.equals("n")) {
			System.out.println("Please type again y or n");
			tostdoout = reader.next();
		}

		if (tostdoout.equals("y")) {
			opt_print = true;
		}

		reader.close();
		System.out.println("\n\n\n\n" + "Executing code" + "\n\n\n");*/
		
		Cube state = importexport.convertjson("ejemplo.json");

		
		SearchAlgorithm.busqueda_acotada(state, "A",6, true,false,false);

	}
}