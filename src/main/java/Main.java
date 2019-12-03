import java.io.IOException;


public class Main {
	public static void main(String[] args) throws IOException {
		
		double startTime = System.nanoTime();

		Cube state = importexport.convertjson();
		
		SearchAlgorithm.busqueda_acotada(state, "profundidad", 6, true);
		
		double endTime = System.nanoTime();
		endTime = endTime - startTime;

		System.out.println("Elapsed time in seconds: " + endTime/1000000000);
	
		
//	
//	Printer.printcube(state);
//	state = Movements.do_movement(state, "L0");
//	System.out.println("-----------------------------------------");
//	Printer.printcube(state);
//	
//	
	
	}
}