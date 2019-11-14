import java.util.Comparator;

public class TreeNode implements Comparable<TreeNode> {

	private TreeNode parent;
	private Cube state;
	private int cost;
	private String action;
	private int depth;
	private int f;

	public TreeNode() {

	}

	public TreeNode(TreeNode parent, Cube state, int cost, String action, int depth, int f) {
		super();
		this.parent = parent;
		this.state = state;
		this.cost = cost;
		this.action = action;
		this.depth = depth;
		this.f = f;
	}

	public TreeNode(Cube state) {
		this.state = state;
		this.parent = null;
		this.cost = 0;
		this.action = "";
		this.depth = 0;
		this.f = 0;

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

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	@Override
	public int compareTo(TreeNode o) {

		return this.f - o.getF();
	}

}

class Sortbyroll implements Comparator<TreeNode> {

	@Override
	public int compare(TreeNode o1, TreeNode o2) {
		// TODO Auto-generated method stub
		return o1.getF() - o2.getF();
	}
}
