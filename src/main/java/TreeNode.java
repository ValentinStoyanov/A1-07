
public class TreeNode {

	

	private Cube parent;
	private Cube state;
	private int cost;
	private String action;
	private int depth;
	private double f;
	
	public TreeNode() {
		
	}
	
	public TreeNode(Cube parent, Cube state, int cost, String action, int depth, double f) {
		super();
		this.parent = parent;
		this.state = state;
		this.cost = cost;
		this.action = action;
		this.depth = depth;
		this.f = f;
	}
	
	
	public TreeNode( Cube state, String action) {
		this.state = state;
		this.cost = 1;
		this.action = action;
	}

	public Cube getParent() {
		return parent;
	}

	public void setParent(Cube parent) {
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
}
