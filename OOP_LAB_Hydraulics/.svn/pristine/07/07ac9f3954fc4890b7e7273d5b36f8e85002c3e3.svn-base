package hydraulic;

/**
 * Represents a source of water, i.e. the initial element for the simulation.
 *
 * Lo status of the source is defined through the method
 * {@link #setFlow(double) setFlow()}.
 */
public class Source extends Element {

	// Private data
	private double flow;
	
	public Source(String name) {
		super(name);
		flow = 0;
	}

	public void setFlow(double flow){
		if( flow >= 0 )
			this.flow = flow;
		else
			System.out.println("Error: flow must be a positive number (0 at least).");
		
	}
	
	public double getFlow(){
		return flow;
	}
	
}
