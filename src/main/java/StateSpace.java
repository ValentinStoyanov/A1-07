
public class StateSpace {
	
	public static void main(String [] args) {
		
	}
	
	public static void Succesors(Cube state ) {
		
		
		//Devuelve [(acc1,NewState1,costAct1)],...,[(accN,NewStateN,costActN)]
	}
	
	public static boolean isGoal(Cube state) {
		boolean[] bolA = new boolean[6];
		boolean bol = true;
		
		bolA[0] = comprobar_color_cara(state.getBack());
		bolA[1] = comprobar_color_cara(state.getDown());
		bolA[2] = comprobar_color_cara(state.getFront());
		bolA[3] = comprobar_color_cara(state.getLeft());
		bolA[4] = comprobar_color_cara(state.getRight());
		bolA[5] = comprobar_color_cara(state.getUp());
		
		
		for(int i= 0; i < bolA.length; i++) {
			if(bolA[i]==false) {
				bol = false;
			}
		}
		return bol;
	}
	
	public static boolean comprobar_color_cara(int[][] cara) {
		int x = cara[0][0];
		boolean bol = true;
		for (int i = 0; i < cara.length;i++) {
			for(int j = 0; j < cara.length;j++) {
				if(x!=cara[i][j]) {
					bol = false;
				}
			}
		}
		return bol;
	}
	
}
