
public class Successor {

	private String accion;
	private Cube state;
	private double cost;
	
	
	public Successor(String accion, Cube state, double cost) {
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


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
}
