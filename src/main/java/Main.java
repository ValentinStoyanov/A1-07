import java.io.IOException;


public class Main {
	public static void main (String [] args) throws IOException, CloneNotSupportedException {
		//Test.tenrowtest();
		Cube state = importexport.convertjson();
		StateSpace.Succesors(state);
	}	
}