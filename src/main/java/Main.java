import java.io.IOException;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) throws IOException {
		

		Cube state = importexport.convertjson();
		double startTime = System.nanoTime();

		boolean cont = true;
		String strategy = "";
		int depth = 0;
		boolean prunning = true;
		while(cont) {
			System.out.println("Write the number in the left of the type of strategy: ");
			Scanner reader = new Scanner(System.in);
			System.out.println("1) Greedy");
			System.out.println("2) A*");
			System.out.println("3) Uniform Cost");
			System.out.println("4) BFS");
			System.out.println("5) Depth");
			int option = reader.nextInt();
			switch(option) {
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
			Scanner reader2 = new Scanner(System.in);
			depth = reader.nextInt();
			System.out.println("Write 'true' if you want prunning implemented on the search or 'false' if not");
			Scanner reader3 = new Scanner(System.in);
			prunning = reader.nextBoolean();
			cont = false;
			System.out.println("The chosen options are: ");
			System.out.println("Strategy: "+strategy);
			System.out.println("Depth: "+depth);
			System.out.println("Prunning: "+prunning);
			
			System.out.println();
			System.out.println("Are they correct? Write yes if they are or no if not");
			Scanner reader4 = new Scanner(System.in);
			String correct = reader4.nextLine();
			if(correct=="yes") {
				cont = false;
			}
		}

		
		SearchAlgorithm.busqueda_acotada(state, strategy, depth, prunning);
		
		double endTime = System.nanoTime();
		endTime = endTime - startTime;

		System.out.println("Elapsed time in seconds: " + endTime/1000000000);
	
		
	
	}
}