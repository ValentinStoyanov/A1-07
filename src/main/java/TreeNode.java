import java.util.Comparator;

public class TreeNode implements Comparable<TreeNode> {

	private int ID;
	private TreeNode parent;
	private Cube state;
	private int cost;
	private String action;
	private int depth;
	private double f;
	double h;
	String estrategia;



	public TreeNode(TreeNode parent, Cube state, String action,String estrategia) {
		super();
		this.parent = parent;
		this.state = state;
		this.action = action;
		this.cost = parent.getCost()+1;
		this.depth = parent.getDepth()+1;
		this.h = calculate_h(state);
		this.f = calculate_f(estrategia);
	}

	public TreeNode(Cube state,String estrategia) {
		this.ID = 0;
		this.state = state;
		this.parent = null;
		this.cost = 0;
		this.action = "";
		this.depth = 0;
		this.h = calculate_h(state);
		this.f = 0;
	}
	
	public String get_md5 () {
		String md5 = importexport.getMd5(state);
		return md5;
	}
	
	public double calculate_f(String estrategia) {
		double f_value = 0;
		
		switch(estrategia) {
		case "costo":
			f_value = cost;
			break;
		case "profundidad":
			f_value = 1.0/(depth+1.0);
			break;
		case "anchura":
			f_value = depth;
			break;
		case "greedy":
			f_value = h;
			break;
		case "A":
			f_value = h+cost;
			break;
		}
		return f_value;
	}
	
	public static double calculate_h(Cube cube) {
		double entropy = 0;
		double[] c = new double[6];
		c[0] = number_of_colors(cube.getBack());
		c[1] = number_of_colors(cube.getDown());
		c[2] = number_of_colors(cube.getFront());
		c[3] = number_of_colors(cube.getLeft());
		c[4] = number_of_colors(cube.getRight());
		c[5] = number_of_colors(cube.getUp());

		entropy = c[0] + c[1] + c[2] + c[3] + c[4] + c[5];

		return Math.abs(entropy);
	}

	public static double number_of_colors(int[][] array) {
		int n = array.length;
		double entropy = 0;
		double[] count = { 0, 0, 0, 0, 0, 0 };
		int c = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				switch (array[i][j]) {
				case 0:
					count[0] += 1;
					break;
				case 1:
					count[1] += 1;
					break;
				case 2:
					count[2] += 1;
					break;
				case 3:
					count[3] += 1;
					break;
				case 4:
					count[4] += 1;
					break;
				case 5:
					count[5] += 1;
					break;
				}
			}
		}

		for (int x = 0; x < count.length; x++) {
			if (count[x] > 0) {
				entropy += (count[x] / (n * n)) * ((Math.log(count[x] / (n * n))) / (Math.log(6)));
			}
		}

		return entropy;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public Cube getState() {
		return state;
	}

	public void setState(Cube state) {
		this.state = state;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public double getF() {
		return f;
	}

	public void setF(double f) {
		this.f = f;
	}

	@Override
	public int compareTo(TreeNode o) {

		return (int) (( this.f - o.getF())*1000);
	}

	@Override
	public String toString() {
		return "TreeNode ID: "+ID+  " state=" + importexport.getMd5(state) + ", cost=" + cost + ", action=" + action + ", depth="
				+ depth + ", f=" + f +" h: "+h+ "]";
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}

}

class Sortbyroll implements Comparator<TreeNode> {

	@Override
	public int compare(TreeNode o1, TreeNode o2) {
		// TODO Auto-generated method stub
		return (int) ((o1.getF() - o2.getF())*1000);
	}
}
