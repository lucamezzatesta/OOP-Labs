package diet;

import java.util.Map;
import java.util.TreeMap;

/**
 * Represents a complete menu.
 * It consist of packaged products and servings of recipes.
 *
 */
public class Menu implements NutritionalElement {

	/**
	 * Private data
	 */
	private String name;
	private Food food;
	
	private double calories;
	private double proteins;
	private double carbs;
	private double fat;
	
	private Map<String, NutritionalElement> portions;
	
	
	/**
	 * Menu constructor.
	 * The reference {@code food} of type {@link Food} must be used to
	 * retrieve the information about recipes and products 
	 * 
	 * @param nome unique name of the menu
	 * @param food object containing the information about products and recipes
	 */
	public Menu(String name, Food food){
		
		this.name = name;
		this.food = food;
		
		calories = 0;
		proteins = 0;
		carbs = 0;
		fat = 0;
		
		portions = new TreeMap<>();
		
	}
	
	/**
	 * Adds a given serving size of a recipe.
	 * The recipe is a name of a recipe defined in the {@code food}
	 * argument of the constructor.
	 * 
	 * @param recipe the name of the recipe to be used as ingredient
	 * @param quantity the amount in grams of the recipe to be used
	 */
	public void addRecipe(String recipe, double quantity) {
		
		NutritionalElement newPortion = food.getRecipe(recipe);
		newPortion.per100g();
		double norm = quantity/100;
		
		// checking if recipe already exists in menu
		if( portions.containsKey(recipe) ){
			System.out.println("Error: recipe "+ recipe +" already exists in the menu "+ name +".");
			return;
		}
		
		portions.put(recipe, newPortion);
		
		calories += newPortion.getCalories()*norm;
		proteins += newPortion.getProteins()*norm;
		carbs += newPortion.getCarbs()*norm;
		fat += newPortion.getFat()*norm;
	}

	/**
	 * Adds a unit of a packaged product.
	 * The product is a name of a product defined in the {@code food}
	 * argument of the constructor.
	 * 
	 * @param product the name of the product to be used as ingredient
	 */
	public void addProduct(String product) {
		NutritionalElement newPortion = food.getProduct(product);
		
		// checking if the product already exists in menu
		if( portions.containsKey(product) ){
			System.out.println("Error: product "+ product +" already exists in the menu "+ name +".");
			return;
		}
		
		portions.put(product, newPortion);
		
		calories += newPortion.getCalories();
		proteins += newPortion.getProteins();
		carbs += newPortion.getCarbs();
		fat += newPortion.getFat();
	}

	public String getName() {
		return name;
	}

	public double getCalories() {
		return calories;
	}

	public double getProteins() {
		return proteins;
	}

	public double getCarbs() {
		return carbs;
	}

	public double getFat() {
		return fat;
	}

	public boolean per100g() {
		// nutritional values are provided for the whole menu.
		return false;
	}
}
