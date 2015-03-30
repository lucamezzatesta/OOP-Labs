package hydraulic;

/**
 * Main class that act as a container of the elements for
 * the simulation of an hydraulics system 
 * 
 */
public class HSystem {
	
	// Private data
	private final int MAX_ELEMENTS = 50;
	private final int MAX_SOURCES = MAX_ELEMENTS/2;
	private Element[] elements = new Element[MAX_ELEMENTS];
	private Element[] sources = new Source[MAX_SOURCES];
	private int nElements = 0;
	private int nSources = 0;
	
	/**
	 * Constructor
	 */
	public HSystem(){
		// this constructor does nothing
	}
	
	
	/**
	 * Adds a new element to the system
	 * @param elem
	 */
	public void addElement(Element elem){
		
		elements[nElements] = elem;
		nElements++;
		
		if( elem instanceof Source ){
			sources[nSources] = elem;
			nSources++;
		}
	}
	
	
	/**
	 * returns the element added so far to the system
	 * @return an array of elements whose length is equal to the number of added elements
	 */
	public Element[] getElements(){
		
		Element[] array = new Element[nElements];
		for( int i = 0; i < nElements; i++ )
			array[i] = elements[i];
		
		return array;
	}
	
	
	/**
	 * Prints the layout of the system starting at each Source
	 */
	public String layout(){
		// TODO: this is not the right solution (try with lists or matrix)
		
		Element elem;
		
		if( nSources < 1 ){
			System.out.println("Error: no sources avalaible in the system.");
		}
		
		for( int i = 0; i < nSources; i++ ){
			
			// Printing source
			System.out.print("[" + sources[i].getName() + "]Source -> ");
			elem = sources[i].getOutput();
			if ( elem == null ){
				return "Error: invalid connection.";
			}
			
			// Printing elements recursively
			recursiveDrawElem( sources[i].getOutput(), 0 );
		
		}
		return null;
	}
	
	
	/**
	 * starts the simulation of the system
	 */
	public void simulate(){
		
		Element elem;
		
		if( nSources < 1 ){
			System.out.println("Error: no sources avalaible in the system.");
		}
		
		System.out.println("System simulation:");
		
		for( int i = 0; i < nSources; i++ ){
			
			// Printing source
			System.out.println(sources[i].getName() + " | output flow:" + ((Source) sources[i]).getFlow() );
			elem = sources[i].getOutput();
			if ( elem == null ){
				System.out.println("Error: invalid connection.");
				return;
			}
			
			// Printing elements recursively
			recursivePrintElem( sources[i].getOutput(), ((Source) sources[i]).getFlow() );
		
		}

		
	}
	
	
	/**
	 *  Private recursive function used for printing statics about the system
	 **/
	private void recursivePrintElem( Element elem, double flow ){ 

		double outputFlow = 0;
		
		// Condition of termination
		if( elem instanceof Sink ){
			System.out.println( elem.getName() + " | input flow: " + flow );
			return;
		} else {
			
			if( elem instanceof Tap ){
				
				if( ((Tap) elem).getOpen() ) outputFlow = flow;
				
				// output
				System.out.println( elem.getName() + " | input flow: " + flow + " | output flow: " + outputFlow );
				
				// check
				if( elem.getOutput() == null ){
					System.out.println("Error: bad connection after the tap.");
					return;
				}
				
				// recursion
				recursivePrintElem( elem.getOutput(), outputFlow );
				// termination at the end
				
			} else if( elem instanceof Split ){
				
				outputFlow = flow/2;
				
				// output
				System.out.println( elem.getName() + " | input flow: " + flow + " | output flows: " + outputFlow );
				
				// check
				if( ((Split) elem).getOutputs()[0] == null || ((Split) elem).getOutputs()[1] == null ){
					System.out.println("Error: bad connection after the splitter.");
					return;
				}
				
				// recursion
				recursivePrintElem( ((Split) elem).getOutputs()[0], outputFlow );
				recursivePrintElem( ((Split) elem).getOutputs()[1], outputFlow );
				// termination at the end
				
			} else {
				//TODO: add here new components
				System.out.println("Error: element not recognised.");
				return;
			}
			
			// termination
			return;
		}
	}
	
	/**
	 * 	Private recursive function used for drawing the system (the same of the function above, with a different printing effect)
		Depth used for printing.
	 */
	
	private void recursiveDrawElem( Element elem, int depth ){ 
		// TODO: this is not the right solution (Try with lists)
		
		// Condition of termination
		if( elem instanceof Sink ){
			System.out.println( "[" + elem.getName() + "]Sink |");
			return;
		} else {
			
			if( elem instanceof Tap ){
				
				// output
				System.out.print( "[" + elem.getName() + "]Tap -> ");
				
				// check
				if( elem.getOutput() == null ){
					System.out.println("Error: bad connection after the tap.");
					return;
				}
				
				// recursion
				recursiveDrawElem( elem.getOutput(), depth+1 );
				// termination at the end
				
			} else if( elem instanceof Split ){
				
				// first output
				System.out.print( "[" + elem.getName() + "]Split +-> " );
				
				// first check
				if( ((Split) elem).getOutputs()[0] == null ){
					System.out.println("Error: bad connection after the splitter.");
					return;
				}
				
				// first recursion
				recursiveDrawElem( ((Split) elem).getOutputs()[0], depth+1 );
				
				// formatting
				for( int i = 0; i < depth*4; i++ ) System.out.print("\t");
				System.out.println("|");
				for( int i = 0; i < depth*4; i++ ) System.out.print("\t");
				
				// second output
				System.out.print( "+->" );
				
				// second check
				if( ((Split) elem).getOutputs()[1] == null ){
					System.out.println("Error: bad connection after the splitter.");
					return;
				}
				
				// second recursion
				recursiveDrawElem( ((Split) elem).getOutputs()[1], depth+1 );
				// termination at the end
				
			} else {
				//TODO: add here new components
				System.out.println("Error: element not recognised.");
				return;
			}
			
			// termination
			return;
		}
	}

}
