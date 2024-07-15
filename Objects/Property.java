
/*
* Date: 2024-06-14
* Contains information about a property
*/
public class Property{
	 
	private String name;
	private int cost;
	
	// Constructor
	public Property(String newName, int newCost) {
		
		name = newName;
		cost = newCost;
	}
	
	// Accessor Methods
	
	/*
	 * Pre: The property name has been set
	 * Post: Returns the name of the property
	 * Gets the property's name
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * Pre: The cost of buying the property is set
	 * Post: Returns the property's cost
	 * Gets how expensive the property is
	 */
	public int getCost() {
		return cost;
	}
	
	/*
	 * Pre: The property's name and cost has been set
	 * Post: Returns information about the property's name and cost
	 * Gets information about the property
	 */
	public String toString () {
		String info = "Name: " + name +" Price: " + cost;
		return(info);
	}
}



