package diet;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;


/**
 * Facade class for the diet management.
 * It allows defining and retrieving raw materials and products.
 * 
 */
public class Food {
	
	/**
	 *  Private static data
	 */
	private Map<String, NutritionalElement> rawMaterials;
	private Map<String, NutritionalElement> products;
	private Map<String, NutritionalElement> recipes;
	
	
	/**
	 * Constructor
	 */
	public Food(){
		rawMaterials = new TreeMap<>();
		products = new TreeMap<>();
		recipes = new TreeMap<>();
	}
	
	/**
	 * Define a new raw material.
	 * The nutritional values are specified for a conventional 100g quantity
	 * @param name unique name of the raw material
	 * @param calories calories per 100g
	 * @param proteins proteins per 100g
	 * @param carbs carbs per 100g
	 * @param fat fats per 100g
	 */
	public void defineRawMaterial(String name,
									  double calories,
									  double proteins,
									  double carbs,
									  double fat){
		// even if it's not requested... checking if new RawMaterial already exists
		if( rawMaterials.containsKey(name) ){
			System.out.println("Error: "+ name +" already exists! Try with a different name");
			return;
		}
		
		// In this way I'm saving the same information (name) twice, in the key and in the value
		rawMaterials.put( name, new RawMaterial( name, calories, proteins, carbs, fat) );
	}
	
	/**
	 * Retrieves the collection of all defined raw materials
	 * @return collection of raw materials though the {@link NutritionalElement} interface
	 */
	public Collection<NutritionalElement> rawMaterials(){
		// rawMaterials' values are already sorted, because .values() sorts automatically by ascending order respect to the key of the TreeMap
		return rawMaterials.values();
	}
	
	/**
	 * Retrieves a specific raw material, given its name
	 * @param name  name of the raw material
	 * @return  a raw material though the {@link NutritionalElement} interface
	 */
	public NutritionalElement getRawMaterial(String name){
		return rawMaterials.get(name);
	}

	/**
	 * Define a new packaged product.
	 * The nutritional values are specified for a unit of the product
	 * @param name unique name of the product
	 * @param calories calories for a product unit
	 * @param proteins proteins for a product unit
	 * @param carbs carbs for a product unit
	 * @param fat fats for a product unit
	 */
	public void defineProduct(String name,
								  double calories,
								  double proteins,
								  double carbs,
								  double fat){
		
		// even if it's not requested... checking if new product already exists
		if( products.containsKey(name) ){
			System.out.println("Error: "+ name +" already exists! Try with a different name");
			return;
		}

		products.put( name, new Product( name, calories, proteins, carbs, fat) );
	}
	
	/**
	 * Retrieves the collection of all defined products
	 * @return collection of products though the {@link NutritionalElement} interface
	 */
	public Collection<NutritionalElement> products(){
		// products' values are already sorted, because .values() sorts automatically by ascending order respect to the key of the TreeMap
		return products.values();
	}
	
	/**
	 * Retrieves a specific product, given its name
	 * @param name  name of the product
	 * @return  a product though the {@link NutritionalElement} interface
	 */
	public NutritionalElement getProduct(String name){
		return products.get(name);
	}
	
	/**
	 * Retrieves the collection of all defined recipes
	 * @return collection of recipes though the {@link NutritionalElement} interface
	 */
	public Collection<NutritionalElement> recipes(){
		return recipes.values();
	}
	
	/**
	 * Retrieves a specific recipe, given its name
	 * @param name  name of the recipe
	 * @return  a recipe though the {@link NutritionalElement} interface
	 */
	public NutritionalElement getRecipe(String name){
		return recipes.get(name);
	}
	
	/**
	 * Set a specific recipe that is added to the list of recipes.
	 * Package and subclasses visibility.
	 * @param name of the recipe
	 * @param recipe object
	 * @return true if the recipe can be added, false if the recipe's name already exists
	 */
	protected boolean setRecipe(String name, Recipe recipe){
		if( recipes.containsKey(name) ) return false;
		else recipes.put(name, recipe);
		
		return true;
	}
	
}
