import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Cube {
	

	private int[][] back;
	private int[][] down;
	private int[][] front;
	private int[][] left;
	private int[][] right;
	private int[][] up;
	
	public Cube() {

	}
	
	public Cube(int[][] back, int[][] down, int[][] front, int[][] left, int[][] right, int[][] up) {
		super();
		this.back = back;
		this.down = down;
		this.front = front;
		this.left = left;
		this.right = right;
		this.up = up;
	}
	
	
	
	
	public int[][] getBack() {
		return back;
	}
	public void setBack(int[][] back) {
		this.back = back;
	}
	public int[][] getDown() {
		return down;
	}
	public void setDown(int[][] down) {
		this.down = down;
	}
	public int[][] getFront() {
		return front;
	}
	public void setFront(int[][] front) {
		this.front = front;
	}
	public int[][] getLeft() {
		return left;
	}
	public void setLeft(int[][] left) {
		this.left = left;
	}
	public int[][] getRight() {
		return right;
	}
	public void setRight(int[][] rigth) {
		this.right = rigth;
	}
	public int[][] getUp() {
		return up;
	}
	public void setUp(int[][] up) {
		this.up = up;
	}

}