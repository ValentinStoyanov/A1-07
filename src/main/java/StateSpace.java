
public class StateSpace implements Cloneable{
	
	
	public static void Succesors(Cube state) {
		
				
		String[] movements = Movements.Movements_list(state);
		
		for(int i = 0; i < movements.length;i++) {
		}
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
