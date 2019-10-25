
public class Test {
	public static void main(String [] args) {
		
	}
	
	
	public static void stres_test() {
		
	}
	
	public static void tenrowtest () {

		//System.out.println("<<<<<<<<<<<<<<<<<<BEFORE MOVEMENT>>>>>>>>>>>>>>>>>>");
		Cube cube =  importexport.convertjson();
		//Printer.printcube(cube);
		//System.out.println("<<<<<<<<<<<<<<<<<<AFTER MOVEMENT>>>>>>>>>>>>>>>>>>");
		//Printer.printcube(cube);
		
		
		cube = Movements.do_movement(cube, "l3" );//------------------------------------
		System.out.print("md5 ID: " + importexport.getMd5(cube));
		if((importexport.getMd5(cube)).equals("130d0d212b8cc15f375b1b0f2cdf42ad")) {
			System.out.println(" <---YES  l3");
		}else {
			System.out.println(" <---NO  l3");
		}
		
		cube = Movements.do_movement(cube, "D1");//---------------------------------------------------------------
		System.out.print("md5 ID: " + importexport.getMd5(cube));
		if((importexport.getMd5(cube)).equals("d83b0f604f0fbdd646497bcc400cb701")) {
			System.out.println(" <---YES  D1");
		}else {
			System.out.println(" <---NO  D1");
		}
		
		cube = Movements.do_movement(cube, "l1");//----------------------------------------------------
		System.out.print("md5 ID: " + importexport.getMd5(cube));
		if((importexport.getMd5(cube)).equals("3072cd153434334e62487aa2c52d0b1c")) {
			System.out.println(" <---YES  l1");
		}else {
			System.out.println(" <---NO  l1");
		}
		
		cube = Movements.do_movement(cube, "d0");//---------------------------------------------
		System.out.print("md5 ID: " + importexport.getMd5(cube));
		if((importexport.getMd5(cube)).equals("dab05f73e4ed15c2394f1712f9dc4fca")) {
			System.out.println(" <---YES  d0");
		}else {
			System.out.println(" <---NO  d0");
		}
		
		cube = Movements.do_movement(cube, "B0");//-----------------------------------------------------
		System.out.print("md5 ID: " + importexport.getMd5(cube));
		if((importexport.getMd5(cube)).equals("ff8a8cd7a7af5da72edfad5d0a801a97")) {
			System.out.println(" <---YES  B0");
		}else {
			System.out.println(" <---NO  B0");
		}
		
		cube = Movements.do_movement(cube, "b5");//-------------------------------------------------
		System.out.print("md5 ID: " + importexport.getMd5(cube));
		if((importexport.getMd5(cube)).equals("8aef8f1a6b6d427fb55581dee01e2557")) {
			System.out.println(" <---YES  b5");
		}else {
			System.out.println(" <---NO  b5");
		}
		
		cube = Movements.do_movement(cube, "l2");//-------------------------------------------
		System.out.print("md5 ID: " + importexport.getMd5(cube));
		if((importexport.getMd5(cube)).equals("151faa80eb7b01fa8db7e8129778de10")) {
			System.out.println(" <---YES  l2");
		}else {
			System.out.println(" <---NO  l2");
		}
		
		cube = Movements.do_movement(cube, "d1");//---------------------------------------------
		System.out.print("md5 ID: " + importexport.getMd5(cube));
		if((importexport.getMd5(cube)).equals("e8682bbb2e6fabf5971e4b471ae2d46d")) {
			System.out.println(" <---YES  d1");
		}else {
			System.out.println(" <---NO  d1");
		}
		
		//Movements.do_movement(cube,"l1");
	}
}
