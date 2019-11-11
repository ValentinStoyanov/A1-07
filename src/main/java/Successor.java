
public class Successor {

	private String accion;
	private Cube state;
	private int cost;
	
	
	public Successor(String accion, Cube state, int cost) {
		super();
		this.accion = accion;
		this.state = state;
		this.cost = cost;
	}
	public Successor() {
		
	}


	public String getAccion() {
		return accion;
	}


	public void setAccion(String accion) {
		this.accion = accion;
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
	@Override
	public String toString() {
		return "Successor [accion=" + accion + ", state=" + state + ", cost=" + cost + "]";
	}
	
	
}
