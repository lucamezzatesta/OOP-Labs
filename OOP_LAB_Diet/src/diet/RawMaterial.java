package diet;


class RawMaterial implements NutritionalElement {

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
	public RawMaterial (String name, 
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
		// Always returns true!
		return true;
	}

	
}
