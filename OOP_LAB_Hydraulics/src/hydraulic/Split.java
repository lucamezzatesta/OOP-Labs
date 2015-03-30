package hydraulic;

/**
 * Represents a split element, a.k.a. T element
 * 
 * During the simulation each downstream element will
 * receive a stream that is half the input stream of the split.
 */

public class Split extends Element {

	// Private data
	private Element output1;
	
	/**
	 * Constructor
	 * @param name
	 */
	public Split(String name) {
		super(name);
		output1 = null;
	}
    
	/**
	 * returns the downstream elements
	 * @return array containing the two downstream element
	 */
    public Element[] getOutputs(){
    	Element[] outputs = new Element[2];
    	outputs[0] = super.getOutput();
    	outputs[1] = output1;
        return outputs;
    }

	public void connect(Element elem, int noutput){
		if( noutput == 0 )
			this.connect(elem);
		else
			output1 = elem;
	}
}
