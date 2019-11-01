
public class StateSpace implements Cloneable{
	
	
	public static void Succesors(Cube state) throws CloneNotSupportedException {
		
		
		
		String[] movements = Movements.Movements_list(state);
		
		Cube[] cubearray = new Cube[movements.length];
		
		for(int i = 0; i < movements.length;i++) {
			Cube aux  =  clone(state);
			cubearray[i] = Movements.do_movement(aux, movements[i]);
			Printer.printcube(cubearray[i]);
			
			
		}
	}
	
	
	public static Cube clone (Cube c1) throws CloneNotSupportedException {
		Cube c2 = (Cube) c1.clone();
		
		return c2;
	}
	
	
	
	
	
	public static boolean isGoal(Cube state) {
		boolean bol = true;
		Cube cube = importexport.convertjson();
		String a = importexport.getMd5(cube);
		String b = importexport.getMd5(state);
		if(!a.equals(b)) {
			bol = false;
		}
		return bol;
	}
	
	
}
