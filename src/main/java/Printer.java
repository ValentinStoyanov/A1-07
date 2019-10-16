
public class Printer {
	public static void printcube (Cube cube) {
		System.out.println("BACK ");
		printarray(cube.getBack());
		System.out.println("--------------------------");
		
		System.out.println("LEFT  DOWN  RIGTH  UP");
		for(int i = 0; i < cube.getBack().length; i++) {
			
		
		
		System.out.println(printarrayrow(cube.getLeft(),i)+"   "+printarrayrow(cube.getDown(),i)+"   "
		+printarrayrow(cube.getRight(),i)+"   "+printarrayrow(cube.getUp(),i));
		}
		System.out.println("--------------------------");
		
		System.out.println("FRONT");
		printarray(cube.getFront());
		
		
	}
	
	public static String printarrayrow(int[][] array,int row) {
		String string = "";
		for(int i = 0; i< array.length;i++) {
			string = string + array[row][i];
		}
		
		return string;
		
	}
	
	public static void printarray(int[][] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length; j++ ) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}
}
