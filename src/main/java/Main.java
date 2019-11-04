import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		// Test.tenrowtest();
		Cube state = importexport.convertjson();
		state = Movements.do_movement(state, "L0");
		//ArrayList<Successor> prueba = StateSpace.Succesors(state);
		// System.out.print(prueba.toString());
		// Frontier.main(null);
		//Printer.printcube(state);
		SearchAlgorithm.Busqueda (state,"",1,10);
	}
}