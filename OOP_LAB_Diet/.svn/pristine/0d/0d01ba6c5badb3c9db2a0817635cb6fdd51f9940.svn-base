package diet;

/**
 * This class could be absorbed by RawMaterial class, because they represents the same logical object, except for
 * the returned value of per100g method (in this class is false, in the other is true).
 * 
 * Think about unifying the two classes (Product and RawMaterial).
 * 
 * @author Luke
 */

class Product implements NutritionalElement {

	/**
	 * Private data
	 */
	private String name;
	private double calories;
	private double proteins;
	private double carbs;
	private double fat;
	
	/**
	 * Constructor
	 * @param name of the raw material
	 * @param calories of the raw material
	 * @param proteins of the raw material
	 * @param carbs of the raw material
	 * @param fat of the raw material
	 */
	public Product (String name, 
						double calories,
						double proteins, 
						double carbs,
						double fat) {
		
		this.name = name;
		this.calories = calories;
		this.proteins = proteins;
		this.carbs = carbs;
		this.fat = fat;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public double getCalories() {
		return this.calories;
	}

	@Override
	public double getProteins() {
		return this.proteins;
	}

	@Override
	public double getCarbs() {
		return this.carbs;
	}

	@Override
	public double getFat() {
		return this.fat;
	}

	@Override
	public boolean per100g() {
		// Always returns false
		return false;
	}

}
