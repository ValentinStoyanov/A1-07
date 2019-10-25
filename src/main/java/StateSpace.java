
public class StateSpace {
	
	
	public static void Succesors(Cube state) {
		
		String[] movements = Movements.Movements_list(state);
		TreeNode[] succesor = new TreeNode[state.getBack().length*6];
		Cube aux;
		
		
		
		for(int i = 0; i < movements.length;i++) {
			aux = new Cube(state.getBack(),state.getDown(),state.getFront(),state.getLeft(),state.getRight(),state.getUp());
			succesor[i] = new TreeNode(Movements.do_movement(aux, movements[i]),movements[i]);
			Printer.printcube(succesor[i].getState());
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
